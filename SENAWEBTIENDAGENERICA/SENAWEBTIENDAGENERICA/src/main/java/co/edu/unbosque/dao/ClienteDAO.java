package co.edu.unbosque.dao;

import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;



import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.edu.unbosque.dto.ClienteDTO;

public class ClienteDAO implements CrudI {

	private List<ClienteDTO> listaClientes;
	private boolean actual;

	public ClienteDAO() {
		listaClientes = new ArrayList();
		actual = false;
	}

	// verifica
	private void listarClientes(List<ClienteDTO> listaClientes) {
		System.out.println(" --- Listado Cliente");
		for (ClienteDTO cliente : listaClientes) {
			System.out.println(cliente);
		}
	}

	@Override
	public String agregar(Object registro) {

		String resultado;
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(ClienteDTO.class).buildSessionFactory();

		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction();
			miSession.save((ClienteDTO) registro);
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

	@Override
	public Object consultar() {
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(ClienteDTO.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction(); // aqui comienza lo hibernate
			listaClientes = miSession.createQuery("from ClienteDTO").getResultList();
			listarClientes(listaClientes);
			miSession.getTransaction().commit();
			miSession.close();
		} catch (Exception e) {
			listaClientes = null;
		} finally {
			miFactory.close();
		}
		return listaClientes;
	}

	@Override
	public String borrar(Object cedula) {
		String resultado;
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(ClienteDTO.class).buildSessionFactory();

		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction();

			Query query = miSession.createQuery("DELETE FROM ClienteDTO WHERE cedula = :cedula");
			query.setParameter("cedula", cedula);
			int filasAfectadas = query.executeUpdate();

			miSession.getTransaction().commit();
			miSession.close();

			if (filasAfectadas > 0) {
				resultado = "OK";
			} else {
				resultado = "No se encontró el cliente con la cédula especificada";
			}
		} catch (Exception e) {
			resultado = e.toString();
		} finally {
			miFactory.close();
		}
		return resultado;
	}

	@Override
	public Object listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override

	public String actualizar(Object cedula, ClienteDTO nuevoCliente) {

		String resultado;

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(ClienteDTO.class).buildSessionFactory();
		Session miSession = miFactory.openSession();

		try {

			miSession.beginTransaction(); // para iniciar
			List<ClienteDTO> clientes = miSession
					.createQuery("from ClienteDTO where cedula  = :cedula", ClienteDTO.class)
					.setParameter("cedula", (String) cedula).list(); // hibernate implemented

			if (!clientes.isEmpty()) {
				ClienteDTO cliente = clientes.get(0);
				cliente.setCedula(nuevoCliente.getCedula());
				cliente.setNombrecompleto(nuevoCliente.getNombrecompleto());
				cliente.setDireccion(nuevoCliente.getDireccion());
				cliente.setCoreoelectronnico(nuevoCliente.getCoreoelectronnico());
				cliente.setTelefono(nuevoCliente.getTelefono());

				miSession.update(cliente); // AC
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

	public ClienteDTO buscarPorCedula(String cedula) {
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(ClienteDTO.class).buildSessionFactory();
		Session miSession = miFactory.openSession();

		ClienteDTO clienteEncontrado = null;

		try {
			miSession.beginTransaction();
			Query query = miSession.createQuery("from ClienteDTO where cedula = :cedula");
			query.setParameter("cedula", cedula);
			clienteEncontrado = (ClienteDTO) query.getSingleResult();
			miSession.getTransaction().commit();
		} catch (NoResultException e) {
			clienteEncontrado = null;
		} catch (Exception e) {
			// Manejo de otras excepciones, si es necesario
			clienteEncontrado = null;
		} finally {
			miSession.close();
			miFactory.close();
		}

		return clienteEncontrado;
	}

}
