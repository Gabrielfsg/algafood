package com.algaworks.algafood.services;

import com.algaworks.algafood.domain.Utils.ArquivoUtils;
import com.algaworks.algafood.domain.dto.DadoUsuarioDTO;
import com.algaworks.algafood.domain.dto.UsuarioDTO;
import com.algaworks.algafood.domain.mapper.UsuarioMapper;
import com.algaworks.algafood.domain.model.Usuario;
import com.algaworks.algafood.domain.model.mail.Mensagem;
import com.algaworks.algafood.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsuarioService {

     private UsuarioMapper usuarioMapper;
     private UsuarioRepository usuarioRepository;
     private PasswordEncoder passwordEncoder;
     private ArquivoUtils arquivoUtils;
     private MailService mailService;


    public UsuarioDTO cadastrarUsuario(DadoUsuarioDTO dadoUsuarioDTO){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setSenha(passwordEncoder.encode(dadoUsuarioDTO.getSenha()));
        usuarioDTO.setConteudo(arquivoUtils.gerarXmlUsuario(dadoUsuarioDTO));
        usuarioDTO.setDataCadastro(dadoUsuarioDTO.getDataCadastro());
        usuarioDTO.setEmail(dadoUsuarioDTO.getEmail());
        usuarioDTO.setNome(dadoUsuarioDTO.getNome());
        usuarioDTO.setGrupos(dadoUsuarioDTO.getGrupos());
        mailService.enviarEmail(new Mensagem("A Lenda <gabrielgondim5609@gmail.com>", Arrays.asList("Gondim <alendagod@gmail.com>"), "Teste email", "Teste email com spring"));
        Usuario usuario = usuarioMapper.usuarioDtoToUsuario(usuarioDTO);

        return usuarioMapper.usuarioToUsuarioDTO(usuarioRepository.save(usuario));
    }

    public DadoUsuarioDTO login(String email,String senha){
            DadoUsuarioDTO dadoUsuarioDTO = usuarioRepository.login(email);
            if(Optional.ofNullable(dadoUsuarioDTO).isPresent()){
                if(passwordEncoder.matches(senha, dadoUsuarioDTO.getSenha()) == true){
                    return dadoUsuarioDTO;
                }else{
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
                }
            }else {
                throw new ResponseStatusException(HttpStatus.NO_CONTENT);
            }
    }


    public DadoUsuarioDTO buscarUsuarioPeloId(Long id){
        DadoUsuarioDTO dadoUsuarioDTO = usuarioRepository.usuariopeloId(id);
        if(dadoUsuarioDTO != null){
            return dadoUsuarioDTO;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public DadoUsuarioDTO buscarUsuarioDadoUsuarioPeloId(Long id){
            DadoUsuarioDTO dadoUsuarioDTO = new DadoUsuarioDTO();
            UsuarioDTO usuarioDTO = usuarioMapper.usuarioToUsuarioDTO(usuarioRepository.findById(id).get());
            if(Optional.ofNullable(usuarioDTO).isPresent()) {
                dadoUsuarioDTO.setRua(this.arquivoUtils.getTagValue(usuarioDTO.getConteudo(), "<rua>"));
                dadoUsuarioDTO.setNumero(this.arquivoUtils.getTagValue(usuarioDTO.getConteudo(), "<numero>"));
                dadoUsuarioDTO.setCidade(this.arquivoUtils.getTagValue(usuarioDTO.getConteudo(), "<cidade>"));
                dadoUsuarioDTO.setSenha(usuarioDTO.getSenha());
                dadoUsuarioDTO.setEmail(usuarioDTO.getEmail());
                dadoUsuarioDTO.setDataCadastro(usuarioDTO.getDataCadastro());
                dadoUsuarioDTO.setNome(usuarioDTO.getNome());
                dadoUsuarioDTO.setId(usuarioDTO.getId());
                dadoUsuarioDTO.setGrupos(usuarioDTO.getGrupos());
            }
        return dadoUsuarioDTO;
    }

    public List<UsuarioDTO> listarTodosUsuarios(){
        return usuarioRepository.findAll().stream().map(usuarioMapper::usuarioToUsuarioDTO).collect(Collectors.toList());
    }


}
