package co.edu.ue.dto;

public class ReceptorCreateRequest {
    
    // Datos del usuario
    private String email;
    private String contrasena;
    private String nombre;
    
    // Datos del receptor
    private String nombre_receptor;
    private String tipo_organizacion;
    private String direccion;
    private String ciudad;
    private String codigo_postal;
    private String telefono_contacto;
    private String email_contacto;
    
    // Constructor vacío
    public ReceptorCreateRequest() {}
    
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
}