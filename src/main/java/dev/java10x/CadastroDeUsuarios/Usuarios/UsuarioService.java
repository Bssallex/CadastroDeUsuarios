package dev.java10x.CadastroDeUsuarios.Usuarios;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    // Listar usuarios por ID

    public UsuarioModel listarUsuariosId(Long id){
        Optional<UsuarioModel> usuarioModelId = usuarioRepository.findById(id);
        return usuarioModelId.orElse(null);
    }

}
