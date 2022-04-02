package com.desafio.cadastromongodb.repository;

import com.desafio.cadastromongodb.model.Usuario;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, Id> {

    Usuario findById(String email);

    void deleteById(String id);


    //Usuario findAll(String id);
}
