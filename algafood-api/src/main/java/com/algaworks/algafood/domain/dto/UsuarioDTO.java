package com.algaworks.algafood.domain.dto;

import com.algaworks.algafood.domain.model.Grupo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String conteudo;
    private LocalDateTime dataCadastro;
    private List<Grupo> grupos = new ArrayList<>();
}
