package com.algaworks.algafood.domain.dto;

import com.algaworks.algafood.domain.model.Permissao;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GrupoDTO {

    private Long id;
    private String nome;
    private List<Permissao> permissoes = new ArrayList<>();
}
