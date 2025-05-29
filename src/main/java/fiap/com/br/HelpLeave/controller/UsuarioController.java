package fiap.com.br.HelpLeave.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import fiap.com.br.HelpLeave.model.Usuario;
import fiap.com.br.HelpLeave.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }
}
