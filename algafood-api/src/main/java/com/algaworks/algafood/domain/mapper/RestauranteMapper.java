package com.algaworks.algafood.domain.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.dto.RestauranteDTO;
import com.algaworks.algafood.domain.model.Restaurante;


@Component
@Mapper(componentModel = "spring")
public interface RestauranteMapper {

	RestauranteDTO restauranteToRestauranteDTO(Restaurante restaurante);
	
	Restaurante restauranteDtoToRestaurante(RestauranteDTO restauranteDTO);
}
