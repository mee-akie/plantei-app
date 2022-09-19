package com.plantei.planteibackend.controller;

import com.plantei.planteibackend.exception.ResourceNotFoundException;
import com.plantei.planteibackend.model.Planta;
import com.plantei.planteibackend.repository.RepositorioPlanta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/planta")
public class PlantaController {

    @Autowired
    private RepositorioPlanta repositorioPlanta;

    /**
     * <p>Retorna uma lista com todas as plantas cadastradas no banco de dados.</p>
     * Path: api/planta/listar
     *
     * @return JSON com todas as plantas cadastradas no banco de dados.
     */
    @GetMapping("/listar")
    public List<Planta> getAllPlants(HttpServletRequest request) {
        return repositorioPlanta.findAll();
    }

    /**
     * <p>Retorna os dados de uma planta cujo ID eh fornecido no path da requisicao.</p>
     * Path: api/planta/{id}
     *
     * @param id ID que identifica a planta no banco de dados.
     * @return JSON com os dados da planta.
     * @throws ResourceNotFoundException
     */
    @GetMapping("/{id}")
    public ResponseEntity<Planta> getPlantByid(@PathVariable long id) throws ResourceNotFoundException {
        Planta dadosPlanta = repositorioPlanta.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Planta com id '" + id + "' nao foi encontrado"));
        return ResponseEntity.ok().body(dadosPlanta);
    }

    /**
     * <p>Cadastra uma nova planta no banco de dados. Seus dados (JSON) sao passados no
     * body da requisicao.</p>
     * Path: api/planta/add
     *
     * @param planta Dados JSON da nova planta que sera cadastrada.
     */
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Planta> addPlant(@RequestBody Planta planta) {
        repositorioPlanta.save(planta);

        return ResponseEntity.ok(planta);
    }

    /**
     * <p>Altera os dados de uma planta existente no banco de dados. Os seus dados (JSON) de alteracao sao dados
     * no body da requisicao.</p>
     * Path: api/planta/alterarDados/{id}
     *
     * @param id          ID da planta que se quer atualizar seus dados.
     * @param dadosPlanta Novos dados da planta.
     * @throws ResourceNotFoundException
     */
    @PutMapping(path = "/alterarDados/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Planta> updatePlant(@PathVariable long id, @RequestBody Planta dadosPlanta) throws ResourceNotFoundException {
        Planta plantaAlterada = repositorioPlanta.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Planta com id '" + id + "' nao foi encontrado"));

        plantaAlterada.setNome(dadosPlanta.getNome());
        plantaAlterada.setIdDescricaoPlanta(dadosPlanta.getIdDescricaoPlanta());

        repositorioPlanta.save(plantaAlterada);

        return ResponseEntity.ok(plantaAlterada);
    }

    /**
     * Remove uma planta cadastrada no banco de dados.
     * Path: api/planta/remover/{id}
     *
     * @param id ID da planta que deve ser removida.
     */
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Long> deletePlantById(@PathVariable Long id) {
        repositorioPlanta.deleteById(id);

        return ResponseEntity.ok(id);
    }
}
