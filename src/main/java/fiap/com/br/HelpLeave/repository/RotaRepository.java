package fiap.com.br.HelpLeave.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fiap.com.br.HelpLeave.model.Rota;

public interface RotaRepository extends JpaRepository<Rota, Long> {

    Page<Rota> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

    Page<Rota> findByNivelRiscoContainingIgnoreCase(String nivelRisco, Pageable pageable);

    Page<Rota> findByNomeContainingIgnoreCaseAndNivelRiscoContainingIgnoreCase(String nome, String nivelRisco, Pageable pageable);

}
