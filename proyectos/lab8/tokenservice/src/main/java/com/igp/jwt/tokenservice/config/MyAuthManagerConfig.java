package com.igp.jwt.tokenservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;


@Configuration
public class MyAuthManagerConfig {
    

    @Bean
    public AuthenticationManager authenticationManager() {
        return new AuthenticationManager() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                String username = authentication.getName();
                String password = authentication.getCredentials().toString();

                // Aquí puedes implementar TU lógica: consultar base de datos, API, etc.
                if ("admin".equals(username) && "password".equals(password)) {  
                    return new UsernamePasswordAuthenticationToken(username, password);
                } else {
                    throw new RuntimeException("Credenciales inválidas");
                }
            }
        };
    }
}
