package com.igp.seguridad.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igp.seguridad.entities.Rol;
import com.igp.seguridad.entities.Usuario;
import com.igp.seguridad.repository.RolRepository;
import com.igp.seguridad.repository.UsuarioRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {
   
    
    @Autowired 	
    private final UsuarioRepository usuarioRepository;
    @Autowired 	
    private final RolRepository rolRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
       	this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }
    public List<Usuario> listar() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario actualizar(Long id, Usuario nuevo) {
        Optional<Usuario> encontrado = usuarioRepository.findById(id);
        if (encontrado.isPresent()) {
            Usuario usuario = encontrado.get();
            usuario.setUsername(nuevo.getUsername());
            usuario.setPassword(nuevo.getPassword());
            usuario.setCorreo(nuevo.getCorreo());
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public void eliminar(Long id) {
    	usuarioRepository.deleteById(id);
    }
    
    public Usuario asignarRol(Long usuarioId, Long rolId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Rol rol = rolRepository.findById(rolId)
            .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        if (usuario.getRoles() == null) {
            usuario.setRoles(new HashSet<>());
        }

        usuario.getRoles().add(rol);
        return usuarioRepository.save(usuario);
    }
    
    public Usuario removerRol(Long usuarioId, Long rolId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Rol rol = rolRepository.findById(rolId)
            .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        if (usuario.getRoles() != null) {
            usuario.getRoles().remove(rol);
        }

        return usuarioRepository.save(usuario);
    }
    
}
