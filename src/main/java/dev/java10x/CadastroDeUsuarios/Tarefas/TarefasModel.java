package dev.java10x.CadastroDeUsuarios.Tarefas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeUsuarios.Usuarios.UsuarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_tarefas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TarefasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Nome")
    private String nome;
    @Column(name = "Dificuldade")
    private String dificuldade;

    @OneToMany(mappedBy = "tarefas")
    @JsonIgnore
    private List<UsuarioModel> usuario;

}
