package com.algaworks.algafood.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Endereco;
import com.algaworks.algafood.domain.model.FormaPagamento;

import com.algaworks.algafood.domain.model.Produtos;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RestauranteDTO {

	private Long id;
	private String nome;
	private BigDecimal taxaFrete;
	private Endereco endereco;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataAtualizacao;
	private Cozinha cozinha;
	private List<Produtos> produtos = new ArrayList<>();
	private List<FormaPagamento> formaPagamentoList = new ArrayList<>();
}


