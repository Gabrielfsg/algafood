package com.algaworks.algafood.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource("classpath:env/mail.properties") // ler arquivo
public class MailConfig {

    @Autowired
    private Environment env;

    @Bean
    public JavaMailSender mailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("mail.smpt.host"));
        mailSender.setPort(env.getProperty("mail.smpt.port",Integer.class));
        mailSender.setUsername(env.getProperty("mail.smpt.username"));
        mailSender.setPassword(env.getProperty("mail.smpt.password"));

        Properties props = new Properties();
        props.put("mail.transport.protocol","smtp");
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.connectiontimeout", 10000);
        mailSender.setJavaMailProperties(props);
        return mailSender;
    }
}
