package dev.java10x.CadastroDeUsuarios.Usuarios;

import dev.java10x.CadastroDeUsuarios.Tarefas.TarefasModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    private String cpf;
    private TarefasModel tarefas;
git
}
