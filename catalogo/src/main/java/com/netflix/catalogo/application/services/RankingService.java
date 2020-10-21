package com.netflix.catalogo.application.services;

import com.netflix.catalogo.application.services.domains.Ranking;
import com.netflix.catalogo.application.usecases.GetRankingUseCase;
import com.netflix.catalogo.repositories.RankingRepository;
import com.netflix.catalogo.repositories.entities.CatalogoEntity;
import com.netflix.catalogo.repositories.CatalogoRepository;
import com.netflix.catalogo.repositories.entities.RankingEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RankingService implements GetRankingUseCase {

    private final CatalogoRepository catalogoRepository;
    private final RankingRepository rankingRepository;

    public RankingService(CatalogoRepository catalogoRepository, RankingRepository rankingRepository) {
        this.catalogoRepository = catalogoRepository;
        this.rankingRepository = rankingRepository;
    }

    @Override
    public void votar(Ranking ranking) {
        Optional<CatalogoEntity> catalogoEntity = catalogoRepository.findById(ranking.getCatalogo().getId());

        catalogoEntity.ifPresent(catalogo -> {
            RankingEntity rankingEntity = new RankingEntity(catalogo, ranking.getUsuarioId());
            rankingRepository.save(rankingEntity);
        });
    }
}
