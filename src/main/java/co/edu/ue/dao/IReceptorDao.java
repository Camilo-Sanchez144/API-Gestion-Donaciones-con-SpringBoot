package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Receptor;

public interface IReceptorDao {
    List<Receptor> listaCompleta(); 
    Receptor guardarReceptor(Receptor receptor); 
    Receptor actualizarReceptor(Receptor receptor); 
    Receptor encontrarReceptorId(int id);
    Receptor encontrarReceptorPorIdUsuario(int idUsuario);
    void eliminarReceptorId(int id); 
    boolean receptorExists(int id);
}