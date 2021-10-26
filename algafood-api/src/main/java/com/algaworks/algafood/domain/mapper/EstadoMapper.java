package com.algaworks.algafood.domain.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.dto.EstadoDTO;
import com.algaworks.algafood.domain.model.Estado;



@Component
@Mapper(componentModel = "spring")
public interface EstadoMapper {

	EstadoDTO estadoToEstadoDTO(Estado estado);
	
	Estado estadoDtoToEstado(EstadoDTO estadoDTO);
}
