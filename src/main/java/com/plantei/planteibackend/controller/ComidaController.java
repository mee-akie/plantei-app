package com.plantei.planteibackend.controller;

import com.plantei.planteibackend.exception.ResourceNotFoundException;
import com.plantei.planteibackend.model.Comida;
import com.plantei.planteibackend.model.Planta;
import com.plantei.planteibackend.repository.RepositorioComida;
import com.plantei.planteibackend.repository.RepositorioPlanta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/comida")
public class ComidaController {
    @Autowired
    private RepositorioComida repositorioComida;

    @Autowired
    private RepositorioPlanta repositorioPlanta;

    /**
     * Retorna uma lista com todas as comidas da planta cujo ID eh passado
     * no path da requisicao.
     *
     * @param idPlanta ID da planta
     * @return lista com os nomes das comidas de uma planta especifica
     */
    @GetMapping("/listar/{idPlanta}")
    public List<Comida> getAllFood(@PathVariable long idPlanta) {
        List<Comida> listaCompleta = repositorioComida.findAll();

        List<Comida> comidasDasPlantas= new ArrayList<>();
        for (Comida comida : listaCompleta) {
            if (comida.getPlanta().getId() == idPlanta) {
                comidasDasPlantas.add(comida);
            }
        }

        return comidasDasPlantas;
    }

    /**
     * Retorna os dados de uma comida. O ID dessa comida deve ser fornecido no path da requisicao.
     *
     * @param id ID da comida
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/{id}")
    public ResponseEntity<Comida> getFoodByid(@PathVariable long id) throws ResourceNotFoundException {
        Comida dadosPlantaDoUsuario = repositorioComida.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comida com id '" + id + "' nao foi encontrada"));

        return ResponseEntity.ok().body(dadosPlantaDoUsuario);
    }

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comida> addFood(@RequestBody Comida comida) throws ResourceNotFoundException {
        Long id_planta = comida.getPlanta().getId();
        Planta planta = repositorioPlanta.findById(id_planta).orElseThrow(() -> new ResourceNotFoundException("Planta com id '" + id_planta + "' nao foi encontrado"));
        comida.setPlanta(planta);

        repositorioComida.save(comida);

        return ResponseEntity.ok(comida);
    }

    @PutMapping(path = "/alterarDados/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comida> updateFood(@PathVariable long id, @RequestBody Comida dadosComida) throws ResourceNotFoundException {
        Comida comidaAlterada = repositorioComida.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comida com id '" + id + "' nao foi encontrado"));

        comidaAlterada.setNome(dadosComida.getNome());

        Planta planta = repositorioPlanta.findById(dadosComida.getPlanta().getId()).orElseThrow(() -> new ResourceNotFoundException("Planta com id '" + id + "' nao foi encontrado"));
        comidaAlterada.setPlanta(planta);

        repositorioComida.save(comidaAlterada);

        return ResponseEntity.ok(comidaAlterada);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Long> deleteFoodById(@PathVariable Long id) {
        repositorioComida.deleteById(id);

        return ResponseEntity.ok(id);
    }
}