package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.dto.DonacionDetalleResponse;
import co.edu.ue.dto.DonacionRequest;
import co.edu.ue.dto.DonacionResponse;
import co.edu.ue.entity.donacion;
import co.edu.ue.service.DonacionService;

@RestController
@RequestMapping("/api/donaciones")
@CrossOrigin(origins = "*")
public class DonacionController {

    @Autowired
    private DonacionService donacionService;

    @PostMapping
    public ResponseEntity<?> crearDonacion(@RequestBody DonacionRequest request) {
        try {
            // Validaciones básicas
            if (request.getIdDonante() <= 0 || request.getIdReceptor() <= 0) {
                return ResponseEntity.badRequest()
                    .body("ID de donante e ID de receptor deben ser valores positivos");
            }
            
            if (request.getIdProyecto() <= 0) {
                return ResponseEntity.badRequest()
                    .body("ID de proyecto debe ser un valor positivo");
            }
            
            if (request.getTipo() == null || request.getTipo().trim().isEmpty()) {
                return ResponseEntity.badRequest()
                    .body("El tipo de donación es requerido");
            }

            DonacionResponse response = donacionService.crearDonacionCompleta(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al crear la donación: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<donacion>> obtenerTodasLasDonaciones() {
        try {
            List<donacion> donaciones = donacionService.listarTodasLasDonaciones();
            return ResponseEntity.ok(donaciones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerDonacionPorId(@PathVariable int id) {
        try {
            DonacionDetalleResponse response = donacionService.obtenerDonacionCompleta(id);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al obtener la donación: " + e.getMessage());
        }
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<?> actualizarEstadoDonacion(
            @PathVariable int id, 
            @RequestBody EstadoRequest estadoRequest) {
        try {
            // Validar que el estado sea válido
            String[] estadosValidos = {"CREADA", "EN_PROCESO", "FINALIZADA", "CANCELADA"};
            boolean estadoValido = false;
            for (String estado : estadosValidos) {
                if (estado.equals(estadoRequest.getEstado())) {
                    estadoValido = true;
                    break;
                }
            }
            
            if (!estadoValido) {
                return ResponseEntity.badRequest()
                    .body("Estado no válido. Estados permitidos: CREADA, EN_PROCESO, FINALIZADA, CANCELADA");
            }

            donacion donacionActualizada = donacionService.actualizarEstadoDonacion(id, estadoRequest.getEstado());
            return ResponseEntity.ok(donacionActualizada);
            
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al actualizar el estado: " + e.getMessage());
        }
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<?> obtenerDonacionesPorEstado(@PathVariable String estado) {
        try {
            List<donacion> donaciones = donacionService.buscarPorEstado(estado);
            return ResponseEntity.ok(donaciones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al buscar donaciones por estado: " + e.getMessage());
        }
    }
}

// Clase DTO para la request de actualización de estado
class EstadoRequest {
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}