package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Receptor;
import co.edu.ue.jpa.IReceptorJpa;

@Repository
public class ReceptorDao implements IReceptorDao {

    @Autowired
    private IReceptorJpa jpa;

    @Override
    public List<Receptor> listaCompleta() {
        return jpa.findByEstadoReceptor((byte) 1); 
    }

    @Override
    public Receptor guardarReceptor(Receptor receptor) {
        return jpa.save(receptor);
    }

    @Override
    public Receptor actualizarReceptor(Receptor receptor) {
        return jpa.save(receptor);
    }

    @Override
    public Receptor encontrarReceptorId(int id) {
        return jpa.findById(id).orElse(null);
    }

    @Override
    public Receptor encontrarReceptorPorIdUsuario(int idUsuario) {
        return jpa.findByIdUsuario(idUsuario).orElse(null);
    }

    @Override
    public void eliminarReceptorId(int id) {
        Receptor receptor = jpa.findById(id).orElse(null);
        if (receptor != null) {
            receptor.setEstado_receptor((byte) 0);
            jpa.save(receptor);
        }
    }

    @Override
    public boolean receptorExists(int id) {
        return jpa.existsById(id);
    }
}
