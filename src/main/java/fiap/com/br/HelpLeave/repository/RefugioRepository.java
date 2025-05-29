package fiap.com.br.HelpLeave.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fiap.com.br.HelpLeave.model.Refugio;

public interface RefugioRepository extends JpaRepository<Refugio, Long> {

    Page<Refugio> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
}
