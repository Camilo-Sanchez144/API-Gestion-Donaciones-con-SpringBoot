package co.edu.ue.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
@NamedQuery(name = "usuario.findAll", query = "SELECT u FROM usuario u")
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(name = "email")
    private String emailusuario;

    @Column(name = "contrasena")
    private String contrasenausuario;

    @Column (name= "username")
    private String username;

    @Column(name = "salt")
    private String saltusuario;

    @Column(name = "rol")
    private String rolusuario;

    @Column(name = "fecha_creacion")
    private LocalDateTime fecha_creacionusuario;

    public Integer getId_usuario() {
    return id_usuario;
}

public void setId_usuario(Integer id_usuario) {
    this.id_usuario = id_usuario;
}

public String getEmailusuario() {
    return emailusuario;
}

public void setEmailusuario(String emailusuario) {
    this.emailusuario = emailusuario;
}

public String getContrasenausuario() {
    return contrasenausuario;
}

public void setContrasenausuario(String contrasenausuario) {
    this.contrasenausuario = contrasenausuario;
}

public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}

public String getSaltusuario() {
    return saltusuario;
}

public void setSaltusuario(String saltusuario) {
    this.saltusuario = saltusuario;
}

public String getRolusuario() {
    return rolusuario;
}

public void setRolusuario(String rolusuario) {
    this.rolusuario = rolusuario;
}

public LocalDateTime getFecha_creacionusuario() {
    return fecha_creacionusuario;
}

public void setFecha_creacionusuario(LocalDateTime fecha_creacionusuario) {
    this.fecha_creacionusuario = fecha_creacionusuario;
}

}
