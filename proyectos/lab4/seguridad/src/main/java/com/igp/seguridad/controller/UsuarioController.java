package com.igp.seguridad.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.igp.seguridad.entities.Usuario;
import com.igp.seguridad.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name="Usuarios", description="Entidad Usuario del modelo de autenticacion")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @Operation(summary = "Obtiene todos los usarios registrados")
    @ApiResponses(value={
        @ApiResponse(responseCode="200", description="Se obtuvo la lista con exito"),
        @ApiResponse(responseCode="500", description="Error interno en el servidor")
    }) 
    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Usuario crear(@RequestBody Usuario usuario) {
        return service.guardar(usuario);
    }

    @GetMapping("/{id}")
    public Usuario obtener(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return service.actualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
    
    @PutMapping("/{usuarioId}/roles/{rolId}")
    public Usuario asignarRol(
            @PathVariable Long usuarioId,
            @PathVariable Long rolId) {
        return service.asignarRol(usuarioId, rolId);
    }
    
    @DeleteMapping("/{usuarioId}/roles/{rolId}")
    public Usuario removerRol(
            @PathVariable Long usuarioId,
            @PathVariable Long rolId) {
        return service.removerRol(usuarioId, rolId);
    }
    
}
