package fiap.com.br.HelpLeave.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fiap.com.br.HelpLeave.model.Rota;

public interface RotaRepository extends JpaRepository<Rota, Long> {

    Page<Rota> findByOrigemContainingIgnoreCase(String origem, Pageable pageable);

    Page<Rota> findByDestinoContainingIgnoreCase(String destino, Pageable pageable);

    Page<Rota> findByOrigemContainingIgnoreCaseAndDestinoContainingIgnoreCase(String origem, String destino, Pageable pageable);
}
