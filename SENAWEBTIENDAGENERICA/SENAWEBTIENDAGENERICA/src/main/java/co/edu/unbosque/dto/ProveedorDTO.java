package co.edu.unbosque.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedores")
public class ProveedorDTO {
	@Id
	@Column(name = "nit")
	private String nit;

	@Column(name = "nombreproveedor")
	private String nombreproveedor;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "ciudad")
	private String ciudad;

	public ProveedorDTO() {

	}

	public ProveedorDTO(String nit, String nombreproveedor, String direccion, String telefono, String ciudad) {
		super();
		this.nit = nit;
		this.nombreproveedor = nombreproveedor;
		this.direccion = direccion;
		this.telefono = telefono;
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "ProveedorDTO [nit=" + nit + ", nombreproveedor=" + nombreproveedor + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", ciudad=" + ciudad + "]";
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

}
