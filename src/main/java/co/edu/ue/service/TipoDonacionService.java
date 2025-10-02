package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.ITipoDonacionDao;
import co.edu.ue.entity.Tipo_donacion;

@Service
public class TipoDonacionService implements ITipoDonacionService {

    @Autowired
    private ITipoDonacionDao tipoDonacionDao;

    @Override
    public List<Tipo_donacion> listAll() {
        return tipoDonacionDao.listaCompleta();
    }

    @Override
    public Tipo_donacion addTipoDonacion(Tipo_donacion tipoDonacion) {
        return tipoDonacionDao.guardarTipoDonacion(tipoDonacion);
    }

    @Override
    public Tipo_donacion updateTipoDonacion(Tipo_donacion tipoDonacion) {
        return tipoDonacionDao.actualizarTipoDonacion(tipoDonacion);
    }

    @Override
    public Tipo_donacion findTipoDonacionById(int id) {
        return tipoDonacionDao.encontrarTipoDonacionId(id);
    }

    @Override
    public List<Tipo_donacion> findTipoDonacionByDonacionId(int idDonacion) {
        return tipoDonacionDao.encontrarPorDonacionId(idDonacion);
    }

    @Override
    public void deleteTipoDonacionById(int id) {
        if (!tipoDonacionDao.tipoDonacionExists(id)) {
            throw new IllegalArgumentException("Tipo de donación con ID " + id + " no encontrado");
        }
        tipoDonacionDao.eliminarTipoDonacionId(id);
    }

    @Override
    public boolean tipoDonacionExists(int id) {
        return tipoDonacionDao.tipoDonacionExists(id);
    }
}