package fiap.com.br.HelpLeave.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fiap.com.br.HelpLeave.model.Refugio;
import fiap.com.br.HelpLeave.repository.RefugioRepository;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Refúgios", description = "Cadastro e listagem de pontos de refúgio")
@RestController
@RequestMapping("/refugios")
public class RefugioController {

    @Autowired
    private RefugioRepository repository;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public Page<Refugio> listarRefugios(
            @RequestParam(required = false) String nome,
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanho,
            @RequestParam(defaultValue = "idRefugio") String ordenarPor,
            @RequestParam(defaultValue = "asc") String direcao
    ) {
        Pageable pageable = PageRequest.of(pagina, tamanho,
                direcao.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,
                ordenarPor);

        if (nome != null) {
            return repository.findByNomeContainingIgnoreCase(nome, pageable);
        } else {
            return repository.findAll(pageable);
        }
    }

    @PostMapping("/novo")
    @PreAuthorize("hasRole('USER')")
    public Refugio cadastrarRefugio(@RequestBody Refugio refugio) {
        return repository.save(refugio);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public Refugio atualizar(@PathVariable Long id, @RequestBody Refugio atualizado) {
        Optional<Refugio> optional = repository.findById(id);
        if (optional.isPresent()) {
            Refugio refugio = optional.get();
            refugio.setNome(atualizado.getNome());
            refugio.setEndereco(atualizado.getEndereco());
            refugio.setCapacidade(atualizado.getCapacidade());
            return repository.save(refugio);
        } else {
            throw new RuntimeException("Refúgio não encontrado com ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
