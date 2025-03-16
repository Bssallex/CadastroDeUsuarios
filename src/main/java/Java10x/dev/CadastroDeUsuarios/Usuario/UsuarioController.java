package Java10x.dev.CadastroDeUsuarios.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public List<UsuarioDTO> usuarioListar(){
        List<UsuarioDTO> usuarioModels = usuarioService.listarUsuarios();
        return usuarioModels;
    }

    @PostMapping("/criar")
    public UsuarioDTO usuarioCriar(@RequestBody UsuarioDTO usuarioDTO){
         UsuarioDTO criar = usuarioService.criarUsuario(usuarioDTO);
          return criar;
    }

    @DeleteMapping("/deletar/{id}")
    public void usuarioDeletar(@PathVariable Long id){
        usuarioService.deletarUuario(id);
    }

    @PutMapping("/atualizar/{id}")
    public UsuarioDTO atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO atualizar = usuarioService.atualizarUsuario(id, usuarioDTO);
        return atualizar;
    }

}
