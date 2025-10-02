package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.medio;
import co.edu.ue.jpa.IMedioJpa;

@Repository
public class MedioDao implements IMedioDao {

    @Autowired
    private IMedioJpa jpa;

    @Override
    public List<medio> listaCompleta() {
        return jpa.findAll();
    }

    @Override
    public medio guardarMedio(medio medio) {
        return jpa.save(medio);
    }

    @Override
    public medio actualizarMedio(medio medio) {
        return jpa.save(medio);
    }

    @Override
    public medio encontrarMedioId(int id) {
        return jpa.findById(id).orElse(null);
    }

    @Override
    public void eliminarMedioId(int id) {
        medio medio = jpa.findById(id).orElse(null);
        if (medio != null) {
            medio.setEstado_medio("Finalizado");
            jpa.save(medio);
        }
    }

    @Override
    public boolean medioExists(int id) {
        return jpa.existsById(id);
    }
}