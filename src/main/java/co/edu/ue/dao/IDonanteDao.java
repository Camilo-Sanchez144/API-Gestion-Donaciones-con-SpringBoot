package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Donante;

public interface IDonanteDao {
    List<Donante> listaCompleta(); 
    Donante guardarDonante(Donante donante); 
    Donante actualizarDonante(Donante donante); 
    Donante encontrarDonanteId(int id);
    Donante encontrarDonantePorIdUsuario(int idUsuario);
    void eliminarDonanteId(int id); 
    boolean donanteExists(int id);
}