package co.edu.ue.dto;

/**
 * DTO para la petición de login
 */
public class LoginRequest {
    private String email;
    private String contrasena;
    
    // Constructores
    public LoginRequest() {}
    
    public LoginRequest(String email, String contrasena) {
        this.email = email;
        this.contrasena = contrasena;
    }
    
    // Getters y Setters
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getContrasena() {
        return contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}