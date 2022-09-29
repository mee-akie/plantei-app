package com.plantei.planteibackend.controller;

import com.plantei.planteibackend.exception.ResourceNotFoundException;
import com.plantei.planteibackend.model.DescricaoPlanta;
import com.plantei.planteibackend.repository.RepositorioDescricaoPlanta;
import com.plantei.planteibackend.repository.RepositorioPlanta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/decricaoPlanta")
public class DescricaoPlantaController {

    @Autowired
    private RepositorioDescricaoPlanta repositorioDescricaoPlanta;

    @Autowired
    private RepositorioPlanta repositorioPlanta;

    /**
     * <p>Retorna uma lista com todas as descricoes de plantas cadastradas no banco de dados.</p>
     * Path: api/decricaoPlanta/listar
     *
     * @return JSON com todas as descricoes de plantas cadastradas no banco de dados.
     */
    @GetMapping("/listar")
    public List<DescricaoPlanta> getAllDescriptions(HttpServletRequest request) {
        return repositorioDescricaoPlanta.findAll();
    }

    /**
     * <p>Retorna os dados de uma descricao de planta cujo ID eh fornecido no path da requisicao.</p>
     * Path: api/decricaoPlanta/{id}
     *
     * @param id ID que identifica a descricao da planta no banco de dados.
     * @return JSON com os dados da descricao da planta.
     * @throws ResourceNotFoundException
     */
    @GetMapping("/{id}")
    public ResponseEntity<DescricaoPlanta> getPlantDescriptionByid(@PathVariable long id) throws ResourceNotFoundException {
        DescricaoPlanta dadosDescricao = repositorioDescricaoPlanta.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Descricao da planta com id '" + id + "' nao foi encontrado"));
        return ResponseEntity.ok().body(dadosDescricao);
    }

    /**
     * <p>Cadastra uma nova descricao de planta no banco de dados. Seus dados (JSON) sao passados no
     * body da requisicao.</p>
     * Path: api/decricaoPlanta/add
     *
     * @param descricao Dados JSON da nova descricao da planta que sera cadastrada.
     */
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DescricaoPlanta> addPlantDescription(@RequestBody DescricaoPlanta descricao) throws ResourceNotFoundException {

        repositorioDescricaoPlanta.save(descricao);

        return ResponseEntity.ok(descricao);
    }

    /**
     * <p>Altera os dados de uma descricao de planta existente no banco de dados. Os seus dados (JSON) de alteracao sao dados
     * no body da requisicao.</p>
     * Path: api/decricaoPlanta/alterarDados/{id}
     *
     * @param id          ID da descricao que se quer atualizar seus dados.
     * @param descricao Novos dados da descricao.
     * @throws ResourceNotFoundException
     */
    @PutMapping(path = "/alterarDados/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DescricaoPlanta> updatePlantDescription(@PathVariable long id, @RequestBody DescricaoPlanta descricao) throws ResourceNotFoundException {
        DescricaoPlanta descricaoAlterada = repositorioDescricaoPlanta.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Descricao da planta com id '" + id + "' nao foi encontrado"));
        descricaoAlterada.setArea_recomendada(descricao.getArea_recomendada());
        descricaoAlterada.setRegiao_ideal(descricao.getRegiao_ideal());
        descricaoAlterada.setIluminacao_ideal(descricao.getIluminacao_ideal());
        descricaoAlterada.setQtd_agua(descricao.getQtd_agua());
        descricaoAlterada.setFreq_regar(descricao.getFreq_regar());
        descricaoAlterada.setTempo_colheita(descricao.getTempo_colheita());
        descricaoAlterada.setFreq_adubagem(descricao.getFreq_adubagem());
        descricaoAlterada.setModo_de_plantar(descricao.getModo_de_plantar());
        descricaoAlterada.setBeneficio(descricao.getBeneficio());

        repositorioDescricaoPlanta.save(descricaoAlterada);

        return ResponseEntity.ok(descricaoAlterada);
    }

    /**
     * Remove uma descricao da planta cadastrada no banco de dados.
     * Path: api/decricaoPlanta/remover/{id}
     *
     * @param id ID da descricao que deve ser removida.
     */
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Long> deletePlantDescriptionById(@PathVariable Long id) {
        repositorioDescricaoPlanta.deleteById(id);

        return ResponseEntity.ok(id);
    }

}
