package co.com.ustaempresarial.controller;


import co.com.ustaempresarial.modelo.crm.TipoMedio;
import co.com.ustaempresarial.servicio.CRMServicio;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "crmTipomedio")
@SessionScoped
public class CRMControlTipoMedio implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TipoMedio tipoMedio;
	private List<TipoMedio> tipoMedios;
    @EJB
    private CRMServicio crmServicio;
    

    public  CRMControlTipoMedio() {
		super();
		tipoMedio=new TipoMedio();
		tipoMedios = new ArrayList<TipoMedio>();
	}
	@PostConstruct
	public void cargarPermisos() {
		try {
			tipoMedios = crmServicio.listarTipoMedio();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	public void creartipoMedio() {
        try {
        	
        	if(tipoMedio!=null && tipoMedio.getCodigo()!=0) {
        		
        		crmServicio.crearTipoMedio(tipoMedio);
        
        	}
        	
        } catch (Exception e) {

        }
    }
	
	public java.sql.Date convertir(java.util.Date fechaUtilDate){
	    return new java.sql.Date(fechaUtilDate.getTime());
	}
	public TipoMedio getTipoMedio() {
		return tipoMedio;
	}
	public void setTipoMedio(TipoMedio tipoMedio) {
		this.tipoMedio = tipoMedio;
	}
	public List<TipoMedio> getTipoMedios() {
		return tipoMedios;
	}
	public void setTipoMedios(List<TipoMedio> tipoMedios) {
		this.tipoMedios = tipoMedios;
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
