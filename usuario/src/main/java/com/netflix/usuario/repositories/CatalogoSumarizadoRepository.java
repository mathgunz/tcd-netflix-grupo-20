package com.netflix.usuario.repositories;

import com.netflix.usuario.repositories.entities.CatalogoSumarizadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoSumarizadoRepository extends JpaRepository<CatalogoSumarizadoEntity, Long> {
}
