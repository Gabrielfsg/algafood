package com.algaworks.algafood.domain.mapper;

import com.algaworks.algafood.domain.dto.GrupoDTO;
import com.algaworks.algafood.domain.model.Grupo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface GrupoMapper {

    GrupoDTO grupoToGrupoDTO(Grupo grupo);

    Grupo grupoDtoToGrupo(GrupoDTO grupoDTO);
}
