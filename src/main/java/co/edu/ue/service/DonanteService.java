package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IDonanteDao;
import co.edu.ue.entity.Donante;

@Service
public class DonanteService implements IDonanteService {

    @Autowired
    private IDonanteDao donanteDao;

    @Override
    public List<Donante> listAll() {
        return donanteDao.listaCompleta();
    }

    @Override
    public Donante addDonante(Donante donante) {
        return donanteDao.guardarDonante(donante);
    }

    @Override
    public Donante updateDonante(Donante donante) {
        return donanteDao.actualizarDonante(donante);
    }

    @Override
    public Donante findDonanteById(int id) {
        return donanteDao.encontrarDonanteId(id);
    }

    @Override
    public Donante findDonanteByIdUsuario(int idUsuario) {
        return donanteDao.encontrarDonantePorIdUsuario(idUsuario);
    }

    @Override
    public void deleteDonanteById(int id) {
        if (!donanteDao.donanteExists(id)) {
            throw new IllegalArgumentException("Donante con ID " + id + " no encontrado");
        }
        
        Donante donante = donanteDao.encontrarDonanteId(id);
        if (donante.getEstadoDonante() != null && donante.getEstadoDonante() == 0) {
            throw new IllegalStateException("El donante ya está dado de baja");
        }
        
        donanteDao.eliminarDonanteId(id);
    }

    @Override
    public boolean donanteExists(int id) {
        return donanteDao.donanteExists(id);
    }
}