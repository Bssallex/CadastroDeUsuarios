package dev.java10x.CadastroDeUsuarios.Usuarios;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/boasvindas")
     public String boasVindas(){
         return "Seja Bem Vindo!";
     }

    // Adicionar usuarios
    @PostMapping("/criar")
    public String criarUsuario(){
         return "Usuario criado";
    }

    // Listar usuarios
    @GetMapping("/listar")
    public List<UsuarioModel> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    // Mostrar todos os usuarios por ID
    @GetMapping("/listarId")
    public String mostrarUsuariosId(){
        return "Mostrar usuario por id";
    }

    // Alterar dados dos usuarios
    @PutMapping("/alterarId")
    public String alterarUsuariosId(){
         return "Alterar usuario por id";
    }

    // Deletar usuarios por ID
    @DeleteMapping("/deletarId")
    public String deletarUsuariosId(){
         return "Usuario deletado por id";
    }





}
