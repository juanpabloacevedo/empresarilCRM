package co.com.UstaEmpresarial.nomina.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dependencia database table.
 * 
 */
@Entity
@Table(name="dependencia", schema="nomina")
public class Dependencia implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FIND_ALL = "Dependencia.LISTAR_POR_DEPENDENCIA";
	private Integer codigo;
	private Integer dependenciaPadre;
	private Boolean estado;
	private String nombre;

	public Dependencia() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	@Column(name="dependencia_padre")
	public Integer getDependenciaPadre() {
		return this.dependenciaPadre;
	}

	public void setDependenciaPadre(Integer dependenciaPadre) {
		this.dependenciaPadre = dependenciaPadre;
	}


	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}