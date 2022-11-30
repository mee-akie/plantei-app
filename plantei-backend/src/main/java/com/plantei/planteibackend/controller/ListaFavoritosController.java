package com.plantei.planteibackend.controller;

import com.plantei.planteibackend.exception.ResourceNotFoundException;
import com.plantei.planteibackend.model.ListaFavoritos;
import com.plantei.planteibackend.model.ListaFavoritosId;
import com.plantei.planteibackend.repository.RepositorioListaFavoritos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listaFavoritos")
public class ListaFavoritosController {
    @Autowired
    private RepositorioListaFavoritos repositorioListaFavoritos;

    @GetMapping("/listar")
    public List<ListaFavoritos> getAllFavoriteList() {
        return repositorioListaFavoritos.findAll();
    }

    @GetMapping("/listaUsuario/{id_usuario}")
    public List<Long> getListaByUserAndPlant(@PathVariable long id_usuario) throws ResourceNotFoundException {
        List<Long> dadosLista = repositorioListaFavoritos.findListaByUserAndPlant(id_usuario);
        return dadosLista;
    }
    
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListaFavoritos> addFavoriteList(@RequestBody ListaFavoritos listaFavoritos) {
        repositorioListaFavoritos.save(listaFavoritos);

        return ResponseEntity.ok(listaFavoritos);
    }

    @DeleteMapping("/remover")
    public ResponseEntity<ListaFavoritos> deleteFavoriteList(@RequestBody ListaFavoritos listaFavoritos) {
        repositorioListaFavoritos.delete(listaFavoritos);

        return ResponseEntity.ok().body(listaFavoritos);
    }
}