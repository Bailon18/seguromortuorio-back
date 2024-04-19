package com.seguro.app.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.seguro.app.model.entidad.Usuario;
import com.seguro.app.model.servicio.UsuarioService;
import com.seguro.app.util.SEGURIDAD.UsuarioLogeado;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apifm/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
    private  UsuarioService usuarioService;


    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAllUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioService.findUsuarioById(id);
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @DeleteMapping("/{usuarioID}")
    public void deleteUsuario(@PathVariable Long usuarioID) {
        usuarioService.deleteUsuario(usuarioID);
    }
    
    @PostMapping("/login")
    public ResponseEntity<Usuario> validarInicioSesion(@RequestBody UsuarioLogeado usuarioLogeado) {
        
    	Usuario usuario = usuarioService.validarInicioSesion(usuarioLogeado.getCorreo(), usuarioLogeado.getContrasena());

        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/existe-correo")
    public ResponseEntity<Boolean> existeCorreoElectronico(@RequestParam String correoElectronico) {
        boolean existe = usuarioService.existeCorreoElectronico(correoElectronico);
        return ResponseEntity.ok(existe);
    }
    
    @GetMapping("/existe-nombre-usuario")
    public ResponseEntity<Boolean> existeNombreUsuario(@RequestParam String nombreUsuario) {
        boolean existe = usuarioService.existeNombreUsuario(nombreUsuario);
        return ResponseEntity.ok(existe);
    }

    @PostMapping("/cambiarEstado/{id}/{estado}")
    public ResponseEntity<Usuario> bloquearUsuario(@PathVariable Long id, @PathVariable boolean estado) {
        Usuario usuario = usuarioService.bloquearUsuario(id, estado);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
}
