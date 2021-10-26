package com.algaworks.algafood;

import com.algaworks.algafood.domain.dto.EstadoDTO;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.services.EstadoService;
import org.assertj.core.api.Assertions;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CadastroEstadoIntegrationTests {

    @Mock
    EstadoRepository estadoRepository;
    @InjectMocks
    EstadoService estadoService;

    public Estado estadoBuild1(){
        Estado estadoBuild = new Estado();
        estadoBuild.setId(1L);
        estadoBuild.setNome("MG");
        return estadoBuild;
    }

    @Test
    public void testCadastroEstadoSucesso(){

        EstadoDTO estadoDTO = new EstadoDTO();
        estadoDTO.setNome("DF");

        estadoDTO = estadoService.cadastrarEstado(estadoDTO);

        Assertions.assertThat(estadoDTO).isNotNull();
        Assertions.assertThat(estadoDTO.getId()).isNotNull();
    }

    @Test
    public void testEditarEstadoSucesso(){

        EstadoDTO estadoDTO = new EstadoDTO();
        estadoDTO.setNome("Mg");
        Long id = (long) 1;

        estadoDTO = estadoService.atualizarEstado(estadoDTO, id);

        Assertions.assertThat(estadoDTO).isNotNull();
        Assertions.assertThat(estadoDTO.getId()).isNotNull();
        Assertions.assertThat(estadoDTO).hashCode();
    }

    @Test
    public void testBuscarEstadoPeloId(){
        EstadoDTO estadoDTO = new EstadoDTO();
        Long id = (long) 1;
        estadoDTO = estadoService.buscarEstadoPeloId(id);
        Assertions.assertThat(estadoDTO).isNotNull();
        Assertions.assertThat(estadoDTO.getNome()).isEqualTo("Acre");
    }

    @Test
    public void testeMostrarTodosEstado(){
        List<Estado> listEstado = new ArrayList<>();
        listEstado.add(estadoBuild1());
        Mockito.when(this.estadoRepository.findAll()).thenReturn(listEstado);
        List<EstadoDTO> listaDto = this.estadoService.listarEstados();
        Assertions.assertThat(listaDto).isNotNull();
        Assertions.assertThat(listaDto.get(0).getId()).isEqualTo(1L);
        Mockito.verify(this.estadoRepository, Mockito.times(1)).findAll();
    }

}
