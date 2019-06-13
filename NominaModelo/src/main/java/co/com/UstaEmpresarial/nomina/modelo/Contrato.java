package co.com.UstaEmpresarial.nomina.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the contrato database table.
 */
@Entity
@Table(name = "contrato", schema = "nomina")
public class Contrato implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "Contrato.FIND_ALL";
    public static final String ENCONTRAR_POR_CARGO = "Contrato.ENCONTRAR_POR_CARGO ";
    public static final String ENCONTRAR_POR_DEPENDENCIA = "Contrato.ENCONTRAR_POR_DEPENDENCIA";
    private Integer codigo;
    private Integer cargoCod;
    private Integer dependenciaCod;
    private Date fechaFin;
    private Date fechaInicio;
    private Integer hojaVidaDoc;
    private Integer salario;

    public Contrato() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }


    @Column(name = "cargo_cod")
    public Integer getCargoCod() {
        return this.cargoCod;
    }

    public void setCargoCod(Integer cargoCod) {
        this.cargoCod = cargoCod;
    }


    @Column(name = "dependencia_cod")
    public Integer getDependenciaCod() {
        return this.dependenciaCod;
    }

    public void setDependenciaCod(Integer dependenciaCod) {
        this.dependenciaCod = dependenciaCod;
    }


    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_fin")
    public Date getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }


    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inicio")
    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }


    @Column(name = "hoja_vida_doc")
    public Integer getHojaVidaDoc() {
        return this.hojaVidaDoc;
    }

    public void setHojaVidaDoc(Integer hojaVidaDoc) {
        this.hojaVidaDoc = hojaVidaDoc;
    }


    public Integer getSalario() {
        return this.salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

}