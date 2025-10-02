package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.proyecto_fundacion;

public interface Iproyecto_fundacionService {
    List<proyecto_fundacion> listAll();
    proyecto_fundacion addproyecto_fundacion(proyecto_fundacion proyecto_fundacion);
    proyecto_fundacion updateproyecto_fundacion(proyecto_fundacion proyecto_fundacion);
    proyecto_fundacion findproyecto_fundacionById(int id);
    void deleteproyecto_fundacionById(int id);
    boolean proyecto_fundacionExists(int id);
}