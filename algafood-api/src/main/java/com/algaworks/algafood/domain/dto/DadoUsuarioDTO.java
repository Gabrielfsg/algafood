package com.algaworks.algafood.domain.dto;

import com.algaworks.algafood.domain.model.Grupo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class DadoUsuarioDTO {

    @NotNull
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cidade;
    private String rua;
    private String numero;
    private LocalDateTime dataCadastro;
    private List<Grupo> grupos = new ArrayList<>();

    public DadoUsuarioDTO(Long id, String nome, String email, String senha){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    public DadoUsuarioDTO(Long id, String nome, String email){
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    public DadoUsuarioDTO(Long id, String nome, String email,String senha, String rua, String numero,String cidade,LocalDateTime dataCadastro, List<Grupo> grupos){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
        this.dataCadastro = dataCadastro;
        this.grupos = grupos;
    }
    public DadoUsuarioDTO(Long id, String nome, String email,String senha, String rua, String numero,String cidade){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
    }
}
