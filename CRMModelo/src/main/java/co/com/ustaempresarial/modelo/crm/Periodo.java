package co.com.ustaempresarial.modelo.crm;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "periodo", schema = "crm", catalog = "usta_empresarial")
public class Periodo {

    private static final long serialVersionUID = 1L;
    
    public static final String TRAER_PERIODO = "Periodo.TRAER_PERIODO";
    public static final String ENCONTRAR_POR_NOMBRE="Periodo.ENCONTRAR_POR_FECHAI";

    private int codigo;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean estado;
    private Collection<Campania> campaniasByCodigo;

    @Id
    @Column(name = "codigo", nullable = false)
    public int getCodigo() {

        return codigo;

    }

    public void setCodigo(int codigo) {

        this.codigo = codigo;

    }

    @Basic
    @Column(name = "fecha_inicio", nullable = false)
    public Date getFechaInicio() {

        return fechaInicio;

    }

    public void setFechaInicio(Date fechaInicio) {

        this.fechaInicio = fechaInicio;

    }

    @Basic
    @Column(name = "fecha_fin", nullable = false)
    public Date getFechaFin() {

        return fechaFin;

    }

    public void setFechaFin(Date fechaFin) {

        this.fechaFin = fechaFin;

    }

    @Basic
    @Column(name = "estado", nullable = false)
    public boolean isEstado() {

        return estado;

    }

    public void setEstado(boolean estado) {

        this.estado = estado;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Periodo periodo = (Periodo) o;
        return codigo == periodo.codigo &&
                estado == periodo.estado &&
                Objects.equals(fechaInicio, periodo.fechaInicio) &&
                Objects.equals(fechaFin, periodo.fechaFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, fechaInicio, fechaFin, estado);
    }
    /*
    @OneToMany(mappedBy = "periodoByPeriodoCod")
    public Collection<Campania> getCampaniasByCodigo() {

        return campaniasByCodigo;

    }

    public void setCampaniasByCodigo(Collection<Campania> campaniasByCodigo) {

        this.campaniasByCodigo = campaniasByCodigo;

    }*/
}
