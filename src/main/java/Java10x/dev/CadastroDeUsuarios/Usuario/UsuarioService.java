package Java10x.dev.CadastroDeUsuarios.Usuario;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    // LISTAR

    public List<UsuarioDTO> listarUsuarios(){
        List<UsuarioModel> usuarioModels = usuarioRepository.findAll();

        return usuarioModels.stream()
                .map(usuarioMapper::map)
                .collect(Collectors.toList());
    }

    // CRIAR
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO){
        UsuarioModel usuario = usuarioMapper.map(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.map(usuario);
    }

    // DELETAR
    public void deletarUuario(Long id){
        usuarioRepository.deleteById(id);
    }

    // ATUALIZAR
    public UsuarioDTO atualizarUsuario(Long id, UsuarioDTO usuarioDTO){
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);

        if(usuario.isPresent()){
            UsuarioModel usuarioExistente = usuarioMapper.map(usuarioDTO);
            usuarioExistente.setId(id);
            UsuarioModel usuarioSalvar = usuarioRepository.save(usuarioExistente);
            return usuarioMapper.map(usuarioSalvar);
        }else {
            return null;
        }
    }
}
