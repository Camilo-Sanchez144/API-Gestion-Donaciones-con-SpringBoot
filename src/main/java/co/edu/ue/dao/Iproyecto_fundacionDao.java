package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.proyecto_fundacion;

public interface Iproyecto_fundacionDao {
    List<proyecto_fundacion> listaCompleta(); 
    proyecto_fundacion guardarproyecto_fundacion(proyecto_fundacion Proyecto_fundacion); 
    proyecto_fundacion actualizarproyecto_fundacion(proyecto_fundacion Proyecto_fundacion); 
    proyecto_fundacion encontrarproyecto_fundacionId(int id); 
    void eliminarproyecto_fundacionId(int id); 
    boolean proyecto_fundacionExists(int id);
}