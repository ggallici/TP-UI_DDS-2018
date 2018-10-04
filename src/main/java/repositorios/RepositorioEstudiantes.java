package repositorios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.uqbar.commons.utils.Observable;

import dominio.Estudiante;

@Observable
public class RepositorioEstudiantes {

	private static final RepositorioEstudiantes INSTANCIA = new RepositorioEstudiantes();
	private List<Estudiante> estudiantes = new ArrayList<>();
	
	public void agregarVarios(List<Estudiante> otrosEstudiantes) {
		
		estudiantes.addAll(otrosEstudiantes);
	}
	
	public void agregar(Estudiante estudiante) {
		
		estudiantes.add(estudiante);
	}
		
	public void borrar(Estudiante estudiante) {
		
		estudiantes.remove(estudiante);
	}
	
	public Optional<Estudiante> buscarEstudiante(int legajo) {
		
		return estudiantes
				.stream()
				.filter(estudiante -> estudiante.getLegajo() == legajo)
				.findFirst();
	}
	
	
	
	// PROPIEDADES
	private RepositorioEstudiantes() { }
	
	public static RepositorioEstudiantes getInstancia() {
		
		return INSTANCIA;
	}
	
	public List<Estudiante> getEstudiantes() {
		
		return estudiantes;
	}
}