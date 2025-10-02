package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.usuario;
import co.edu.ue.service.RegistroUsuarioRequest;
import co.edu.ue.service.RegistroUsuarioService;

@RestController
@RequestMapping("/registro")
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:5500", "http://localhost:5500"})
public class RegistroController {
    
    @Autowired
    private RegistroUsuarioService registroService;

    @PostMapping("/donante")
    public ResponseEntity<?> registrarDonante(@RequestBody RegistroUsuarioRequest request) {
        try {
            // Validar que es un registro de donante
            if (request.getEstado_donante() == null) {
                request.setEstado_donante((byte) 1); 
            }
            if (!"DONANTE".equals(request.getRol())) {
                return ResponseEntity.badRequest()
                    .body("El rol debe ser 'DONANTE' para este endpoint");
            }
            
            // Validaciones básicas
            if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Email es obligatorio");
            }
            if (request.getContrasena() == null || request.getContrasena().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Contraseña es obligatoria");
            }
            if (request.getNombre_donante() == null || request.getNombre_donante().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Nombre del donante es obligatorio");
            }
            
            usuario usuarioCreado = registroService.registrarDonante(request);
            
            return ResponseEntity.status(HttpStatus.CREATED)
                .body("Donante registrado exitosamente con ID: " + usuarioCreado.getId_usuario());
                
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al registrar donante: " + e.getMessage());
        }
    }
    
    @GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<usuario>> getAllUsuarios() {
        try {
            List<usuario> usuarioList = registroService.listAllusuarios();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Total-Usuarios", String.valueOf(usuarioList.size()));
            return new ResponseEntity<>(usuarioList, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(null);
        }
    }

    @PostMapping("/receptor")
    public ResponseEntity<?> registrarReceptor(@RequestBody RegistroUsuarioRequest request) {
        try {
            if (!"RECEPTOR".equals(request.getRol())) {
                return ResponseEntity.badRequest()
                    .body("El rol debe ser 'RECEPTOR' para este endpoint");
            }
            
            if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Email es obligatorio");
            }
            if (request.getContrasena() == null || request.getContrasena().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Contraseña es obligatoria");
            }
            if (request.getNombre_receptor() == null || request.getNombre_receptor().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Nombre del receptor es obligatorio");
            }
            
            usuario usuarioCreado = registroService.registrarReceptor(request);
            
            return ResponseEntity.status(HttpStatus.CREATED)
                .body("Receptor registrado exitosamente con ID: " + usuarioCreado.getId_usuario());
                
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al registrar receptor: " + e.getMessage());
        }
    }
}