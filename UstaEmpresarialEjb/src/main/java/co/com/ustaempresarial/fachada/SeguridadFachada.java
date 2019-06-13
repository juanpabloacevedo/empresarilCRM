package co.com.ustaempresarial.fachada;

import java.util.List;


import co.com.ustaempresarial.seguridad.modelo.Permiso;
import co.com.ustaempresarial.seguridad.modelo.Rol;
import co.com.ustaempresarial.seguridad.modelo.RolPermiso;
import co.com.ustaempresarial.seguridad.modelo.RolUsuario;
import co.com.ustaempresarial.seguridad.modelo.Usuario;
import co.com.ustaempresarial.seguridad.modelo.UsuarioLog;

import javax.ejb.Remote;

@Remote
public interface SeguridadFachada {
	
	
	/**
	 * Método  para listar los usuarios
	 * @return List<CategoriaProducto>: listado de productos
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 */
	public List<Usuario> traerUsuarios() throws Exception;
	
	/**
	 * Método  que crea los usuarios 
	 * @param User: tipo de objeto a crear
	 * @throws Exception errores posibles sobre ejecucion
	 */
	public void crearUsuario(Usuario user) throws Exception;
	
	/**
	 * Método  encargado de actualizar los usuarios 
	 * @param Usuario
	 * @return el usuario que se creo
	 * @throws Exception
	 */
	public Usuario editarUsuario(Usuario user) throws Exception;
	
	/**
	 * Método  que borra el Usuario seleccionado
	 * @param codigo
	 * @return true: donde si borra y false donde hay error de ejecucion
	 * @throws Exception
	 */
	public boolean borrarUsuario(int codigo) throws Exception;

	/**
	 * Método  que busca por el nombre de Usuario
	 * @param nombre: nombre de usuario
	 * @return: la objeto Usuario
	 * @throws Exception
	 */
	public List<Usuario> buscarUsuarioPorNombre(String nombre) throws Exception;
	//************************Usuario_Log*********************************************
			/**
	 * Método  para listar los usuarios_log
	 * @return List<UsuarioLog>: listado de usuarioLog
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 * @author Lorena
	 */
		public List<UsuarioLog> listarUsuarioLog() throws Exception;

	/**
	 * Método  que crea los usuarios_log 
	 * @param usuarioLog: tipo de objeto a crear
	 * @throws Exception errores posibles sobre ejecucion
	 *  @author Lorena
	 */
		public void crearUsuarioLog(UsuarioLog usuarioLog) throws Exception;

	/**
	 * Método  encargado de actualizar los usuarios_log 
	 * @param usuarioLog
	 * @return el usuarioLog que se ha creado
	 * @throws Exception
	 * @author Lorena
	 */
		public UsuarioLog editarUsuarioLog(UsuarioLog usuarioLog) throws Exception;

	/**
	 * Método  que borra el usuarioLog seleccionado
	 * @param codigo
	 * @return true: donde si borra y false donde hay error de ejecucion
	 * @throws Exception
	 * @author Lorena
	 */
		public boolean eliminarUsuarioLog(int codigo) throws Exception;
	/**
	 * Método  que busca por el codigo de UsuarioLog
	 * @param codigo: codigo de usuario
	 * @return: la objeto Usuario
	 * @throws Exception
	 * @author Lorena
	 */
	
		public UsuarioLog buscarUsuarioLog(int codigo) throws Exception; 
		/**
	 * Método  que busca por el proceso de UsuarioLog
	 * @param proceso: proceso de usuario
	 * @return: la objeto Usuario
	 * @throws Exception
	 * @author Lorena
	 */
public List<UsuarioLog> buscarUsuarioLogPorProceso(String proceso) throws Exception; 
	//********************************************************************************
		//--------------rol-----------------------------------------------------------
		/**
		 * Método  para listar los roles
		 * @return List<Rol>: listado de rol
		 * @throws Exception Capturar errores posibles sobre ejecucion
		 * @author Jairo
		 */
			public List<Rol> listarRol() throws Exception;
		
		/**
		 * Método  que crea los roles
		 * @param rol: tipo de objeto a crear
		 * @throws Exception errores posibles sobre ejecucion
		 * @author Jairo
		 */
			public void crearRol(Rol rol) throws Exception;
		
		/**
		 * Método  encargado de actualizar los roles 
		 * @param rol
		 * @return el rol que se ha actualizado
		 * @throws Exception
		 * @author Jairo
		 */
			public Rol editarRol(Rol rol) throws Exception;

		/**
		 * Método  que borra el rol seleccionado
		 * @param codigo
		 * @return true: donde si borra y false donde hay error de ejecucion
		 * @throws Exception
		 * @author Jairo
		 */
			public boolean eliminarRol(int codigo) throws Exception;
		/**
		 * Método  que busca por el codigo de rol
		 * @param codigo: codigo de usuario
		 * @return: la objeto Usuario
		 * @throws Exception
		 * @author Jairo
		 */
			public Rol buscarRol(int codigo) throws Exception; 
		/**
		 * Método  que busca por el nombre de rol
		 * @param nombre: nombre de usuario
		 * @return: la objeto Usuario
		 * @throws Exception
		 * @author Jairo
		
		*/
	public List<Rol> buscarRolPorNombre(String nombre) throws Exception;
	
	//******************************Permiso*******************************************
	/**
	 * Método  para listar los roles
	 * @return List<Permiso>: listado de Permiso
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 * @author Lizeth
	 */
		public List<Permiso> listarPermiso() throws Exception;
	
	/**
	 * Método  que crea los permiso
	 * @param permiso: tipo de objeto a crear
	 * @throws Exception errores posibles sobre ejecucion
	 * @author Lizeth
	 */
		public void crearPermiso(Permiso permiso) throws Exception;
		/**
		 * Método  para editar permisos
		 * @param permiso: tipo de objeto a editar
		 * @return permiso tipo de objeto que se edita
		 * @throws Exception errores posibles sobre ejecucion
		 * @author Lizeth
		 */

		public Permiso editarPermiso(Permiso permiso) throws Exception;
		/**
		 * Método  para eliminar permisos
		 * @param codigo identificador para buscar el objeto a borrar
		 * @return boolean tipo de respuesta para la eliminacion de objeto permiso
		 * @throws Exception errores posibles sobre ejecucion
		 * @author Lizeth
		 */
		public boolean eliminarPermiso(int codigo) throws Exception;
		/**
		 * Método  para buscar permisos con codigo
		 * @param permiso: tipo de objeto buscar 
		 * @throws Exception errores posibles sobre ejecucion
		 * @author Lizeth
		 */
		
		public Permiso buscarPermiso(int codigo) throws Exception; 
		/**
		 * Método  para buscar permisos por nombre
		 * @param permiso: tipo de objeto buscar 
		 * @throws Exception errores posibles sobre ejecucion
		 * @author Lizeth
		 */
		
		public List<Permiso> buscarPermisoPorNombre(String nombre) throws Exception;
	
       //********************************rol_usuario*******************************************
		/**
		 * Método  para listar los RolUsuarios
		 * @return List<RolUsuario>: listado de RolUsuario
		 * @throws Exception Capturar errores posibles sobre ejecucion
		 *@author Fabian
		 */
		public List<RolUsuario> listarRolUsuario() throws Exception;
		/**
		 * Método  encargado para crear rolUsuario 
		 * @return el Rolusuario que se creo
		 * @throws Exception Capturar errores posibles sobre ejecucion
		 * @author Fabian
		 */
		public void crearRolUsuario(RolUsuario rolU) throws Exception;
		/**
		 * Método  encargado de buscar los RolUsuarios 
		 * @param codigo del usuario
		 * @return el objeto rolUsuario
		 * @throws Exception Capturar errores posibles sobre ejecucion
		 *@author Fabian
		 */
		public RolUsuario buscarRolUsuario(int codigo) throws Exception; 
		
	//**********************************rol_permiso******************************************
		/**
		 * Método  para listar los RolPermiso
		 * @return List<RolPermiso>: listado de RolPermiso
		 * @throws Exception Capturar errores posibles sobre ejecucion
		 * @author Fabian
		 */
		public List<RolPermiso> listarRolPermiso() throws Exception;
		/**
		 * Método  encargado para crear el rolPermiso
		 * @throws Exception
		 * @author Fabian
		 */
		public void crearRolPermiso(RolPermiso rolP) throws Exception;
		/**
		 * Método  para listar los RolPermiso
		 * @param codigo del permiso
		 * @return el objeto rolPermiso
		 * @throws Exception Capturar errores posibles sobre ejecucion
		 * @author Fabian
		 */
		public RolPermiso buscarRolPermiso(int codigo) throws Exception;
	
}
