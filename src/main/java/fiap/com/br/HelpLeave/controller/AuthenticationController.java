package fiap.com.br.HelpLeave.controller;

import fiap.com.br.HelpLeave.security.JWTUtil;
import fiap.com.br.HelpLeave.model.AuthRequest;
import fiap.com.br.HelpLeave.model.AuthResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    public AuthenticationController(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha())
            );

            String token = jwtUtil.generateToken(request.getEmail());
            return new AuthResponse(token);

        } catch (AuthenticationException e) {
            throw new RuntimeException("Credenciais inválidas");
        }
    }
}
