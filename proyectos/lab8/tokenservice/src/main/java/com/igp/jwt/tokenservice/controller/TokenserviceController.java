package com.igp.jwt.tokenservice.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.igp.jwt.tokenservice.entities.Usuario;
import com.igp.jwt.tokenservice.service.MyUserDetailsService;
import com.igp.jwt.tokenservice.service.SeguridadClient;

import com.igp.jwt.tokenservice.util.JwtUtil;

@RestController
@RequestMapping("/autenticar")
public class TokenserviceController {
    
    // @Autowired
    // private AuthenticationManager authenticationManager;
    
    @Autowired
    private SeguridadClient seguridadClient;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private final JwtUtil jwtUtil;

    public TokenserviceController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String generarToken(@RequestBody AuthRequest authRequest) throws Exception {
        String username = authRequest.getUsername();
        String password = authRequest.getPassword();
        Usuario usuario=seguridadClient.obtenerUsuarioPorUsername(username);
        
       if (password.equals(usuario.getPassword())) {
            System.out.println("usuario encontrado:"+username);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            return jwtUtil.generateToken(userDetails.getUsername());
        } else {
            throw new Exception("Credenciales inválidas"); 
        }
        
    }

    @GetMapping("/validar")
    public Boolean validarToken(@RequestHeader("Authorization") String authHeader) throws Exception {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new Exception("Falta o formato incorrecto en Authorization header");
        }
        String token = authHeader.substring(7); // quitar "Bearer "
        return jwtUtil.isTokenValid(token);
    }
}
