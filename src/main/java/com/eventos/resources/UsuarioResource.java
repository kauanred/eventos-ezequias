package com.eventos.resources;


import com.eventos.dtos.UsuarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")

public class UsuarioResource {

    @GetMapping("/all")
    public String getUsuarios() {
        return "teste de usuarios";
    }

    @PostMapping("/criar")
    public ResponseEntity<UsuarioDTO> criarUsuarios(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioDTO);
    }
}