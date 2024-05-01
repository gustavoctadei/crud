package com.example.crud.service;

import com.example.crud.dto.UsuarioDto;
import com.example.crud.mapper.UsuarioMapper;
import com.example.crud.model.Usuario;
import com.example.crud.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public void criar(UsuarioDto usuarioDto) {
        Usuario usuario = UsuarioMapper.fromDto(usuarioDto);
        usuario.setSenha("cadastro-senha-pendente");

        usuarioRepository.save(usuario);
    }

    public Usuario usuarioPeloId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void editar(Integer id, UsuarioDto usuarioDto) throws Exception {
        Integer ok = usuarioRepository.editar(id, usuarioDto.getEmail(), usuarioDto.getLogin());

        if (ok == null || !ok.equals(1)) throw new Exception("Erro ao editar");
    }

}
