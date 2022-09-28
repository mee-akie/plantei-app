package com.plantei.planteibackend.repository;

import com.plantei.planteibackend.model.Comida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioComida extends JpaRepository<Comida, Long>{

}
