package com.plantei.planteibackend.repository;

import com.plantei.planteibackend.model.DescricaoPlanta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDescricaoPlanta extends JpaRepository<DescricaoPlanta, Long> {
}
