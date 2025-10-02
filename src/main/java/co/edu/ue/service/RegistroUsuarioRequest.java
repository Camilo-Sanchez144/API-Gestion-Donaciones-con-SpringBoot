package co.edu.ue.service;

public class RegistroUsuarioRequest {
    
    private String email;
    private String contrasena;
    private String salt;
    private String nombre;
    private String rol; 
    
    private String nombre_donante;
    private Byte tipo_donante;
    private String direccion_donante;
    private String ciudad_donante;
    private String codigo_postal_donante;
    private String telefono_contacto_donante;
    private String email_contacto_donante;
    private Byte estado_donante;
    
    private String nombre_receptor;
    private String tipo_organizacion;
    private String direccion_receptor;
    private String ciudad_receptor;
    private String codigo_postal_receptor;
    private String telefono_contacto_receptor;
    private String email_contacto_receptor;
    
    public RegistroUsuarioRequest() {}
    
    public RegistroUsuarioRequest(String email, String contrasena, String salt, String nombre,
                                String nombre_donante, Byte tipo_donante, String direccion_donante,
                                String ciudad_donante, String codigo_postal_donante, 
                                String telefono_contacto_donante, String email_contacto_donante,
                                Byte estado_donante) {
        this.email = email;
        this.contrasena = contrasena;
        this.salt = salt;
        this.nombre = nombre;
        this.rol = "DONANTE";
        this.nombre_donante = nombre_donante;
        this.tipo_donante = tipo_donante;
        this.direccion_donante = direccion_donante;
        this.ciudad_donante = ciudad_donante;
        this.codigo_postal_donante = codigo_postal_donante;
        this.telefono_contacto_donante = telefono_contacto_donante;
        this.email_contacto_donante = email_contacto_donante;
        this.estado_donante = estado_donante;
    }
    
    public RegistroUsuarioRequest(String email, String contrasena, String salt, String nombre,
                                String nombre_receptor, String tipo_organizacion, String direccion_receptor,
                                String ciudad_receptor, String codigo_postal_receptor,
                                String telefono_contacto_receptor, String email_contacto_receptor) {
        this.email = email;
        this.contrasena = contrasena;
        this.salt = salt;
        this.nombre = nombre;
        this.rol = "RECEPTOR";
        this.nombre_receptor = nombre_receptor;
        this.tipo_organizacion = tipo_organizacion;
        this.direccion_receptor = direccion_receptor;
        this.ciudad_receptor = ciudad_receptor;
        this.codigo_postal_receptor = codigo_postal_receptor;
        this.telefono_contacto_receptor = telefono_contacto_receptor;
        this.email_contacto_receptor = email_contacto_receptor;
    }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    
    public String getSalt() { return salt; }
    public void setSalt(String salt) { this.salt = salt; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
    

    public String getNombre_donante() { return nombre_donante; }
    public void setNombre_donante(String nombre_donante) { this.nombre_donante = nombre_donante; }
    
    public Byte getTipo_donante() { return tipo_donante; }
    public void setTipo_donante(Byte tipo_donante) { this.tipo_donante = tipo_donante; }
    
    public String getDireccion_donante() { return direccion_donante; }
    public void setDireccion_donante(String direccion_donante) { this.direccion_donante = direccion_donante; }
    
    public String getCiudad_donante() { return ciudad_donante; }
    public void setCiudad_donante(String ciudad_donante) { this.ciudad_donante = ciudad_donante; }
    
    public String getCodigo_postal_donante() { return codigo_postal_donante; }
    public void setCodigo_postal_donante(String codigo_postal_donante) { this.codigo_postal_donante = codigo_postal_donante; }
    
    public String getTelefono_contacto_donante() { return telefono_contacto_donante; }
    public void setTelefono_contacto_donante(String telefono_contacto_donante) { this.telefono_contacto_donante = telefono_contacto_donante; }
    
    public String getEmail_contacto_donante() { return email_contacto_donante; }
    public void setEmail_contacto_donante(String email_contacto_donante) { this.email_contacto_donante = email_contacto_donante; }
    
    public Byte getEstado_donante() { return estado_donante; }
    public void setEstado_donante(Byte estado_donante) { this.estado_donante = estado_donante; }
    
    public String getNombre_receptor() { return nombre_receptor; }
    public void setNombre_receptor(String nombre_receptor) { this.nombre_receptor = nombre_receptor; }
    
    public String getTipo_organizacion() { return tipo_organizacion; }
    public void setTipo_organizacion(String tipo_organizacion) { this.tipo_organizacion = tipo_organizacion; }
    
    public String getDireccion_receptor() { return direccion_receptor; }
    public void setDireccion_receptor(String direccion_receptor) { this.direccion_receptor = direccion_receptor; }
    
    public String getCiudad_receptor() { return ciudad_receptor; }
    public void setCiudad_receptor(String ciudad_receptor) { this.ciudad_receptor = ciudad_receptor; }
    
    public String getCodigo_postal_receptor() { return codigo_postal_receptor; }
    public void setCodigo_postal_receptor(String codigo_postal_receptor) { this.codigo_postal_receptor = codigo_postal_receptor; }
    
    public String getTelefono_contacto_receptor() { return telefono_contacto_receptor; }
    public void setTelefono_contacto_receptor(String telefono_contacto_receptor) { this.telefono_contacto_receptor = telefono_contacto_receptor; }
    
    public String getEmail_contacto_receptor() { return email_contacto_receptor; }
    public void setEmail_contacto_receptor(String email_contacto_receptor) { this.email_contacto_receptor = email_contacto_receptor; }
}