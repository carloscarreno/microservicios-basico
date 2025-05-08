package com.igp.jwt.tokenservice.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.igp.jwt.tokenservice.entities.Rol;
import com.igp.jwt.tokenservice.entities.Usuario;

@Service
public class MyUserDetailsService implements UserDetailsService {
    
    @Autowired
    private SeguridadClient seguridadClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Carga el usuario con los roles 
        Usuario usuario=seguridadClient.obtenerUsuarioPorUsername(username);
        
        if (usuario != null) {
            Set<Rol> roles = seguridadClient.obtenerRoles(usuario.getId());
            List<String> lista = roles.stream()
                                      .map(Rol::getNombre)
                                      .collect(Collectors.toList());
            System.out.println("roles del usuario:"+lista.toString());
            return User.withUsername(usuario.getUsername())
                    .password(new BCryptPasswordEncoder().encode(usuario.getPassword()))
                    .roles(lista.toString())
                    .build();
        } 
        throw new UsernameNotFoundException("Usuario no encontrado");

    }
}
