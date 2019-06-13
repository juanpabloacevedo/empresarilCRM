package co.com.UstaEmpresarial.nomina.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cargo database table.
 * 
 */
@Entity
@Table(name="cargo", schema="nomina")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String LISTAR_CARGO="Cargo.LISTAR_CARGO";
	private Integer codigo;
	private String competencias;
	private String funcion;
	private String nombre;

	public Cargo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getCompetencias() {
		return this.competencias;
	}

	public void setCompetencias(String competencias) {
		this.competencias = competencias;
	}


	public String getFuncion() {
		return this.funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}