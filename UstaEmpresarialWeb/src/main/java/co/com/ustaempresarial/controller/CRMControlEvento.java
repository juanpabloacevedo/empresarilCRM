package co.com.ustaempresarial.controller;


import co.com.ustaempresarial.modelo.crm.Evento;
import co.com.ustaempresarial.servicio.CRMServicio;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "crmEvento")
@SessionScoped
public class CRMControlEvento implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Evento evento;
	private List<Evento> eventos;
    @EJB
    private CRMServicio crmServicio;
    

    public CRMControlEvento() {
		super();
		evento=new Evento();
		eventos = new ArrayList<Evento>();
	}
	@PostConstruct
	public void cargarPermisos() {
		try {
			eventos = crmServicio.listarEvento();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	public void crearevento() {
        try {
        	
        	if(evento!=null && evento.getCodigo()!=0) {
        		
        		crmServicio.crearEvento(evento);
        
        	}
        	
        } catch (Exception e) {

        }
    }
	
	public java.sql.Date convertir(java.util.Date fechaUtilDate){
	    return new java.sql.Date(fechaUtilDate.getTime());
	}
	public Evento getevento() {
		
		return evento;
	}
	public void setevento(Evento evento) {
		
		this.evento = evento;
	}
	
	public List<Evento> geteventos() {
		return eventos;
	}
	public void seteventos(List<Evento> eventos) {
		this.eventos = eventos;
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
