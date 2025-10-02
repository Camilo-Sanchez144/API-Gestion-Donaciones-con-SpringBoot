package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.Iproyecto_fundacionDao;
import co.edu.ue.entity.proyecto_fundacion;

@Service
public class proyecto_fundacionService implements Iproyecto_fundacionService {

    @Autowired
    private Iproyecto_fundacionDao proyecto_fundacionDao;

    @Override
    public List<proyecto_fundacion> listAll() {
        return proyecto_fundacionDao.listaCompleta();
    }

    @Override
    public proyecto_fundacion addproyecto_fundacion(proyecto_fundacion proyecto_fundacion) {
        return proyecto_fundacionDao.guardarproyecto_fundacion(proyecto_fundacion);
    }

    @Override
    public proyecto_fundacion updateproyecto_fundacion(proyecto_fundacion proyecto_fundacion) {
        return proyecto_fundacionDao.actualizarproyecto_fundacion(proyecto_fundacion);
    }

    @Override
    public proyecto_fundacion findproyecto_fundacionById(int id) {
        return proyecto_fundacionDao.encontrarproyecto_fundacionId(id);
    }

    @Override
    public void deleteproyecto_fundacionById(int id) {
        if (!proyecto_fundacionDao.proyecto_fundacionExists(id)) {
            throw new IllegalArgumentException("proyecto_fundacion con ID " + id + " no encontrado");
        }

        proyecto_fundacion proyecto_fundacion = proyecto_fundacionDao.encontrarproyecto_fundacionId(id);
        if (proyecto_fundacion.getEstadoproyecto() != null && proyecto_fundacion.getEstadoproyecto().equals("Finalizado")) {
            throw new IllegalStateException("El proyecto_fundacion ya está dado de baja");
        }

        proyecto_fundacionDao.eliminarproyecto_fundacionId(id);
    }

    @Override
    public boolean proyecto_fundacionExists(int id) {
        return proyecto_fundacionDao.proyecto_fundacionExists(id);
    }
}