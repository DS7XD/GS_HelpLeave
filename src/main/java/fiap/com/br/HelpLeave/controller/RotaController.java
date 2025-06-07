package fiap.com.br.HelpLeave.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import fiap.com.br.HelpLeave.model.Rota;
import fiap.com.br.HelpLeave.repository.RotaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Rotas", description = "Gerenciamento das rotas seguras")
@RestController
@RequestMapping("/rotas")
public class RotaController {

    @Autowired
    private RotaRepository repository;

    @Operation(summary = "Listar rotas", description = "Lista todas as rotas com filtros opcionais por nome e nível de risco.")
    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public Page<Rota> listar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String nivelRisco,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "idRota") String sort,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Pageable pageable = PageRequest.of(page, size,
                direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,
                sort);

        if (nome != null && nivelRisco != null) {
            return repository.findByNomeContainingIgnoreCaseAndNivelRiscoContainingIgnoreCase(nome, nivelRisco, pageable);
        } else if (nome != null) {
            return repository.findByNomeContainingIgnoreCase(nome, pageable);
        } else if (nivelRisco != null) {
            return repository.findByNivelRiscoContainingIgnoreCase(nivelRisco, pageable);
        } else {
            return repository.findAll(pageable);
        }
    }

    @Operation(summary = "Cadastrar rota", description = "Cadastra uma nova rota segura.")
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public Rota cadastrar(@RequestBody Rota rota) {
        return repository.save(rota);
    }
}
