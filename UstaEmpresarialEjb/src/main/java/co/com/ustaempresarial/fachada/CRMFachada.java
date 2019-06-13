package co.com.ustaempresarial.fachada;

import javax.ejb.Remote;

import java.util.List;

import co.com.ustaempresarial.modelo.crm.Campania;
import co.com.ustaempresarial.modelo.crm.Evento;
import co.com.ustaempresarial.modelo.crm.Medio;
import co.com.ustaempresarial.modelo.crm.Periodo;
import co.com.ustaempresarial.modelo.crm.Recurso;
import co.com.ustaempresarial.modelo.crm.TipoMedio;

@Remote
public interface CRMFachada {

	/**
	 * En este metodo se va a listar las campañas publicitarias Realizadas
	 * 
	 * @return List<Campania>: listado de Campañas
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */
	public List<Campania> listarCampania() throws Exception;

	/**
	 * Este Metodo que crea una campaña publicitaria
	 * 
	 * @param campania: tipo de objeto a crear
	 * @param listaEvento: Lista de eventos
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */
	public void crearCampania(Campania campania) throws Exception;

	/**
	 * Este metodo lo que hace es editar una campaña ya creada
	 * 
	 * @param Objeto de tipo Campania
	 * @return La campania que se creo
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */
	public Campania editarCampania(Campania campania) throws Exception;

	/**
	 * Este metodo borra una campaña
	 * 
	 * @param Codigo de la campaña que hay que borrar
	 * @return true: donde si borra y false donde hay error de ejecucion
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */
	public boolean eliminarCampania(int codigo) throws Exception;

	/**
	 * Este metodo busca una campaña publicitaria por el nombre
	 * 
	 * @param String que viene siendo el nombre de la campaña a buscar
	 * @return List<Campania>: listado de Campañas por ese nombre
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */

	public List<Campania> buscarCampaniaPorNombre(String nombre) throws Exception;

	// RECURSO
	/**
	 * Metodo que lista los recursos completo
	 * 
	 * @return List<recursos>
	 * @throws Exception Captura posibles errores sobre la ejecución
	 */
	public List<Recurso> listarRecursos() throws Exception;

	/**
	 * Metodo que permite agregar un recurso
	 * 
	 * @param Objeto recurso
	 * @throws Exception Captura posibles errores sobre la ejecución
	 */
	public void crearRecurso(Recurso puc) throws Exception;

	/**
	 * Metodo que permite actualizar una recurso
	 * 
	 * @param Objeto recurso
	 * @return Objeto recurso
	 * @throws Exception Captura posibles errores sobre la ejecución
	 */
	public Recurso editarRecurso(Recurso puc) throws Exception;

	/**
	 * Metodo que elimina un recurso
	 * 
	 * @param Entero que representa el codigo de la recurso
	 * @return true: Si se borró y false si no se borró
	 * @throws Exception Captura posibles errores sobre la ejecución
	 */
	public boolean eliminarRecurso(int codigo) throws Exception;

	/**
	 * Metodo que busca una recurso por nombre
	 * 
	 * @param Nombre de la recurso
	 * @return Objeto recurso
	 * @throws Exception Captura posibles errores sobre la ejecución
	 */
	public Recurso listarRecursoNombre(String nombre) throws Exception;

	// TIPO MEDIO
	/**
	 * Metodo que lista el tipo medio
	 * 
	 * @return List<TipoMedio> Lista de las cuentas del TipoMedio
	 * @throws Exception Captura posibles errores sobre la ejecución
	 */
	public List<TipoMedio> listarTipoMedio() throws Exception;

	/**
	 * Metodo que permite agregar un medio a TipoMedio
	 * 
	 * @param Objeto TipoMedio
	 * @throws Exception Captura posibles errores sobre la ejecución
	 */
	public void crearTipoMedio(TipoMedio name) throws Exception;

	/**
	 * Metodo qué permite actualizar un medio perteneciente al TipoMedio
	 * 
	 * @param Objeto TipoMedio
	 * @return Objeto TipoMedio
	 * @throws Exception Captura posibles errores sobre la ejecución
	 */
	public TipoMedio editarTipoMedio(TipoMedio name) throws Exception;

	/**
	 * Metodo que elimina un medio asociada al TipoMedio
	 * 
	 * @return true: Si se borró y false si no se borró
	 * @throws Exception Captura posibles errores sobre la ejecución
	 */
	public boolean eliminarTipoMedio(int estado) throws Exception;

	/**
	 * Metodo que busca un medio por nombre
	 * 
	 * @param Nombre del medio
	 * @return Objeto TipoMedio
	 * @throws Exception Captura posibles errores sobre la ejecución
	 */
	public TipoMedio listarTipoMedioPorNombre(String nombre) throws Exception;

	// Periodo

	/**
	 *  En este metodo se va a listar los periodos
	 * 
	 * @return List<Periodo>: listado de periodo
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */

	public List<Periodo> listarPeriodo() throws Exception;

	/**
	 * Metodo que permite crear los periodos
	 * 
	 * @param Objeto Tipo de objeto a crear.
	 * @throws Exception Captura posibles errores sobre la ejecución
	 */

	public void crearPeriodo(Periodo per) throws Exception;

	/**
	 * Metodo que permite actualizar el periodo de una cuenta
	 * 
	 * @param Objeto Periodo
	 * @return Objeto Periodo
	 * @throws Exception Captura posibles errores sobre la ejecución
	 */
	public Periodo editarPeriodo(Periodo per) throws Exception;

	/**
	 * Metodo que elimina un periodo asociado a la cuenta
	 * 
	 * @param Entero que representa el codigo de periodo de publicidad
	 * @return true: Si es activo y false si es inactivo
	 * @throws Exception Captura posibles errores sobre la ejecución
	 */
	public boolean eliminarRegistros(int codigo) throws Exception;

	/**
	 * Metodo que busca un registro por codigo
	 * 
	 * @param Codigo del periodo
	 * @return Objeto Periodo
	 * @throws Exception Captura posibles errores sobre la ejecución
	 */

	// Medio

	/**
	 * En este metodo se va a listar los medios publicitarios utilizados
	 * 
	 * @return List<Medio>: listado de medios
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */
	public List<Medio> listarMedio() throws Exception;

	/**
	 * Este Metodo crea un medio
	 * 
	 * @param medio: tipo de objeto a crear
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */
	public void crearMedio(Medio medio) throws Exception;

	/**
	 * Este metodo lo que hace es editar un medio ya creado
	 * 
	 * @param Objeto de tipo Medio
	 * @return La medio que se creo
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */
	public Medio editarMedio(Medio medio) throws Exception;

	/**
	 * Este metodo borra una medio
	 * 
	 * @param Codigo de la medio que hay que eliminar
	 * @return true: donde si borra y false donde hay error de ejecucion
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */
	public boolean eliminarMedio(int codigo) throws Exception;

	/**
	 * Este metodo busca una medio publicitario por el nombre
	 * 
	 * @param String que viene siendo el nombre de la medio a buscar
	 * @return List<Medio>: listado de medios por ese nombre
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */

	public List<Medio> buscarMedioPorNombre(String nombre) throws Exception;
	
	//Evento
	
	/**
	 *  En este metodo se va a listar los eventos publicitarios realizados
	 * 
	 * @return List<Evento>: listado de Evento
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */
	public List<Evento> listarEvento() throws Exception;

	/**
	 * Este Metodo que crea un evento publicitario
	 * 
	 * @param evento: tipo de objeto a crear
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */
	public void crearEvento(Evento evento) throws Exception;

	/**
	 * Este metodo edita un evento creado
	 * 
	 * @param Objeto de tipo Evento
	 * @return El evento que se creo
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */
	public Evento editarEvento(Evento evento) throws Exception;

	/**
	 * Este metodo borra un evento
	 * 
	 * @param Codigo del evento que hay que eliminar
	 * @return true: donde si borra y false donde hay error de ejecucion
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */
	public boolean eliminarEvento(int codigo) throws Exception;

	/**
	 * Este metodo busca un evento publicitario por el nombre 
	 * 
	 * @param String nombre del evento a buscar
	 * @return List<Evento>: listado de Evento por ese nombre
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */

	public List<Evento> buscarEventoPorNombre(String nombre) throws Exception;
}
