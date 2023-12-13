package co.edu.unbosque.model;

import java.util.List;

import javax.faces.bean.ManagedBean;

import co.edu.unbosque.dao.ClienteDAO;
import co.edu.unbosque.dao.ProveedorDAO;
import co.edu.unbosque.dto.ClienteDTO;
import co.edu.unbosque.dto.ProveedorDTO;
@ManagedBean
public class ProveedorBean {

	public String nit;
	public String nombreproveedor;
	public String direccion;
	public String telefono;
	public String ciudad;
	private String resultado;
	private List<ProveedorDTO> listaProveedores;
	private ProveedorDAO proveedor;

	public String agregar() {
		proveedor = new ProveedorDAO();

		this.resultado = proveedor.agregar(new ProveedorDTO(this.nit, this.nombreproveedor, this.direccion, this.telefono, this.ciudad));
		this.listaProveedores = (List<ProveedorDTO>) proveedor.consultar();

		if (this.resultado.equals("OK") && this.listaProveedores != null) {
			return "tablaProveedores.xhtml";
		} else {
			return "error.xhtml";
		}
	}

	public Object consultar() {
		proveedor = new ProveedorDAO();

		this.listaProveedores = (List<ProveedorDTO>) proveedor.consultar();

		if (this.listaProveedores != null) {
			return "tablaProveedores.xhtml";
		} else {
			return "error.xhtml";
		}
	}
	public String borrar() {
		proveedor = new ProveedorDAO();
		this.resultado = proveedor.borrar(this.nit);

		if (this.resultado.equals("OK")) {
			this.listaProveedores = (List<ProveedorDTO>) proveedor.consultar();
			return "tablaProveedores.xhtml";
		} else {
			return "error.xhtml";
		}
	}

	public Object listar() {
		// TODO Auto-generated method stub
		return null;
	}
	public String actualizar() {
		ProveedorDAO proveedorDAO = new ProveedorDAO();
		ProveedorDTO newProveedor = new ProveedorDTO();
		newProveedor.setNit(this.nit);
		newProveedor.setNombreproveedor(this.nombreproveedor);
		newProveedor.setDireccion(this.direccion);
		newProveedor.setTelefono(this.telefono);
		newProveedor.setCiudad(this.ciudad);
		this.resultado = proveedorDAO.actualizar(this.nit, newProveedor);

		if (this.resultado.equals("OK")) {
			this.listaProveedores = (List<ProveedorDTO>) proveedorDAO.consultar();

			return "tablaProveedores.xhtml";
		} else {
			return "error.xhtml";
		}

	}

	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombreproveedor() {
		return nombreproveedor;
	}

	public void setNombreproveedor(String nombreproveedor) {
		this.nombreproveedor = nombreproveedor;
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public List<ProveedorDTO> getListaProveedores() {
		return listaProveedores;
	}

	public void setListaProveedores(List<ProveedorDTO> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}

	public ProveedorDAO getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorDAO proveedor) {
		this.proveedor = proveedor;
	}
}
