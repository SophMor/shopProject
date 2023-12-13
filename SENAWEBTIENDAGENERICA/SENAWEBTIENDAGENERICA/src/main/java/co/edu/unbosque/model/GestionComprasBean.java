package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class GestionComprasBean {
	private boolean mostrarDialogo;
	private String nitProveedor;
	
	
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

	public String getNitProveedor() {
		return nitProveedor;
	}

	public void setNitProveedor(String nitProveedor) {
		this.nitProveedor = nitProveedor;
	}
	
}
