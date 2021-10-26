package com.algaworks.algafood.domain.mapper;

import com.algaworks.algafood.domain.dto.ProdutosDTO;
import com.algaworks.algafood.domain.model.Produtos;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProdutosMapper {

    ProdutosDTO produtosToProdutosDTO(Produtos produtos);

    Produtos produtosDtoToProdutos(ProdutosDTO produtosDTO);
}
