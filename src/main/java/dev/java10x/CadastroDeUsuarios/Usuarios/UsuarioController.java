package dev.java10x.CadastroDeUsuarios.Usuarios;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

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
    @GetMapping("/todos")
    public String mostrarUsuarios(){
         return "Mostrar usuario";
    }

    // Mostrar todos os usuarios por ID
    @GetMapping("/todosId")
    public String mostrarUsuariosId(){
        return "Mostrar usuario por id";
    }

    // Alterar dados dos usuarios
    @PutMapping("/alterarId")
    public String alterarUsuariosId(){
         return "Alterar usuario por id";
    }

    // Deletar usuarios por ID
    @DeleteMapping("/deletar")
    public String deletarUsuariosId(){
         return "Usuario deletado por id";
    }





}
