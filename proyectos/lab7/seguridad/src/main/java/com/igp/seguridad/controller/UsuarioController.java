package com.igp.seguridad.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.igp.seguridad.entities.Rol;
import com.igp.seguridad.entities.Usuario;
import com.igp.seguridad.service.UsuarioService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return service.guardar(usuario);
    }

    @GetMapping("/{id}")
    public Usuario obtener(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/username/{username}")
    public Usuario obtenerPorUsername(@PathVariable String username) {
        return service.buscarPorUsername(username);
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
    
    @GetMapping("/{usuarioId}/roles")
    public Set<Rol> obtenerRoles(@PathVariable Long usuarioId){
       return service.buscarPorId(usuarioId).getRoles();
    }

}
