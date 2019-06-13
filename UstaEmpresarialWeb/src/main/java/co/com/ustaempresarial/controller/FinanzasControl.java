package co.com.ustaempresarial.controller;

import co.com.ustaempresarial.finanzas.modelo.PlanContable;
import co.com.ustaempresarial.servicio.FinanzasServicio;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@ManagedBean(name = "finanzas")
@SessionScoped
public class FinanzasControl implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer codigo;
    private Integer codigoPadre;
    private String descripcion;
    private String nombre;
    private Integer tipo;

    @Temporal(TemporalType.DATE)
    private Date vigencia;

    @EJB
    private FinanzasServicio finanzasServicio;

    public void crearPlanContable() {
        try {
            PlanContable planContable = new PlanContable();
            planContable.setCodigo(codigo);
            planContable.setCodigoPadre(codigoPadre);
            planContable.setDescripcion(descripcion);
            planContable.setNombre(nombre);
            planContable.setTipo(tipo);
            planContable.setVigencia(vigencia);
            finanzasServicio.crearPlanContable(planContable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigoPadre() {
        return codigoPadre;
    }

    public void setCodigoPadre(Integer codigoPadre) {
        this.codigoPadre = codigoPadre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

}
