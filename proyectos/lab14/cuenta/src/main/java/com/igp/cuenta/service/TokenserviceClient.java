package com.igp.cuenta.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.igp.cuenta.service.dto.AuthRequest;

//@FeignClient(name = "tokenservice-service", url = "http://localhost:8081")
@FeignClient(name = "tokenservice")
public interface TokenserviceClient {

    @GetMapping("/autenticar/login")
    String obtenerToken(AuthRequest authRequest); 

}
