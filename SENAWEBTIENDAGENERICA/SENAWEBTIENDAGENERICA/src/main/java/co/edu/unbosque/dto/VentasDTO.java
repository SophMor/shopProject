package co.edu.unbosque.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ventas")
public class VentasDTO {
	@Id
	@Column(name = "codigoventa")
	private int codigoventa;
	@Column(name = "cedulacliente")
	private String cedulacliente;
	@Column(name = "totalventa")
	private float totalventa;
	@Column(name = "valoriva")
	private float valoriva;
	@Column(name = "totalmasiva")
	private float totalmasiva;

	// Columna que establece la relación entre VentasDTO y DetalleVentasDTO


	public VentasDTO() {
		// TODO Auto-generated constructor stub
	}


	public VentasDTO(int codigoventa, String cedulacliente, float totalventa, float valoriva, int totalmasiva) {
		super();
		this.codigoventa = codigoventa;
		this.cedulacliente = cedulacliente;
		this.totalventa = totalventa;
		this.valoriva = valoriva;
		this.totalmasiva = totalmasiva;
	}


	public int getCodigoventa() {
		return codigoventa;
	}


	public void setCodigoventa(int codigoventa) {
		this.codigoventa = codigoventa;
	}


	public String getCedulacliente() {
		return cedulacliente;
	}

	public void setCedulacliente(String cedulacliente) {
		this.cedulacliente = cedulacliente;
	}

	public float getTotalventa() {
		return totalventa;
	}

	public void setTotalventa(float totalventa) {
		this.totalventa = totalventa;
	}

	public float getValoriva() {
		return valoriva;
	}

	public void setValoriva(float valoriva) {
		this.valoriva = valoriva;
	}


	public float getTotalmasiva() {
		return totalmasiva;
	}


	public void setTotalmasiva(float totalmasiva) {
		this.totalmasiva = totalmasiva;
	}




}
