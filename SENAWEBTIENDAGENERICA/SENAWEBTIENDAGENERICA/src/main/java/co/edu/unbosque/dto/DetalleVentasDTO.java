package co.edu.unbosque.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalleventas")
public class DetalleVentasDTO {
	@Id
	@Column(name = "codigodetalleventa")
	private int 	codigodetalleventa;
	@Column(name = "codigoproducto")
	private int	codigoproducto;	
	@Column(name = "codigoventa")
	private int	codigoventa;	
	@Column(name = "cantidad")
	private float	cantidad;
	@Column(name = "valorunitario")
	private float valorunitario;
	@Column(name = "valortotal")
	private float valortotal;
	public DetalleVentasDTO() {
		// TODO Auto-generated constructor stub
	}
	public DetalleVentasDTO(int codigodetalleventa, int codigoproducto, int codigoventa, float cantidad,
			float valorunitario, float valortotal) {
		super();
		this.codigodetalleventa = codigodetalleventa;
		this.codigoproducto = codigoproducto;
		this.codigoventa = codigoventa;
		this.cantidad = cantidad;
		this.valorunitario = valorunitario;
		this.valortotal = valortotal;
	}
	public int getCodigodetalleventa() {
		return codigodetalleventa;
	}
	public void setCodigodetalleventa(int codigodetalleventa) {
		this.codigodetalleventa = codigodetalleventa;
	}
	public int getCodigoproducto() {
		return codigoproducto;
	}
	public void setCodigoproducto(int codigoproducto) {
		this.codigoproducto = codigoproducto;
	}
	public int getCodigoventa() {
		return codigoventa;
	}
	public void setCodigoventa(int codigoventa) {
		this.codigoventa = codigoventa;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public float getValorunitario() {
		return valorunitario;
	}
	public void setValorunitario(float valorunitario) {
		this.valorunitario = valorunitario;
	}
	public float getValortotal() {
		return valortotal;
	}
	public void setValortotal(float valortotal) {
		this.valortotal = valortotal;
	}

	

}
