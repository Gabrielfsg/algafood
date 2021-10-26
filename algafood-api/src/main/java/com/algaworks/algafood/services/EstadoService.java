package com.algaworks.algafood.services;

import com.algaworks.algafood.domain.dto.EstadoDTO;
import com.algaworks.algafood.domain.mapper.EstadoMapper;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EstadoService {

    EstadoRepository estadoRepository;
    EstadoMapper estadoMapper;

    public EstadoDTO cadastrarEstado(EstadoDTO estadoDTO){
        Estado estado = estadoMapper.estadoDtoToEstado(estadoDTO);
        return estadoMapper.estadoToEstadoDTO(estadoRepository.save(estado));
    }

    public void deletarEstadopeloId(Long id){
        Optional<Estado> estado = estadoRepository.findById(id);
        if(estado.isPresent()){
            estadoRepository.deleteById(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public List<EstadoDTO> listarEstados(){
        return estadoRepository.findAll().stream().map(estadoMapper:: estadoToEstadoDTO).collect(Collectors.toList());
    }

    public EstadoDTO buscarEstadoPeloNome(String nome){
        Estado estado = estadoRepository.buscarRestaurantePeloNome(nome);
        return estadoMapper.estadoToEstadoDTO(estado);
    }

    public List<EstadoDTO> buscarEstadoPaginado(Pageable pageable){
        return estadoRepository.findAll(pageable).stream().map(estadoMapper::estadoToEstadoDTO).collect(Collectors.toList());
    }

    public EstadoDTO buscarEstadoPeloId(Long id){
        Estado estado = estadoRepository.findById(id).get();
        return estadoMapper.estadoToEstadoDTO(estado);
    }

    public EstadoDTO atualizarEstado(EstadoDTO estadoDTO,  Long id){
            Estado estadoB = estadoRepository.findById(id).get();
          return  Optional.ofNullable(estadoB).map(estado ->
                    estadoMapper.estadoToEstadoDTO(estadoRepository.save(estadoMapper.estadoDtoToEstado(estadoDTO))))
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
