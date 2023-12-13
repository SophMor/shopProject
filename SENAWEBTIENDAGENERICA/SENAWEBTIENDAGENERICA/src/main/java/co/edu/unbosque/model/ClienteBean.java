package co.edu.unbosque.model;
import java.util.List;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import co.edu.unbosque.dao.ClienteDAO;
import co.edu.unbosque.dto.ClienteDTO;

@ManagedBean
public class ClienteBean {

	private String cedula;
	private String nombrecompleto;
	private String direccion;
	private String telefono;
	private String coreoelectronnico;
	private String resultado;
	private List<ClienteDTO> listaClientes;
	private ClienteDAO cliente;

	@ManagedProperty(value="#{gestionVentasBean}")
	private GestionVentasBean gestionVentasBean;

	public GestionVentasBean getGestionVentasBean() {
		return gestionVentasBean;
	}

	public void setGestionVentasBean(GestionVentasBean gestionVentasBean) {
		this.gestionVentasBean = gestionVentasBean;
	}

	public void buscarClientePorCedula() {
		cliente = new ClienteDAO();
		ClienteDTO clienteEncontrado = cliente.buscarPorCedula(this.cedula);

		if (clienteEncontrado != null) {
			nombrecompleto = clienteEncontrado.getNombrecompleto();

			setCedula(clienteEncontrado.getCedula());

			// Almacenar el nombre del cliente en FlashScoped
			FacesContext facesContext = FacesContext.getCurrentInstance();
			Flash flash = facesContext.getExternalContext().getFlash();
			flash.put("nombreCliente", nombrecompleto);

			gestionVentasBean.setMostrarDialogo(true); // Mostrar el panel con los datos del cliente

			// Redirigir a gestionVentas2.xhtml
			FacesContext context = FacesContext.getCurrentInstance();
			NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
			navigationHandler.handleNavigation(context, null, "gestionVentas2.xhtml?faces-redirect=true");
		} else {
			nombrecompleto = "Cliente no encontrado";
			gestionVentasBean.setMostrarDialogo(false); // Ocultar el panel si no se encuentra el cliente
		}
	}

	public String agregar() {
		cliente = new ClienteDAO();

		this.resultado = cliente.agregar(new ClienteDTO(this.cedula, this.nombrecompleto, this.direccion, this.telefono,
				this.coreoelectronnico));
		this.listaClientes = (List<ClienteDTO>) cliente.consultar();

		if (this.resultado.equals("OK") && this.listaClientes != null) {
			return "tablaClientes.xhtml";
		} else {
			return "error.xhtml";
		}
	}

	public Object consultar() {
		cliente = new ClienteDAO();

		this.listaClientes = (List<ClienteDTO>) cliente.consultar();

		if (this.listaClientes != null) {
			return "tablaClientes.xhtml";
		} else {
			return "error.xhtml";
		}
	}

	public String borrar() {
		cliente = new ClienteDAO();
		this.resultado = cliente.borrar(this.cedula);

		if (this.resultado.equals("OK")) {
			this.listaClientes = (List<ClienteDTO>) cliente.consultar();
			return "tablaClientes.xhtml";
		} else {
			return "error.xhtml";
		}
	}

	public Object listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public String actualizar() {
		ClienteDAO cliente = new ClienteDAO();
		ClienteDTO newCliente = new ClienteDTO();
		newCliente.setCedula(this.cedula);
		newCliente.setNombrecompleto(this.nombrecompleto);
		newCliente.setDireccion(this.direccion);
		newCliente.setCoreoelectronnico(this.getCoreoelectronnico());
		newCliente.setTelefono(this.getTelefono());

		this.resultado = cliente.actualizar(this.cedula, newCliente);

		if (this.resultado.equals("OK")) {
			this.listaClientes = (List<ClienteDTO>) cliente.consultar();

			return "tablaClientes.xhtml";
		} else {
			return "error.xhtml";
		}

	}


	//
	//	public void aceptar() {
	//		// Almacenar la cédula del cliente en el FlashScoped
	//		FacesContext facesContext = FacesContext.getCurrentInstance();
	//		Flash flash = facesContext.getExternalContext().getFlash();
	//		flash.put("cedulaCliente", cedula); // Aquí debes obtener la cédula del cliente
	//
	//		// Redirigir a gestionVentasPago.xhtml
	//		FacesContext context = FacesContext.getCurrentInstance();
	//		NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
	//		navigationHandler.handleNavigation(context, null, "gestionVentasPago.xhtml?faces-redirect=true");
	//	}
	//	public void aceptar() {
	//		FacesContext facesContext = FacesContext.getCurrentInstance();
	//		ExternalContext externalContext = facesContext.getExternalContext();
	//		Flash flash = externalContext.getFlash();
	//		flash.put("cedulaCliente", this.cedula);
	//
	//
	//		try {
	//			externalContext.redirect("gestionVentasPago.xhtml");
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
	//	}


	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCoreoelectronnico() {
		return coreoelectronnico;
	}

	public void setCoreoelectronnico(String coreoelectronnico) {
		this.coreoelectronnico = coreoelectronnico;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public List<ClienteDTO> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<ClienteDTO> listaClientes) {
		this.listaClientes = listaClientes;
	}
}
