package dominio.servicios;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dominio.Estudiante;
import dominio.Nota;

public class ParserEstudiante {

	private Gson jsonParser = new Gson();
	
	public ParserEstudiante() {
		
		this.jsonParser = new GsonBuilder()
				.registerTypeAdapter(Nota.class, new DesarealizadorNotas())
				.create();
	}
	
	public Estudiante parsear(String informacionPersonal, String notas) {
		
		String estudiante = informacionPersonal.substring(0, informacionPersonal.length() - 1) + "," + notas.substring(1);

		return jsonParser.fromJson(estudiante, Estudiante.class);
	}
	
	public String parsear(Estudiante estudiante) {
		
		return jsonParser.toJson(estudiante);
	}
}