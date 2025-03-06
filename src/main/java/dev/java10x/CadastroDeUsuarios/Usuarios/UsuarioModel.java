package dev.java10x.CadastroDeUsuarios.Usuarios;

import dev.java10x.CadastroDeUsuarios.Tarefas.TarefasModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_cadastro")
@Data
@ToString(exclude = "tarefas_id")
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "Img_Url")
    private String imgUrl;

    @Column(name = "Idade")
    private int idade;

    @Column(name = "Cpf")
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "tarefas_id")
    private TarefasModel tarefas;

}
