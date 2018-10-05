package dominio;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import com.google.gson.annotations.SerializedName;

@Observable
public class Tarea
{
	@SerializedName("description")
	private String descripcion;
	@SerializedName("grades")
	private List<Nota> notas; 
	
	//Una tarea está aprobada, si su ultima nota está aprobada. Si no tiene notas, esta desaprobada.
	public boolean estaAprobada() {
		
		return notas.stream().reduce((__, segunda) -> segunda).map(nota -> nota.esAprobatoria()).orElse(false);
	}
	
	
	
	//Constructor y propiedades
	public Tarea(String descripcion, List<Nota> notas) {
		
		this.descripcion = descripcion;
		this.notas = notas;
	}

	public String getDescripcion() {
		
		return descripcion;
	}

	public List<Nota> getNotas() {
		
		return notas;
	}
}