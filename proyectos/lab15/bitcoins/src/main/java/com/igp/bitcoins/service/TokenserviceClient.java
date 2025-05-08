package com.igp.bitcoins.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.igp.bitcoins.service.dto.AuthRequest;

//@FeignClient(name = "tokenservice-service", url = "http://localhost:8081")
@FeignClient(name = "tokenservice")
public interface TokenserviceClient {

    @GetMapping("/autenticar/login")
    String obtenerToken(@RequestBody AuthRequest authRequest); 

    @GetMapping("/autenticar/validar")
    Boolean validarToken(@RequestHeader("Authorization") String tokenRequest);  // El token request es Beader Token 

}
