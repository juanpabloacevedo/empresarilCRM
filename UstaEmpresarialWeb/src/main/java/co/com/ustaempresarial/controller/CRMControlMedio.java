package co.com.ustaempresarial.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.com.ustaempresarial.modelo.crm.Medio;
import co.com.ustaempresarial.modelo.crm.Periodo;
import co.com.ustaempresarial.servicio.CRMServicio;

@ManagedBean(name = "crmmedio")
@SessionScoped
public class CRMControlMedio {
	
	private static final long serialVersionUID = 1L;
	private Medio medio;
	private List<Medio> medios;
    @EJB
    private CRMServicio crmServicio;
    
    
    public CRMControlMedio() {
		super();
		medio = new Medio();
		medios = new ArrayList<Medio>();
	}
    
    @PostConstruct
	public void cargarPermisos() {
		try {
			medios = crmServicio.listarMedio();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	public void crearMedio() {
        try {
        	
        	if(medio!=null && medio.getCodigo()!=0 && medio.getDescripcion()!=null  && medio.getNombre()!=null ) {
        		
        		crmServicio.crearMedio(medio);
        
        	}
        	
        } catch (Exception e) {

        }
    }
    
    
	public Medio getMedio() {
		return medio;
	}



	public void setMedio(Medio medio) {
		this.medio = medio;
	}



	public List<Medio> getMedios() {
		return medios;
	}



	public void setMedios(List<Medio> medios) {
		this.medios = medios;
	}



	public CRMServicio getCrmServicio() {
		return crmServicio;
	}



	public void setCrmServicio(CRMServicio crmServicio) {
		this.crmServicio = crmServicio;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	
    
    

}