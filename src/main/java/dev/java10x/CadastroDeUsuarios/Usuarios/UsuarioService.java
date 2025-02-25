package dev.java10x.CadastroDeUsuarios.Usuarios;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    // Fazer a conexeção com o repository

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Listar todos os usuarios com um método especial

    public List<UsuarioModel> listarUsuarios(){
        return usuarioRepository.findAll();
    }

}
