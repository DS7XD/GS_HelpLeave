package fiap.com.br.HelpLeave.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fiap.com.br.HelpLeave.model.AuthRequest;
import fiap.com.br.HelpLeave.model.AuthResponse;
import fiap.com.br.HelpLeave.model.RegisterRequest;
import fiap.com.br.HelpLeave.model.Usuario;
import fiap.com.br.HelpLeave.security.JWTUtil;
import fiap.com.br.HelpLeave.security.UserDetailsServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Autenticação", description = "Login e registro de usuários")
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getSenha()
                )
            );

            final var userDetails = userDetailsService.loadUserByUsername(request.getEmail());
            final var token = jwtUtil.generateToken(userDetails);

            
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Usuário ou senha inválidos");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrarUsuario(@RequestBody RegisterRequest request) {
        if (userDetailsService.getUsuarioRepository().findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email já está em uso.");
        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setEmail(request.getEmail());
        novoUsuario.setNome(request.getNome());
        novoUsuario.setSenha(passwordEncoder.encode(request.getSenha()));
        novoUsuario.setIdUsuario(System.currentTimeMillis());

        userDetailsService.getUsuarioRepository().save(novoUsuario);

        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }
}
