package dev.java10x.CadastroDeUsuarios.Tarefas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tarefas")

public class TarefasController {

    @GetMapping("/listar")
    public String mostrarTarefas(){
        return "Todas as tarefas";
    }

    @PostMapping("/criar")
    public String criarTarefas(){
       return "Tarefa criada";
    }

    @PutMapping("/alterar")
    public String alterarTarefa(){
        return "Tarefa alterada";
    }

    @DeleteMapping("/deletar")
    public String deletarTarefa(){
        return "Tarefa deletada";
    }
}
