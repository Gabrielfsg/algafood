package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.dto.RestauranteEnderecoDTO;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    @Query("from Restaurante where taxaFrete >= :taxaFrete")
    List<Restaurante> buscarPelaTaxaDeFrete(BigDecimal taxaFrete);

    @Query("update Restaurante set nome = :nome where id = :id")
    Restaurante atualizarNomeRestaurante(String nome, Long id);

    @Query("SELECT c from Restaurante r " +
            "join r.cozinha c " +
            "where r.id =:id")
    Cozinha buscaCozinhaPeloIdRestaurante(Long id);

    @Query("select fp from Restaurante r " +
            "join r.formaPagamentoList fp " +
            "where r.id =:idRes")
    List<FormaPagamento> restaurantePagamento(Long idRes);

    @Query("SELECT new com.algaworks.algafood.domain.dto.RestauranteEnderecoDTO(r.id,r.nome,e.cep,e.logradouro,e.numero," +
            " e.complemento, e.bairro, c.nome, est.nome) from Restaurante r " +
            "join r.endereco e join e.cidade c join c.estado est where r.id =: idRestaurante")
    RestauranteEnderecoDTO buscarDadosEnderecoRestaurante(Long idRestaurante);
}
