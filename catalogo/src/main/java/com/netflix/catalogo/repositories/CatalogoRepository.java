package com.netflix.catalogo.repositories;

import com.netflix.catalogo.repositories.entities.CatalogoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogoRepository extends JpaRepository<CatalogoEntity, Long> {

    @Query("from catalogo " +
           "where generoType = :generoType " +
           "or nome like '%:palavraChave%' " +
           "or categoria like '%:palavraChave%' " +
           "or direcao like '%:palavraChave%' " +
           "or elenco like '%:palavraChave%' ")
    List<CatalogoEntity> findAllByGeneroTypeOuPorPalavraChave(@Param("generoType") String generoType, @Param("palavraChave") String palavraChave);
}
