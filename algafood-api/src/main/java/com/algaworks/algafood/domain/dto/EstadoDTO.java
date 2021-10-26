package com.algaworks.algafood.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EstadoDTO {

	private Long id;
	private String nome;
}
