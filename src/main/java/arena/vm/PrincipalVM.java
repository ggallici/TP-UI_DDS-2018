package arena.vm;

import javax.ws.rs.core.Response;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import dominio.Estudiante;
import dominio.servicios.NotitasRestService;
import dominio.servicios.ParserEstudiante;

@Observable
public class PrincipalVM {

	private Estudiante estudiante;
	private String token;
	
	public String getToken() {
		
		return token;
	}

	public void setToken(String token) {
		
		this.token = token;
	}

	public Estudiante getEstudiante() {
		
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		
		this.estudiante = estudiante;
	}

	public void buscarEstudiante() {
		
		ParserEstudiante parser = new ParserEstudiante();
		
		NotitasRestService servicio = new NotitasRestService(token);
		
		Response respuestaInformacionPersonal = servicio.getInformacionPersonal();
		
		Response respuestaTareas = servicio.getTareas();
		
		if(respuestaInformacionPersonal.getStatus() == 200 && respuestaTareas.getStatus() == 200) {
			
			String informacionPersonal = respuestaInformacionPersonal.readEntity(String.class);
			
			String tareas = respuestaTareas.readEntity(String.class);

			estudiante = parser.parsear(informacionPersonal, tareas);
		}
		else {
			
			throw new UserException("" );
		}
		
	}
}