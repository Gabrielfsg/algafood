package com.algaworks.algafood.services;

import com.algaworks.algafood.domain.dto.RestauranteDTO;
import com.algaworks.algafood.domain.dto.RestauranteEnderecoDTO;
import com.algaworks.algafood.domain.mapper.RestauranteMapper;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RestauranteService {

    RestauranteRepository restauranteRepository;
    RestauranteMapper restauranteMapper;

    public RestauranteDTO inserirRestaurante(RestauranteDTO restauranteDTO){
        Restaurante restaurante = restauranteMapper.restauranteDtoToRestaurante(restauranteDTO);
        return restauranteMapper.restauranteToRestauranteDTO(restauranteRepository.save(restaurante));
    }

    public RestauranteEnderecoDTO buscarEnderecoCompletoRestaurante(Long idRestaurante){
        RestauranteEnderecoDTO restauranteEndereco = restauranteRepository.buscarDadosEnderecoRestaurante(idRestaurante);
        if(Optional.ofNullable(restauranteEndereco.getId()).isPresent()){
            return restauranteEndereco;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<RestauranteDTO> restaurantePelaTaxaDeFrete(BigDecimal taxaFrete){
        return restauranteRepository.buscarPelaTaxaDeFrete(taxaFrete).stream().
                map(restauranteMapper:: restauranteToRestauranteDTO).collect(Collectors.toList());
    }

    public List<Long> idsPagamento(Long id){
      Optional <Restaurante> restaurante = restauranteRepository.findById(id);
      return restaurante.get().getFormaPagamentoList().stream().map(formaPagamento -> formaPagamento.getId()).collect(Collectors.toList());
    }
}
