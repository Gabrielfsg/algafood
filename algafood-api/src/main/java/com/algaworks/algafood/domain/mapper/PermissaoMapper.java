package com.algaworks.algafood.domain.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.dto.PermissaoDTO;
import com.algaworks.algafood.domain.model.Permissao;



@Component
@Mapper(componentModel = "spring")
public interface PermissaoMapper {
	
	PermissaoDTO permissaoToPermissaoDTO(Permissao permissao);
	
	Permissao permissaoDtoToPermissao(PermissaoDTO permissaoDTO);
}
