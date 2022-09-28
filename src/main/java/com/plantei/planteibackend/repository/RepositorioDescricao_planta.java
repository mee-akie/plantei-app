package com.plantei.planteibackend.repository;

import com.plantei.planteibackend.model.Descricao_planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDescricao_planta extends JpaRepository<Descricao_planta, Long>{

}
