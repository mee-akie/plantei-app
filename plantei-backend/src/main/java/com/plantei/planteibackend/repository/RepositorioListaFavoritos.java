package com.plantei.planteibackend.repository;

import com.plantei.planteibackend.model.ListaFavoritos;
import com.plantei.planteibackend.model.ListaFavoritosId;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface RepositorioListaFavoritos extends JpaRepository<ListaFavoritos, ListaFavoritosId> {
	@Query(value = "SELECT id_planta FROM Lista_Favoritos where id_usuario = :id_usuario", nativeQuery = true)
    List<Long> findListaByUserAndPlant(@Param("id_usuario") long id_usuario);
}