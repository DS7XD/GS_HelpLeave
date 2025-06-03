package fiap.com.br.HelpLeave.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fiap.com.br.HelpLeave.model.Rota;

public interface RotaRepository extends JpaRepository<Rota, Long> {

    Page<Rota> findByPontoInicioContainingIgnoreCase(String pontoInicio, Pageable pageable);

    Page<Rota> findByPontoFimContainingIgnoreCase(String pontoFim, Pageable pageable);

    Page<Rota> findByPontoInicioContainingIgnoreCaseAndPontoFimContainingIgnoreCase(String pontoInicio, String pontoFim, Pageable pageable);

}
