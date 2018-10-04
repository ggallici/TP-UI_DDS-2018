package arena.vm;

import org.uqbar.commons.utils.Observable;

import dominio.Estudiante;

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
}