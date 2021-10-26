package com.algaworks.algafood.domain.criptografarSenha;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CripitografarSenhas {

    @Bean
    public PasswordEncoder criptografarSenha(){
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        return encoder;
    }
}
