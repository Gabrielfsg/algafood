package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.dto.DadoUsuarioDTO;
import com.algaworks.algafood.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query("SELECT NEW com.algaworks.algafood.domain.dto.DadoUsuarioDTO(u.id,u.nome,u.email,u.senha)" +
            "from Usuario u where u.id =:id")
    DadoUsuarioDTO usuariopeloId(Long id);

    @Query("SELECT NEW com.algaworks.algafood.domain.dto.DadoUsuarioDTO(u.id,u.nome,u.email, u.senha)" +
    "from Usuario u where u.email =:email")
    DadoUsuarioDTO login(String email);
}
