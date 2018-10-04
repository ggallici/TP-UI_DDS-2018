package dominio;

import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class Estudiante
{
	private int legajo;
	private String nombre;
	private String apellido;
	private String usuarioGitHub;
	private List<Tarea> tareas;
	
	public boolean aproboMateria() {
		
		return tareas.stream().allMatch(tarea -> tarea.estaAprobada());
	}
	
	
	
	//Constructor y propiedades
	public Estudiante(int legajo, String nombre, String apellido, String usuarioGitHub, List<Tarea> tareas) {
		
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuarioGitHub = usuarioGitHub;
		this.tareas = tareas;
	}

	public int getLegajo() {
		
		return legajo;
	}
	
	public void setLegajo(int legajo) {
		
		this.legajo = legajo;
	}
	
	public String getNombre() {
		
		return nombre;
	}
	public void setNombre(String nombre) {
		
		this.nombre = nombre;
	}
	public String getApellido() {
		
		return apellido;
	}
	public void setApellido(String apellido) {
		
		this.apellido = apellido;
	}
	public String getUsuarioGitHub() {
		
		return usuarioGitHub;
	}
	public void setUsuarioGitHub(String usuarioGitHub) {
		
		this.usuarioGitHub = usuarioGitHub;
	}
	public List<Tarea> getTareas() {
		
		return tareas;
	}
}