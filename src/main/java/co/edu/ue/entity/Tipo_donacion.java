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
@Table(name = "Tipo_donacion")
@NamedQuery(name = "Tipo_donacion.findAll", query = "SELECT d FROM Tipo_donacion d")
public class Tipo_donacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_donacion")
    private int id_tipo_donacion;

    @Column(name = "id_donacion")
    private int id_donacion;

    @Column(name = "tipo")
    private String tipo_donacion;

    @Column(name = "descripcion")
    private String descripcion_donacion;

    @Column(name = "categoria_general")
    private String categoria_general;

    @Column(name = "cantidad_donacion")
    private int cantidad_donacion;

    public Tipo_donacion() {}

    public int getId_tipo_donacion() {
        return id_tipo_donacion;
    }   
    public void setId_tipo_donacion(int id_tipo_donacion) {
        this.id_tipo_donacion = id_tipo_donacion;
    }
    public int getId_donacion() {
        return id_donacion;
    }
    public void setId_donacion(int id_donacion) {
        this.id_donacion = id_donacion;
    }
    public String getTipo_donacion() {
        return tipo_donacion;
    }
    public void setTipo_donacion(String tipo_donacion) {
        this.tipo_donacion = tipo_donacion; 
    }
    public String getDescripcion_donacion() {
        return descripcion_donacion;
    }
    public void setDescripcion_donacion(String descripcion_donacion) {
        this.descripcion_donacion = descripcion_donacion;
    }
    public String getCategoria_general() {
        return categoria_general;
    }
    public void setCategoria_general(String categoria_general) {
        this.categoria_general = categoria_general;
    }
    public int getCantidad_donacion() {
        return cantidad_donacion;
    }
    public void setCantidad_donacion(int cantidad_donacion) {   
        this.cantidad_donacion = cantidad_donacion;
    }

    @Override
    public String toString() {
        return "tipo_donacion{" +
                "id_tipo_donacion=" + id_tipo_donacion +
                ", id_donacion=" + id_donacion +
                ", tipo_donacion='" + tipo_donacion + '\'' +
                ", descripcion_donacion='" + descripcion_donacion + '\'' +
                ", categoria_general='" + categoria_general + '\'' +
                ", cantidad_donacion=" + cantidad_donacion +
                '}';
    }
}   