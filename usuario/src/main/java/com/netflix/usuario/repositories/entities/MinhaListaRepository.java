package com.netflix.usuario.repositories.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinhaListaRepository  extends JpaRepository<MinhaListaEntity, Long> {
}