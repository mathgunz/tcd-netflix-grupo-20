package com.netflix.catalogo.application.services.domains;

import com.netflix.catalogo.application.usecases.GetCatalogoUseCase;
import com.netflix.catalogo.repositories.entities.CatalogoEntity;
import com.netflix.catalogo.repositories.entities.CatalogoRepository;
import com.netflix.catalogo.repositories.entities.enums.GeneroEnum;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatalogoService implements GetCatalogoUseCase {

    private final CatalogoRepository catalogoRepository;

    public CatalogoService(CatalogoRepository catalogoRepository) {
        this.catalogoRepository = catalogoRepository;
    }

    @Override
    public List<Catalogo> getByGenero(GeneroEnum genero) {

        List<CatalogoEntity> resultados = catalogoRepository.findAllByGeneroType(genero.name());

        return resultados.stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public Catalogo getById(Long id) throws Exception {
        Optional<CatalogoEntity> result = catalogoRepository.findById(id);

        CatalogoEntity catalogoEntity = result.orElseThrow(() -> new Exception("Catalogo não existe.") );

        return toDomain(catalogoEntity);
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
}
