package co.edu.unbosque.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ventasporcuotas")
public class VentasCuotasDTO {
	@Id
	@Column(name = "codigoventacuotas")
	private	int		codigoventacuotas	;
	@Column(name = "cedulacliente")
	private	String cedulacliente;
	@Column(name = "codigoventa")
	private	int	codigoventa	;
	@Column(name = "montoafinanciar")
	private	float	montoafinanciar	;
	@Column(name = "tasanominal")
	private	float	tasanominal	;
	@Column(name = "tasaefectiva")
	private	float tasaefectiva;
	@Column(name = "tanualidad")

	private	float tanualidad;	
	@Column(name = "cuotapesos")
	private	float cuotapesos;
	public VentasCuotasDTO() {
		// TODO Auto-generated constructor stub
	}
	public VentasCuotasDTO(int codigoventacuotas, String cedulacliente, int codigoventa, float montoafinanciar,
			float tasanominal, float tasaefectiva, float tanualidad, float cuotapesos) {
		super();
		this.codigoventacuotas = codigoventacuotas;
		this.cedulacliente = cedulacliente;
		this.codigoventa = codigoventa;
		this.montoafinanciar = montoafinanciar;
		this.tasanominal = tasanominal;
		this.tasaefectiva = tasaefectiva;
		this.tanualidad = tanualidad;
		this.cuotapesos = cuotapesos;
	}
	public int getCodigoventacuotas() {
		return codigoventacuotas;
	}
	public void setCodigoventacuotas(int codigoventacuotas) {
		this.codigoventacuotas = (int) Math.random();
	}
	public String getCedulacliente() {
		return cedulacliente;
	}
	public void setCedulacliente(String cedulacliente) {
		this.cedulacliente = cedulacliente;
	}
	public int getCodigoventa() {
		return codigoventa;
	}
	public void setCodigoventa(int codigoventa) {
		this.codigoventa = (int) Math.random();
	}
	public float getMontoafinanciar() {
		return montoafinanciar;
	}
	public void setMontoafinanciar(float montoafinanciar) {
		this.montoafinanciar = montoafinanciar;
	}
	public float getTasanominal() {
		return tasanominal;
	}
	public void setTasanominal(float tasanominal) {
		this.tasanominal = tasanominal;
	}
	public float getTasaefectiva() {
		return tasaefectiva;
	}
	public void setTasaefectiva(float tasaefectiva) {
		this.tasaefectiva = tasaefectiva;
	}
	public float getTanualidad() {
		return tanualidad;
	}
	public void setTanualidad(float tanualidad) {
		this.tanualidad = tanualidad;
	}
	public float getCuotapesos() {
		return cuotapesos;
	}
	public void setCuotapesos(float cuotapesos) {
		this.cuotapesos = cuotapesos;
	}

}
