package dev.java10x.CadastroDeUsuarios.Tarefas;

import dev.java10x.CadastroDeUsuarios.Usuarios.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefasRepository extends JpaRepository<TarefasModel, Long> {
}
