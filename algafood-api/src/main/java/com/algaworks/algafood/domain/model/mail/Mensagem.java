package com.algaworks.algafood.domain.model.mail;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class Mensagem {

    private String remetente;

    private List<String> destinatarios;

    private String assunto;

    private String corpo;

    public Mensagem(String remetente, List<String> destinatarios, String assunto, String corpo) {
        this.remetente = remetente;
        this.destinatarios = destinatarios;
        this.assunto = assunto;
        this.corpo = corpo;
    }
}
