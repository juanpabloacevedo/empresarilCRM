package co.com.ustaempresarial.controller;


import co.com.ustaempresarial.modelo.crm.Campania;
import co.com.ustaempresarial.servicio.CRMServicio;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "crmCampania")
@SessionScoped
public class CRMControlCampania implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Campania campania;
	private List<Campania> campanias;
    @EJB
    private CRMServicio crmServicio;
    

    public CRMControlCampania() {
		super();
		campania=new Campania();
		campanias = new ArrayList<Campania>();
	}
	@PostConstruct
	public void cargarPermisos() {
		try {
			campanias = crmServicio.listarCampania();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	public void crearcampania() {
        try {
        	
        	if(campania!=null && campania.getCodigo()!=0) {
        		
        		crmServicio.crearCampania(campania);
        
        	}
        	
        } catch (Exception e) {

        }
    }
	
	public java.sql.Date convertir(java.util.Date fechaUtilDate){
	    return new java.sql.Date(fechaUtilDate.getTime());
	}
	public Campania getCampania() {
		
		return campania;
	}
	public void setCampania(Campania campania) {
		
		this.campania = campania;
	}
	
	public List<Campania> getCampanias() {
		return campanias;
	}
	public void setCampanias(List<Campania> campanias) {
		this.campanias = campanias;
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
