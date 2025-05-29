package fiap.com.br.HelpLeave.repository;

import fiap.com.br.HelpLeave.model.Alerta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {

    Page<Alerta> findByTipoContainingIgnoreCase(String tipo, Pageable pageable);

    Page<Alerta> findByLocalizacaoContainingIgnoreCase(String localizacao, Pageable pageable);

    Page<Alerta> findByTipoContainingIgnoreCaseAndLocalizacaoContainingIgnoreCase(String tipo, String localizacao, Pageable pageable);
}
