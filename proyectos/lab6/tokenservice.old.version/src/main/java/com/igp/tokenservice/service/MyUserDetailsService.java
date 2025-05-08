
package com.igp.tokenservice.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Carga el usuario con los roles 
        if ("admin".equals(username)) {
            return User.withUsername("admin")
                    .password(new BCryptPasswordEncoder().encode("password"))
                    .roles("ADMIN","OPERATOR")
                    .build();
        } else if ("user".equals(username)) {
            return User.withUsername("user")
                    .password(new BCryptPasswordEncoder().encode("password"))
                    .roles("USER")
                    .build();
        }
        throw new UsernameNotFoundException("Usuario no encontrado");

       //return new User("admin", new BCryptPasswordEncoder().encode("password"), new ArrayList<>());
    }
}
