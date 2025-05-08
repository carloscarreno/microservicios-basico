package com.igp.jwt.tokenservice.controller;

import org.springframework.web.bind.annotation.*;
import com.igp.jwt.tokenservice.util.JwtUtil;

@RestController
@RequestMapping("/autenticar")
public class TokenserviceController {

    private final JwtUtil jwtUtil;

    public TokenserviceController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        // Validación del usuario y generacion del token si el usuario no es valido genera una excepcion.
        if ("admin".equals(authRequest.getUsername()) && "password".equals(authRequest.getPassword())) {
            return jwtUtil.generateToken(authRequest.getUsername());
        }
        throw new RuntimeException("Credenciales inválidas");
    }

    @GetMapping("/validar")
    public Boolean calidarToken(@RequestHeader("Authorization") String authHeader) throws Exception {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new Exception("Falta o formato incorrecto en Authorization header");
        }
        String token = authHeader.substring(7); // quitar "Bearer "
        if (jwtUtil.isTokenValid(token)){
            System.out.println("Token válido para usuario: " + jwtUtil.extractUsername(token));
        } else {
            throw new Exception("El token no es valido o esta vencido.");
        }       
        return true;
    }
}
