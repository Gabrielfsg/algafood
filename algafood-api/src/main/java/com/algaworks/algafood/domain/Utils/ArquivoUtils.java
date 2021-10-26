package com.algaworks.algafood.domain.Utils;

import com.algaworks.algafood.domain.dto.DadoUsuarioDTO;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ArquivoUtils {


    public String gerarXmlUsuario(DadoUsuarioDTO usuarioDTO){
        StringBuilder str = new StringBuilder();
        str.append("<endereco>").append("<rua>").append(usuarioDTO.getRua()).append("</rua>")
        .append("<numero>").append(usuarioDTO.getNumero()).append("</numero>")
        .append("<cidade>").append(usuarioDTO.getCidade()).append("</cidade>").append("</endereco>");
        return str.toString();
    }

    public String getTagValue(String xml, String tag) {
        String closeTag = new StringBuffer(tag).insert(1, "/").toString(); // fecha a tag adicionando "/"
        int from = xml.indexOf(tag) + tag.length();
        int to = xml.indexOf(closeTag);

        return xml.substring(from, to);
        }

    }

