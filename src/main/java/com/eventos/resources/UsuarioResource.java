package com.eventos.resources;

import com.eventos.dtos.UsuarioDTO;
import com.eventos.models.Usuario;
import com.eventos.repositories.UsuarioRepository;
import com.eventos.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;

    public UsuarioResource(UsuarioService usuarioService, UsuarioRepository usuarioRepository) {
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
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

    @PutMapping()
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
       return ResponseEntity.ok(usuarioService.atualizarUsuario(usuarioDTO));
    }


    @DeleteMapping()
    public ResponseEntity<UsuarioDTO> deletarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        usuarioService.deletarUsuario(usuarioDTO.getId());
        return ResponseEntity.noContent().build();
    }
}