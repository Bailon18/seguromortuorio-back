package com.seguro.app.model.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.seguro.app.model.entidad.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
   
}
