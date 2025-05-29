package fiap.com.br.HelpLeave.repository;

import fiap.com.br.HelpLeave.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
