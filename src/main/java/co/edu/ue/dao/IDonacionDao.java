package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.donacion;

public interface IDonacionDao {
    List<donacion> listaCompleta(); 
    donacion guardarDonacion(donacion donacion); 
    donacion actualizarDonacion(donacion donacion); 
    donacion encontrarDonacionId(int id); 
    List<donacion> encontrarPorDonante(int idDonante);
    List<donacion> encontrarPorReceptor(int idReceptor);
    List<donacion> encontrarPorEstado(String estado);
    void eliminarDonacionId(int id); 
    boolean donacionExists(int id);
}