package com.algaworks.algafood.domain.mapper;


import com.algaworks.algafood.domain.dto.EsderecoSimplesDTO;
import com.algaworks.algafood.domain.model.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface EnderecoSimplesMapper {

    @Mapping(source = "cep", target = "cep")
    @Mapping(source = "numero", target = "numero")
    @Mapping(source = "bairro", target = "bairro")
    EsderecoSimplesDTO toDTO(Endereco endereco);
}
