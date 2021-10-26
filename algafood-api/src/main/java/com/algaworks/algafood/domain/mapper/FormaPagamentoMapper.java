package com.algaworks.algafood.domain.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.dto.FormaPagamentoDTO;
import com.algaworks.algafood.domain.model.FormaPagamento;



@Component
@Mapper(componentModel = "spring")
public interface FormaPagamentoMapper {

	FormaPagamentoDTO formaPagamentoToFormaPagamentoDTO(FormaPagamento formaPagamento);
	
	FormaPagamento formaPagamentoDtoToFormaPagamento(FormaPagamentoDTO formaPagamentoDTO);
}
