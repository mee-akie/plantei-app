package com.plantei.planteibackend.controller;

import com.plantei.planteibackend.exception.ResourceNotFoundException;
import com.plantei.planteibackend.model.Planta;
import com.plantei.planteibackend.model.PlantaDoUsuario;
import com.plantei.planteibackend.model.Usuario;
import com.plantei.planteibackend.repository.RepositorioPlanta;
import com.plantei.planteibackend.repository.RepositorioPlantaDoUsuario;
import com.plantei.planteibackend.repository.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/plantaDoUsuario")
public class PlantaDoUsuarioController {
    @Autowired
    private RepositorioPlantaDoUsuario repositorioPlantaDoUsuario;

    @Autowired
    private RepositorioPlanta repositorioPlanta;

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    /**
     * Retorna uma lista com todas as plantas do usuario cujo ID eh passado
     * no path da requisicao.
     *
     * @param idUsuario ID do usuario
     * @return lista com os dados das planta de um usuario especifico
     */
    @GetMapping("/listar/{idUsuario}")
    public List<PlantaDoUsuario> getAllUserPlants(@PathVariable long idUsuario) {
        List<PlantaDoUsuario> listaCompleta = repositorioPlantaDoUsuario.findAll();

        List<PlantaDoUsuario> plantasDoUsuario = new ArrayList<>();
        for (PlantaDoUsuario planta : listaCompleta) {
            if (planta.getUsuario().getId() == idUsuario) {
                plantasDoUsuario.add(planta);
            }
        }

        return plantasDoUsuario;
    }

    /**
     * Retorna os dados de uma planta de um usuario. O ID dessa planta deve ser fornecido no path da requisicao.
     * OBS: note que nao eh o ID do usuario e nem o ID da planta, e sim o ID da tupla da tabela ({@link PlantaDoUsuario#getId()}).
     *
     * @param id ID da plantaDoUsuario
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/{id}")
    public ResponseEntity<PlantaDoUsuario> getUserPlantByid(@PathVariable long id) throws ResourceNotFoundException {
        PlantaDoUsuario dadosPlantaDoUsuario = repositorioPlantaDoUsuario.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Planta do usuario com id '" + id + "' nao foi encontrado"));

        return ResponseEntity.ok().body(dadosPlantaDoUsuario);
    }

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlantaDoUsuario> addUserPlant(@RequestBody PlantaDoUsuario plantaDoUsuario) throws ResourceNotFoundException {

        Long id_planta = plantaDoUsuario.getPlanta().getId();
        Planta planta = repositorioPlanta.findById(id_planta).orElseThrow(() -> new ResourceNotFoundException("Planta com id '" + id_planta+ "' nao foi encontrado"));
        plantaDoUsuario.setNome_plantacao(planta);

        Long id_usuario = plantaDoUsuario.getUsuario().getId();
        Usuario usuario = repositorioUsuario.findById(id_usuario).orElseThrow(() -> new ResourceNotFoundException("Usuario com id '" + id_usuario + "' nao foi encontrado"));
        plantaDoUsuario.setUsuario(usuario);

        repositorioPlantaDoUsuario.save(plantaDoUsuario);

        return ResponseEntity.ok(plantaDoUsuario);
    }

    @PutMapping(path = "/alterarDados/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlantaDoUsuario> updateUserPlant(@PathVariable long id, @RequestBody PlantaDoUsuario dadosPlanta) throws ResourceNotFoundException {
        PlantaDoUsuario plantaAlterada = repositorioPlantaDoUsuario.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Planta do usuario com id '" + id + "' nao foi encontrado"));

        plantaAlterada.setNome(dadosPlanta.getNome());
        plantaAlterada.setIdade_planta(dadosPlanta.getIdade_planta());
        plantaAlterada.setTempo_sem_regar(dadosPlanta.getTempo_sem_regar());
        plantaAlterada.setTipo_vaso(dadosPlanta.getTipo_vaso());

        Planta planta = repositorioPlanta.findById(dadosPlanta.getPlanta().getId()).orElseThrow(() -> new ResourceNotFoundException("Planta com id '" + id + "' nao foi encontrado"));
        plantaAlterada.setNome_plantacao(planta);

        Usuario usuario = repositorioUsuario.findById(dadosPlanta.getUsuario().getId()).orElseThrow(() -> new ResourceNotFoundException("Usuario com id '" + id + "' nao foi encontrado"));
        plantaAlterada.setUsuario(usuario);

        repositorioPlantaDoUsuario.save(plantaAlterada);

        return ResponseEntity.ok(plantaAlterada);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Long> deletePlantById(@PathVariable Long id) {
        repositorioPlantaDoUsuario.deleteById(id);

        return ResponseEntity.ok(id);
    }
}
