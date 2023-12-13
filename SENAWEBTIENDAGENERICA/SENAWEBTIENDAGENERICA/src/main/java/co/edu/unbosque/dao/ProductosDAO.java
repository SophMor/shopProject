package co.edu.unbosque.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.edu.unbosque.dto.ClienteDTO;
import co.edu.unbosque.dto.ProductoDTO;

public class ProductosDAO implements ICrud{

	private List<ProductoDTO>listaProductos;
	private boolean actual;
	public ProductosDAO() {
		listaProductos = new ArrayList();
		actual  = false;
	}

	//verifica
	private void listarProductos(List<ProductoDTO> listaProductos) {
		System.out.println(" --- Listado Productos");
		for (ProductoDTO producto : listaProductos) {
			System.out.println(producto);
		}
	}
	@Override
	public String agregar(Object registro) {

		String resultado;
		SessionFactory miFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(ProductoDTO.class)
				.buildSessionFactory();

		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction();
			miSession.save((ProductoDTO) registro);
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
		SessionFactory miFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(ProductoDTO.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction(); //aqui comienza lo hibernate 
			listaProductos = miSession.createQuery("from ProductoDTO").getResultList();
			listarProductos(listaProductos);
			miSession.getTransaction().commit();
			miSession.close();
		} catch (Exception e) {
			listaProductos = null;
		} finally {
			miFactory.close();
		}
		return listaProductos;
	}

	@Override
	public String borrar(Object nombreproducto) {
		String resultado;
		SessionFactory miFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(ProductoDTO.class)
				.buildSessionFactory();

		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction();

			Query query = miSession.createQuery("DELETE FROM ProductoDTO WHERE nombreproducto = :nombreproducto");
			query.setParameter("nombreproducto", nombreproducto);
			int filasAfectadas = query.executeUpdate();

			miSession.getTransaction().commit();
			miSession.close();

			if (filasAfectadas > 0) {
				resultado = "OK";
			} else {
				resultado = "No se encontró el producto con la nombre producto especificada";
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

	public String actualizar(Object codigoproducto, ProductoDTO nuevoProducto){

		String resultado;

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(ProductoDTO.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();

		try {

			miSession.beginTransaction();  //para iniciar
			List<ProductoDTO> productos = miSession
					.createQuery("from ProductoDTO where codigoproducto  = :codigoproducto", ProductoDTO.class)
					.setParameter("codigoproducto", (int)codigoproducto) 
					.list();  //hibernate implemented

			if(!productos.isEmpty()) {
				ProductoDTO producto = productos.get(0);
				producto.setCodigoproducto(nuevoProducto.getCodigoproducto());
				producto.setNombreproducto(nuevoProducto.getNombreproducto());
				producto.setNitproveedor(nuevoProducto.getNitproveedor());
				producto.setPreciocompra(nuevoProducto.getPreciocompra());
				producto.setPrecioventa(nuevoProducto.getPrecioventa());

				miSession.update(producto); // AC
				miSession.getTransaction().commit(); //LO QUE EXPLICABA EL CUCHO
				resultado = "OK";
			}
			else {
				resultado = "NO ENCONTRADO";
			}
			miSession.close();

		}catch (Exception e) {
			resultado = e.toString();

		}
		finally {
			miFactory.close();
		}

		return resultado;

	}

	public ProductoDTO buscarPorCodigo(int codigoproducto) {
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(ProductoDTO.class).buildSessionFactory();
		Session miSession = miFactory.openSession();

		ProductoDTO productoEncontrado = null;

		try {
			miSession.beginTransaction();
			Query query = miSession.createQuery("from ProductoDTO where codigoproducto = :codigoproducto");
			query.setParameter("codigoproducto", codigoproducto);
			productoEncontrado = (ProductoDTO) query.getSingleResult();
			miSession.getTransaction().commit();
		} catch (NoResultException e) {
			productoEncontrado = null;
		} catch (Exception e) {
			// Manejo de otras excepciones, si es necesario
			productoEncontrado = null;
		} finally {
			miSession.close();
			miFactory.close();
		}

		return productoEncontrado;
	}

}