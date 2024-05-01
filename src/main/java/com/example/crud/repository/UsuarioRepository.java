package com.example.crud.repository;

import com.example.crud.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Modifying
    @Query("update Usuario u set u.email = :email, u.login = :login where u.id = :id")
    Integer editar(Integer id, String email, String login);

    Usuario findByLogin(String login);

}