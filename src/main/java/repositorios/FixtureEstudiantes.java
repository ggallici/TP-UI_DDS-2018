package repositorios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dominio.Conceptual;
import dominio.Estudiante;
import dominio.Nota;
import dominio.Numerica;
import dominio.Tarea;

public class FixtureEstudiantes {
	
	private static final FixtureEstudiantes INSTANCIA = new FixtureEstudiantes();

	private List<Nota> notasParcial = Arrays.asList(new Numerica(4), new Conceptual("B"));
	private List<Nota> notasTp = Arrays.asList(new Conceptual("M"), new Numerica(6));
	
	private List<Tarea> tareas = Arrays.asList(new Tarea("1° Parcial", notasParcial), new Tarea("TP-Anual", notasTp));

	private Estudiante e1 = new Estudiante(1, "Agustin", "Coda", "aocoda", tareas);
	private Estudiante e2 = new Estudiante(2, "German", "Galici", "ggalici", null);
	private Estudiante e3 = new Estudiante(3, "Guido", "Martinez", "GuidoMartinez", null);
	
	
	
	//PROPIEDADES
	private FixtureEstudiantes() { }
	
	public static FixtureEstudiantes getInstancia() {
		
		return INSTANCIA;
	}

	public List<Estudiante> getEstudiantes() {
		
		return Stream.of(e1, e2, e3).collect(Collectors.toCollection(ArrayList::new));
	}
}