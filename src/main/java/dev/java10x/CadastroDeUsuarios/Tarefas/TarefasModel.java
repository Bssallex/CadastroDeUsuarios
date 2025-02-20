package dev.java10x.CadastroDeUsuarios.Tarefas;

import dev.java10x.CadastroDeUsuarios.Usuarios.UsuarioModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_tarefas")

public class TarefasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    @OneToMany(mappedBy = "tarefas")
    private List<UsuarioModel> usuario;

}
