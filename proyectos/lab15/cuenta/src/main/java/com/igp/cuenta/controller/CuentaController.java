package com.igp.cuenta.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.igp.cuenta.entities.Bitcoin;
import com.igp.cuenta.entities.Cuenta;
import com.igp.cuenta.entities.seguridad.Usuario;
import com.igp.cuenta.service.BitcoinClient;
import com.igp.cuenta.service.CuentaService;
import com.igp.cuenta.service.dto.AuthRequest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    
    Logger logger = LoggerFactory.getLogger(CuentaController.class);
    private final CuentaService service;
    
    @Autowired
    private final BitcoinClient bitcoinClient;

    public CuentaController(CuentaService service, BitcoinClient bitcoinClient) {
        this.service = service;
        this.bitcoinClient = bitcoinClient;
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
    @GetMapping("/{id}/usuario")
    public Usuario obtenerUsuario(@PathVariable Long id) {
        Cuenta encontrado = service.buscarPorId(id);
        return service.obtenerUsuario(encontrado.getIdUsuario());
    }

    @GetMapping("/username/{username}")
    public Usuario obtenerUsuarioPorUsername(@PathVariable String username) {
        Usuario encontrado = service.obtenerUsuarioPorUsername(username);
        return encontrado;
    }

   @GetMapping("/{id}/token")
   public String getObtenerToken(@PathVariable Long id) {
       Usuario usuario = service.obtenerUsuario(id);
       AuthRequest authrequest = new AuthRequest();
       authrequest.setUsername(usuario.getUsername());
       authrequest.setPassword(usuario.getPassword());
       return service.obtenerToken(authrequest);
   }
   
   @GetMapping("/{id}/bitcoins")
   public Bitcoin obtenerBitcoins(@PathVariable Long id){
       Usuario usuario = service.obtenerUsuario(id);
       AuthRequest authrequest = new AuthRequest();
       authrequest.setUsername(usuario.getUsername());
       authrequest.setPassword(usuario.getPassword());
       String tokenBearer = "Bearer "+service.obtenerToken(authrequest);
       System.out.println("TOKEN BEARER => "+tokenBearer);
       Bitcoin bitcoin = bitcoinClient.obtenerBitcoins(tokenBearer, id);
       return bitcoin;
   }

   @PostMapping("/bitcoins")
   @CircuitBreaker(name = "cuenta-service", fallbackMethod = "fallbackObtenerBitcoins")
   public Bitcoin obtenerBitcoinsCredentials(@RequestBody AuthRequest authRequest){
       String tokenBearer = "Bearer "+service.obtenerToken(authRequest);
       Usuario usuario = service.obtenerUsuarioPorUsername(authRequest.getUsername());
       System.out.println("TOKEN BEARER => "+tokenBearer);
       Bitcoin bitcoin = bitcoinClient.obtenerBitcoins(tokenBearer, service.obterCuenta(usuario.getId()).getId());
       return bitcoin;
   }

   public Bitcoin fallbackObtenerBitcoins(Exception e){
    logger.info("Estamos experimentando fallas tecnicas en la aplicacion. Enviamos un Bitcoin vacio. Detalles:" + e.getMessage());
    return new Bitcoin(0.0,0.0, 0L);
   }

}