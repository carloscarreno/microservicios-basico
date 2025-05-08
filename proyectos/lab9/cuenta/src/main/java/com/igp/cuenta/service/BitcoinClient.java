package com.igp.cuenta.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.igp.cuenta.entities.Bitcoin;

@FeignClient(name = "bitcoin-service", url = "http://localhost:8084")
public interface BitcoinClient {

    @GetMapping("/bitcoins/cuenta/{idcuenta}")
    Bitcoin obtenerBitcoins(@RequestHeader("Authorization") String authHeader, @PathVariable("idcuenta") Long idCuenta); 

}
