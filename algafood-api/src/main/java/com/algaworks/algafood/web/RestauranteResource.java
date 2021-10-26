package com.algaworks.algafood.web;

import com.algaworks.algafood.domain.dto.DadoUsuarioDTO;
import com.algaworks.algafood.domain.dto.RestauranteDTO;
import com.algaworks.algafood.domain.dto.RestauranteEnderecoDTO;
import com.algaworks.algafood.domain.dto.UsuarioDTO;
import com.algaworks.algafood.services.RestauranteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/restaurante")
public class RestauranteResource {

    private final RestauranteService restauranteService;

    @PostMapping
    public ResponseEntity<RestauranteDTO> cadastrarRestaurante(@RequestBody RestauranteDTO restauranteDTO){
        return new ResponseEntity<>(restauranteService.inserirRestaurante(restauranteDTO), HttpStatus.CREATED);
    }

    @GetMapping("/endereco/{id}")
    public ResponseEntity<RestauranteEnderecoDTO> buscarUsuarioPeloId(@PathVariable Long idRestaurante){
        return new ResponseEntity<>(restauranteService.buscarEnderecoCompletoRestaurante(idRestaurante), HttpStatus.OK);
    }
}
