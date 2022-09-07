package com.plantei.planteibackend.controller;

import com.plantei.planteibackend.exception.ResourceNotFoundException;
import com.plantei.planteibackend.model.Usuario;
import com.plantei.planteibackend.repository.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UserController {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    /**
     * <p>Retorna uma lista com todos os usuarios existentes no banco de dados.</p>
     * Path: /api/usuario/listar
     *
     * @return Uma lista (JSON) com todos os usuarios existentes no banco de dados.
     */
    @GetMapping("/listar")
    public List<Usuario> getAllUsers(HttpServletRequest request) {
        return repositorioUsuario.findAll();
    }

    /**
     * <p>Retorna os dados de um usuario com base no ID fornecido na requisicao.</p>
     * Path: /api/usuario/{id}
     *
     * @param userId ID do usuario buscado.
     * @return Os dados de um usuario (JSON).
     * @throws ResourceNotFoundException
     */
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserByid(@PathVariable long id) throws ResourceNotFoundException {
        Usuario dadosUsuario = repositorioUsuario.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario com id '" + id + "' nao foi encontrado"));
        return ResponseEntity.ok().body(dadosUsuario);
    }

    /**
     * <p>Adiciona um novo usuario ao Banco de Dados. Esse end-point so ira consumir
     * dadas no formato JSON.</p>
     * Path: /api/usuario/add
     *
     * @param usuario JSON com os dados do novo usuario.
     * @see Usuario#Usuario(Long, String, String, String, String, boolean, String, String, Long)
     */
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> addUser(@RequestBody Usuario usuario) {
        repositorioUsuario.save(usuario);

        return ResponseEntity.ok(usuario);
    }

    /**
     * <p>Altera os dados do usuario, cujo ID eh enviado na requisicao.</p>
     * Path: /api/usuario/alterarDados/{id}
     *
     * @param id           Id que identifica o usuario no banco de dados.
     * @param dadosUsuario JSON com os dados do usuario que devem ser alterados.
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping(path = "/alterarDados/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> updateUser(@PathVariable long id, @RequestBody Usuario dadosUsuario) throws ResourceNotFoundException {
        Usuario usuarioAlterado = repositorioUsuario.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario com id '" + id + "' nao foi encontrado"));

        usuarioAlterado.setNome(dadosUsuario.getNome());
        usuarioAlterado.setEmail(dadosUsuario.getEmail());
        usuarioAlterado.setRegiao(dadosUsuario.getRegiao());
        usuarioAlterado.setNotificacoes(dadosUsuario.getNotificacoes());
        usuarioAlterado.setObjetivo(dadosUsuario.getObjetivo());
        usuarioAlterado.setArea(dadosUsuario.getArea());
        usuarioAlterado.setIluminacao(dadosUsuario.getIluminacao());

        repositorioUsuario.save(usuarioAlterado);

        return ResponseEntity.ok(usuarioAlterado);
    }
}
