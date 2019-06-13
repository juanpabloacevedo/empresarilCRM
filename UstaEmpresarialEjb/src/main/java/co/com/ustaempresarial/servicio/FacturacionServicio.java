package co.com.ustaempresarial.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

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
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class FacturacionServicio {

	/**
	 * objeto de La fachada de facturacion,que llama los ejb creados para el modulo
	 * de facturacion
	 **/
	@EJB
	FacturacionFachada fachada;

	/**
	 * Busca la categoria del producto por nombre
	 **/
	public List<CategoriaProducto> buscarPorNombre(String nombre) throws Exception {
		return fachada.buscarCategoriaPorNombre(nombre);
	}

	/**
	 * Se edita una categoria de producto, llamando por parametro un objeto de tipo
	 * CategoriaProducto
	 **/
	public CategoriaProducto editarCategoriaProducto(CategoriaProducto categoriaProducto) throws Exception {
		return fachada.editarCategoriaProducto(categoriaProducto);
	}

	/**
	 * Se cambia de estado una categoria de producto, filtrandolo por el codigo del
	 * producto
	 **/
	public boolean borrarCategoriaProducto(int codigo) throws Exception {
		return fachada.borrarCategoriaProducto(codigo);
	}

	/**
	 * Se crea un array de tipo CategoriaProducto, que trae todos las categorias de
	 * productos de la base de datos
	 **/
	public List<CategoriaProducto> traerProductos() throws Exception {
		return fachada.traerProductos();
	}

	/**
	 * Se crea un objeto de tipo CagtegoriaProducto,que guardara los atributos de
	 * una categoria nueva y la persistira en base de datos
	 **/
	public void crearCagtegoriaProducto(CategoriaProducto producto) throws Exception {
		fachada.crearCagtegoriaProducto(producto);
	}

	// ------------------------CRUD DE VENTA-DETALLE -
	// PK--------------------------------
	/**
	 * Edita en la base de datos los atributos de la tupla Ventadetalle ingresada
	 **/
	public VentaDetalle actualizarVentaDetalle(VentaDetalle detalle) throws Exception {
		return fachada.actualizarVentaDetalle(detalle);
	}

	/**
	 * Crea una nueva venta
	 **/
	public void crearVentaDetalle(VentaDetalle detalle) throws Exception {
		fachada.crearVentaDetalle(detalle);
	}

	/**
	 * cambia el estado de la Ventadetalle a false sin borrarlo de la base de datos
	 **/
	public boolean borrarVentaDetalle(VentaDetallePK id) throws Exception {
		return fachada.borrarVentaDetalle(id);
	}

	/**
	 * Busca en la base de datos la tupla Ventadetalle ingresada, buscandola por id
	 **/
	public VentaDetalle buscarPorID(VentaDetallePK id) throws Exception {
		return fachada.buscarPorID(id);
	}

	// ------------------------CRUD DE CLIENTE--------------------------------
	/**
	 * Edita en la base de datos los atributos de la tupla Cliente ingresado
	 **/
	public Cliente actualizarCliente(Cliente cliente) throws Exception {
		return fachada.actualizarCliente(cliente);
	}

	/*
	 * Crea un nuevo objeto de tipo clinte para persistirlo en las base de datos
	 **/
	public void crearCliente(Cliente cliente) throws Exception {
		fachada.crearCliente(cliente);
	}

	/**
	 * cambia el esatdo de un clinte de activo a inactivo en la base de datos
	 **/
	public boolean borrarCliente(int codigo) throws Exception {
		return fachada.borrarCliente(codigo);
	}

	/*
	 * Busca un cliente o clientes espcificos
	 **/
	public List<Cliente> traerCliente() throws Exception {
		return fachada.traerCliente();
	}

	// ------------------------CRUD DE VENTA--------------------------------

	/**
	 *Edita los detalles de una venta especifica 
	 **/
	public Venta actualizarVenta(Venta venta) throws Exception {
		return fachada.actualizarVenta(venta);
	}
	/*
	 *Crea una objeto de tipo Venta para persistrilo en la base de datos
	 **/
	public void crearVenta(Venta venta) throws Exception {
		fachada.crearVenta(venta);
	}
	/**
	 *Cambia el estado de una vent de true a false, sin borrarla por integridad de los datos
	 **/
	public boolean borrarVenta(int codigo) throws Exception {
		return fachada.borrarVenta(codigo);
	}
	/*Lista todas las ventas/
	public List<Venta> traerVenta() throws Exception {
		return fachada.traerVenta();
	}
	// ------------------------CRUD DE PRODUCTO--------------------------------
	/**
	 *Edita los atributos del objeto producto ingresado y lo persiste en base de datos 
	 **/
	public Producto actualizarProducto(Producto producto) throws Exception {
		return fachada.actualizarProducto(producto);
	}
	/**
	 * Crea un objeto de tipo Producto y lo persiste en base de datos
	 */
		public void crearProducto(Producto producto) throws Exception {
		fachada.crearProducto(producto);
	}
	/**
	 * Cambia el estado de un producto a false
	 **/
	public boolean borrarProducto(int codigo) throws Exception {
		return fachada.borrarProducto(codigo);
	}
	/**
	 *Crea un array o lista  de los productos en base de datos
	 * */
	public List<Producto> traerProducto() throws Exception {
		return fachada.traerProducto();
	}
	// ------------------------CRUD DE PROVEEDOR--------------------------------
	/**
	 *Edita los atributos del objeto proveedor ingresado y lo persiste en base de datos 
	 **/
	public Proveedor actualizarProveedor(Proveedor proveedor) throws Exception {
		return fachada.actualizarProveedor(proveedor);
	}
	/**
	 * Crea un objeto de tipo proveedor y lo persiste en base de datos
	 */
	public void crearProveedor(Proveedor proveedor) throws Exception {
		fachada.crearProveedor(proveedor);

	}
	/**
	 * Cambia el estado de un Proveedor a false
	 **/
	public boolean borrarProveedor(int codigo) throws Exception {
		return fachada.borrarProveedor(codigo);
	}
	/**
	 *Crea un array o lista  de los Proveedores en base de datos
	 **/
	public List<Proveedor> traerProveedor() throws Exception {
		return fachada.traerProveedor();
	}
	// ------------------------CRUD DE PROVEEDOR-PRODUCTO PK--------------------------------
	/**
	 *Edita los atributos del objeto ProvedorProducto ingresado y lo persiste en base de datos 
	 **/
	public ProveedorProducto actualizarProveedorProducto(ProveedorProducto detalle) throws Exception {
		return fachada.actualizarProveedorProducto(detalle);
	}
	/**
	 * Crea un objeto de tipo ProvedorProducto y lo persiste en base de datos
	 */
	public void crearProveedorProducto(ProveedorProducto detalle) throws Exception {
		fachada.crearProveedorProducto(detalle);
	}
	/**
	 * Cambia el estado de un Proveedor a false,filtrandolo por la id 
	 **/
	public boolean borrarProveedorProducto(ProveedorProductoPK id) throws Exception {
		return fachada.borrarProveedorProducto(id);
	}
	/**
	 *Crea un array o lista  de los Proveedores en base de datos
	 * */
	public List<ProveedorProducto> traerProveedorProducto() throws Exception {
		return fachada.traerProveedorProducto();
	}

}