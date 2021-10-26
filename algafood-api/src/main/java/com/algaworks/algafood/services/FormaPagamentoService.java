package com.algaworks.algafood.services;

import com.algaworks.algafood.domain.dto.FormaPagamentoDTO;
import com.algaworks.algafood.domain.mapper.FormaPagamentoMapper;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FormaPagamentoService {

    FormaPagamentoRepository formaPagamentoRepository;
    FormaPagamentoMapper formaPagamentoMapper;

    public FormaPagamentoDTO inserirFormaPagamento(FormaPagamentoDTO formaPagamentoDTO){
        return formaPagamentoMapper.formaPagamentoToFormaPagamentoDTO(formaPagamentoRepository
                .save(formaPagamentoMapper.formaPagamentoDtoToFormaPagamento(formaPagamentoDTO)));
    }
}
