package co.edu.ue.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "donacion")
@NamedQuery(name = "donacion.findAll", query = "SELECT d FROM donacion d")
public class donacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_donacion")
    private int id_donacion;

    @Column(name = "id_donante")
    private int id_donante;

    @Column(name = "id_receptor")
    private int id_receptor;

    @Column(name = "id_proyecto", nullable = true)
    private int id_proyecto;

    @Column(name = "estado")
    private String estado_donacion;

    @Column(name = "fecha_creacion")
    private String fecha_donacion;

    public donacion() {}

    public int getId_donacion() {
        return id_donacion;
    }   
    public void setId_donacion(int id_donacion) {
        this.id_donacion = id_donacion;
    }
    public int getId_donante() {
        return id_donante;
    }
    public void setId_donante(int id_donante) {
        this.id_donante = id_donante;
    }
    public int getId_receptor() {
        return id_receptor;
    }
    public void setId_receptor(int id_receptor) {
        this.id_receptor = id_receptor;
    }
    public int getId_proyecto() {
        return id_proyecto;
    }
    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }
    public String getEstado_donacion() {
        return estado_donacion;
    }
    public void setEstado_donacion(String estado_donacion) {
        this.estado_donacion = estado_donacion;
    }
    public String getFecha_donacion() {
        return fecha_donacion;
    }
    public void setFecha_donacion(String fecha_donacion) {
        this.fecha_donacion = fecha_donacion;
    }
        @Override
    public String toString() {
        return "donacion{" +
                "id_donacion=" + id_donacion +
                ", id_donante=" + id_donante +
                ", id_receptor=" + id_receptor +
                ", id_proyecto=" + id_proyecto +
                ", estado_donacion='" + estado_donacion + '\'' +
                ", fecha_donacion='" + fecha_donacion + '\'' +
                '}';
    }
}   