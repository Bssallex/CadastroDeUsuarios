package Java10x.dev.CadastroDeUsuarios.Usuario;

import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<UsuarioDTO> adicionarUsuarios(){
        List<UsuarioModel> usuarioModels = usuarioRepository.findAll();

        return usuarioModels.stream()
                .map(usuarioMapper::map)
                .collect(Collectors.toList());

    }
}
