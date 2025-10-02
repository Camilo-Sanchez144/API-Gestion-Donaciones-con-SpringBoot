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
@Table(name = "medio")
@NamedQuery(name = "medio.findAll", query = "SELECT m FROM medio m")
public class medio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medio")
    private int id_medio;

    @Column(name = "id_donacion")
    private String id_donacion;

    @Column(name = "referencia")
    private String referencia;

    @Column(name = "estado_medio")
    private String estado_medio;

    public medio() {}

    public int getId_medio() {
        return id_medio;
    }   
    public void setId_medio(int id_medio) {
        this.id_medio = id_medio;
    }
    public String getId_donacion() {
        return id_donacion;
    }
    public void setId_donacion(String id_donacion) {
        this.id_donacion = id_donacion;
    }
    public String getReferencia() {
        return referencia;
    }
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    public String getEstado_medio() {
        return estado_medio;
    }
    public void setEstado_medio(String estado_medio) {
        this.estado_medio = estado_medio;
    }
        @Override
    public String toString() {
        return "medio{" +
                "id_medio=" + id_medio +
                ", id_donacion=" + id_donacion +
                ", referencia='" + referencia + '\'' +
                ", estado_medio='" + estado_medio + '\'' +
                '}';
    }
}   
