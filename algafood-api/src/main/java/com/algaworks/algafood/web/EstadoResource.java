package com.algaworks.algafood.web;

import com.algaworks.algafood.domain.dto.EstadoDTO;
import com.algaworks.algafood.services.EstadoService;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/estado")
public class EstadoResource {

    EstadoService estadoService;

    @PostMapping
    public ResponseEntity<EstadoDTO> inserirEstado(@RequestBody @Valid EstadoDTO estadoDTO){
        return new ResponseEntity<>(estadoService.cadastrarEstado(estadoDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarEstado(@PathVariable Long id){
        try{
            estadoService.deletarEstadopeloId(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException data){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{nome}")
    public ResponseEntity<EstadoDTO> buscarPeloNomeDoEstado(@PathVariable String nome){
        return new ResponseEntity<>(estadoService.buscarEstadoPeloNome(nome),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EstadoDTO>> buscaEstadoPag(Pageable pageable){
        return new ResponseEntity<>(estadoService.buscarEstadoPaginado(pageable),HttpStatus.OK);
    }
}
