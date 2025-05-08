package com.igp.saludo.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class SaludoController {

   private static final Logger logger = LoggerFactory.getLogger(SaludoController.class);

   @GetMapping("/") 
   public String hola(){
    logger.info("Hola Bro!, enviado a Logstash, date:"+new Date());
     return "Hola Mundo desde Spring Boot!";
   }
}
