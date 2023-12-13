package co.edu.unbosque.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



import co.edu.unbosque.dto.DetalleVentasDTO;
import co.edu.unbosque.dto.VentasDTO;

public class DetalleVentasDAO {
	private List<DetalleVentasDTO> ListaDetallesVentas;
    
	private void listarDetalle(List<DetalleVentasDTO> ListaDetallesVentas) {
		System.out.println(" --- Listado Ventas");
		for (DetalleVentasDTO ventas : ListaDetallesVentas) {
			System.out.println(ventas.getCantidad());
		}
	}
	
	public String agregar(Object detalle) {
        String resultado;

        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(DetalleVentasDTO.class)
                .buildSessionFactory();

        Session miSession = miFactory.openSession();
        try {
            miSession.beginTransaction();
			miSession.save((DetalleVentasDTO)detalle);
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
				.addAnnotatedClass(DetalleVentasDTO.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction(); // aqui comienza lo hibernate
			ListaDetallesVentas = miSession.createQuery("from DetalleVentasDTO")
					.getResultList();
			listarDetalle(ListaDetallesVentas);
			miSession.getTransaction().commit();
			miSession.close();
		} catch (Exception e) {
			ListaDetallesVentas = null;
		} finally {
			miFactory.close();
		}
		return ListaDetallesVentas;
	}

	public List<DetalleVentasDTO> getListaDetallesVentas() {
		return ListaDetallesVentas;
	}

	public void setListaDetallesVentas(List<DetalleVentasDTO> listaDetallesVentas) {
		ListaDetallesVentas = listaDetallesVentas;
	}

	
	
}