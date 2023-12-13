package co.edu.unbosque.model;

import java.util.List;

import javax.faces.bean.ManagedBean;

import co.edu.unbosque.dao.ClienteDAO;
import co.edu.unbosque.dao.TiendaDAO;
import co.edu.unbosque.dto.ClienteDTO;
import co.edu.unbosque.dto.TiendaDTO;

@ManagedBean
public class TiendaBean {
	private String tipocomercio;
	private String nit;
	private String nombretienda;
	private String ciudadtienda;

	private float valoriva;
	private float tasainteres;
	private String banco;
	private String cuentacorriente;
	private String nombregerente;
	private List<TiendaDTO> listaTiendas;

	private TiendaDTO tiendaDTO;
	private String resultado;
	public TiendaBean() {
		// TODO Auto-generated constructor stub
	}

	public String agregar() {
		TiendaDAO	tienda = new TiendaDAO();

		//		tiendaDTO.setValoriva(this.valoriva);

		setValoriva(this.valoriva);
		this.resultado = tienda.agregar(new TiendaDTO(this.nit, this.tipocomercio,
				this.nombretienda, this.ciudadtienda, this.valoriva, 
				this.tasainteres, this.banco, this.cuentacorriente, 
				this.nombregerente));
		this.listaTiendas = (List<TiendaDTO>) tienda.consultar();



		if (this.resultado.equals("OK") && this.listaTiendas != null) {
			return "tablaTienda.xhtml";
		} else {
			return "error.xhtml";
		}


	}

	public Object consultar() {
		TiendaDAO tienda = new TiendaDAO();

		this.listaTiendas = (List<TiendaDTO>) tienda.consultar();

		if (this.listaTiendas != null) {
			return "tablaTienda.xhtml";
		} else {
			return "error.xhtml";
		}
	}

	public String actualizar() {
		TiendaDAO tienda = new TiendaDAO();
		TiendaDTO newTienda = new TiendaDTO();
		newTienda.setNit(this.nit);
		newTienda.setTipocomercio(this.tipocomercio);
		newTienda.setNombretienda(this.nombretienda);
		newTienda.setCiudadtienda(this.ciudadtienda);
		newTienda.setValoriva(this.valoriva);
		newTienda.setTasainteres(this.tasainteres);
		newTienda.setBanco(this.banco);
		newTienda.setCuentacorriente(this.cuentacorriente);
		newTienda.setNombregerente(this.nombregerente);

		this.resultado = tienda.actualizar(this.nit, newTienda);

		if (this.resultado.equals("OK")) {
			this.listaTiendas = (List<TiendaDTO>) tienda.consultar();

			return "tablaTienda.xhtml"; //modificar
		} else {
			return "error.xhtml";
		}

	}
	public String getTipocomercio() {
		return tipocomercio;
	}

	public void setTipocomercio(String tipocomercio) {
		this.tipocomercio = tipocomercio;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombretienda() {
		return nombretienda;
	}

	public void setNombretienda(String nombretienda) {
		this.nombretienda = nombretienda;
	}

	public float getValoriva() {
		return valoriva;
	}


	public void setValoriva(float valoriva) {
		this.valoriva = (float) 0.19;
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


	public String getNombregerente() {
		return nombregerente;
	}

	public void setNombregerente(String nombregerente) {
		this.nombregerente = nombregerente;
	}

	public String getCuentacorriente() {
		return cuentacorriente;
	}

	public void setCuentacorriente(String cuentacorriente) {
		this.cuentacorriente = cuentacorriente;
	}

	public String getCiudadtienda() {
		return ciudadtienda;
	}

	public void setCiudadtienda(String ciudadtienda) {
		this.ciudadtienda = ciudadtienda;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public List<TiendaDTO> getListaTiendas() {
		return listaTiendas;
	}

	public void setListaTiendas(List<TiendaDTO> listaTiendas) {
		this.listaTiendas = listaTiendas;
	}





}
