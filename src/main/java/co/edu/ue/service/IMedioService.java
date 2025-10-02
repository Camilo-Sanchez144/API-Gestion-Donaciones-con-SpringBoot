package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.medio;

public interface IMedioService {

    List<medio> listAll();
    medio addMedio(medio medio);
    medio updateMedio(medio medio);
    medio findMedioById(int id);
    void deleteMedioById(int id);
    boolean medioExists(int id);
}