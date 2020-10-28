package com.netflix.usuario.repositories.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoRepository extends JpaRepository<UsuarioEntity, Long> {


    List<UsuarioEntity> findAll();
}
