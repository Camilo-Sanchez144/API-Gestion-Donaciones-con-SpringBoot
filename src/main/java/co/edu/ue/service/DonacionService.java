package co.edu.ue.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ue.dao.IDonacionDao;
import co.edu.ue.dao.IMedioDao;
import co.edu.ue.dao.ITipoDonacionDao;
import co.edu.ue.dto.DonacionDetalleResponse;
import co.edu.ue.dto.DonacionRequest;
import co.edu.ue.dto.DonacionResponse;
import co.edu.ue.entity.Tipo_donacion;
import co.edu.ue.entity.donacion;
import co.edu.ue.entity.medio;

@Service
public class DonacionService {

    @Autowired
    private IDonacionDao donacionDao;
    
    @Autowired
    private ITipoDonacionDao tipoDonacionDao;
    
    @Autowired
    private IMedioDao medioDao;

    /**
     * Método transaccional para crear una donación completa
     * Registra en las 3 tablas: donacion, tipo_donacion y medio
     */
    @Transactional
    public DonacionResponse crearDonacionCompleta(DonacionRequest request) {
        try {
            // 1. Crear y guardar la donación principal con estado "CREADA"
            donacion nuevaDonacion = new donacion();
            nuevaDonacion.setId_donante(request.getIdDonante());
            nuevaDonacion.setId_receptor(request.getIdReceptor());
            nuevaDonacion.setId_proyecto(request.getIdProyecto()); // Ahora es obligatorio
            nuevaDonacion.setEstado_donacion("CREADA");
            nuevaDonacion.setFecha_donacion(LocalDateTime.now().toString());
            
            donacion donacionGuardada = donacionDao.guardarDonacion(nuevaDonacion);
            
            // 2. Crear y guardar el tipo de donación
            Tipo_donacion tipoDonacion = new Tipo_donacion();
            tipoDonacion.setId_donacion(donacionGuardada.getId_donacion());
            tipoDonacion.setTipo_donacion(request.getTipo());
            tipoDonacion.setDescripcion_donacion(request.getDescripcion());
            tipoDonacion.setCategoria_general(request.getCategoriaGeneral());
            tipoDonacion.setCantidad_donacion(request.getCantidadDonacion());
            
            Tipo_donacion tipoDonacionGuardado = tipoDonacionDao.guardarTipoDonacion(tipoDonacion);
            
            // 3. Crear y guardar el medio de entrega
            medio medioEntrega = new medio();
            medioEntrega.setId_donacion(String.valueOf(donacionGuardada.getId_donacion()));
            medioEntrega.setReferencia(request.getReferencia());
            medioEntrega.setEstado_medio("En curso");
            
            medio medioGuardado = medioDao.guardarMedio(medioEntrega);
            
            // 4. Crear respuesta con todos los IDs generados
            DonacionResponse response = new DonacionResponse();
            response.setIdDonacion(donacionGuardada.getId_donacion());
            response.setIdTipoDonacion(tipoDonacionGuardado.getId_tipo_donacion());
            response.setIdMedio(medioGuardado.getId_medio());
            response.setEstado("CREADA");
            response.setMensaje("Donación creada exitosamente");
            
            return response;
            
        } catch (Exception e) {
            throw new RuntimeException("Error al crear la donación: " + e.getMessage());
        }
    }

    /**
     * Actualizar estado de una donación
     */
    @Transactional
    public donacion actualizarEstadoDonacion(int idDonacion, String nuevoEstado) {
        donacion donacion = donacionDao.encontrarDonacionId(idDonacion);
        if (donacion == null) {
            throw new IllegalArgumentException("Donación no encontrada con ID: " + idDonacion);
        }
        
        donacion.setEstado_donacion(nuevoEstado);
        return donacionDao.actualizarDonacion(donacion);
    }

    /**
     * Obtener donación por ID con sus detalles
     */
    public DonacionDetalleResponse obtenerDonacionCompleta(int idDonacion) {
        donacion donacion = donacionDao.encontrarDonacionId(idDonacion);
        if (donacion == null) {
            throw new IllegalArgumentException("Donación no encontrada");
        }
        
        List<Tipo_donacion> tiposDonacion = tipoDonacionDao.encontrarPorDonacionId(idDonacion);
        medio medioEntrega = medioDao.listaCompleta().stream()
                .filter(m -> m.getId_donacion().equals(String.valueOf(idDonacion)))
                .findFirst()
                .orElse(null);
        
        DonacionDetalleResponse response = new DonacionDetalleResponse();
        response.setDonacion(donacion);
        response.setTiposDonacion(tiposDonacion);
        response.setMedio(medioEntrega);
        
        return response;
    }

    /**
     * Listar todas las donaciones
     */
    public List<donacion> listarTodasLasDonaciones() {
        return donacionDao.listaCompleta();
    }

    /**
     * Buscar donaciones por estado
     */
    public List<donacion> buscarPorEstado(String estado) {
        return donacionDao.encontrarPorEstado(estado);
    }
}