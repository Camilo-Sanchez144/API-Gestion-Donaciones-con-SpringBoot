package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Donante;
import co.edu.ue.jpa.IDonanteJpa;

@Repository
public class DonanteDao implements IDonanteDao {

    @Autowired
    private IDonanteJpa jpa;

    @Override
    public List<Donante> listaCompleta() {
        return jpa.findByEstadoDonante((byte) 1); 
    }

    @Override
    public Donante guardarDonante(Donante donante) {
        return jpa.save(donante);
    }

    @Override
    public Donante actualizarDonante(Donante donante) {
        return jpa.save(donante);
    }

    @Override
    public Donante encontrarDonanteId(int id) {
        return jpa.findById(id).orElse(null);
    }

    @Override
    public Donante encontrarDonantePorIdUsuario(int idUsuario) {
        return jpa.findByIdUsuario(idUsuario).orElse(null);
    }

    @Override
    public void eliminarDonanteId(int id) {
        Donante donante = jpa.findById(id).orElse(null);
        if (donante != null) {
            donante.setEstadoDonante((byte) 0);
            jpa.save(donante);
        }
    }

    @Override
    public boolean donanteExists(int id) {
        return jpa.existsById(id);
    }
}