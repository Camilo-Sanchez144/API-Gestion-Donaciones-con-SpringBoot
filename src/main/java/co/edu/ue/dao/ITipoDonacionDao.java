package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Tipo_donacion;

public interface ITipoDonacionDao {
    List<Tipo_donacion> listaCompleta(); 
    Tipo_donacion guardarTipoDonacion(Tipo_donacion tipoDonacion); 
    Tipo_donacion actualizarTipoDonacion(Tipo_donacion tipoDonacion); 
    Tipo_donacion encontrarTipoDonacionId(int id); 
    List<Tipo_donacion> encontrarPorDonacionId(int idDonacion);
    void eliminarTipoDonacionId(int id); 
    boolean tipoDonacionExists(int id);
}