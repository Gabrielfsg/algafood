package com.algaworks.algafood.services;

import com.algaworks.algafood.domain.model.mail.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void enviarEmail(Mensagem mensagem){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mensagem.getRemetente());
        simpleMailMessage.setTo(mensagem.getDestinatarios()
                .toArray(new String[mensagem.getDestinatarios().size()]));
        simpleMailMessage.setSubject(mensagem.getAssunto());
        simpleMailMessage.setText(mensagem.getCorpo());

        javaMailSender.send(simpleMailMessage);
    }
}
