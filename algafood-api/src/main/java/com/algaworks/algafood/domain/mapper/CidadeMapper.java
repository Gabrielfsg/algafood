package com.algaworks.algafood.domain.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.dto.CidadeDTO;
import com.algaworks.algafood.domain.model.Cidade;

@Component
@Mapper(componentModel = "spring")
public interface CidadeMapper {

	CidadeDTO cidadeToCidadeDTO(Cidade cidade);

    Cidade cidadeDtoToCidade(CidadeDTO cidadeDTO);
}
