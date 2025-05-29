package fiap.com.br.HelpLeave.controller;

import fiap.com.br.HelpLeave.model.Rota;
import fiap.com.br.HelpLeave.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rotas")
public class RotaController {

    @Autowired
    private RotaRepository repository;

    @GetMapping
    public List<Rota> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Rota cadastrar(@RequestBody Rota rota) {
        return repository.save(rota);
    }
}
