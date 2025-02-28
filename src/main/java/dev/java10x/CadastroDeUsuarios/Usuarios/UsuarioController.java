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
    public UsuarioDTO criarUsuario(@RequestBody UsuarioDTO usuario){
       return usuarioService.criarUsuario(usuario);
    }

    // Listar usuarios
    @GetMapping("/listar")
    public List<UsuarioDTO> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    // Mostrar todos os usuarios por ID
    @GetMapping("/listar/{id}")
    public UsuarioDTO listarUsuariosId(@PathVariable Long id){
        return usuarioService.listarUsuariosId(id);
    }

    // Alterar dados dos usuarios
    @PutMapping("/alterar/{id}")
    public UsuarioDTO alterarUsuariosId(@PathVariable Long id, @RequestBody UsuarioDTO usuarioAtualizado){
         return usuarioService.atualizarUsuario(id, usuarioAtualizado);
    }

    // Deletar usuario por ID
    @DeleteMapping("/deletar/{id}")
    public void deletarUsuariosId(@PathVariable Long id){
        usuarioService.deletarUsuarioId(id);
    }







}
