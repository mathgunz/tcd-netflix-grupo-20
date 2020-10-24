package com.netflix.catalogo.repositories;

import com.netflix.catalogo.repositories.entities.CatalogoEntity;
import com.netflix.catalogo.repositories.entities.enums.GeneroEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogoRepository extends JpaRepository<CatalogoEntity, Long> {

    @Query("from catalogo " +
           "where " +
           "generoType = coalesce(cast(:generoType as string), generoType) "
    )
    List<CatalogoEntity> findAllByGeneroTypeOuPorPalavraChave(@Param("generoType") String generoType);
}
