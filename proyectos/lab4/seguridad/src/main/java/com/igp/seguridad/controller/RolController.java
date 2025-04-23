package com.igp.seguridad.controller;

import org.springframework.web.bind.annotation.*;
import com.igp.seguridad.entities.Rol;
import com.igp.seguridad.service.RolService;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public List<Rol> listar() {
        return rolService.listar();
    }

    @GetMapping("/{id}")
    public Rol obtener(@PathVariable Long id) {
        return rolService.buscarPorId(id);
    }

    @PostMapping
    public Rol crear(@RequestBody Rol rol) {
        return rolService.crear(rol);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        rolService.eliminar(id);
    }
}