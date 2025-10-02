package co.edu.ue.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "donante")
@NamedQuery(name = "Donante.findAll", query = "SELECT d FROM Donante d")
public class Donante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_donante")
    private int id_donante;

    @Column(name = "id_usuario")
    private int id_usuario;

    @Column(name = "nombre_donante")
    private String nombre_donante;

    @Column(name = "tipo_donante")
    private Byte tipo_donante;

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

    @Column(name = "estado_donante", nullable = false)
    private Byte estadoDonante;

    @OneToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private usuario usuario;

    public Donante() {}

    public int getId_donante() {
        return id_donante;
    }

    public void setId_donante(int id_donante) {
        this.id_donante = id_donante;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_donante() {
        return nombre_donante;
    }

    public void setNombre_donante(String nombre_donante) {
        this.nombre_donante = nombre_donante;
    }

    public Byte getTipo_donante() {
        return tipo_donante;
    }

    public void setTipo_donante(Byte tipo_donante) {
        this.tipo_donante = tipo_donante;
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


    public Byte getEstadoDonante() { return estadoDonante; }
    public void setEstadoDonante(Byte estadoDonante) { this.estadoDonante = estadoDonante; }

    public usuario getUsuario() { return usuario; }
    public void setUsuario(usuario usuario) { this.usuario = usuario; }

    @Override
    public String toString() {
        return "Donante{" +
                "id_donante=" + id_donante +
                ", id_usuario=" + id_usuario +
                ", nombre_donante='" + nombre_donante + '\'' +
                ", tipo_donante=" + tipo_donante +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", codigo_postal='" + codigo_postal + '\'' +
                ", telefono_contacto='" + telefono_contacto + '\'' +
                ", email_contacto='" + email_contacto + '\'' +
                ", estado_donante=" + estadoDonante +
                '}';
    }
}
