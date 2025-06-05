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

import fiap.com.br.HelpLeave.model.Rota;
import fiap.com.br.HelpLeave.repository.RotaRepository;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Rotas", description = "Gerenciamento das rotas de fuga em eventos de emergência")
@RestController
@RequestMapping("/rotas")
public class RotaController {

    @Autowired
    private RotaRepository repository;

    @GetMapping
    public Page<Rota> listarRotas(
            @RequestParam(required = false) String origem,
            @RequestParam(required = false) String destino,
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanho,
            @RequestParam(defaultValue = "idRota") String ordenarPor,
            @RequestParam(defaultValue = "asc") String direcao
    ) {
        Pageable pageable = PageRequest.of(pagina, tamanho,
                direcao.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,
                ordenarPor);

        if (origem != null && destino != null) {
            return repository.findByPontoInicioContainingIgnoreCaseAndPontoFimContainingIgnoreCase(origem, destino, pageable);
        } else if (origem != null) {
            return repository.findByPontoInicioContainingIgnoreCase(origem, pageable);
        } else if (destino != null) {
            return repository.findByPontoFimContainingIgnoreCase(destino, pageable);
        } else {
            return repository.findAll(pageable);
        }
    }

    @PostMapping("/nova")
    public Rota cadastrarRota(@RequestBody Rota rota) {
        return repository.save(rota);
    }
}
