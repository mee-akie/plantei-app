package com.plantei.planteibackend.repository;

import com.plantei.planteibackend.model.PlantaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPlantaUsuario extends JpaRepository<PlantaUsuario, Long> {
}
