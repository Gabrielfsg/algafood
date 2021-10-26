package com.algaworks.algafood.domain.mapper;

import com.algaworks.algafood.domain.dto.DadoUsuarioDTO;
import com.algaworks.algafood.domain.dto.UsuarioDTO;
import com.algaworks.algafood.domain.model.Usuario;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);

    Usuario usuarioDtoToUsuario(UsuarioDTO usuarioDTO);

}
