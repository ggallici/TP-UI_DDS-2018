package dominio.servicios;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class NotitasRestService
{	
	private final static String API_NOTITAS = "http://notitas.herokuapp.com";
	private final static String RECURSO_DATOS_PERSONALES = "student";
	private final static String RECURSO_TAREAS = "student/assignments";
	
	private Client cliente;
	
	public NotitasRestService(String token) {
		
		cliente = ClientBuilder.newClient();
		
		cliente.register(new ClientRequestFilter() {
			
			@Override
			public void filter(ClientRequestContext requestContext) throws IOException {
				
				requestContext.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
			}
		});
	}
	
	public Response getInformacionPersonal() {
	 
		 return cliente
				 .target(API_NOTITAS)
				 .path(RECURSO_DATOS_PERSONALES)
				 .request(MediaType.APPLICATION_JSON)
				 .get();
	}
	
	public Response setInformacionPersonal(String datosPersonales) {
		
		 return cliente
				 .target(API_NOTITAS)
				 .path(RECURSO_DATOS_PERSONALES)
				 .request()
				 .put(Entity.json(datosPersonales));
	}

	public Response getTareas() {
		
		return cliente
				 .target(API_NOTITAS)
				 .path(RECURSO_TAREAS)
				 .request(MediaType.APPLICATION_JSON)
				 .get();
	}
}