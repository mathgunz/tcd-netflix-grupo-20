package com.netflix.catalogo.repositories.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogoRepository extends JpaRepository<CatalogoEntity, Long> {

    List<CatalogoEntity> findAllByGeneroType(String name);
}
