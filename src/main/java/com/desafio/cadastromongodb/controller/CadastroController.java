package com.desafio.cadastromongodb.controller;

import com.desafio.cadastromongodb.model.Usuario;
import com.desafio.cadastromongodb.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro")

public class CadastroController {

    private final UsuarioRepository usuarioRepository;

    public CadastroController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping(path = "/salvar")
    @ResponseStatus(HttpStatus.CREATED)
   public Usuario salvar(@RequestBody Usuario usuario) {

        usuario.setSenha(criptografar(usuario.getSenha()));

        System.out.println(" Usuário Criado e Senha Criptografada: " + usuario.getSenha());
        return usuarioRepository.save(usuario);
    }

    @GetMapping(path = "/buscar/{email}")
    Usuario usuario(@PathVariable String email) {
        return usuarioRepository.findById(email);

    }

    @GetMapping(path = "/listar")
    public ResponseEntity<List<Usuario>> todosUsuarios() {

        return ResponseEntity.ok(usuarioRepository.findAll()) ;
    }



    @PutMapping(path = "/atualizar/{id}")

    public ResponseEntity<Usuario> updateUsuario(@PathVariable (value = "id") String id,
                           @RequestBody Usuario usuario)  {

        Usuario newUsuario = usuarioRepository.findById(id);

        if(newUsuario == null){
            return ResponseEntity.noContent().build();
        }


        newUsuario.setNome(usuario.getNome());
        newUsuario.setEmail(usuario.getEmail());
        newUsuario.setSenha(criptografar(usuario.getSenha()));


        Usuario atualizaUsuario = usuarioRepository.save(newUsuario);

        return ResponseEntity.ok().build();

    }

    @DeleteMapping(path = "/deletar/{id}")
       void eletaUsuario(@PathVariable String id){
        usuarioRepository.deleteById(id);

    }

    private String criptografar(String senhaAberta){

        return new BCryptPasswordEncoder().encode(senhaAberta);

    }
}


