package com.seguro.app.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.seguro.app.model.entidad.Usuario;
import com.seguro.app.model.servicio.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
    private  UsuarioService usuarioService;


    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAllUsuarios();
    }

    @GetMapping("/{usuarioID}")
    public Optional<Usuario> getUsuarioById(@PathVariable Long usuarioID) {
        return usuarioService.findUsuarioById(usuarioID);
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @DeleteMapping("/{usuarioID}")
    public void deleteUsuario(@PathVariable Long usuarioID) {
        usuarioService.deleteUsuario(usuarioID);
    }
    
}
