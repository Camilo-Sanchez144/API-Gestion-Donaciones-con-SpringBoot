package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IReceptorDao;
import co.edu.ue.entity.Receptor;

@Service
public class ReceptorService implements IReceptorService {

    @Autowired
    private IReceptorDao receptorDao;

    @Override
    public List<Receptor> listAll() {
        return receptorDao.listaCompleta();
    }

    @Override
    public Receptor addReceptor(Receptor receptor) {
        return receptorDao.guardarReceptor(receptor);
    }

    @Override
    public Receptor updateReceptor(Receptor receptor) {
        return receptorDao.actualizarReceptor(receptor);
    }

    @Override
    public Receptor findReceptorById(int id) {
        return receptorDao.encontrarReceptorId(id);
    }

    @Override
    public Receptor findReceptorByIdUsuario(int idUsuario) {
        return receptorDao.encontrarReceptorPorIdUsuario(idUsuario);
    }

    @Override
    public void deleteReceptorById(int id) {
        if (!receptorDao.receptorExists(id)) {
            throw new IllegalArgumentException("Receptor con ID " + id + " no encontrado");
        }
        receptorDao.eliminarReceptorId(id);
    }

    @Override
    public boolean receptorExists(int id) {
        return receptorDao.receptorExists(id);
    }
}
