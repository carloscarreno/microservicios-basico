package com.igp.cuenta.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.igp.cuenta.entities.seguridad.Usuario;

@FeignClient(name = "seguridad-service", url = "http://localhost:8082")
public interface SeguridadClient {
   
    @GetMapping("/usuarios/{id}")
    Usuario obtenerUsuario(@PathVariable("id") Long id);
}
