package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Tipo_donacion;
import co.edu.ue.jpa.ITipo_donacion;

@Repository
public class TipoDonacionDao implements ITipoDonacionDao {

    @Autowired
    private ITipo_donacion jpa;

    @Override
    public List<Tipo_donacion> listaCompleta() {
        return jpa.findAll();
    }

    @Override
    public Tipo_donacion guardarTipoDonacion(Tipo_donacion tipoDonacion) {
        return jpa.save(tipoDonacion);
    }

    @Override
    public Tipo_donacion actualizarTipoDonacion(Tipo_donacion tipoDonacion) {
        return jpa.save(tipoDonacion);
    }

    @Override
    public Tipo_donacion encontrarTipoDonacionId(int id) {
        return jpa.findById(id).orElse(null);
    }

    @Override
    public List<Tipo_donacion> encontrarPorDonacionId(int idDonacion) {
        return jpa.findByIdDonacion(idDonacion);
    }

    @Override
    public void eliminarTipoDonacionId(int id) {
        if (jpa.existsById(id)) {
            jpa.deleteById(id);
        }
    }

    @Override
    public boolean tipoDonacionExists(int id) {
        return jpa.existsById(id);
    }
}