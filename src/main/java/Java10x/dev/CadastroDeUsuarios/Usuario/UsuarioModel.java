package Java10x.dev.CadastroDeUsuarios.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Idade")
    private int idade;

    @Column(name = "Cpf")
    private int cpf;

    @Column(unique = true)
    private String email;

}
