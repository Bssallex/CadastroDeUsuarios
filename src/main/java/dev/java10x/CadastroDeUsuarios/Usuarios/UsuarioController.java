package dev.java10x.CadastroDeUsuarios.Usuarios;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Mensagem de boas vindas", description = "Uma rota que exibe uma mensagem de boas vindas para quem acessa")
     public String boasVindas(){
         return "Seja Bem Vindo!";
     }

    // Adicionar usuarios
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo usuario", description = "Um novo usuario é alocado ao banco de dados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Usuario criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do usuario")
    })
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
    @Operation(summary = "Exibe um usuario", description = "Exibe um usuario que está alocado ao banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario listado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuario não encontrado")
    })
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
    @Operation(summary = "Altera um usuario", description = "Altera os dados do usuario que está alocado ao banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuario não encontrado")
    })
    public ResponseEntity<?> alterarUsuariosId(
            @Parameter(description = "Usuario manda o ID no caminho a requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario recebe, através do corpo da requisição, os dados de alteração")
            @RequestBody UsuarioDTO usuarioAtualizado){

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
