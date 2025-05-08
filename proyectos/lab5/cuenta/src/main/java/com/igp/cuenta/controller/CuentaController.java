package com.igp.cuenta.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igp.cuenta.entities.Cuenta;
import com.igp.cuenta.entities.seguridad.Usuario;
import com.igp.cuenta.service.CuentaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name="Cuentas", description="Controlador de peticiones REST de Cuentas")
@RestController
@RequestMapping("/cuentas")
public class CuentaController {
        private final CuentaService service;

    public CuentaController(CuentaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cuenta> listar() {
        return service.listar();
    }

    @PostMapping
    public Cuenta crear(@RequestBody Cuenta cuenta) {
        return service.guardar(cuenta);
    }

    @GetMapping("/{id}")
    public Cuenta obtener(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Cuenta actualizar(@PathVariable Long id, @RequestBody Cuenta cuenta) {
        return service.actualizar(id, cuenta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    // Obtiene el usuario desde el servicio de seguridad
    @Operation(summary="Obtiene el usuario asociado a la cuenta de bitcoins")
    @ApiResponse(responseCode="200",description="Retorno el usuario con exito")
    @GetMapping("/{id}/usuario")
    public Usuario obtenerUsuario(@PathVariable Long id) {
        Cuenta encontrado = service.buscarPorId(id);
        return service.obtenerUsuario(encontrado.getIdUsuario());
    }

}
