package co.edu.unbosque.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parametros")
public class TiendaDTO {
	@Id
	@Column(name = "nit")

	private String nit;
	@Column(name = "tipocomercio")	
	private String tipocomercio;
	@Column(name = "nombretienda")
	private String nombretienda;
	@Column(name = "ciudadtienda")
	private String ciudadtienda;
	@Column(name = "valoriva")
	private float valoriva;
	@Column(name = "tasainteres")
	private float tasainteres;
	@Column(name = "banco")
	private String banco;
	@Column(name = "cuentacorriente")
	private String cuentacorriente;
	@Column(name = "nombregerente	")
	private String nombregerente;
	public TiendaDTO() {

	}
	public TiendaDTO(String nit, String tipocomercio, String nombretienda, String ciudadtienda, float valoriva,
			float tasainteres, String banco, String cuentacorriente, String nombregerente) {
		super();
		this.nit = nit;
		this.tipocomercio = tipocomercio;
		this.nombretienda = nombretienda;
		this.ciudadtienda = ciudadtienda;
		this.valoriva = valoriva;
		this.tasainteres = tasainteres;
		this.banco = banco;
		this.cuentacorriente = cuentacorriente;
		this.nombregerente = nombregerente;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getTipocomercio() {
		return tipocomercio;
	}
	public void setTipocomercio(String tipocomercio) {
		this.tipocomercio = tipocomercio;
	}
	public String getNombretienda() {
		return nombretienda;
	}
	public void setNombretienda(String nombretienda) {
		this.nombretienda = nombretienda;
	}
	public String getCiudadtienda() {
		return ciudadtienda;
	}
	public void setCiudadtienda(String ciudadtienda) {
		this.ciudadtienda = ciudadtienda;
	}
	public float getValoriva() {
		return valoriva;
	}
	public void setValoriva(float valoriva) {
		this.valoriva = valoriva;
	}
	public float getTasainteres() {
		return tasainteres;
	}
	public void setTasainteres(float tasainteres) {
		this.tasainteres = tasainteres;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getCuentacorriente() {
		return cuentacorriente;
	}
	public void setCuentacorriente(String cuentacorriente) {
		this.cuentacorriente = cuentacorriente;
	}
	public String getNombregerente() {
		return nombregerente;
	}
	public void setNombregerente(String nombregerente) {
		this.nombregerente = nombregerente;
	}


}
