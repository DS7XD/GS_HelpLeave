package fiap.com.br.HelpLeave.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fiap.com.br.HelpLeave.model.Alerta;
import fiap.com.br.HelpLeave.repository.AlertaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Alertas", description = "Gerenciamento dos alertas em situações de risco")
@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private AlertaRepository repository;

    @Operation(summary = "Listar alertas", description = "Lista todos os alertas com filtros opcionais por tipo e localização.")
    @GetMapping
    @PreAuthorize("hasRole('USER')")
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

    @Operation(summary = "Cadastrar alerta", description = "Cadastra um novo alerta.")
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public Alerta cadastrar(@RequestBody Alerta alerta) {
        return repository.save(alerta);
    }
}
