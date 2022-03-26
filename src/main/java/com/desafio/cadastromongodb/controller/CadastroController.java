package com.desafio.cadastromongodb.controller;

import com.desafio.cadastromongodb.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @PostMapping(path = "/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Usuario usuario) {
        System.out.println("Usuário criado com sucesso!");
        String password = usuario.getSenha();
        usuario.setSenha(new BCryptPasswordEncoder().encode(password));
        System.out.println("Senha Criptografada: " + usuario.getSenha());
    }
}


