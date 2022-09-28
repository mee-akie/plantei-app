package com.plantei.planteibackend.repository;

import com.plantei.planteibackend.model.Plantacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPlantacao extends JpaRepository<Plantacao, Long> {
}

