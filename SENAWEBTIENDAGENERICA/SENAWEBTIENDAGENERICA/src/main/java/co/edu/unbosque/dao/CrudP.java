package co.edu.unbosque.dao;


import co.edu.unbosque.dto.ProveedorDTO;

public interface CrudP {

	public abstract String agregar(Object registro);

	public abstract Object consultar();

	// public abstract String actualizar(Object id, Object registro);
	public abstract String borrar(Object nit);

	public abstract Object listar();

	public abstract String actualizar(Object nombre, ProveedorDTO nuevoProveedor);
}
