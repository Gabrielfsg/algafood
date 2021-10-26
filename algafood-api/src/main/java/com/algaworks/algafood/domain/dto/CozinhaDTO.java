package com.algaworks.algafood.domain.dto;

import com.algaworks.algafood.domain.model.Restaurante;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CozinhaDTO {

	private Long id;	
	private String nome;
	private List<Restaurante> restaurantes = new ArrayList<>();
}
