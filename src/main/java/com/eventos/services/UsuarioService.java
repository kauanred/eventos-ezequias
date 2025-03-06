package com.eventos.services;

import com.eventos.dtos.UsuarioDTO;
import com.eventos.models.Usuario;
import com.eventos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import static java.util.Objects.isNull;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = converterUsuarioDToParaUsuario(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return converterUsuarioParaUsuarioDTO(usuario);
    }

    private Usuario converterUsuarioDToParaUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setDataNascimento(usuarioDTO.getDataNascimento());
        usuario.setPerfil(usuarioDTO.getPerfil());
        usuario.setVerificado(usuarioDTO.getVerificado());
        return usuario;
    }

    public UsuarioDTO converterUsuarioParaUsuarioDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setSenha(usuario.getSenha());
        usuarioDTO.setCpf(usuario.getCpf());
        usuarioDTO.setDataNascimento(usuario.getDataNascimento());
        usuarioDTO.setPerfil(usuario.getPerfil());
        usuarioDTO.setVerificado(usuario.getIsVerificado());
        return usuarioDTO;
    }
    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id) .orElseThrow(() ->
                new IllegalArgumentException("Usuário não encontrado"));
    }
    public UsuarioDTO buscarUsuarioPorEmail(String email) {
        return converterUsuarioParaUsuarioDTO(usuarioRepository.findByEmail(email).orElseThrow(() ->
                new IllegalArgumentException("Usuário não encontrado")));
    }

    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO) {
        if (isNull(usuarioDTO.getId())) {
            throw new IllegalArgumentException("campo Id não informado");
        }
        Usuario usuario = usuarioRepository.findById(usuarioDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        return converterUsuarioParaUsuarioDTO(usuario);
    }
    public void deletarUsuario(Long id) {}

}