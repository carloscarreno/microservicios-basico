package com.igp.cuenta.service;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igp.cuenta.entities.Bitcoin;
import com.igp.cuenta.entities.Cuenta;
import com.igp.cuenta.entities.seguridad.Usuario;
import com.igp.cuenta.repository.CuentaRepository;
import com.igp.cuenta.service.dto.AuthRequest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;

@Service
public class CuentaService {
    
    private final CuentaRepository repository;
    
    @Autowired
    private SeguridadClient seguridadClient;

    @Autowired
    private TokenserviceClient tokenserviceClient;

    @Autowired
    private BitcoinClient bitcoinClient;

    public CuentaService(CuentaRepository repository) {
        this.repository = repository;
    }

    public List<Cuenta> listar() {
        return repository.findAll();
    }

    public Cuenta guardar(Cuenta cuenta) {
        return repository.save(cuenta);
    }

    public Cuenta buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Cuenta actualizar(Long id, Cuenta nuevo) {
        Optional<Cuenta> encontrado = repository.findById(id);
        if (encontrado.isPresent()) {
            Cuenta cuenta = encontrado.get();
            cuenta.setNombre(nuevo.getNombre());
            cuenta.setCorreo(nuevo.getCorreo());
            cuenta.setIdUsuario(nuevo.getIdUsuario());
            return repository.save(cuenta);
        }
        return null;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

   public Usuario obtenerUsuario(Long idUsuario){
        return seguridadClient.obtenerUsuario(idUsuario);
   }

  
   public String obtenerToken(AuthRequest authRequest){
         return tokenserviceClient.obtenerToken(authRequest);
   }

   public Usuario obtenerUsuarioPorUsername(String username){
          return seguridadClient.obtenerUsuarioPorUsername(username);
   }
   
   
   public Bitcoin obtenerBitcoins(String tokeString,Long idCuenta){
          return bitcoinClient.obtenerBitcoins(tokeString, idCuenta);
   }
   
   public Cuenta obterCuenta(Long idUsuario){
         return repository.findByIdUsuario(idUsuario);
   }

}
