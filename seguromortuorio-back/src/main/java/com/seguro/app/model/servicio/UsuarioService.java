package com.seguro.app.model.servicio;

import java.util.List;
import java.util.Optional;

import com.seguro.app.model.entidad.Usuario;

public interface UsuarioService {
	
    List<Usuario> findAllUsuarios();

    Optional<Usuario> findUsuarioById(Long usuarioID);

    Usuario saveUsuario(Usuario usuario);

    void deleteUsuario(Long usuarioID);
    
    Usuario validarInicioSesion(String correoElectronico, String contrasena);
    
    boolean existeCorreoElectronico(String correoElectronico);
    
    boolean existeNombreUsuario(String nombreUsuario);
    
    Usuario bloquearUsuario(Long id,  boolean estado);
    

}
