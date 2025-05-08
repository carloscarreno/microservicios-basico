package com.igp.cuenta.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igp.cuenta.entities.Cuenta;
import com.igp.cuenta.entities.seguridad.Usuario;
import com.igp.cuenta.repository.CuentaRepository;

@Service
public class CuentaService {

    private final CuentaRepository repository;
    
    @Autowired
    private SeguridadClient seguridadClient;

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

   public Usuario obtenerUsuarioPorUsername(String username){
    return seguridadClient.obtenerUsuarioPorUsername(username);
   }
}
