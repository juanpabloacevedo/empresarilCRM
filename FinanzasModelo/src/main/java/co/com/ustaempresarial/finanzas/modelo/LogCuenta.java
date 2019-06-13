package co.com.ustaempresarial.finanzas.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the log_cuentas database table.
 * 
 */
@Entity
@Table(name="log_cuentas", schema="finanzas")
public class LogCuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_cuenta_nueva")
	private Integer codigoCuentaNueva;

	@Column(name="descripcion_cuenta_nueva")
	private String descripcionCuentaNueva;

	@Column(name="nombre_cuenta_nueva")
	private String nombreCuentaNueva;

	@Column(name="tipo_cuenta_nueva")
	private Integer tipoCuentaNueva;

	@Temporal(TemporalType.DATE)
	@Column(name="vigencia_cuenta_nueva")
	private Date vigenciaCuentaNueva;

	public LogCuenta() {
	}

	public Integer getCodigoCuentaNueva() {
		return this.codigoCuentaNueva;
	}

	public void setCodigoCuentaNueva(Integer codigoCuentaNueva) {
		this.codigoCuentaNueva = codigoCuentaNueva;
	}

	public String getDescripcionCuentaNueva() {
		return this.descripcionCuentaNueva;
	}

	public void setDescripcionCuentaNueva(String descripcionCuentaNueva) {
		this.descripcionCuentaNueva = descripcionCuentaNueva;
	}

	public String getNombreCuentaNueva() {
		return this.nombreCuentaNueva;
	}

	public void setNombreCuentaNueva(String nombreCuentaNueva) {
		this.nombreCuentaNueva = nombreCuentaNueva;
	}

	public Integer getTipoCuentaNueva() {
		return this.tipoCuentaNueva;
	}

	public void setTipoCuentaNueva(Integer tipoCuentaNueva) {
		this.tipoCuentaNueva = tipoCuentaNueva;
	}

	public Date getVigenciaCuentaNueva() {
		return this.vigenciaCuentaNueva;
	}

	public void setVigenciaCuentaNueva(Date vigenciaCuentaNueva) {
		this.vigenciaCuentaNueva = vigenciaCuentaNueva;
	}

}