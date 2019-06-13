package co.com.ustaempresarial.controller;

import co.com.ustaempresarial.modelo.crm.Periodo;
import co.com.ustaempresarial.servicio.CRMServicio;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "crm")
@SessionScoped
public class CRMControl implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Periodo periodo;
    @EJB
    private CRMServicio crmServicio;

    public void crearCRM() {
        try {
        crmServicio.crearPeriodo(periodo);
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
