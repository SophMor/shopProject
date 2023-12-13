package co.edu.unbosque.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detallecompras")
public class DetalleComprasDTO {
	@Id
	@Column(name = "codigodetallecompra")
	private int 	codigodetallecompra;
	@Column(name = "codigoproducto")
	private String	codigoproducto;	
	@Column(name = "codigocompra")
	private int	codigocompra;	
	@Column(name = "cantidad")
	private float	cantidad;
	@Column(name = "valorunitario")
	private float valorunitario;
	@Column(name = "valortotal")
	private float valortotal;
	public DetalleComprasDTO() {
		// TODO Auto-generated constructor stub
	}


	public DetalleComprasDTO(int codigodetallecompra, String codigoproducto, int codigocompra, float cantidad,
			float valorunitario, float valortotal) {
		super();
		this.codigodetallecompra = codigodetallecompra;
		this.codigoproducto = codigoproducto;
		this.codigocompra = codigocompra;
		this.cantidad = cantidad;
		this.valorunitario = valorunitario;
		this.valortotal = valortotal;
	}


	public int getCodigodetallecompra() {
		return codigodetallecompra;
	}


	public void setCodigodetallecompra(int codigodetallecompra) {
		this.codigodetallecompra = codigodetallecompra;
	}


	public String getCodigoproducto() {
		return codigoproducto;
	}


	public void setCodigoproducto(String codigoproducto) {
		this.codigoproducto = codigoproducto;
	}


	public int getCodigocompra() {
		return codigocompra;
	}


	public void setCodigocompra(int codigocompra) {
		this.codigocompra = codigocompra;
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
