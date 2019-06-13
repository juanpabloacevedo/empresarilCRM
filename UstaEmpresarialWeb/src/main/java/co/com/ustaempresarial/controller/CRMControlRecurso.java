package co.com.ustaempresarial.controller;


import co.com.ustaempresarial.modelo.crm.Recurso;
import co.com.ustaempresarial.servicio.CRMServicio;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "crmRecurso")
@SessionScoped
public class CRMControlRecurso implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Recurso recurso;
	private List<Recurso> recursos;
    @EJB
    private CRMServicio crmServicio;
    

    public CRMControlRecurso() {
		super();
		recurso=new Recurso();
		recursos = new ArrayList<Recurso>();
	}
	@PostConstruct
	public void cargarPermisos() {
		try {
			recursos = crmServicio.listarRecursos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	public void crearrecurso() {
        try {
        	
        	if(recurso!=null && recurso.getCodigo()!=0) {
        		
        		crmServicio.crearRecurso(recurso);
        
        	}
        	
        } catch (Exception e) {

        }
    }
	
	public java.sql.Date convertir(java.util.Date fechaUtilDate){
	    return new java.sql.Date(fechaUtilDate.getTime());
	}
	public Recurso getrecurso() {
		
		return recurso;
	}
	public void setrecurso(Recurso recurso) {
		
		this.recurso = recurso;
	}
	
	public List<Recurso> getrecursos() {
		return recursos;
	}
	public void setrecursos(List<Recurso> recursos) {
		this.recursos = recursos;
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
