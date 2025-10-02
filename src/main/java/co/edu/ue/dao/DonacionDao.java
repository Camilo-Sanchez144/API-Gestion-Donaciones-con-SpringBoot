package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.donacion;
import co.edu.ue.jpa.IdonacionJpa;

@Repository
public class DonacionDao implements IDonacionDao {

    @Autowired
    private IdonacionJpa jpa;

    @Override
    public List<donacion> listaCompleta() {
        return jpa.findAll();
    }

    @Override
    public donacion guardarDonacion(donacion donacion) {
        return jpa.save(donacion);
    }

    @Override
    public donacion actualizarDonacion(donacion donacion) {
        return jpa.save(donacion);
    }

    @Override
    public donacion encontrarDonacionId(int id) {
        return jpa.findById(id).orElse(null);
    }

    @Override
    public List<donacion> encontrarPorDonante(int idDonante) {
        return jpa.findAll().stream()
                .filter(d -> d.getId_donante() == idDonante)
                .toList();
    }

    @Override
    public List<donacion> encontrarPorReceptor(int idReceptor) {
        // Nota: necesitaremos agregar este método al repository JPA
        return jpa.findAll().stream()
                .filter(d -> d.getId_receptor() == idReceptor)
                .toList();
    }

    @Override
    public List<donacion> encontrarPorEstado(String estado) {
        // Nota: necesitaremos agregar este método al repository JPA
        return jpa.findAll().stream()
                .filter(d -> d.getEstado_donacion().equals(estado))
                .toList();
    }

    @Override
    public void eliminarDonacionId(int id) {
        if (jpa.existsById(id)) {
            donacion donacion = jpa.findById(id).orElse(null);
            if (donacion != null) {
                donacion.setEstado_donacion("CANCELADA");
                jpa.save(donacion);
            }
        }
    }

    @Override
    public boolean donacionExists(int id) {
        return jpa.existsById(id);
    }
}