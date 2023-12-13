package co.edu.unbosque.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "productos") 
public class ProductoDTO {
	@Id
	@Column(name = "codigoproducto")
	private int codigoproducto;

	@Column(name="nombreproducto")
	private String nombreproducto;

	@Column(name="nitproveedor")
	private String nitproveedor;

	@Column(name="preciocompra")
	private float preciocompra;

	@Column(name="precioventa")
	private float precioventa;

	public ProductoDTO(int codigoproducto, String nombreproducto, String nitproveedor, float preciocompra,
			float precioventa) {
		super();
		this.codigoproducto = codigoproducto;
		this.nombreproducto = nombreproducto;
		this.nitproveedor = nitproveedor;
		this.preciocompra = preciocompra;
		this.precioventa = precioventa;
	}

	public ProductoDTO() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "ProductoDTO [codigoproducto=" + codigoproducto + ", nombreproducto=" + nombreproducto
				+ ", nitproveedor=" + nitproveedor + ", preciocompra=" + preciocompra + ", precioventa=" + precioventa
				+ "]";
	}

	public int getCodigoproducto() {
		return codigoproducto;
	}


	public void setCodigoproducto(int codigoproducto) {
		this.codigoproducto = codigoproducto;
	}


	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	public String getNitproveedor() {
		return nitproveedor;
	}

	public void setNitproveedor(String nitproveedor) {
		this.nitproveedor = nitproveedor;
	}

	public float getPreciocompra() {
		return preciocompra;
	}

	public void setPreciocompra(float preciocompra) {
		this.preciocompra = preciocompra;
	}

	public float getPrecioventa() {
		return precioventa;
	}

	public void setPrecioventa(float precioventa) {
		this.precioventa = precioventa;
	}



}
