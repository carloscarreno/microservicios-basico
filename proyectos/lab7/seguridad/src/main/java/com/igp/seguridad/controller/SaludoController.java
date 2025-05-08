package com.igp.seguridad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

	 @GetMapping("/")
	    public String hola() {
	        return "Hola Mundo desde Spring Boot!";
	    }
}
