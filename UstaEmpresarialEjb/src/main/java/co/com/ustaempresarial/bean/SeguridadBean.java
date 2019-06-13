package co.com.ustaempresarial.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.ustaempresarial.fachada.SeguridadFachada;
import co.com.ustaempresarial.seguridad.modelo.Permiso;
import co.com.ustaempresarial.seguridad.modelo.Rol;
import co.com.ustaempresarial.seguridad.modelo.RolPermiso;
import co.com.ustaempresarial.seguridad.modelo.RolPermisoPK;
import co.com.ustaempresarial.seguridad.modelo.RolUsuario;
import co.com.ustaempresarial.seguridad.modelo.RolUsuarioPK;
import co.com.ustaempresarial.seguridad.modelo.Usuario;
import co.com.ustaempresarial.seguridad.modelo.UsuarioLog;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SeguridadBean implements SeguridadFachada {
	@PersistenceContext(unitName = "PersistenceSeguridad")
	private EntityManager em;

	public SeguridadBean() {
		super();
	}

	@Override
	public List<Usuario> traerUsuarios() throws Exception {
		List<Usuario> users = new ArrayList<Usuario>();

		Query query = em.createNamedQuery(Usuario.FIND_ALL);
		users = query.getResultList();
		return users;
	}

	@Override
	public void crearUsuario(Usuario user) throws Exception {
		if (user.getNombre() != null && !user.getNombre().equals("")) {
			em.persist(user);
		}
	}

	@Override
	public Usuario editarUsuario(Usuario user) throws Exception {
		Usuario usuario = new Usuario();
		usuario = buscarPorId(user.getCodigo());
		if (usuario.getCodigo() > 0) {
			em.merge(user);
		} else
			usuario = null;

		return usuario;
	}

	@Override
	public boolean borrarUsuario(int codigo) throws Exception {
		Usuario user = buscarPorId(codigo);
		boolean retorno = false;
		if (user.getCodigo() > 0) {
			em.remove(user);
			retorno = true;
		}

		return retorno;
	}

	/**
	 * metodo para buscar por el codigo usuario
	 * 
	 * @return usuario
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 * @autor Juan Sebastian Ulloa
	 */
	private Usuario buscarPorId(int codigoUser) throws Exception {
		Usuario u = new Usuario();
		u = em.find(Usuario.class, codigoUser);
		return u;
	}

	@Override
	public List<Usuario> buscarUsuarioPorNombre(String nombre) throws Exception {
		List<Usuario> usuario = new ArrayList<>();
		Query query = em.createNamedQuery(Usuario.ENCONTRAR_POR_NOMBRE);
		if (nombre != null) {
			query.setParameter("nombre", nombre);
			usuario = query.getResultList();
		}
		return usuario;

	}

	// ****************************************Usuariolog******************************************
	@Override
	public List<UsuarioLog> listarUsuarioLog() throws Exception {
		List<UsuarioLog> usuarioLogList;
		Query q;
		usuarioLogList = new ArrayList<UsuarioLog>();
		q = em.createNamedQuery(UsuarioLog.TRAER_USUARIO_LOG);
		return usuarioLogList;
	}

	@Override
	public void crearUsuarioLog(UsuarioLog usuarioLog) throws Exception {
		if (usuarioLog.getProceso() != null && !usuarioLog.getProceso().equals("")) {
			em.persist(usuarioLog);
		}
		// TODO Auto-generated method stub

	}

	@Override
	public UsuarioLog editarUsuarioLog(UsuarioLog usuarioLog) throws Exception {
		UsuarioLog objUsuarioLog;
		objUsuarioLog = new UsuarioLog();
		if (usuarioLog != null) {
			objUsuarioLog = buscarUsuarioLog(usuarioLog.getCodigo());
			em.merge(usuarioLog);
		} else {
			usuarioLog = null;
		}
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public boolean eliminarUsuarioLog(int codigo) throws Exception {
		UsuarioLog objUsuarioLog;
		objUsuarioLog = new UsuarioLog();
		boolean retorno;
		objUsuarioLog = buscarUsuarioLog(codigo);
		retorno = false;
		if (objUsuarioLog.getCodigo() > 0) {
			em.remove(objUsuarioLog);
			retorno = true;
		}
		return retorno;
	}

	@Override
	public UsuarioLog buscarUsuarioLog(int codigo) throws Exception {
		UsuarioLog objUsuarioLog;
		objUsuarioLog = new UsuarioLog();
		objUsuarioLog = em.find(UsuarioLog.class, codigo);
		// TODO Auto-generated method stub
		return objUsuarioLog;
	}

	@Override
	public List<UsuarioLog> buscarUsuarioLogPorProceso(String proceso) throws Exception {
		List<UsuarioLog> usuarioLogList;
		Query q;

		usuarioLogList = new ArrayList<UsuarioLog>();
		q = em.createNamedQuery(UsuarioLog.ENCONTRAR_NOMBRE_PROCESO_USUARIO_LOG);

		if (proceso != null) {
			q.setParameter("proceso", proceso);
			usuarioLogList = q.getResultList();
		}
		return usuarioLogList;
	}

	// *************************************************************************************************
	// ************************************Rol*****************************************************
	@Override
	public List<Rol> listarRol() throws Exception {
		List<Rol> rolList;
		Query q;
		rolList = new ArrayList<Rol>();
		q = em.createNamedQuery(Rol.TRAER_ROL);
		return rolList;
	}

	@Override
	public void crearRol(Rol rol) throws Exception {
		if (rol.getNombre() != null && !rol.getNombre().equals("")) {
			if (rol.getDescripcion() != null && !rol.getDescripcion().equals("")) {
				em.persist(rol);
			}
		} else {

		}

	}

	@Override
	public Rol editarRol(Rol rol) throws Exception {
		Rol objRol;
		objRol = new Rol();
		if (objRol != null) {
			objRol = buscarRol(objRol.getCodigo());
			em.merge(objRol);
		} else {
			objRol = null;
		}

		return objRol;
	}

	@Override
	public boolean eliminarRol(int codigo) throws Exception {
		Rol objRol;
		boolean retorno;

		objRol = buscarRol(codigo);
		retorno = false;
		if (objRol.getCodigo() > 0) {
			em.remove(objRol);
			retorno = true;
		}
		return retorno;
	}

	@Override
	public Rol buscarRol(int codigo) throws Exception {
		Rol objRol;
		objRol = new Rol();
		objRol = em.find(Rol.class, codigo);
		return objRol;

	}

	@Override
	public List<Rol> buscarRolPorNombre(String nombre) throws Exception {
		List<Rol> rolList;
		Query q;

		rolList = new ArrayList<Rol>();
		q = em.createNamedQuery(Rol.ENCONTRAR_NOMBRE_ROL);

		if (nombre != null) {
			q.setParameter("nombre", nombre);
			rolList = q.getResultList();
		}
		return rolList;
	}

	// ********************************************************************************************
	// **************************************Permiso****************************************************
	@Override
	public List<Permiso> listarPermiso() throws Exception {
		List<Permiso> permisoList;
		Query q;
		permisoList = new ArrayList<Permiso>();
		q = em.createNamedQuery(Permiso.TRAER_PERMISO);
		return permisoList;
	}

	@Override
	public void crearPermiso(Permiso permiso) throws Exception {
		if (permiso.getNombre() != null && !permiso.getNombre().equals("")) {
			if (permiso.getDescripcion() != null && !permiso.getDescripcion().equals("")) {
				em.persist(permiso);
			}
		}

	}

	@Override
	public Permiso editarPermiso(Permiso permiso) throws Exception {
		Permiso objPermiso;
		objPermiso = new Permiso();
		if (objPermiso != null) {
			objPermiso = buscarPermiso(objPermiso.getCodigo());
			em.merge(objPermiso);
		} else {
			objPermiso = null;
		}

		return objPermiso;
	}

	@Override
	public boolean eliminarPermiso(int codigo) throws Exception {
		Permiso objPermiso;
		boolean retorno;

		objPermiso = buscarPermiso(codigo);
		retorno = false;
		if (objPermiso.getCodigo() > 0) {
			em.remove(objPermiso);
			retorno = true;
		}
		return retorno;
	}

	@Override
	public Permiso buscarPermiso(int codigo) throws Exception {
		Permiso objPermiso;
		objPermiso = new Permiso();
		objPermiso = em.find(Permiso.class, codigo);
		return objPermiso;
	}

	@Override
	public List<Permiso> buscarPermisoPorNombre(String nombre) throws Exception {
		List<Permiso> permisoList;
		Query q;

		permisoList = new ArrayList<Permiso>();
		q = em.createNamedQuery(Permiso.ENCONTRAR_NOMBRE_PERMISO);

		if (nombre != null) {
			q.setParameter("nombre", nombre);
			permisoList = q.getResultList();
		}
		return permisoList;
	}
	// *********************************************************************************************

	@Override
	public List<RolPermiso> listarRolPermiso() throws Exception {
		List<RolPermiso> rolPermisoList;
		rolPermisoList = new ArrayList<RolPermiso>();
		Query q = em.createNamedQuery(RolPermiso.LISTAR_PERMISOS);
		rolPermisoList = q.getResultList();
		return rolPermisoList;
	}

	@Override
	public void crearRolPermiso(RolPermiso rolP) throws Exception {
		if (rolP.getId().getRolCod() > 0 && rolP.getId().getPermisoCod() > 0) {
			em.persist(rolP);
		}

	}

	@Override
	public RolPermiso buscarRolPermiso(int codigo) throws Exception {
		RolPermiso objRol;
		objRol = new RolPermiso();
		objRol = em.find(RolPermiso.class, codigo);
		return objRol;
	}

	/**
	 * metodo para buscar el rolpermiso por el codigo
	 * 
	 * @return RolPermiso
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 * @autor Juan Sebastian Ulloa
	 */
	private RolPermiso buscarPorId(RolPermisoPK codigo) throws Exception {
		RolPermiso rolP = new RolPermiso();
		rolP = em.find(RolPermiso.class, codigo);
		return rolP;
	}

	@Override
	public List<RolUsuario> listarRolUsuario() throws Exception {
		List<RolUsuario> rolUsuarioList;
		rolUsuarioList = new ArrayList<RolUsuario>();
		Query q = em.createNamedQuery(RolUsuario.LISTAR_ROL_USER);
		rolUsuarioList = q.getResultList();
		return rolUsuarioList;
	}

	@Override
	public void crearRolUsuario(RolUsuario rolU) throws Exception {
		if (rolU.getId().getRolCod() > 0 && rolU.getId().getUsuarioCod() > 0) {
			em.persist(rolU);
		}
	}

	@Override
	public RolUsuario buscarRolUsuario(int codigo) throws Exception {
		RolUsuario objRol;
		objRol = new RolUsuario();
		objRol = em.find(RolUsuario.class, codigo);
		return objRol;
	}

	/**
	 * metodo para buscar el RolUsuario por el codigo
	 * 
	 * @return RolUsuario
	 * @throws Exception Capturar errores posibles sobre ejecucion
	 * @autor Karen Pacasira, Jairo Cardenas
	 */

	private RolUsuario buscarPorId(RolUsuarioPK codigo) throws Exception {
		RolUsuario rolP = new RolUsuario();
		rolP = em.find(RolUsuario.class, codigo);
		return rolP;
	}

	// ------------------------------Regla
	// negocio-----------------------------------------------
	public List listaPermiso() throws Exception {
		List<String> objPermiso;
		objPermiso = new ArrayList<>();
		Query q = em.createNamedQuery(UsuarioLog.ENCONTRAR_MODULO_USUARIO);
		objPermiso = q.getResultList();
		return objPermiso;
	}

	// ----------------------------------------------------------------------------------------------
	// ------------------------------Cambiar
	// Formato-------------------------------------------------
	/**
	 * metodo para cambiar formato de date a Timestamp
	 * 
	 * @return Timestamp
	 * @autor Karen Pacasira, Jairo Cardenas
	 */

	public Timestamp cambiarFormato(Date fecha) {
		return new Timestamp(fecha.getTime());
	}
	// -----------------------------------------------------------------------------------------------

}
