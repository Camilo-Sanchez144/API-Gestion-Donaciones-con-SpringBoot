package co.edu.ue.dto;

public class DonanteCreateRequest {
    
    // Datos del usuario
    private String email;
    private String contrasena;
    private String nombre;
    
    // Datos del donante
    private String nombre_donante;
    private Byte tipo_donante;
    private String direccion;
    private String ciudad;
    private String codigo_postal;
    private String telefono_contacto;
    private String email_contacto;
    
    // Constructor vacío
    public DonanteCreateRequest() {}
    
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
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
}