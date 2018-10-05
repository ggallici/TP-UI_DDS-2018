package dominio.servicios;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import dominio.Conceptual;
import dominio.Nota;
import dominio.Numerica;

public class DesarealizadorNotas implements JsonDeserializer<Nota>{

	@Override
	public Nota deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
		
		String nota = json.getAsJsonObject().get("value").getAsString();
		
		try {
			
			int notaInt = Integer.parseInt(nota);
			
			return new Numerica(notaInt);
		}
		catch(NumberFormatException e) {
			
			return new Conceptual(nota);
		}
	}
}