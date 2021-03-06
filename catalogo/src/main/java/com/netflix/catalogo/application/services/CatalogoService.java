package com.netflix.catalogo.application.services;

import com.netflix.catalogo.application.services.domains.Catalogo;
import com.netflix.catalogo.application.usecases.GetCatalogoUseCase;
import com.netflix.catalogo.repositories.entities.CatalogoEntity;
import com.netflix.catalogo.repositories.CatalogoRepository;
import com.netflix.catalogo.repositories.entities.RankingEntity;
import com.netflix.catalogo.repositories.entities.enums.CategoriaEnum;
import com.netflix.catalogo.repositories.entities.enums.GeneroEnum;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CatalogoService implements GetCatalogoUseCase {

    private final CatalogoRepository catalogoRepository;

    public CatalogoService(CatalogoRepository catalogoRepository) {
        this.catalogoRepository = catalogoRepository;
    }

    @Override
    public List<Catalogo> getByGeneroOuPalavraChave(GeneroEnum genero, String nome) {

        List<CatalogoEntity> catalogos = catalogoRepository.findAllByGeneroTypeOuPorPalavraChave(genero == null ? null : genero.name());

        return catalogos.stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Catalogo> getById(Long id) throws Exception {
        Optional<CatalogoEntity> result = catalogoRepository.findById(id);

        CatalogoEntity catalogoEntity = result.orElseThrow(() -> new Exception("Catalogo não existe.") );

        return Optional.of(toDomain(catalogoEntity));
    }

    @Override
    public List<CatalogoEntity> findAllMostRatedByGeneroUseCase() {

        List<CatalogoEntity> catalogs = catalogoRepository.findAll();

        return catalogs;
    }

    private Catalogo toDomain(CatalogoEntity catalogoEntity) {
        return Catalogo.newBuilder()
                .withCapa(catalogoEntity.getCapa())
                .withCategoria(catalogoEntity.getCategoria())
                .withClassificacaoEtaria(catalogoEntity.getClassificacaoEtaria())
                .withDescricao(catalogoEntity.getDescricao())
                .withDirecao(catalogoEntity.getDirecao())
                .withElenco(catalogoEntity.getElenco())
                .withGeneroType(catalogoEntity.getGeneroType())
                .withId(catalogoEntity.getId())
                .withNome(catalogoEntity.getNome())
                .withUrlFilme(catalogoEntity.getUrlFilme())
                .build();
    }

    @PostConstruct
    public void createMassa(){

        System.out.println("adicionando catalogos");

        Arrays.stream(GeneroEnum.values()).forEach(generoEnum -> {

            for (int i = 0; i < 10; i++) {
                CatalogoEntity catalogoEntity = new CatalogoEntity();
                catalogoEntity.setCapa(UUID.randomUUID().toString());
                catalogoEntity.setCategoria(CategoriaEnum.FILMES);
                catalogoEntity.setElenco(UUID.randomUUID().toString());
                catalogoEntity.setDirecao(UUID.randomUUID().toString());
                catalogoEntity.setGeneroType(generoEnum);
                catalogoEntity.setNome(UUID.randomUUID().toString());
                catalogoEntity.setDescricao(UUID.randomUUID().toString());
                catalogoEntity.setUrlFilme(UUID.randomUUID().toString());
                catalogoEntity.setClassificacaoEtaria(18l);

                catalogoRepository.save(catalogoEntity);
            }
        });
    }
}
