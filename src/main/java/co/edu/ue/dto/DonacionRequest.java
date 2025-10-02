package co.edu.ue.dto;

public class DonacionRequest {
    private int idDonante;
    private int idReceptor;
    private int idProyecto; // Obligatorio
    private String tipo;
    private String descripcion;
    private String categoriaGeneral;
    private int cantidadDonacion;
    private String referencia;
    
    // Getters y setters
    public int getIdDonante() { 
        return idDonante; 
    }
    
    public void setIdDonante(int idDonante) { 
        this.idDonante = idDonante; 
    }
    
    public int getIdReceptor() { 
        return idReceptor; 
    }
    
    public void setIdReceptor(int idReceptor) { 
        this.idReceptor = idReceptor; 
    }
    
    public int getIdProyecto() { 
        return idProyecto; 
    }
    
    public void setIdProyecto(int idProyecto) { 
        this.idProyecto = idProyecto; 
    }
    
    public String getTipo() { 
        return tipo; 
    }
    
    public void setTipo(String tipo) { 
        this.tipo = tipo; 
    }
    
    public String getDescripcion() { 
        return descripcion; 
    }
    
    public void setDescripcion(String descripcion) { 
        this.descripcion = descripcion; 
    }
    
    public String getCategoriaGeneral() { 
        return categoriaGeneral; 
    }
    
    public void setCategoriaGeneral(String categoriaGeneral) { 
        this.categoriaGeneral = categoriaGeneral; 
    }
    
    public int getCantidadDonacion() { 
        return cantidadDonacion; 
    }
    
    public void setCantidadDonacion(int cantidadDonacion) { 
        this.cantidadDonacion = cantidadDonacion; 
    }
    
    public String getReferencia() { 
        return referencia; 
    }
    
    public void setReferencia(String referencia) { 
        this.referencia = referencia; 
    }
}