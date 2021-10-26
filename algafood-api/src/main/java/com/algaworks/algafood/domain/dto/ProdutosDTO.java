package com.algaworks.algafood.domain.dto;

import com.algaworks.algafood.domain.model.Restaurante;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;

@Getter
@Setter
public class ProdutosDTO {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Boolean ativo;
    private Restaurante restaurante;
}

