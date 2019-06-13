package co.com.UstaEmpresarial.nomina.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the hoja_vida database table.
 * 
 */
@Entity
@Table(name="hoja_vida", schema = "nomina")
public class HojaVida implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FILL_ALL = "Hoja_vida.LISTAR_HOJA_VIDA";
	private Integer documento;
	private String apellido;
	private String direccion;
	private Date nacimientoFecha;
	private String nacimientoLugar;
	private String nombre;
	private Integer telefono;

	public HojaVida() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getDocumento() {
		return this.documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}


	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="nacimiento_fecha")
	public Date getNacimientoFecha() {
		return this.nacimientoFecha;
	}

	public void setNacimientoFecha(Date nacimientoFecha) {
		this.nacimientoFecha = nacimientoFecha;
	}


	@Column(name="nacimiento_lugar")
	public String getNacimientoLugar() {
		return this.nacimientoLugar;
	}

	public void setNacimientoLugar(String nacimientoLugar) {
		this.nacimientoLugar = nacimientoLugar;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

}