package com.plantei.planteibackend.controller;

import com.plantei.planteibackend.exception.ResourceNotFoundException;
import com.plantei.planteibackend.model.PlantaUsuario;
import com.plantei.planteibackend.repository.RepositorioPlantaUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/plantaUsuario")
public class PlantaUsuarioController {

    @Autowired
    private RepositorioPlantaUsuario repositorioPlantaUsuario;

    /**
     * <p>Retorna uma lista com as informacoes das plantas do usuario cadastradas
     * no banco de dados.</p>
     * Path: api/plantaUsuario/listar
     *
     * @return JSON com todas as plantas cadastradas no banco de dados.
     */
    @GetMapping("/listar")
    public List<PlantaUsuario> getAllPlants(HttpServletRequest request) {
        return repositorioPlantaUsuario.findAll();
    }

    /**
     * <p>Retorna as informacoes de uma planta cujo ID eh fornecido no path da requisicao.</p>
     * Path: api/plantaUsuario/{id}
     *
     * @param id ID que identifica a planta no banco de dados.
     * @return JSON com os dados da planta.
     * @throws ResourceNotFoundException
     */
    @GetMapping("/{id}")
    public ResponseEntity<PlantaUsuario> getPlantUsuarioByid(@PathVariable long id) throws ResourceNotFoundException {
        PlantaUsuario dadosPlantaUsuario = repositorioPlantaUsuario.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PlantaUsuario com id '" + id + "' nao foi encontrado"));
        return ResponseEntity.ok().body(dadosPlantaUsuario);
    }

    /**
     * <p>Cadastra uma nova informacao da planta no banco de dados. Seus dados
     * (JSON) sao passados no body da requisicao.</p>
     * Path: api/plantaUsuario/add
     *
     * @param planta Dados JSON da nova informacao da planta que sera cadastrada.
     */
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlantaUsuario> addPlantUsuario(@RequestBody PlantaUsuario plantaUsuario) {
        repositorioPlantaUsuario.save(plantaUsuario);

        return ResponseEntity.ok(plantaUsuario);
    }

    /**
     * <p>Altera as informacoes de uma planta existente no banco de dados. Os
     * seus dados (JSON) de alteracao sao dados no body da requisicao.</p>
     * Path: api/plantaUsuario/alterarDados/{id}
     *
     * @param id          ID da planta que se quer atualizar seus dados.
     * @param dadosPlanta Novos dados da planta.
     * @throws ResourceNotFoundException
     */
    @PutMapping(path = "/alterarDados/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlantaUsuario> updatePlantaUsuario(@PathVariable long id, @RequestBody PlantaUsuario dadosPlantaUsuario) throws ResourceNotFoundException {
        PlantaUsuario plantaUsuarioAlterada = repositorioPlantaUsuario.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PlantaUsuario com id '" + id + "' nao foi encontrado"));

        plantaUsuarioAlterada.setIdPlanta(dadosPlantaUsuario.getIdPlanta());
        plantaUsuarioAlterada.setIdUsuario(dadosPlantaUsuario.getIdUsuario());
        plantaUsuarioAlterada.setIdadePlanta(dadosPlantaUsuario.getIdadePlanta());
        plantaUsuarioAlterada.setTempoSemRegar(dadosPlantaUsuario.getTempoSemRegar());
        plantaUsuarioAlterada.setTipoVaso(dadosPlantaUsuario.getTipoVaso());

        repositorioPlantaUsuario.save(plantaUsuarioAlterada);

        return ResponseEntity.ok(plantaUsuarioAlterada);
    }

    /**
     * Remove uma informacao da planta cadastrada no banco de dados.
     * Path: api/plantaUsuario/remover/{id}
     *
     * @param id ID da planta que deve ser removida.
     */
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Long> deletePlantUsuarioById(@PathVariable Long id) {
        repositorioPlantaUsuario.deleteById(id);

        return ResponseEntity.ok(id);
    }
}
