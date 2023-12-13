package co.edu.unbosque.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.edu.unbosque.dto.DetalleComprasDTO;
import co.edu.unbosque.dto.DetalleVentasDTO;
import co.edu.unbosque.dto.VentasDTO;

public class DetalleComprasDAO {
	private List<DetalleComprasDTO> ListaDetallesCompras;
    
	private void listarDetalle(List<DetalleComprasDTO> ListaDetallesCompras) {
		System.out.println(" --- Listado Compras");
		for (DetalleComprasDTO compras : ListaDetallesCompras) {
			System.out.println(compras);
		}
	}
	
	public String agregar(Object detalle) {
        String resultado;

        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(DetalleComprasDTO.class)
                .buildSessionFactory();

        Session miSession = miFactory.openSession();
        try {
            miSession.beginTransaction();
			miSession.save((DetalleComprasDTO)detalle);
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
				.addAnnotatedClass(DetalleComprasDTO.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction(); // aqui comienza lo hibernate
			ListaDetallesCompras = miSession.createQuery("from DetalleComprasDTO")
					.getResultList();
			listarDetalle(ListaDetallesCompras);
			miSession.getTransaction().commit();
			miSession.close();
		} catch (Exception e) {
			ListaDetallesCompras = null;
		} finally {
			miFactory.close();
		}
		return ListaDetallesCompras;
	}

	public List<DetalleComprasDTO> getListaDetallesCompras() {
		return ListaDetallesCompras;
	}

	public void setListaDetallesCompras(List<DetalleComprasDTO> listaDetallesCompras) {
		ListaDetallesCompras = listaDetallesCompras;
	}

	
	
	
}
