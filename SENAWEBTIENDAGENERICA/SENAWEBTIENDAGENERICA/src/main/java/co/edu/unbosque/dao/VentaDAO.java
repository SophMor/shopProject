package co.edu.unbosque.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import co.edu.unbosque.dto.ClienteDTO;
import co.edu.unbosque.dto.DetalleVentasDTO;
import co.edu.unbosque.dto.TiendaDTO;
import co.edu.unbosque.dto.VentasDTO;

public class VentaDAO {
	private List<VentasDTO> ListaVentas;

	// verifica
	private void listarVentas(List<VentasDTO> ListaVentas) {
		System.out.println(" --- Listado Ventas");
		for (VentasDTO ventas : ListaVentas) {
			System.out.println(ventas);
		}
	}

	public String agregar(Object venta) {
		String resultado;

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(VentasDTO.class).buildSessionFactory();

		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction();
			miSession.save((VentasDTO)venta);
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
				.addAnnotatedClass(VentasDTO.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction(); // aqui comienza lo hibernate
			ListaVentas = miSession.createQuery("from VentasDTO")
					.getResultList();
			listarVentas(ListaVentas);
			miSession.getTransaction().commit();
			miSession.close();
		} catch (Exception e) {
			ListaVentas = null;
		} finally {
			miFactory.close();
		}
		return ListaVentas;
	}

	public List<VentasDTO> getListaVentas() {
		return ListaVentas;
	}

	public void setListaVentas(List<VentasDTO> listaVentas) {
		ListaVentas = listaVentas;
	}



}