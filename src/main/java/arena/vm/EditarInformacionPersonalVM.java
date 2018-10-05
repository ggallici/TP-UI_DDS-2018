package arena.vm;

import javax.ws.rs.core.Response;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import dominio.Estudiante;
import dominio.servicios.NotitasRestService;
import dominio.servicios.ParserEstudiante;

@Observable
public class EditarInformacionPersonalVM {
	
	private Estudiante estudiante;
	
	public EditarInformacionPersonalVM(Estudiante estudiante) {

		this.estudiante = estudiante;
	}
	
	public int getLegajo() {
		
		return estudiante.getLegajo();
	}
	
	public void setLegajo(int legajo) {
		
		estudiante.setLegajo(legajo);
	}
	
	public String getNombre() {
		
		return estudiante.getNombre();
	}
	
	public void setNombre(String nombre) {
		
		estudiante.setNombre(nombre);
	}
	
	public String getApellido() {
		
		return estudiante.getApellido();
	}
	
	public void setApellido(String apellido) {
		
		estudiante.setApellido(apellido);
	}
	
	public String getUsuarioGitHub() {
		
		return estudiante.getUsuarioGitHub();
	}
	
	public void setUsuarioGitHub(String usuarioGitHub) {
		
		estudiante.setUsuarioGitHub(usuarioGitHub);
	}

	public void editarInformacionPersonal(String token) {
		
		ParserEstudiante parser = new ParserEstudiante();
		
		NotitasRestService servicio = new NotitasRestService(token);
		
		String estudianteParseado = parser.parsear(estudiante);
		
		Response respuesta = servicio.setInformacionPersonal(estudianteParseado);
		
		if(respuesta.getStatus() != 201) {
			
			throw new UserException("un mensaje" + respuesta.getStatus());
		}
	}
}