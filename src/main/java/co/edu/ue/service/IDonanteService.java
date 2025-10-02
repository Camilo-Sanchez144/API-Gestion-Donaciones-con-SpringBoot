package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Donante;

public interface IDonanteService {
    List<Donante> listAll();
    Donante addDonante(Donante donante);
    Donante updateDonante(Donante donante);
    Donante findDonanteById(int id);
    Donante findDonanteByIdUsuario(int idUsuario);
    void deleteDonanteById(int id);
    boolean donanteExists(int id);
}