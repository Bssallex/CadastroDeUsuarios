package dev.java10x.CadastroDeUsuarios.Usuarios;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

     @GetMapping("/boasvindas")
     public String boasVindas(){
         return "Seja Bem Vindo!";
     }

    // Adicionar usuarios
    @PostMapping("/criar")
    public String criarUsuario(){
         return "Usuario criado";
    }

    // Procurar usuarios
    @GetMapping("/listar")
    public String mostrarUsuarios(){
         return "Mostrar usuario";
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
