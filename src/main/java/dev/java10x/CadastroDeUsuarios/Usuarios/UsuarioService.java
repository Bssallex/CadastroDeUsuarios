package dev.java10x.CadastroDeUsuarios.Usuarios;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    // Fazer a conexeção com o repository

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    // Listar todos os usuarios
    public List<UsuarioDTO> listarUsuarios(){
        List<UsuarioModel> usuario = usuarioRepository.findAll();
        return usuario.stream()
                .map(usuarioMapper::map)
                .collect(Collectors.toList());
    }

    // Listar usuarios por ID
    public UsuarioDTO listarUsuariosId(Long id){
        Optional<UsuarioModel> usuarioModelId = usuarioRepository.findById(id);
        return usuarioModelId.map(usuarioMapper::map).orElse(null);
    }

    // Criar usuario (CONCLUIDO)
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO){
        UsuarioModel usuario = usuarioMapper.map(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.map(usuario);
    }

    // Deletar usuario
    public void deletarUsuarioId(Long id){
        usuarioRepository.deleteById(id);
    }

    // Atualizar usuario
    public UsuarioDTO atualizarUsuario(Long id, UsuarioDTO usuarioDTO){
       Optional<UsuarioModel> usuarioExistente = usuarioRepository.findById(id);
       if(usuarioExistente.isPresent()){
            UsuarioModel usuarioAtualizado = usuarioMapper.map(usuarioDTO);
            usuarioAtualizado.setId(id);
            UsuarioModel usuarioSalvo = usuarioRepository.save(usuarioAtualizado);
            return usuarioMapper.map(usuarioSalvo);
       }
       return null;
    }


}
