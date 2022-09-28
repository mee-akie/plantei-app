package com.plantei.planteibackend.repository;

import com.plantei.planteibackend.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioReceita extends JpaRepository<Receita, Long> {
}