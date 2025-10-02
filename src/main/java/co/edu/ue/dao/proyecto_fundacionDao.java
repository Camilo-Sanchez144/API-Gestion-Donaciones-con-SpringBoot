package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.proyecto_fundacion;
import co.edu.ue.jpa.Iproyecto_fundacionJpa;

@Repository
public class proyecto_fundacionDao implements Iproyecto_fundacionDao {

    @Autowired
    private Iproyecto_fundacionJpa jpa;

    @Override
    public List<proyecto_fundacion> listaCompleta() {
        return jpa.findByEstadoproyecto("En curso"); 
    }

    @Override
    public proyecto_fundacion guardarproyecto_fundacion(proyecto_fundacion Proyecto_fundacion) {
        return jpa.save(Proyecto_fundacion);
    }

    @Override
    public proyecto_fundacion actualizarproyecto_fundacion(proyecto_fundacion Proyecto_fundacion) {
        return jpa.save(Proyecto_fundacion);
    }

    @Override
    public proyecto_fundacion encontrarproyecto_fundacionId(int id) {
        return jpa.findById(id).orElse(null);
    }

    @Override
    public void eliminarproyecto_fundacionId(int id) {
        proyecto_fundacion Proyecto_fundacion = jpa.findById(id).orElse(null);
        if (Proyecto_fundacion != null) {
            Proyecto_fundacion.setEstadoproyecto("Finalizado");
            jpa.save(Proyecto_fundacion);
        }
    }

    @Override
    public boolean proyecto_fundacionExists(int id) {
        return jpa.existsById(id);
    }
}