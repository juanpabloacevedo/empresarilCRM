package co.com.UstaEmpresarial.nomina.dto;

import java.io.Serializable;

public class LiquidacionNominaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;
    private Double salario;
    private String direccion;
    private String tipo;
    private String formula;
    private String resultado;
    private String concepto;

    public LiquidacionNominaDTO() {
        super();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.concepto = resultado;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
}
