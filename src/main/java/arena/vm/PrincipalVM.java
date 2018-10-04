package arena.vm;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import dominio.Estudiante;
import repositorios.RepositorioEstudiantes;

@Observable
public class PrincipalVM {

	private Estudiante estudiante;
	private int legajo;
	
	public int getLegajo() {
		
		return legajo;
	}

	public void setLegajo(int legajo) {
		
		this.legajo = legajo;
	}

	public Estudiante getEstudiante() {
		
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		
		this.estudiante = estudiante;
	}

	public void buscarEstudiante() {
		
		estudiante = RepositorioEstudiantes
				.getInstancia()
				.buscarEstudiante(legajo)
				.orElseThrow(() -> new UserException("No existe estudiante de legajo: " + legajo));
	}
}