package co.edu.unbosque.dao;

import java.util.List;

import co.edu.unbosque.dto.ClienteDTO;

public interface CrudI {
	public abstract String agregar(Object registro);

	public abstract Object consultar();

	// public abstract String actualizar(Object id, Object registro);
	public abstract String borrar(Object id);

	public abstract Object listar();

	public abstract String actualizar(Object nombre, ClienteDTO nuevoCliente);
}
