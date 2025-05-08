package com.igp.bitcoins.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igp.bitcoins.entities.Bitcoin;
import com.igp.bitcoins.repository.BitcoinRepository;


@Service
public class BitcoinService {
    
    private final BitcoinRepository repository;
    
    @Autowired
    private final TokenserviceClient tokenserviceClient;
   
    public BitcoinService(BitcoinRepository repository) {
        this.repository = repository;
        this.tokenserviceClient = null;
    }

    public List<Bitcoin> listar() {
        return repository.findAll();
    }

    public Bitcoin guardar(Bitcoin nuevo) {
        return repository.save(nuevo);
    }

    public Bitcoin buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Bitcoin actualizar(Long id, Bitcoin nuevo) {
        Optional<Bitcoin> encontrado = repository.findById(id);
        if (encontrado.isPresent()) {
            Bitcoin entidad = encontrado.get();
            entidad.setIdCuenta(nuevo.getIdCuenta());
            entidad.setCantidad(nuevo.getCantidad());
            entidad.setValor(nuevo.getValor());
            return repository.save(entidad);
        }
        return null;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public Bitcoin obtenerBitcoins(Long idCuenta, String tokenRequest){   
      System.out.println("VALIDANDO EL TOKEN REQUEST:"+tokenRequest);  
      if(tokenserviceClient.validarToken(tokenRequest)){
            return repository.findByIdCuenta(idCuenta);
        }     
        return null;   
    }
    
}
