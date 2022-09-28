package com.plantei.planteibackend.repository;

import com.plantei.planteibackend.model.Lista_favoritos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioLista_favoritos extends JpaRepository<Lista_favoritos, Long>{

}
