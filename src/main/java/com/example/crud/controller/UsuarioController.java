package com.example.crud.controller;

import com.example.crud.dto.UsuarioDto;
import com.example.crud.mapper.UsuarioMapper;
import com.example.crud.model.Usuario;
import com.example.crud.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(name = "getVisualizarUsuario", value = "/visualizar")
    public ModelAndView getVisualizar() {
        var modelAndView = new ModelAndView("usuario/visualizar");

        List<Usuario> listaUsuario = usuarioService.listar();

        modelAndView.addObject("listaUsuario", listaUsuario);

        return modelAndView;
    }

    @GetMapping(name = "getCadastrarUsuario", value = "/cadastrar")
    public ModelAndView getCadastrar() {
        var modelAndView = new ModelAndView("usuario/cadastrar");

        var usuarioDto = new UsuarioDto();

        modelAndView.addObject("usuarioDto", usuarioDto);

        return modelAndView;
    }

    @PostMapping(name = "postCadastrarUsuario", value = "/cadastrar")
    public ModelAndView postCadastrar(UsuarioDto usuarioDto) {
        usuarioService.criar(usuarioDto);

        return new ModelAndView("redirect:/usuario/visualizar");
    }

    @GetMapping(name = "getEditarUsuario", value = "/editar/{id}")
    public ModelAndView getEditar(@PathVariable("id") Integer id) {
        var modelAndView = new ModelAndView("usuario/editar");

        UsuarioDto usuarioDto = UsuarioMapper.toDto( usuarioService.usuarioPeloId(id) );

        modelAndView.addObject("usuarioDto", usuarioDto);

        return modelAndView;
    }

    @PostMapping(name = "postEditarUsuario", value = "/editar/{id}")
    public ModelAndView postEditar(@PathVariable("id") Integer id, UsuarioDto usuarioDto) throws Exception {
        usuarioService.editar(id, usuarioDto);

        return new ModelAndView("redirect:/usuario/visualizar");
    }

}
