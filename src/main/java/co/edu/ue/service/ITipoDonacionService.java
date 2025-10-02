package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Tipo_donacion;

public interface ITipoDonacionService {

    List<Tipo_donacion> listAll();
    Tipo_donacion addTipoDonacion(Tipo_donacion tipoDonacion);
    Tipo_donacion updateTipoDonacion(Tipo_donacion tipoDonacion);
    Tipo_donacion findTipoDonacionById(int id);
    List<Tipo_donacion> findTipoDonacionByDonacionId(int idDonacion);
    void deleteTipoDonacionById(int id);
    boolean tipoDonacionExists(int id);
}