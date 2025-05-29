package fiap.com.br.HelpLeave.controller;

import fiap.com.br.HelpLeave.model.Alerta;
import fiap.com.br.HelpLeave.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private AlertaRepository repository;

    @GetMapping
    public Page<Alerta> listar(
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) String localizacao,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "idAlerta") String sort,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Pageable pageable = PageRequest.of(page, size,
                direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,
                sort);

        if (tipo != null && localizacao != null) {
            return repository.findByTipoContainingIgnoreCaseAndLocalizacaoContainingIgnoreCase(tipo, localizacao, pageable);
        } else if (tipo != null) {
            return repository.findByTipoContainingIgnoreCase(tipo, pageable);
        } else if (localizacao != null) {
            return repository.findByLocalizacaoContainingIgnoreCase(localizacao, pageable);
        } else {
            return repository.findAll(pageable);
        }
    }

    @PostMapping
    public Alerta cadastrar(@RequestBody Alerta alerta) {
        return repository.save(alerta);
    }
}
