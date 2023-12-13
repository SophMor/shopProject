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
@Table(name = "compras")
public class ComprasDTO {
	@Id
	@Column(name = "codigocompra")
	private int codigocompra;
	@Column(name = "nitproveedor")
	private String nitproveedor;
	@Column(name = "totalcompra")
	private float totalcompra;
	@Column(name = "valoriva")
	private float valoriva;
	@Column(name = "totalmasiva")
	private float totalmasiva;

	// Columna que establece la relación entre VentasDTO y DetalleVentasDTO


	public ComprasDTO() {
		// TODO Auto-generated constructor stub
	}

	public ComprasDTO(int codigoventa, String nitproveedor, float totalcompra, float valoriva, float totalmasiva) {
		super();
		this.codigocompra = codigoventa;
		this.nitproveedor = nitproveedor;
		this.totalcompra = totalcompra;
		this.valoriva = valoriva;
		this.totalmasiva = totalmasiva;
	}

	

	public int getCodigocompra() {
		return codigocompra;
	}

	public void setCodigocompra(int codigocompra) {
		this.codigocompra = codigocompra;
	}

	public String getNitproveedor() {
		return nitproveedor;
	}

	public void setNitproveedor(String nitproveedor) {
		this.nitproveedor = nitproveedor;
	}

	public float getTotalcompra() {
		return totalcompra;
	}

	public void setTotalcompra(float totalcompra) {
		this.totalcompra = totalcompra;
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