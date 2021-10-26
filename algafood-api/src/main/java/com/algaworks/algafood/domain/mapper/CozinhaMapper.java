package com.algaworks.algafood.domain.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.dto.CozinhaDTO;
import com.algaworks.algafood.domain.model.Cozinha;

@Component
@Mapper(componentModel = "spring")
public interface CozinhaMapper {
	
	CozinhaDTO cozinhaToCozinhaDTO(Cozinha cozinha);
	
	Cozinha cozinhaDtoToCozinha(CozinhaDTO cozinhaDTO);
}
