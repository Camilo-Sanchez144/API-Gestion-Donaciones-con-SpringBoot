package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.dto.DonanteCreateRequest;
import co.edu.ue.entity.Donante;
import co.edu.ue.service.IDonanteService;
import co.edu.ue.service.RegistroUsuarioService;

@RestController
@RequestMapping("/donantes")
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:5500", "http://localhost:5500"})
public class DonanteController {

    @Autowired
    private IDonanteService donantesService;
    
    @Autowired
    private RegistroUsuarioService registroService;

    @GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Donante>> getAllDonantes() {
        List<Donante> donantesList = donantesService.listAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Donantes", String.valueOf(donantesList.size()));
        return new ResponseEntity<>(donantesList, headers, HttpStatus.OK);
    }

    @PostMapping(value = "/crear", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crearDonanteCompleto(@RequestBody DonanteCreateRequest request) {
        try {
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
            
            // Crear el RegistroUsuarioRequest
            co.edu.ue.service.RegistroUsuarioRequest registroRequest = new co.edu.ue.service.RegistroUsuarioRequest();
            registroRequest.setEmail(request.getEmail());
            registroRequest.setContrasena(request.getContrasena());
            registroRequest.setNombre(request.getNombre());
            registroRequest.setRol("DONANTE");
            registroRequest.setNombre_donante(request.getNombre_donante());
            registroRequest.setTipo_donante(request.getTipo_donante());
            registroRequest.setDireccion_donante(request.getDireccion());
            registroRequest.setCiudad_donante(request.getCiudad());
            registroRequest.setCodigo_postal_donante(request.getCodigo_postal());
            registroRequest.setTelefono_contacto_donante(request.getTelefono_contacto());
            registroRequest.setEmail_contacto_donante(request.getEmail_contacto());
            registroRequest.setEstado_donante((byte) 1);
            
            // Registrar el usuario y donante
            co.edu.ue.entity.usuario usuarioCreado = registroService.registrarDonante(registroRequest);
            
            // Obtener el donante creado con toda la información
            Donante donanteCreado = donantesService.findDonanteByIdUsuario(usuarioCreado.getId_usuario());
            
            return ResponseEntity.status(HttpStatus.CREATED).body(donanteCreado);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al crear donante: " + e.getMessage());
        }
    }

    @PutMapping(value = "/{id}", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Donante> putDonante(@PathVariable("id") int id, @RequestBody Donante donante) {
        if (!donantesService.donanteExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        Donante existingDonante = donantesService.findDonanteById(id);
        
        donante.setId_donante(id);
        
        if (donante.getEmail_contacto() == null) {
            donante.setEmail_contacto(existingDonante.getEmail_contacto());
        }
        if (donante.getNombre_donante() == null) {
            donante.setNombre_donante(existingDonante.getNombre_donante());
        }
        if (donante.getTelefono_contacto() == null) {
            donante.setTelefono_contacto(existingDonante.getTelefono_contacto());
        }
        
        if (donante.getEstadoDonante() == null) {
            donante.setEstadoDonante((byte) 1);
        }
        
        Donante updatedDonante = donantesService.updateDonante(donante);
        return new ResponseEntity<>(updatedDonante, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Donante> getDonanteById(@PathVariable("id") int id) {
        Donante donante = donantesService.findDonanteById(id);
        if (donante != null) {
            return new ResponseEntity<>(donante, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteDonanteById(@PathVariable("id") int id) {
        try {
            donantesService.deleteDonanteById(id);
            return new ResponseEntity<>("Donante dado de baja correctamente", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
