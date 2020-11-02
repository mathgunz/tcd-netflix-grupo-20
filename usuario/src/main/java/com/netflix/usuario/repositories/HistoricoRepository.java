package com.netflix.usuario.repositories;

import com.netflix.usuario.repositories.entities.HistoricoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HistoricoRepository extends JpaRepository<HistoricoEntity, Long> {

    @Query("from historico where usuarioEntity.email = :userName")
    List<HistoricoEntity> findAllByUsuarioEmail(@Param("userName") String userName);
}
