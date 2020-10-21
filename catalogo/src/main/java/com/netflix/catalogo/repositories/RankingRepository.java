package com.netflix.catalogo.repositories;

import com.netflix.catalogo.repositories.entities.RankingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<RankingEntity, Long> {

}
