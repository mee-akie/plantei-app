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

    // Retorna uma lista com todos os usuarios existentes no BD
    @GetMapping("/listar")
    public List<Usuario> getAllUsers(HttpServletRequest request) {
        return repositorioUsuario.findAll();
    }

    // Retorna um usuario do BD atraves de seu ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserByid(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        Usuario usuario = repositorioUsuario.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario com id '" + userId + "' nao foi encontrado"));
        return ResponseEntity.ok().body(usuario);
    }

    // Adiciona um novo usuario ao BD
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody Usuario usuario) {
        repositorioUsuario.save(usuario);
    }
}
