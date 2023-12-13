package co.edu.unbosque.model;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class GestioPagosCompras {

	private String nitProveedor;

	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		Map<String, String> requestParams = externalContext.getRequestParameterMap();
		nitProveedor = requestParams.get("nitProveedor");
	}
}
