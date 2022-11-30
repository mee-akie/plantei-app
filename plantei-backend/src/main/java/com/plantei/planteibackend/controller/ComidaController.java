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
    @GetMapping("/listar/planta/{idPlanta}")
    public List<Comida> getAllFood(@PathVariable long idPlanta) {
        List<Comida> listaCompleta = repositorioComida.findAll();

        List<Comida> comidasDasPlantas = new ArrayList<>();
        for (Comida comida : listaCompleta) {
            if (comida.getPlanta().getId() == idPlanta) {
                comidasDasPlantas.add(comida);
            }
        }

        return comidasDasPlantas;
    }

    /**
     * Retorna as plantas para fazer uma comida. O nome dessa comida deve ser fornecido no path da requisicao.
     *
     * @param nome nome da comida
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/listar/{nome}")
    public List<Comida> getFoodByName(@PathVariable String nome) throws ResourceNotFoundException {
        List<Comida> listaCompleta = repositorioComida.findAll();

        List<Comida> comidasDasPlantas = new ArrayList<>();
        for (Comida comida : listaCompleta) {
            if (comida.getNome().equals(nome)) {
                comidasDasPlantas.add(comida);
            }
        }

        return comidasDasPlantas;
    }

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comida> addFood(@RequestBody Comida comida) throws ResourceNotFoundException {
        Long id_planta = comida.getPlanta().getId();
        Planta planta = repositorioPlanta.findById(id_planta).orElseThrow(() -> new ResourceNotFoundException("Planta com id '" + id_planta + "' nao foi encontrado"));
        comida.setPlanta(planta);

        repositorioComida.save(comida);

        return ResponseEntity.ok(comida);
    }

    @DeleteMapping("/remover/{nome}")
    public List<Comida> deleteFoodByName(@PathVariable String nome) {
        List<Comida> listaCompleta = repositorioComida.findAll();

        List<Comida> listaDeletar = new ArrayList<>();
        for (Comida comida : listaCompleta) {
            if (comida.getNome().equals(nome)) {
                listaDeletar.add(comida);
            }
        }

        for (Comida comida : listaDeletar) {
            repositorioComida.delete(comida);
        }

        return listaDeletar;
    }
}
