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

import co.edu.ue.entity.proyecto_fundacion;
import co.edu.ue.service.Iproyecto_fundacionService;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:5500", "http://localhost:5500"})
public class proyecto_fundacionController {

    @Autowired
    private Iproyecto_fundacionService proyecto_fundacionService;

    @PostMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<proyecto_fundacion> addproyecto_fundacion(@RequestBody proyecto_fundacion proyecto) {
        if (proyecto.getEstadoproyecto() == null) {
            proyecto.setEstadoproyecto("En curso"); // Asigna un valor por defecto si es null
        }
        proyecto_fundacion savedProyecto = proyecto_fundacionService.addproyecto_fundacion(proyecto);
        return new ResponseEntity<>(savedProyecto, HttpStatus.CREATED);
    }

    @GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<proyecto_fundacion>> getAllProyecto_fundacion() {
        List<proyecto_fundacion> Proyecto_fundacionList = proyecto_fundacionService.listAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Proyectos", String.valueOf(Proyecto_fundacionList.size()));
        return new ResponseEntity<>(Proyecto_fundacionList, headers, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<proyecto_fundacion> putProyecto(@PathVariable("id") int id, @RequestBody proyecto_fundacion proyecto) {
        if (!proyecto_fundacionService.proyecto_fundacionExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        proyecto_fundacion existingProyecto = proyecto_fundacionService.findproyecto_fundacionById(id);
        
        proyecto.setId_proyecto(id);
        
        if (proyecto.getNombre_proyecto() == null) {
            proyecto.setNombre_proyecto(existingProyecto.getNombre_proyecto());
        }
        if (proyecto.getDescripcion_proyecto() == null) {
            proyecto.setDescripcion_proyecto(existingProyecto.getDescripcion_proyecto());
        }

        if (proyecto.getEstadoproyecto() == null) {
            proyecto.setEstadoproyecto("En curso");
        }

        proyecto_fundacion updatedProyecto = proyecto_fundacionService.updateproyecto_fundacion(proyecto);
        return new ResponseEntity<>(updatedProyecto, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<proyecto_fundacion> getproyecto_fundacionById(@PathVariable("id") int id) {
        proyecto_fundacion proyecto = proyecto_fundacionService.findproyecto_fundacionById(id);
        if (proyecto != null) {
            return new ResponseEntity<>(proyecto, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteProyectoById(@PathVariable("id") int id) {
        try {
            proyecto_fundacionService.deleteproyecto_fundacionById(id);
            return new ResponseEntity<>("Proyecto dado de baja correctamente", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
