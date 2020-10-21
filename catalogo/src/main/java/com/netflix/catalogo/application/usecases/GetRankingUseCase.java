package com.netflix.catalogo.application.usecases;

import com.netflix.catalogo.application.services.domains.Ranking;

public interface GetRankingUseCase {

    void votar(Ranking ranking);
}
