package co.com.ustaempresarial.controller;


import co.com.ustaempresarial.modelo.crm.Periodo;
import co.com.ustaempresarial.servicio.CRMServicio;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "crm")
@SessionScoped
public class CRMControlPeriodo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Periodo periodo;
	private List<Periodo> periodos;
    @EJB
    private CRMServicio crmServicio;
    

    public CRMControlPeriodo() {
		super();
		periodo=new Periodo();
		periodos = new ArrayList<Periodo>();
	}
	@PostConstruct
	public void cargarPermisos() {
		try {
			periodos = crmServicio.listarPeriodo();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	public void crearPeriodo() {
        try {
        	
        	if(periodo!=null && periodo.getCodigo()!=0) {
        		
        		crmServicio.crearPeriodo(periodo);
        
        	}
        	
        } catch (Exception e) {

        }
    }
    
   
    public Periodo getValor() {
        return periodo;
    }

    public void setValor(Periodo valor) {
        this.periodo = valor;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public CRMServicio getCrmServicio() {
        return crmServicio;
    }

    public void setCrmServicio(CRMServicio crmServicio) {
        this.crmServicio = crmServicio;
    }
}
