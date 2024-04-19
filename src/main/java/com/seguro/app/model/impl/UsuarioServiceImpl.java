package com.seguro.app.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.seguro.app.model.entidad.Usuario;
import com.seguro.app.model.repositorio.UsuarioRepository;
import com.seguro.app.model.servicio.UsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
	@Autowired
	private  UsuarioRepository usuarioRepository;

   
    @Override
    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Optional<Usuario> findUsuarioById(Long usuarioID) {
        return usuarioRepository.findById(usuarioID);
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Long usuarioID) {
        usuarioRepository.deleteById(usuarioID);
    }
    
    @Override
    public Usuario validarInicioSesion(String correoElectronico, String contrasena) {
        return usuarioRepository.findByCorreoElectronicoAndContrasena(correoElectronico, contrasena);
    }
    
    @Override
    public boolean existeCorreoElectronico(String correoElectronico) {
        return usuarioRepository.existsByCorreoElectronico(correoElectronico);
    }

    @Override
    public boolean existeNombreUsuario(String nombreUsuario) {
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    @Override
    public Usuario bloquearUsuario(Long id, boolean estado) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setActivo(estado);
        return usuarioRepository.save(usuario);
    }
}
