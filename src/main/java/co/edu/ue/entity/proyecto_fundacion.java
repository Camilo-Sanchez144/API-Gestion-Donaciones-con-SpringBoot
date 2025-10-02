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
@Table(name = "proyecto_fundacion")
@NamedQuery(name = "proyecto_fundacion.findAll", query = "SELECT p FROM proyecto_fundacion p")
public class proyecto_fundacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto")
    private int id_proyecto;

    @Column(name = "nombre")
    private String nombre_proyecto;

    @Column(name = "descripcion")
    private String descripcion_proyecto;

    @Column(name = "estado")
    private String estadoproyecto;

    @Column(name = "tipo_donacion")
    private String tipodonacion;

    @Column(name = "meta_cantidad")
    private float meta_cantidad;

    @Column(name = "fecha_inicio")
    private String fecha_inicio;

    @Column(name = "fecha_fin_estimada")
    private String fecha_fin;

    @Column(name = "id_receptor")
    private int id_receptor;

    public proyecto_fundacion() {}

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }

    public String getDescripcion_proyecto() {
        return descripcion_proyecto;
    }

    public void setDescripcion_proyecto(String descripcion_proyecto) {
        this.descripcion_proyecto = descripcion_proyecto;
    }

    public String getEstadoproyecto() {
        return estadoproyecto;
    }

    public void setEstadoproyecto(String estadoproyecto) {
        this.estadoproyecto = estadoproyecto;
    }

    public String getTipodonacion() {
        return tipodonacion;
    }
    public void setTipodonacion(String tipodonacion) {
        this.tipodonacion = tipodonacion;
    }
    public float getMeta_cantidad() {
        return meta_cantidad;
    }
    public void setMeta_cantidad(float meta_cantidad) {
        this.meta_cantidad = meta_cantidad;
    }
    public String getFecha_inicio() {
        return fecha_inicio;
    }
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    public String getFecha_fin() {
        return fecha_fin;
    }
    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    public int getId_receptor() {
        return id_receptor;
    }
    public void setId_receptor(int id_receptor) {
        this.id_receptor = id_receptor;
    }
}
