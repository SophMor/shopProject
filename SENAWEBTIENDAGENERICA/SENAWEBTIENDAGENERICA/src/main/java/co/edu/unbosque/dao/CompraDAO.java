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
import co.edu.unbosque.dto.ComprasDTO;
import co.edu.unbosque.dto.DetalleVentasDTO;
import co.edu.unbosque.dto.TiendaDTO;
import co.edu.unbosque.dto.VentasDTO;

public class CompraDAO {
	private List<ComprasDTO> ListaCompras;

	// verifica
	private void listarCompras(List<ComprasDTO> ListaCompras) {
		System.out.println(" --- Listado Compras");
		for (ComprasDTO compras : ListaCompras) {
			System.out.println(compras);
		}
	}

	public String agregar(Object compra) {
		String resultado;

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(ComprasDTO.class).buildSessionFactory();

		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction();
			miSession.save((ComprasDTO)compra);
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
				.addAnnotatedClass(ComprasDTO.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction(); // aqui comienza lo hibernate
			ListaCompras = miSession.createQuery("from VentasDTO")
					.getResultList();
			listarCompras(ListaCompras);
			miSession.getTransaction().commit();
			miSession.close();
		} catch (Exception e) {
			ListaCompras = null;
		} finally {
			miFactory.close();
		}
		return ListaCompras;
	}

	public List<ComprasDTO> getListaCompras() {
		return ListaCompras;
	}

	public void setListaCompras(List<ComprasDTO> listaCompras) {
		ListaCompras = listaCompras;
	}




}

