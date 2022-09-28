package com.plantei.planteibackend.repository;

import com.plantei.planteibackend.model.Planta_do_usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPlanta_do_usuario extends JpaRepository<Planta_do_usuario, Long>{

}
