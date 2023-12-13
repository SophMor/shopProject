package co.edu.unbosque.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.edu.unbosque.dto.ClienteDTO;
import co.edu.unbosque.dto.ProveedorDTO;

public class ProveedorDAO implements CrudP{
	private List<ProveedorDTO> listaProveedores;
	private boolean actual;

	public ProveedorDAO() {
		listaProveedores = new ArrayList();
		actual = false;
	}

	// verifica
	private void listarProveedores(List<ProveedorDTO> listaProveedores) {
		System.out.println(" --- Listado Proveedor");
		for (ProveedorDTO proveedor : listaProveedores) {
			System.out.println(proveedor);
		}
	}

	@Override
	public String agregar(Object registro) {

		String resultado;
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(ProveedorDTO.class).buildSessionFactory();

		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction();
			miSession.save((ProveedorDTO) registro);
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
				.addAnnotatedClass(ProveedorDTO.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction(); // aqui comienza lo hibernate
			listaProveedores = miSession.createQuery("from ProveedorDTO").getResultList();
			listarProveedores(listaProveedores);
			miSession.getTransaction().commit();
			miSession.close();
		} catch (Exception e) {
			listaProveedores = null;
		} finally {
			miFactory.close();
		}
		return listaProveedores;
	}

	@Override
	public String borrar(Object nit) {
		String resultado;
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(ProveedorDTO.class).buildSessionFactory();

		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction();

			Query query = miSession.createQuery("DELETE FROM ProveedorDTO WHERE nit = :nit");
			query.setParameter("nit", nit);
			int filasAfectadas = query.executeUpdate();

			miSession.getTransaction().commit();
			miSession.close();

			if (filasAfectadas > 0) {
				resultado = "OK";
			} else {
				resultado = "No se encontró el PROVEEDOR con el nit especificado";
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
	public String actualizar(Object nit, ProveedorDTO nuevoProveedor) {
		String resultado;
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(ProveedorDTO.class).buildSessionFactory();

		Session miSession = miFactory.openSession();

		try {
			miSession.beginTransaction();

			Query query = miSession.createQuery("FROM ProveedorDTO WHERE nit = :nit");
			query.setParameter("nit", nit);
			List<ProveedorDTO> proveedores = query.getResultList();

			if (!proveedores.isEmpty()) {
				ProveedorDTO proveedor = proveedores.get(0);
				proveedor.setNit(nuevoProveedor.getNit());
				proveedor.setNombreproveedor(nuevoProveedor.getNombreproveedor());
				proveedor.setDireccion(nuevoProveedor.getDireccion());
				proveedor.setTelefono(nuevoProveedor.getTelefono());
				proveedor.setCiudad(nuevoProveedor.getCiudad());

				miSession.update(proveedor);
				miSession.getTransaction().commit();
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
