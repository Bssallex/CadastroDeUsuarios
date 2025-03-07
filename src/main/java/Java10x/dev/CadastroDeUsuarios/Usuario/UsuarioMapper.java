package Java10x.dev.CadastroDeUsuarios.Usuario;

import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioModel map(UsuarioDTO usuarioDTO){

       UsuarioModel usuarioModel = new UsuarioModel();

       usuarioModel.setId(usuarioDTO.getId());
       usuarioModel.setCpf(usuarioDTO.getCpf());
       usuarioModel.setEmail(usuarioDTO.getEmail());
       usuarioModel.setNome(usuarioDTO.getNome());
       usuarioModel.setIdade(usuarioDTO.getIdade());

       return usuarioModel;
    }

    public UsuarioDTO map(UsuarioModel usuarioModel){

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId(usuarioModel.getId());
        usuarioDTO.setCpf(usuarioModel.getCpf());
        usuarioDTO.setEmail(usuarioModel.getEmail());
        usuarioDTO.setNome(usuarioModel.getNome());
        usuarioDTO.setIdade(usuarioModel.getIdade());

        return usuarioDTO;
    }




}
