package com.eventos.repositories;

import com.eventos.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    static Usuario findByEmail(String email) {
    }
}
