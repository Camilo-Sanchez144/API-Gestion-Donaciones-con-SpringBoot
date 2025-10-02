package co.edu.ue.dto;

import java.util.List;

import co.edu.ue.entity.Tipo_donacion;
import co.edu.ue.entity.donacion;
import co.edu.ue.entity.medio;

public class DonacionDetalleResponse {
    private donacion donacion;
    private List<Tipo_donacion> tiposDonacion;
    private medio medio;
    
    public donacion getDonacion() { 
        return donacion; 
    }
    
    public void setDonacion(donacion donacion) { 
        this.donacion = donacion; 
    }
    
    public List<Tipo_donacion> getTiposDonacion() { 
        return tiposDonacion; 
    }
    
    public void setTiposDonacion(List<Tipo_donacion> tiposDonacion) { 
        this.tiposDonacion = tiposDonacion; 
    }
    
    public medio getMedio() { 
        return medio; 
    }
    
    public void setMedio(medio medio) { 
        this.medio = medio; 
    }
}