package co.edu.unbosque.dao;

import java.util.List;

import co.edu.unbosque.dto.ProductoDTO;

public interface ICrud {
	public abstract String agregar(Object registro);
	public abstract Object consultar();
	//public abstract String actualizar(Object id, Object registro);
	public abstract String borrar(Object id);
	public abstract Object listar();
	public abstract String actualizar(Object nombreproducto, ProductoDTO productoNuevo);

}
