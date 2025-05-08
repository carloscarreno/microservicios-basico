
package com.igp.tokenservice.controller;

import com.igp.tokenservice.model.AuthRequest;
import com.igp.tokenservice.service.MyUserDetailsService;
import com.igp.tokenservice.util.JwtUtil;

import io.jsonwebtoken.Claims;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (Exception e) {
            throw new Exception("Credenciales inválidas");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        return jwtUtil.generateToken(userDetails.getUsername());
    }

  
    @GetMapping("/verify")
    public Boolean verificarToken(@RequestHeader("Authorization") String authHeader) throws Exception {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new Exception("Falta o formato incorrecto en Authorization header");
        }

        String token = authHeader.substring(7); // quitar "Bearer "
        Claims claims = jwtUtil.validateToken(token);
        System.out.println("Token válido para usuario: " + claims.getSubject());
        return true;
    }
}
