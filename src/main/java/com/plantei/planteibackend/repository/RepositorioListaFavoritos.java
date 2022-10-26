package com.plantei.planteibackend.repository;

import com.plantei.planteibackend.model.ListaFavoritos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioListaFavoritos extends JpaRepository<ListaFavoritos, Long> {
}
