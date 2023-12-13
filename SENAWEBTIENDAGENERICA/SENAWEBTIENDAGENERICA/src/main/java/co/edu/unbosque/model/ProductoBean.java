package co.edu.unbosque.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import co.edu.unbosque.dao.ClienteDAO;
import co.edu.unbosque.dao.DetalleVentasDAO;
import co.edu.unbosque.dao.ProductosDAO;
import co.edu.unbosque.dao.VentaDAO;
import co.edu.unbosque.dto.ClienteDTO;
import co.edu.unbosque.dto.DetalleVentasDTO;
import co.edu.unbosque.dto.ProductoDTO;
import co.edu.unbosque.dto.TiendaDTO;
import co.edu.unbosque.dto.VentasCuotasDTO;
import co.edu.unbosque.dto.VentasDTO;

@ManagedBean
@RequestScoped
public class ProductoBean {

	private int codigoproducto;
	private String nombreproducto;
	private boolean mostrarPanelUsuario;
	private String nitproveedor;
	private float preciocompra;

	private float precioventa;

	private String resultado;
	private List<ProductoDTO> listaProductos;

	private float cantidad;

	private float subtotalProducto; // subtotal
	private float totalProducto; // subtotal
	private TiendaBean tiendaBean = new TiendaBean();

	private ProductosDAO producto;
	private List<ProductoDTO> productosAgregados = new ArrayList<>();

	private float totalProductos;

	private int codigoVenta; // Nuevo atributo para almacenar el código de venta consecutivo
	private List<DetalleVentasDTO> detallesVenta = new ArrayList<>(); // Lista para almacenar los detalles de venta
	private List<VentasCuotasDTO> listaCuotas = new ArrayList<>();
	//////////A
	private boolean pagoCuotas;
	private float tasaInteresNominal;
	private int plazoMeses;

	public ProductoBean() {
		mostrarPanelUsuario = false;
	}

	public void buscarProductoPorCodigo() {
		ProductosDAO producto = new ProductosDAO();
		ProductoDTO productoEncontrado = producto.buscarPorCodigo(this.codigoproducto);

		if (productoEncontrado != null) {
			nombreproducto = productoEncontrado.getNombreproducto();
			subtotalProducto = this.cantidad * productoEncontrado.getPrecioventa();
			totalProducto = subtotalProducto + (subtotalProducto * 19 / 100);
			System.out.println("iva" + 0.19);
			totalProductos += subtotalProducto;

			productosAgregados.add(productoEncontrado);
		} else {
			nombreproducto = "PRODUCTO NO ENCONTRADO";
			//subtotalProducto = 0;
		}
	}

	public void agregarProducto() {
		ProductosDAO productoDAO = new ProductosDAO();
		ProductoDTO productoEncontrado = productoDAO.buscarPorCodigo(this.codigoproducto);

		DetalleVentasDTO detalleVenta = new DetalleVentasDTO();

		if (productoEncontrado != null) {
			productosAgregados.add(productoEncontrado);
			float subtotalProducto = this.cantidad * productoEncontrado.getPrecioventa();

			//			detalleVenta.setCodigoproducto(getCodigoproducto());
			detalleVenta.setCodigoproducto(codigoproducto);
			detalleVenta.setCantidad(cantidad);
			detalleVenta.setValorunitario(subtotalProducto);
			detalleVenta.setValortotal(subtotalProducto);
			detallesVenta.add(detalleVenta);

			this.totalProductos += subtotalProducto;

		} else {
			totalProductos = 1;
		}
	}

	public float calcularTotalProductos() {
		return totalProductos;
	}

	public String registrarVenta() {
		VentasDTO venta = new VentasDTO();
		GestionVentasBean gestionVentasBean = new GestionVentasBean();

		venta.setCodigoventa((int) Math.random());
		venta.setCedulacliente(gestionVentasBean.getCedulaCliente());
		float subtotal = getSubtotalProducto();
		float total = getTotalProductos();
		venta.setTotalventa(total);
		venta.setValoriva(total * 19 / 100);
		venta.setTotalmasiva(total + (total * 19 / 100));

		DetalleVentasDTO detalleDTO = new DetalleVentasDTO();
		DetalleVentasDAO detallesVentasDAO = new DetalleVentasDAO();
		detalleDTO.setCodigodetalleventa((int) Math.random());
		detalleDTO.setCodigoventa(venta.getCodigoventa());
		detalleDTO.setCantidad(getCantidad());
		detalleDTO.setValorunitario(getSubtotalProducto());
		detalleDTO.setValortotal(getTotalProductos());
		this.resultado = detallesVentasDAO.agregar(new DetalleVentasDTO(codigoVenta, this.codigoproducto, codigoVenta, getCantidad(), getSubtotalProducto(), getTotalProductos()));

		this.detallesVenta = (List<DetalleVentasDTO>) detallesVentasDAO.consultar();

		if (this.resultado.equals("OK") && this.detallesVenta != null) {
			return "gestionDetalles.xhtml";
		} else {
			return "error.xhtml";
		}
	}

	//cuOTs
	public String registrarCuota() {
		VentasCuotasDTO venta = new VentasCuotasDTO();
		GestionVentasBean gestionVentasBean=new GestionVentasBean(); // Obtener la instancia mediante inyección de dependencias
		TiendaBean tiendaBean = new TiendaBean(); // Obtener la instancia mediante inyección de dependencias
		ClienteBean cliente= new ClienteBean(); // Obtener la instancia mediante inyección de dependencias

		// Lógica para configurar los valores de venta y detalle

		//CuotasDAO cuotasDAO = new CuotasDAO();
		int codigoventacuotas = (int) Math.random(); // Reemplazar con un valor real
		String cedulacliente = cliente.getCedula();
		int codigoventa = (int) Math.random(); // Reemplazar con un valor real
		float montoafinanciar = (float) Math.random(); // Reemplazar con un valor real
		float tasanominal = (float) Math.random(); // Reemplazar con un valor real
		float tasaefectiva = (float) Math.random(); // Reemplazar con un valor real
		float tanualidad = (float) Math.random(); // Reemplazar con un valor real
		float cuotapesos = (float) Math.random(); // Reemplazar con un valor real

		venta.setCedulacliente(cliente.getCedula());
		venta.setCodigoventa((int) Math.random()); // Reemplazar con un valor real
		venta.setCodigoventacuotas((int) Math.random()); // Reemplazar con un valor real
		venta.setCuotapesos((int) Math.random()); // Reemplazar con un valor real
		venta.setMontoafinanciar((int) Math.random()); // Reemplazar con un valor real
		venta.setTanualidad(19/100); // Reemplazar con un valor real
		venta.setTasaefectiva(19/100); // Reemplazar con un valor real
		venta.setTasanominal(19/100); // Reemplazar con un valor real


//		this.resultado = cuotasDAO.agregar(new VentasCuotasDTO(codigoventacuotas, cedulacliente, codigoventa,
//				montoafinanciar, tasanominal, tasaefectiva, tanualidad, cuotapesos));
//
//
//
//		this.listaCuotas = (List<VentasCuotasDTO>) cuotasDAO.consultar();

		if (this.resultado.equals("OK") && this.detallesVenta != null) {
			return "tablaCuotas.xhtml";
		} else {
			return "error.xhtml";
		}
	}

	////Crud

	public String agregar() {
		ProductosDAO productodao = new ProductosDAO();
		this.resultado = productodao.agregar(new ProductoDTO(this.codigoproducto,
				this.nombreproducto, this.nitproveedor,
				this.preciocompra,this.precioventa));
		this.listaProductos = (List<ProductoDTO>) productodao.consultar();

		if (this.resultado.equals("OK") && this.listaProductos != null) {
			return "tablaProductos.xhtml";
		} else {
			return "error.xhtml";
		}
	}

	public Object consultar() {
		ProductosDAO productodao = new ProductosDAO();
		this.listaProductos = (List<ProductoDTO>) productodao.consultar();

		if (this.listaProductos != null) {
			return "tablaProductos.xhtml";
		} else {
			return "error.xhtml";
		}
	}

	public String borrar() {
		ProductosDAO productodao = new ProductosDAO();
		this.resultado = productodao.borrar(this.nombreproducto);

		if (this.resultado.equals("OK")) {
			this.listaProductos = (List<ProductoDTO>) productodao.consultar();
			return "tablaProductos.xhtml";
		} else {
			return "error.xhtml";
		}
	}

	public Object listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public String actualizar() {
		ProductosDAO productoDAO = new ProductosDAO();
		ProductoDTO newProducto = new ProductoDTO();
		newProducto.setCodigoproducto(this.codigoproducto);
		newProducto.setNombreproducto(this.nombreproducto);
		newProducto.setNitproveedor(this.nitproveedor);
		newProducto.setPreciocompra(this.preciocompra);
		newProducto.setPrecioventa(this.precioventa);
		this.resultado = productoDAO.actualizar(this.codigoproducto, newProducto);

		if (this.resultado.equals("OK")) {
			this.listaProductos = (List<ProductoDTO>) productoDAO.consultar();
			return "tablaProductos.xhtml";
		} else {
			return "error.xhtml";
		}
	}

	////////////cuotas

	public int getCodigoproducto() {
		return codigoproducto;
	}

	public void setCodigoproducto(int codigoproducto) {
		this.codigoproducto = codigoproducto;
	}

	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	public boolean isMostrarPanelUsuario() {
		return mostrarPanelUsuario;
	}

	public void setMostrarPanelUsuario(boolean mostrarPanelUsuario) {
		this.mostrarPanelUsuario = mostrarPanelUsuario;
	}

	public String getNitproveedor() {
		return nitproveedor;
	}

	public void setNitproveedor(String nitproveedor) {
		this.nitproveedor = nitproveedor;
	}

	public float getPreciocompra() {
		return preciocompra;
	}

	public void setPreciocompra(float preciocompra) {
		this.preciocompra = preciocompra;
	}

	public float getPrecioventa() {
		return precioventa;
	}

	public void setPrecioventa(float precioventa) {
		this.precioventa = precioventa;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public List<ProductoDTO> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<ProductoDTO> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public float getSubtotalProducto() {
		return subtotalProducto;
	}

	public void setSubtotalProducto(float subtotalProducto) {
		this.subtotalProducto = subtotalProducto;
	}

	public float getTotalProducto() {
		return totalProducto;
	}

	public void setTotalProducto(float totalProducto) {
		this.totalProducto = totalProducto;
	}

	public TiendaBean getTiendaBean() {
		return tiendaBean;
	}

	public void setTiendaBean(TiendaBean tiendaBean) {
		this.tiendaBean = tiendaBean;
	}

	public ProductosDAO getProducto() {
		return producto;
	}

	public void setProducto(ProductosDAO producto) {
		this.producto = producto;
	}

	public List<ProductoDTO> getProductosAgregados() {
		return productosAgregados;
	}

	public void setProductosAgregados(List<ProductoDTO> productosAgregados) {
		this.productosAgregados = productosAgregados;
	}

	public float getTotalProductos() {
		return totalProductos;
	}

	public void setTotalProductos(float totalProductos) {
		this.totalProductos = totalProductos;
	}

	public int getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public List<DetalleVentasDTO> getDetallesVenta() {
		return detallesVenta;
	}

	public void setDetallesVenta(List<DetalleVentasDTO> detallesVenta) {
		this.detallesVenta = detallesVenta;
	}

	public boolean isPagoCuotas() {
		return pagoCuotas;
	}

	public void setPagoCuotas(boolean pagoCuotas) {
		this.pagoCuotas = pagoCuotas;
	}

	public float getTasaInteresNominal() {
		return tasaInteresNominal;
	}

	public void setTasaInteresNominal(float tasaInteresNominal) {
		this.tasaInteresNominal = tasaInteresNominal;
	}

	public int getPlazoMeses() {
		return plazoMeses;
	}

	public void setPlazoMeses(int plazoMeses) {
		this.plazoMeses = plazoMeses;
	}

	public List<VentasCuotasDTO> getListaCuotas() {
		return listaCuotas;
	}

	public void setListaCuotas(List<VentasCuotasDTO> listaCuotas) {
		this.listaCuotas = listaCuotas;
	}



}