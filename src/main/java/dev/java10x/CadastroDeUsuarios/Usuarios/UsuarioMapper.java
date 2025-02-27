package dev.java10x.CadastroDeUsuarios.Usuarios;

import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioModel map(UsuarioDTO usuarioDTO){

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setId(usuarioDTO.getId());
        usuarioModel.setNome(usuarioDTO.getNome());
        usuarioModel.setEmail(usuarioDTO.getEmail());
        usuarioModel.setImgUrl(usuarioDTO.getImgUrl());
        usuarioModel.setIdade(usuarioDTO.getIdade());
        usuarioModel.setCpf(usuarioDTO.getCpf());
        usuarioModel.setTarefas(usuarioDTO.getTarefas());

        return usuarioModel;
    }

    public UsuarioDTO map(UsuarioModel usuarioModel){

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuarioModel.getId());
        usuarioDTO.setNome(usuarioModel.getNome());
        usuarioDTO.setEmail(usuarioModel.getEmail());
        usuarioDTO.setImgUrl(usuarioModel.getImgUrl());
        usuarioDTO.setIdade(usuarioModel.getIdade());
        usuarioDTO.setCpf(usuarioModel.getCpf());
        usuarioDTO.setTarefas(usuarioModel.getTarefas());

        return usuarioDTO;

    }


}
