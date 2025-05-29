package fiap.com.br.HelpLeave.controller;

import fiap.com.br.HelpLeave.model.Rota;
import fiap.com.br.HelpLeave.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rotas")
public class RotaController {

    @Autowired
    private RotaRepository repository;

    @GetMapping
    public Page<Rota> listar(
            @RequestParam(required = false) String origem,
            @RequestParam(required = false) String destino,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "idRota") String sort,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Pageable pageable = PageRequest.of(page, size,
                direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,
                sort);

        if (origem != null && destino != null) {
            return repository.findByOrigemContainingIgnoreCaseAndDestinoContainingIgnoreCase(origem, destino, pageable);
        } else if (origem != null) {
            return repository.findByOrigemContainingIgnoreCase(origem, pageable);
        } else if (destino != null) {
            return repository.findByDestinoContainingIgnoreCase(destino, pageable);
        } else {
            return repository.findAll(pageable);
        }
    }

    @PostMapping
    public Rota cadastrar(@RequestBody Rota rota) {
        return repository.save(rota);
    }
}
