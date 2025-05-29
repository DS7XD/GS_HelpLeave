package fiap.com.br.HelpLeave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fiap.com.br.HelpLeave.model.Refugio;
import fiap.com.br.HelpLeave.repository.RefugioRepository;

@RestController
@RequestMapping("/refugios")
public class RefugioController {

    @Autowired
    private RefugioRepository repository;

    @GetMapping
    public List<Refugio> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Refugio cadastrar(@RequestBody Refugio refugio) {
        return repository.save(refugio);
    }
}
