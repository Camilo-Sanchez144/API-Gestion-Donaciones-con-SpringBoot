package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.medio;

public interface IMedioDao {
    List<medio> listaCompleta(); 
    medio guardarMedio(medio medio); 
    medio actualizarMedio(medio medio); 
    medio encontrarMedioId(int id); 
    void eliminarMedioId(int id); 
    boolean medioExists(int id);
}