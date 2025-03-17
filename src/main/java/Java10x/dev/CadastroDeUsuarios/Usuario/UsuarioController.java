package Java10x.dev.CadastroDeUsuarios.Usuario;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> usuarioListarId(@PathVariable Long id){
        UsuarioDTO usuarioId = usuarioService.listarUsuarioId(id);

        if(usuarioId != null){
            usuarioService.listarUsuarioId(id);
            return ResponseEntity.ok(usuarioId);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário com o id " + id + " não encontrado");
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<String> usuarioCriar(@RequestBody UsuarioDTO usuarioDTO){
         UsuarioDTO criar = usuarioService.criarUsuario(usuarioDTO);
          return ResponseEntity.status(HttpStatus.CREATED)
                  .body("Usuário criado: " + criar.getNome());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> usuarioDeletar(@PathVariable Long id){
        UsuarioDTO deletar = usuarioService.listarUsuarioId(id);

        if(deletar != null){
            usuarioService.deletarUuario(id);
            return ResponseEntity.ok("Usuário deletado: " + id );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Id não encontrado");
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO verificarId = usuarioService.listarUsuarioId(id);

        if(verificarId != null){
            usuarioService.atualizarUsuario(id, usuarioDTO);
            return ResponseEntity.ok("Usuário Atualizado");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Id não encontrado");
        }
    }
}
