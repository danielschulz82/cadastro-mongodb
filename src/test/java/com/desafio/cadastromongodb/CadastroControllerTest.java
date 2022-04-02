package com.desafio.cadastromongodb;

import com.desafio.cadastromongodb.controller.CadastroController;
import com.desafio.cadastromongodb.model.Usuario;
import com.desafio.cadastromongodb.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CadastroControllerTest {

    @Mock
    private UsuarioRepository usuarioRepository;
    @InjectMocks
    private CadastroController cadastroController;

    @Test
    void testaInclusaoComSucesso(){
        Usuario usuario = new Usuario();
        usuario.setNome("Jair Bolsonaro");
        usuario.setSenha("b23456");

        Mockito.when(usuarioRepository.save(Mockito.any())).thenReturn(usuario);

        Usuario retorno = cadastroController.salvar(usuario);

        Assertions.assertTrue(retorno != null);
    }

}
