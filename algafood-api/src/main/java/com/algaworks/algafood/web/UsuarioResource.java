package com.algaworks.algafood.web;




import com.algaworks.algafood.domain.dto.DadoUsuarioDTO;
import com.algaworks.algafood.domain.dto.UsuarioDTO;
import com.algaworks.algafood.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("api/usuario")
public class UsuarioResource {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody DadoUsuarioDTO dadoUsuarioDTO){
        return new ResponseEntity<>(usuarioService.cadastrarUsuario(dadoUsuarioDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadoUsuarioDTO> buscarUsuarioPeloId(@PathVariable Long id){
            return new ResponseEntity<>(usuarioService.buscarUsuarioDadoUsuarioPeloId(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarTodosUsuarios(){
        try{
            return new ResponseEntity<>(usuarioService.listarTodosUsuarios(), HttpStatus.OK);
        }catch (Error error){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<DadoUsuarioDTO> fazerLogin(String email, String senha) {
        try {
            return new ResponseEntity<>(usuarioService.login(email,senha), HttpStatus.OK);
        } catch (Error error) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
