package co.com.ustaempresarial.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.facturacion.modelo.CategoriaProducto;
import co.com.facturacion.modelo.Cliente;
import co.com.facturacion.modelo.Producto;
import co.com.facturacion.modelo.Proveedor;
import co.com.facturacion.modelo.ProveedorProducto;
import co.com.facturacion.modelo.ProveedorProductoPK;
import co.com.facturacion.modelo.Venta;
import co.com.facturacion.modelo.VentaDetalle;
import co.com.facturacion.modelo.VentaDetallePK;
import co.com.ustaempresarial.fachada.FacturacionFachada;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FacturacionBean implements FacturacionFachada {

	@PersistenceContext(unitName = "PersistenceFacturacion")
	private EntityManager em;

	public FacturacionBean() {
		super();
	}
	//------------------------CRUD DE CATEGORIAPRODUCTO--------------------------------
	@Override
	public List<CategoriaProducto> traerProductos() throws Exception {
		List<CategoriaProducto> categoriaProductos = new ArrayList<CategoriaProducto>();

		Query query = em.createNamedQuery(CategoriaProducto.FILL_ALL);

		categoriaProductos = query.getResultList();

		return categoriaProductos;
	}

	@Override
	public void crearCagtegoriaProducto(CategoriaProducto producto) throws Exception {
		if (producto.getNombre() != null && !producto.getNombre().equals("")) {
			em.persist(producto);
		}

	}

	@Override
	public CategoriaProducto editarCategoriaProducto(CategoriaProducto categoriaProducto) throws Exception {
		CategoriaProducto producto = new CategoriaProducto();
		producto = buscarPorId(categoriaProducto.getCodigo());
		if (producto.getCodigo() > 0) {
			em.merge(categoriaProducto);
		} else
			producto = null;

		return producto;
	}

	@Override
	public boolean borrarCategoriaProducto(int codigo) throws Exception {
		CategoriaProducto categoriaProducto = buscarPorId(codigo);
		boolean retorno = false;
		if (categoriaProducto.getCodigo() > 0) {
			em.remove(categoriaProducto);
			retorno = true;
		}

		return retorno;
	}

	private CategoriaProducto buscarPorId(int codigoCategoria) throws Exception {
		CategoriaProducto p = new CategoriaProducto();
		p = em.find(CategoriaProducto.class, codigoCategoria);
		return p;
	}

	@Override
	public List<CategoriaProducto> buscarCategoriaPorNombre(String nombre) throws Exception {
		List<CategoriaProducto> catProd = new ArrayList<CategoriaProducto>();
		Query query = em.createNamedQuery(CategoriaProducto.ENCONTRAR_POR_NOMBRE);
		if (nombre != null) {
			query.setParameter("nombre", nombre);
			catProd =query.getResultList();
		}
		return catProd;
	}
	//------------------------CRUD DE VETA DETALLE--------------------------------

	@Override
	public VentaDetalle actualizarVentaDetalle(VentaDetalle detalle) throws Exception {
		VentaDetalle ventaDetalle = new VentaDetalle();
		ventaDetalle = em.find(VentaDetalle.class, detalle.getId());
		if(ventaDetalle.getId().getVentaCodigo()>0) {
			em.merge(detalle);
			ventaDetalle = detalle;
		}
		
		return ventaDetalle;
	}

	@Override
	public void crearVentaDetalle(VentaDetalle detalle) throws Exception {
		if (detalle.getId().getProductoCodigo()>0 && detalle.getId().getProveedorCodigo()>0
				&& detalle.getId().getVentaCodigo()>0) {
			em.persist(detalle);
		}
		
	}

	@Override
	public boolean borrarVentaDetalle(VentaDetallePK id) throws Exception {
		boolean venta=false;
		if(id.getProductoCodigo()>0 && id.getProveedorCodigo()>0&& id.getVentaCodigo()>0) {
			em.remove(buscarPorID(id));
			venta= true;
		}
		
		return venta;
	}
	
	public VentaDetalle buscarPorID(VentaDetallePK id) throws Exception{
		VentaDetalle ve = new VentaDetalle();
		ve = em.find(VentaDetalle.class, id);
		return ve;
	}
	
	@Override
	public List<VentaDetalle> buscarVentadetalle(int ventaId, int productoId, int proveedorId,int cantidad,int  descuento) throws Exception {
		List<VentaDetalle> ventaDetalle = new ArrayList<VentaDetalle>();
		Query query = em.createNamedQuery(VentaDetalle.EncontrarPorCodigos);
		if (ventaId >0 && productoId >0 && proveedorId>0) {
			query.setParameter("CANTIDAD", cantidad);
			query.setParameter("DESCUENTO", descuento);
			ventaDetalle =query.getResultList();
		}
		return ventaDetalle;
	}

	
	//------------------------CRUD DE CLIENTE--------------------------------

	@Override
	public Cliente actualizarCliente(Cliente cliente) throws Exception {
		Cliente cli = new Cliente();
		cli = buscarClientePorId(cliente.getCodigo());
		if (cli.getCodigo() > 0) {
			em.merge(cliente);
		} else
			cli = null;

		return cli;
	}
	private Cliente buscarClientePorId(int codigo) throws Exception {
		Cliente p = new Cliente();
		p = em.find(Cliente.class, codigo);
		return p;
	}

	@Override
	public void crearCliente(Cliente cliente) throws Exception {
		if ( cliente.getNombre() != null && !cliente.getNombre().equals("")) {
			em.persist(cliente);
		}
		
	}

	@Override
	public boolean borrarCliente(int codigo) throws Exception {
		Cliente cliente = buscarClientePorId(codigo);
		boolean retorno = false;
		if (cliente.getCodigo() > 0) {
			em.remove(cliente);
			retorno = true;
		}

		return retorno;
	}

	@Override
	public List<Cliente> traerCliente() throws Exception {
		List<Cliente> c = new ArrayList<Cliente>();

		Query query = em.createNamedQuery(Cliente.FILL_ALL);

		c = query.getResultList();

		return c;
	}
	//------------------------CRUD DE VENTA--------------------------------
	@Override
	public Venta actualizarVenta(Venta venta) throws Exception {
		Venta v = new Venta();
		v = buscarVentaPorId(venta.getCodigo());
		if (v.getCodigo() > 0) {
			em.merge(venta);
		} else
			v = null;

		return v;
	}

	@Override
	public void crearVenta(Venta venta) throws Exception {
		if (venta.getCodigo()>0 ) {
			em.persist(venta);
		}
		
	}
	private Venta buscarVentaPorId(int codigo) throws Exception {
		Venta p = new Venta();
		p = em.find(Venta.class, codigo);
		return p;
	}
	@Override
	public boolean borrarVenta(int codigo) throws Exception {
		Venta venta = buscarVentaPorId(codigo);
		boolean retorno = false;
		if (venta.getCodigo() > 0) {
			em.remove(venta);
			retorno = true;
		}

		return retorno;
	}

	@Override
	public List<Venta> traerVenta() throws Exception {
		List<Venta> c = new ArrayList<Venta>();

		Query query = em.createNamedQuery(Venta.FILL_ALL);

		c = query.getResultList();

		return c;
	}
	//------------------------CRUD DE PRODUCTO--------------------------------

	@Override
	public Producto actualizarProducto(Producto producto) throws Exception {
		Producto p = new Producto();
		p = buscarProductoPorId(producto.getCodigo());
		if (p.getCodigo() > 0) {
			em.merge(producto);
		} else
			p = null;

		return p;
	}

	@Override
	public void crearProducto(Producto producto) throws Exception {
		if ( producto.getNombre() != null && !producto.getNombre().equals("")) {
			em.persist(producto);
		}
		
	}
	private Producto buscarProductoPorId(int codigo) throws Exception {
		Producto p = new Producto();
		p = em.find(Producto.class, codigo);
		return p;}

	@Override
	public boolean borrarProducto(int codigo) throws Exception {
		Producto venta = buscarProductoPorId(codigo);
		boolean retorno = false;
		if (venta.getCodigo() > 0) {
			em.remove(venta);
			retorno = true;
		}
		return retorno;
	}

	@Override
	public List<Producto> traerProducto() throws Exception {
		List<Producto> c = new ArrayList<Producto>();

		Query query = em.createNamedQuery(Producto.FILL_ALL);

		c = query.getResultList();

		return c;
	}
	//------------------------CRUD DE PROOVEDOR--------------------------------
	@Override
	public Proveedor actualizarProveedor(Proveedor proveedor) throws Exception {
		Proveedor producto = new Proveedor();
		producto = buscarProveedorPorId(proveedor.getCodigo());
		if (producto.getCodigo() > 0) {
			em.merge(proveedor);
		} else
			producto = null;

		return producto;
	}

	public void crearProveedor(Proveedor proveedor) throws Exception {
		int restrictDayofMonth = 5;
		LocalDate date = LocalDate.now();
		
		if (proveedor.getCodigo() > 0) {
			if (date.getDayOfMonth() > restrictDayofMonth) {
				System.out.println("Solo puede registrar proveedores los primeros cinco dias del mes");
			} else {
				em.persist(proveedor);
			}
		}

	}
		
	
	private Proveedor buscarProveedorPorId(int codigo) throws Exception {
		Proveedor p = new Proveedor();
		p = em.find(Proveedor.class, codigo);
		return p;}
	@Override
	public boolean borrarProveedor(int codigo) throws Exception {
		Proveedor p = buscarProveedorPorId(codigo);
		boolean retorno = false;
		if (p.getCodigo() > 0) {
			em.remove(p);
			retorno = true;
		}
		return retorno;
	}

	@Override
	public List<Proveedor> traerProveedor() throws Exception {
		List<Proveedor> c = new ArrayList<Proveedor>();

		Query query = em.createNamedQuery(Proveedor.FILL_ALL);

		c = query.getResultList();

		return c;
	}
	//------------------------CRUD DE PROVEEDORPRODUCTO--------------------------------
	@Override
	public ProveedorProducto actualizarProveedorProducto(ProveedorProducto detalle) throws Exception {
		ProveedorProducto pp = new ProveedorProducto();
		pp = em.find(ProveedorProducto.class, detalle.getId());
		if(pp.getId().getProductoCodigo()>0 && pp.getId().getProveedorCodigo()>0) {
			em.merge(detalle);
			pp = detalle;
		}
		
		return pp;
	}

	@Override
	public void crearProveedorProducto(ProveedorProducto pp) throws Exception {
		if (pp.getId().getProductoCodigo()>0 && pp.getId().getProveedorCodigo()>0
			) {
			em.persist(pp);
		}
		
	}
	
	public ProveedorProducto buscarPPPorID(ProveedorProductoPK id) throws Exception{
		ProveedorProducto ve = new ProveedorProducto();
		ve = em.find(ProveedorProducto.class, id);
		return ve;
	}

	@Override
	public boolean borrarProveedorProducto(ProveedorProductoPK id) throws Exception {
		boolean venta=false;
		if(id.getProductoCodigo()>0 && id.getProveedorCodigo()>0) {
			em.remove(buscarPPPorID(id));
			venta= true;
		}
		
		return venta;
	}

	@Override
	public List<ProveedorProducto> traerProveedorProducto() throws Exception {
		List<ProveedorProducto> c = new ArrayList<ProveedorProducto>();

		Query query = em.createNamedQuery(ProveedorProducto.FILL_ALL);

		c = query.getResultList();

		return c;
	}
	
	

}
