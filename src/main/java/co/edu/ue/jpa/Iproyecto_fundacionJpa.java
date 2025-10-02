package co.edu.ue.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.proyecto_fundacion;
@Repository
public interface Iproyecto_fundacionJpa extends JpaRepository<proyecto_fundacion, Integer> {
    List<proyecto_fundacion> findByEstadoproyecto(String estadoproyecto);
}
