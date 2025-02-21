package com.eventos.services;

import com.eventos.dtos.UsuarioDTO;
import com.eventos.models.Usuario;
import com.eventos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO);
        return new UsuarioDTO(usuarioRepository.save(usuario));
    }

    @GetMapping("/salvar")
    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() ->
                new IllegalArgumentException("Usuario na encontrado"));
    }

    public UsuarioDTO buscarUsuarioPorEmail(String email) {
        return new UsuarioDTO(UsuarioRepository.findByEmail(email))
                .orElseThrow(() ->
                        new IllegalArgumentException("Usuario na encontrado"));
}