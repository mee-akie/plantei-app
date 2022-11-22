package com.plantei.planteibackend.repository;

import com.plantei.planteibackend.model.PlantaDoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPlantaDoUsuario extends JpaRepository<PlantaDoUsuario, Long> {

}
