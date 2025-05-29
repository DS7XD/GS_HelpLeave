package fiap.com.br.HelpLeave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fiap.com.br.HelpLeave.model.Alerta;
import fiap.com.br.HelpLeave.repository.AlertaRepository;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private AlertaRepository repository;

    @GetMapping
    public List<Alerta> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Alerta cadastrar(@RequestBody Alerta alerta) {
        return repository.save(alerta);
    }
}
