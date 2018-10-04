package dominio;

public class Conceptual implements Nota {

	private String  valor;

	public boolean esAprobatoria() {
		
		return !valor.contains("M");
	}	
	
	
	
	//Constructor y propiedades
	public Conceptual(String valor) {
		
		this.valor = valor;
	}
	
	public String getValor() {
		
		return valor;
	}
}