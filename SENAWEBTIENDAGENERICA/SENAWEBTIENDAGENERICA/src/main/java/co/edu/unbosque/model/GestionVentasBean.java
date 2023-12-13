package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class GestionVentasBean {
	private boolean mostrarDialogo;
	private String cedulaCliente;


	public void metodoMostrarDialogo() {
		mostrarDialogo = true;
	}
	public void ocultarDialogo() {
		mostrarDialogo = false;
	}


	public boolean isMostrarDialogo() {
		return mostrarDialogo;
	}

	public void setMostrarDialogo(boolean mostrarDialogo) {
		this.mostrarDialogo = mostrarDialogo;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
}
