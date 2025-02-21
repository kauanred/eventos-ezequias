package com.eventos.resources;

import com.eventos.dtos.UsuarioDTO;
import com.eventos.models.Usuario;
import com.eventos.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    private final UsuarioService usuarioService;

    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/all")
    public ResponseEntity<UsuarioDTO>buscarUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.ok(new UsuarioDTO(usuario));
    }
    @PostMapping("/criar")
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuarioDTO));
    }
}