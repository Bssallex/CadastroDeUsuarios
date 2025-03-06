package dev.java10x.CadastroDeUsuarios.Usuarios;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/boasvindas")
     public String boasVindas(){
         return "Seja Bem Vindo!";
     }

    // Adicionar usuarios
    @PostMapping("/criar")
    public ResponseEntity<String> criarUsuario(@RequestBody UsuarioDTO usuario){
        UsuarioDTO usuarioDTO = usuarioService.criarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuário criado: " + usuarioDTO.getNome() + " / id: " + usuarioDTO.getId());
    }

    // Listar usuarios
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios(){
        List<UsuarioDTO> listaUsuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(listaUsuarios);
    }

    // Mostrar todos os usuarios por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarUsuariosId(@PathVariable Long id){

        UsuarioDTO usuarioID = usuarioService.listarUsuariosId(id);

        if(usuarioID != null){
            return ResponseEntity.ok(usuarioID);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe nenhum usuário com esse ID");
        }
    }

    // Alterar dados dos usuarios
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarUsuariosId(@PathVariable Long id, @RequestBody UsuarioDTO usuarioAtualizado){

        UsuarioDTO alterarUsuarioDTO = usuarioService.atualizarUsuario(id, usuarioAtualizado);

        if(alterarUsuarioDTO != null){
            return ResponseEntity.ok(usuarioAtualizado);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe nenhum usuário com esse ID");
        }

    }

    // Deletar usuario por ID
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarUsuariosId(@PathVariable Long id){

        if(usuarioService.listarUsuariosId(id) != null){
            usuarioService.deletarUsuarioId(id);
            return ResponseEntity.ok("Usuário deletado " + "/ Id: " + id);
        }
        else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe nenhum usuário com esse ID");
        }
    }







}
