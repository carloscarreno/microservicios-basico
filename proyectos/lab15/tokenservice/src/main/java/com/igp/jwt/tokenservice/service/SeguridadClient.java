package com.igp.jwt.tokenservice.service;

import java.util.Set;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.igp.jwt.tokenservice.entities.Rol;
import com.igp.jwt.tokenservice.entities.Usuario;

//@FeignClient(name = "seguridad-service", url = "http://localhost:8082")
@FeignClient(name = "seguridad-service")
public interface SeguridadClient {
   
    @GetMapping("/usuarios/username/{username}")
    Usuario obtenerUsuarioPorUsername(@PathVariable("username") String username);
    
    @GetMapping("/usuarios/{usuarioId}/roles")
    Set<Rol> obtenerRoles(@PathVariable Long usuarioId);

}
