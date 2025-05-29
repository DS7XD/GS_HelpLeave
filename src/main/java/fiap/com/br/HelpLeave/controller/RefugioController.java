package fiap.com.br.HelpLeave.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fiap.com.br.HelpLeave.model.Refugio;
import fiap.com.br.HelpLeave.repository.RefugioRepository;

@RestController
@RequestMapping("/refugios")
public class RefugioController {

    @Autowired
    private RefugioRepository repository;

    @GetMapping
    public Page<Refugio> listar(
            @RequestParam(required = false) String nome,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "idRefugio") String sort,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Pageable pageable = PageRequest.of(page, size,
                direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,
                sort);

        if (nome != null) {
            return repository.findByNomeContainingIgnoreCase(nome, pageable);
        } else {
            return repository.findAll(pageable);
        }
    }

    @PostMapping
    public Refugio cadastrar(@RequestBody Refugio refugio) {
        return repository.save(refugio);
    }
}
