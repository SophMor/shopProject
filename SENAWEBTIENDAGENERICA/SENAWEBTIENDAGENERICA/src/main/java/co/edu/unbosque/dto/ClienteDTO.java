package co.edu.unbosque.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class ClienteDTO {
	@Id
	@Column(name = "cedula")
	private String cedula;

	@Column(name = "nombrecompleto")
	private String nombrecompleto;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "coreoelectronico")
	private String coreoelectronnico;

	public ClienteDTO() {
		// TODO Auto-generated constructor stub
	}

	public ClienteDTO(String cedula, String nombrecompleto, String direccion, String telefono,
			String coreoelectronnico) {
		super();
		this.cedula = cedula;
		this.nombrecompleto = nombrecompleto;
		this.direccion = direccion;
		this.telefono = telefono;
		this.coreoelectronnico = coreoelectronnico;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Clientes [cedula=" + cedula + ", nombre=" + nombrecompleto + ", direccion=" + direccion + ", telefono="
				+ telefono + ", correo electronico =" + coreoelectronnico + "]";
	}

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

}
