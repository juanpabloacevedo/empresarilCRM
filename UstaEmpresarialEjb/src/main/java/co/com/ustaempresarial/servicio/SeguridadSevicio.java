package co.com.ustaempresarial.servicio;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;


import co.com.ustaempresarial.fachada.SeguridadFachada;
import co.com.ustaempresarial.seguridad.modelo.Permiso;
import co.com.ustaempresarial.seguridad.modelo.Rol;
import co.com.ustaempresarial.seguridad.modelo.RolPermiso;
import co.com.ustaempresarial.seguridad.modelo.RolUsuario;
import co.com.ustaempresarial.seguridad.modelo.Usuario;
import co.com.ustaempresarial.seguridad.modelo.UsuarioLog;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)

public class SeguridadSevicio {

	@EJB
	 SeguridadFachada fachada;
	
	/**
	 * metodo para listar los usuarios
	 * 
	 * @return traerUsuarios();: listado de usuarios
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */
	public List<Usuario> traerUsuarios() throws Exception {
		return fachada.traerUsuarios();
	}

	/**
	 * metodo que crea los usuarios
	 * 
	 * @param User: tipo de objeto a crear
	 * @throws Exception errores posibles sobre ejecucion
	 */
	public void crearUsuario(Usuario user) throws Exception {
		fachada.crearUsuario(user);
	}

	/**
	 * metodo encargado de actualizar los usuarios
	 * 
	 * @param Usuario
	 * @return el usuario que se creo
	 * @throws Exception
	 */

	public Usuario editarUsuario(Usuario user) throws Exception {
		return fachada.editarUsuario(user);
	}

	/**
	 * metodo que borra el Usuario seleccionado
	 * 
	 * @param codigo
	 * @return true: donde si borra y false donde hay error de ejecucion
	 * @throws Exception
	 */
	public boolean borrarUsuario(int codigo) throws Exception {
		return fachada.borrarUsuario(codigo);
	}

	/**
	 * metodo que busca por el nombre de Usuario
	 * 
	 * @param nombre: nombre de usuario
	 * @return: la objeto Usuario
	 * @throws Exception
	 */
	public List<Usuario> buscarPorNombre(String nombre) throws Exception {
		return fachada.buscarUsuarioPorNombre(nombre);
	}



	// ********************************************UsuarioLog***********************************
	/**
	 * metodo para listar los usuarios_log
	 * 
	 * @return List<UsuarioLog>: listado de usuarioLog
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 * @author Lorena
	 */
	public List<UsuarioLog> listarUsuarioLog() throws Exception {
		return fachada.listarUsuarioLog();
	}

	/**
	 * metodo que crea los usuarios_log
	 * 
	 * @param usuarioLog: tipo de objeto a crear
	 * @throws Exception errores posibles sobre ejecucion
	 * @author Lorena
	 */
	public void crearUsuarioLog(UsuarioLog usuarioLog) throws Exception {
		fachada.crearUsuarioLog(usuarioLog);
	}

	/**
	 * metodo encargado de actualizar los usuarios_log
	 * 
	 * @param usuarioLog
	 * @return el usuarioLog que se ha creado
	 * @throws Exception
	 * @author Lorena
	 */
	public UsuarioLog editarUsuarioLog(UsuarioLog usuarioLog) throws Exception {
		return fachada.editarUsuarioLog(usuarioLog);
	}

	/**
	 * metodo que borra el usuarioLog seleccionado
	 * 
	 * @param codigo
	 * @return true: donde si borra y false donde hay error de ejecucion
	 * @throws Exception
	 * @author Lorena
	 */
	public boolean eliminarUsuarioLog(int codigo) throws Exception {
		return fachada.eliminarUsuarioLog(codigo);
	}

	/**
	 * metodo que busca por el codigo de UsuarioLog
	 * 
	 * @param codigo: codigo de usuario
	 * @return: la objeto Usuario
	 * @throws Exception
	 * @author Lorena
	 */
	public UsuarioLog buscarUsuarioLog(int codigo) throws Exception {
		return fachada.buscarUsuarioLog(codigo);
	}

	/**
	 * metodo que busca por el proceso de UsuarioLog
	 * 
	 * @param proceso: proceso de usuario
	 * @return: la objeto Usuario
	 * @throws Exception
	 * @author Lorena
	 */
	public List<UsuarioLog> buscarUsuarioLogPorProceso(String proceso) throws Exception {
		return fachada.buscarUsuarioLogPorProceso(proceso);
	}

	// ******************************************************************************************
	// ************************************Rol************************************************
	/**
	 * metodo para listar los roles
	 * 
	 * @return List<Rol>: listado de rol
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 * @author Jairo
	 */
	public List<Rol> listarRol() throws Exception {
		return fachada.listarRol();
	}

	/**
	 * metodo que crea los roles
	 * 
	 * @param rol: tipo de objeto a crear
	 * @throws Exception errores posibles sobre ejecucion
	 * @author Jairo
	 */
	public void crearRol(Rol rol) throws Exception {
		fachada.crearRol(rol);
	}

	/**
	 * metodo encargado de actualizar los roles
	 * 
	 * @param rol
	 * @return el rol que se ha actualizado
	 * @throws Exception
	 * @author Jairo
	 */
	public Rol editarRol(Rol rol) throws Exception {
		return fachada.editarRol(rol);
	}

	/**
	 * metodo que borra el rol seleccionado
	 * 
	 * @param codigo
	 * @return true: donde si borra y false donde hay error de ejecucion
	 * @throws Exception
	 * @author Jairo
	 */

	public boolean eliminarRol(int codigo) throws Exception {
		return fachada.eliminarRol(codigo);
	}

	/**
	 * metodo que busca por el codigo de rol
	 * 
	 * @param codigo: codigo de usuario
	 * @return: la objeto Usuario
	 * @throws Exception
	 * @author Jairo
	 */

	public Rol buscarRol(int codigo) throws Exception {
		return fachada.buscarRol(codigo);
	}

	/**
	 * metodo que busca por el nombre de rol
	 * 
	 * @param nombre: nombre de usuario
	 * @return: la objeto Usuario
	 * @throws Exception
	 * @author Jairo
	 * 
	 */
	public List<Rol> buscarRolPorNombre(String nombre) throws Exception {
		return fachada.buscarRolPorNombre(nombre);
	}

	// *****************************************************************************************
	// *************************************Permiso**********************************************
	/**
	 * metodo para listar los roles
	 * 
	 * @return List<Permiso>: listado de Permiso
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 * @author Lizeth
	 */
	public List<Permiso> listarPermiso() throws Exception {
		return fachada.listarPermiso();
	}

	/**
	 * metodo para editar permisos
	 * 
	 * @param permiso: tipo de objeto a editar
	 * @return permiso tipo de objeto que se edita
	 * @throws Exception errores posibles sobre ejecucion
	 * @author Lizeth
	 */

	public void crearPermiso(Permiso permiso) throws Exception {
		fachada.crearPermiso(permiso);
	}

	/**
	 * metodo para editar permisos
	 * 
	 * @param permiso: tipo de objeto a editar
	 * @return permiso tipo de objeto que se edita
	 * @throws Exception errores posibles sobre ejecucion
	 * @author Lizeth
	 */
	public Permiso editarPermiso(Permiso permiso) throws Exception {
		return fachada.editarPermiso(permiso);
	}

	/**
	 * metodo para eliminar permisos
	 * 
	 * @param codigo identificador para buscar el objeto a borrar
	 * @return boolean tipo de respuesta para la eliminacion de objeto permiso
	 * @throws Exception errores posibles sobre ejecucion
	 * @author Lizeth
	 */
	public boolean eliminarPermiso(int codigo) throws Exception {
		return fachada.eliminarPermiso(codigo);
	}

	/**
	 * metodo para bucar permisos con codigo
	 * 
	 * @param permiso: tipo de objeto buscar
	 * @throws Exception errores posibles sobre ejecucion
	 * @author Lizeth
	 */
	public Permiso buscarPermiso(int codigo) throws Exception {
		return fachada.buscarPermiso(codigo);
	}

	/**
	 * metodo para bucar permisos por nombre
	 * 
	 * @param permiso: tipo de objeto buscar
	 * @throws Exception errores posibles sobre ejecucion
	 * @author Lizeth
	 */

	public List<Permiso> buscarPermisoPorNombre(String nombre) throws Exception {
		return buscarPermisoPorNombre(nombre);
	}

	// **************************************************************************************
	/**
	 * metodo para listar los RolUsuarios
	 * 
	 * @return List<RolUsuario>: listado de RolUsuario
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 * @author Fabian
	 */
	public List<RolPermiso> traerRolPermisos() throws Exception {
		return fachada.listarRolPermiso();
	}

	/**
	 * metodo encargado para crear rolUsuario
	 * 
	 * @return el Rolusuario que se creo
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 * @author Fabian
	 */
	public void crearRolPermisos(RolPermiso rolP) throws Exception {
		fachada.crearRolPermiso(rolP);
	}
	/**
	 * metodo encargado de buscar los RolUsuarios 
	 * @param codigo del usuario
	 * @return el objeto rolUsuario
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 *@author Fabian
	 */

	public RolPermiso buscarRolPermiso(int codigo) throws Exception {
		return fachada.buscarRolPermiso(codigo);
	}
	/**
	 * metodo para listar los RolPermiso
	 * @return List<RolPermiso>: listado de RolPermiso
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 * @author Fabian
	 */

	public List<RolUsuario> traerRolUsuario() throws Exception {
		return fachada.listarRolUsuario();
	}
	/**
	 * metodo encargado para crear el rolPermiso
	 * @throws Exception
	 * @author Fabian
	 */

	public void crearRolUsuarios(RolUsuario rolU) throws Exception {
		fachada.crearRolUsuario(rolU);
	}
	/**
	 * metodo para listar los RolPermiso
	 * @param codigo del permiso
	 * @return el objeto rolPermiso
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 * @author Fabian
	 */

	public RolUsuario buscarRolUsuario(int codigo) throws Exception {
		return fachada.buscarRolUsuario(codigo);
	}	
	
}
