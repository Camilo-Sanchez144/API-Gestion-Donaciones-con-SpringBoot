package co.edu.ue.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "receptor")
public class Receptor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receptor")
    private int id_receptor;

    @Column(name = "id_usuario")
    private int id_usuario;

    @Column(name = "nombre_receptor")
    private String nombre_receptor;

    @Column(name = "tipo_organizacion")
    private String tipo_organizacion;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "codigo_postal")
    private String codigo_postal;

    @Column(name = "telefono_contacto")
    private String telefono_contacto;

    @Column(name = "email_contacto")
    private String email_contacto;

    @Column(name = "estado_receptor", nullable = false, columnDefinition = "TINYINT DEFAULT 1")
    private Byte estado_receptor = 1;

    @OneToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private usuario usuario;

    public Receptor() {}

    public int getId_receptor() {
        return id_receptor;
    }

    public void setId_receptor(int id_receptor) {
        this.id_receptor = id_receptor;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_receptor() {
        return nombre_receptor;
    }

    public void setNombre_receptor(String nombre_receptor) {
        this.nombre_receptor = nombre_receptor;
    }

    public String getTipo_organizacion() {
        return tipo_organizacion;
    }

    public void setTipo_organizacion(String tipo_organizacion) {
        this.tipo_organizacion = tipo_organizacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getTelefono_contacto() {
        return telefono_contacto;
    }

    public void setTelefono_contacto(String telefono_contacto) {
        this.telefono_contacto = telefono_contacto;
    }

    public String getEmail_contacto() {
        return email_contacto;
    }

    public void setEmail_contacto(String email_contacto) {
        this.email_contacto = email_contacto;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }
    public Byte getEstado_receptor() {
        return estado_receptor;
    }
    public void setEstado_receptor(Byte estado_receptor) {
        this.estado_receptor = estado_receptor;
    }

    @Override
    public String toString() {
        return "Receptor{" +
                "id_receptor=" + id_receptor +
                ", id_usuario=" + id_usuario +
                ", nombre_receptor='" + nombre_receptor + '\'' +
                ", tipo_organizacion='" + tipo_organizacion + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", codigo_postal='" + codigo_postal + '\'' +
                ", telefono_contacto='" + telefono_contacto + '\'' +
                ", email_contacto='" + email_contacto + '\'' +
                ", estado_receptor=" + estado_receptor +
                '}';
    }
}