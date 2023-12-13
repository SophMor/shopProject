package co.edu.unbosque.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.edu.unbosque.dto.ClienteDTO;
import co.edu.unbosque.dto.TiendaDTO;

public class TiendaDAO {

	private List<TiendaDTO> listaTienda;
	private boolean actual;
	public TiendaDAO() {
		listaTienda = new ArrayList();
		actual = false;
	}

	// verifica
	private void listarTienda(List<TiendaDTO> listaTienda) {
		System.out.println(" --- Listado Cliente");
		for (TiendaDTO tienda : listaTienda) {
			System.out.println(tienda);
		}
	}


	public String agregar(Object registro) {

		String resultado;
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(TiendaDTO.class).buildSessionFactory();

		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction();
			miSession.save((TiendaDTO) registro);
			miSession.getTransaction().commit();
			resultado = "OK";
			miSession.close();
		} catch (Exception e) {
			resultado = e.toString();
		} finally {
			miFactory.close();
		}
		return resultado;
	}


	public Object consultar() {
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(TiendaDTO.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction(); // aqui comienza lo hibernate
			listaTienda = miSession.createQuery("from TiendaDTO").getResultList();
			listarTienda(listaTienda);
			miSession.getTransaction().commit();
			miSession.close();
		} catch (Exception e) {
			listaTienda = null;
		} finally {
			miFactory.close();
		}
		return listaTienda;
	}


	public String actualizar(Object nit, TiendaDTO nuevoTienda) {

		String resultado;

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(TiendaDTO.class).buildSessionFactory();
		Session miSession = miFactory.openSession();

		try {

			miSession.beginTransaction(); // para iniciar
			List<TiendaDTO> tiendas = miSession
					.createQuery("from TiendaDTO where nit  = :nit", TiendaDTO.class)
					.setParameter("nit", (String) nit).list(); // hibernate implemented

			if (!tiendas.isEmpty()) {
				TiendaDTO tienda = tiendas.get(0);
				tienda.setNit(nuevoTienda.getNit());
				tienda.setTipocomercio(nuevoTienda.getTipocomercio());
				tienda.setNombretienda(nuevoTienda.getNombretienda());
				tienda.setCiudadtienda(nuevoTienda.getCiudadtienda());
				tienda.setValoriva(nuevoTienda.getValoriva());
				tienda.setTasainteres(nuevoTienda.getTasainteres());
				tienda.setBanco(nuevoTienda.getBanco());
				tienda.setCuentacorriente(nuevoTienda.getCuentacorriente());
				tienda.setNombregerente(nuevoTienda.getNombregerente());
				miSession.update(tienda); // AC
				miSession.getTransaction().commit(); // LO QUE EXPLICABA EL CUCHO
				resultado = "OK";
			} else {
				resultado = "NO ENCONTRADO";
			}
			miSession.close();

		} catch (Exception e) {
			resultado = e.toString();

		} finally {
			miFactory.close();
		}

		return resultado;

	}

}

