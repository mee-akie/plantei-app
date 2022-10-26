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

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/listar")
    public List<PlantaDoUsuario> getAllUserPlants(HttpServletRequest request) {
        return repositorioPlantaDoUsuario.findAll();
    }

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
        plantaDoUsuario.setPlanta(planta);

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

        plantaAlterada.setIdade_planta(dadosPlanta.getIdade_planta());
        plantaAlterada.setTempo_sem_regar(dadosPlanta.getTempo_sem_regar());
        plantaAlterada.setTipo_vaso(dadosPlanta.getTipo_vaso());

        Planta planta = repositorioPlanta.findById(dadosPlanta.getPlanta().getId()).orElseThrow(() -> new ResourceNotFoundException("Planta com id '" + id + "' nao foi encontrado"));
        plantaAlterada.setPlanta(planta);

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
