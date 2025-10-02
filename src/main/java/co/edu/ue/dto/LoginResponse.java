package co.edu.ue.dto;

import co.edu.ue.entity.Donante;
import co.edu.ue.entity.Receptor;
import co.edu.ue.entity.usuario;

/**
 * DTO para la respuesta de login exitoso
 */
public class LoginResponse {
    private boolean success;
    private String message;
    private String tipoUsuario; // "DONANTE" o "RECEPTOR"
    private usuario usuario;
    private Donante donante;
    private Receptor receptor;
    
    // Constructores
    public LoginResponse() {}
    
    public LoginResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    
    // Constructor para login exitoso
    public LoginResponse(boolean success, String message, String tipoUsuario, usuario usuario) {
        this.success = success;
        this.message = message;
        this.tipoUsuario = tipoUsuario;
        this.usuario = usuario;
    }
    
    // Getters y Setters
    public boolean isSuccess() {
        return success;
    }
    
    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getTipoUsuario() {
        return tipoUsuario;
    }
    
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }
    
    public Donante getDonante() {
        return donante;
    }
    
    public void setDonante(Donante donante) {
        this.donante = donante;
    }
    
    public Receptor getReceptor() {
        return receptor;
    }
    
    public void setReceptor(Receptor receptor) {
        this.receptor = receptor;
    }
}