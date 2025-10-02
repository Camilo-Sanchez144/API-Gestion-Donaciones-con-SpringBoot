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

import co.edu.ue.dto.ReceptorCreateRequest;
import co.edu.ue.entity.Receptor;
import co.edu.ue.service.IReceptorService;
import co.edu.ue.service.RegistroUsuarioService;

@RestController
@RequestMapping("/receptor")
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:5500", "http://localhost:5500"})
public class ReceptorController {

    @Autowired
    private IReceptorService receptorService;
    
    @Autowired
    private RegistroUsuarioService registroService;

    @GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Receptor>> getAllReceptores() {
        List<Receptor> receptoresList = receptorService.listAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Receptores", String.valueOf(receptoresList.size()));
        return new ResponseEntity<>(receptoresList, headers, HttpStatus.OK);
    }

    @PostMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Receptor> postReceptor(@RequestBody Receptor receptor) {
        try {
            if (receptor.getEstado_receptor() == null) {
                receptor.setEstado_receptor((byte) 1); // Activo por defecto
            }
            
            if (receptor.getId_usuario() <= 0) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            
            Receptor nuevoReceptor = receptorService.addReceptor(receptor);
            return new ResponseEntity<>(nuevoReceptor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = "/crear", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crearReceptorCompleto(@RequestBody ReceptorCreateRequest request) {
        try {
            // Validaciones básicas
            if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Email es obligatorio");
            }
            if (request.getContrasena() == null || request.getContrasena().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Contraseña es obligatoria");
            }
            if (request.getNombre_receptor() == null || request.getNombre_receptor().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Nombre del receptor es obligatorio");
            }
            
            co.edu.ue.service.RegistroUsuarioRequest registroRequest = new co.edu.ue.service.RegistroUsuarioRequest();
            registroRequest.setEmail(request.getEmail());
            registroRequest.setContrasena(request.getContrasena());
            registroRequest.setNombre(request.getNombre());
            registroRequest.setRol("RECEPTOR");
            registroRequest.setNombre_receptor(request.getNombre_receptor());
            registroRequest.setTipo_organizacion(request.getTipo_organizacion());
            registroRequest.setDireccion_receptor(request.getDireccion());
            registroRequest.setCiudad_receptor(request.getCiudad());
            registroRequest.setCodigo_postal_receptor(request.getCodigo_postal());
            registroRequest.setTelefono_contacto_receptor(request.getTelefono_contacto());
            registroRequest.setEmail_contacto_receptor(request.getEmail_contacto());
            
            // Registrar el usuario y receptor
            co.edu.ue.entity.usuario usuarioCreado = registroService.registrarReceptor(registroRequest);
            
            // Obtener el receptor creado con toda la información
            Receptor receptorCreado = receptorService.findReceptorByIdUsuario(usuarioCreado.getId_usuario());
            
            return ResponseEntity.status(HttpStatus.CREATED).body(receptorCreado);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al crear receptor: " + e.getMessage());
        }
    }

    @PutMapping(value = "/{id}", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Receptor> putReceptor(@PathVariable("id") int id, @RequestBody Receptor receptor) {

        if (!receptorService.receptorExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Receptor existingReceptor = receptorService.findReceptorById(id);
        receptor.setId_receptor(id);
        
        // Mantener valores existentes si no se proporcionan nuevos
        if (receptor.getEmail_contacto() == null) {
            receptor.setEmail_contacto(existingReceptor.getEmail_contacto());
        }
        if (receptor.getNombre_receptor() == null) {
            receptor.setNombre_receptor(existingReceptor.getNombre_receptor());
        }
        if (receptor.getTelefono_contacto() == null) {
            receptor.setTelefono_contacto(existingReceptor.getTelefono_contacto());
        }
        if (receptor.getEstado_receptor() == null) {
            receptor.setEstado_receptor(existingReceptor.getEstado_receptor());
        }

        Receptor updatedReceptor = receptorService.updateReceptor(receptor);
        return new ResponseEntity<>(updatedReceptor, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Receptor> getReceptorById(@PathVariable("id") int id) {
        Receptor receptor = receptorService.findReceptorById(id);
        if (receptor != null) {
            return new ResponseEntity<>(receptor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteReceptorById(@PathVariable("id") int id) {
        try {
            receptorService.deleteReceptorById(id);
            return new ResponseEntity<>("Receptor dado de baja correctamente", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}