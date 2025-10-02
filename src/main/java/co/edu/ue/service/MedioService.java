package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IMedioDao;
import co.edu.ue.entity.medio;

@Service
public class MedioService implements IMedioService {

    @Autowired
    private IMedioDao medioDao;

    @Override
    public List<medio> listAll() {
        return medioDao.listaCompleta();
    }

    @Override
    public medio addMedio(medio medio) {
        return medioDao.guardarMedio(medio);
    }

    @Override
    public medio updateMedio(medio medio) {
        return medioDao.actualizarMedio(medio);
    }

    @Override
    public medio findMedioById(int id) {
        return medioDao.encontrarMedioId(id);
    }

    @Override
    public void deleteMedioById(int id) {
        if (!medioDao.medioExists(id)) {
            throw new IllegalArgumentException("medio con ID " + id + " no encontrado");
        }

        medio medio = medioDao.encontrarMedioId(id);
        if (medio.getEstado_medio() != null && medio.getEstado_medio().equals("Finalizado")) {
            throw new IllegalStateException("El medio ya está dado de baja");
        }

        medioDao.eliminarMedioId(id);
    }

    @Override
    public boolean medioExists(int id) {
        return medioDao.medioExists(id);
    }
}