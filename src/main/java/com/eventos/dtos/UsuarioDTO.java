package com.eventos.dtos;

import com.eventos.models.Usuario;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data

public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private Date dataNascimento;
    private String perfil;
    private Boolean isVerificado;

    public UsuarioDTO() {}

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.cpf = usuario.getCpf();
        this.dataNascimento = usuario.getDataNascimento();
        this.perfil = usuario.getPerfil();
        this.dataNascimento = usuario.getDataNascimento();
        this.perfil = usuario.getPerfil();
        this.isVerificado = usuario.getVerificado();
    }

}
