package co.edu.ue.dto;

public class DonacionResponse {
    private int idDonacion;
    private int idTipoDonacion;
    private int idMedio;
    private String estado;
    private String mensaje;
    
    // Getters y setters
    public int getIdDonacion() { 
        return idDonacion; 
    }
    
    public void setIdDonacion(int idDonacion) { 
        this.idDonacion = idDonacion; 
    }
    
    public int getIdTipoDonacion() { 
        return idTipoDonacion; 
    }
    
    public void setIdTipoDonacion(int idTipoDonacion) { 
        this.idTipoDonacion = idTipoDonacion; 
    }
    
    public int getIdMedio() { 
        return idMedio; 
    }
    
    public void setIdMedio(int idMedio) { 
        this.idMedio = idMedio; 
    }
    
    public String getEstado() { 
        return estado; 
    }
    
    public void setEstado(String estado) { 
        this.estado = estado; 
    }
    
    public String getMensaje() { 
        return mensaje; 
    }
    
    public void setMensaje(String mensaje) { 
        this.mensaje = mensaje; 
    }
}