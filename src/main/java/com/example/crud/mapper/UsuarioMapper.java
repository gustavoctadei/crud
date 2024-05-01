package com.example.crud.mapper;

import com.example.crud.dto.UsuarioDto;
import com.example.crud.model.Usuario;

public class UsuarioMapper {

    public static UsuarioDto toDto(Usuario usuario) {
        var dto = new UsuarioDto();

        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setLogin(usuario.getLogin());

        return dto;
    }

    public static Usuario fromDto(UsuarioDto dto) {
        var usuario = new Usuario();

        usuario.setId(dto.getId());
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setLogin(dto.getLogin());

        return usuario;
    }

}
