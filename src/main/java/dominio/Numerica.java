package dominio;

public class Numerica implements Nota {
	
	private int valor;

	public boolean esAprobatoria() {
		
		return valor >= 6;		
	}
		
	
	
	//Constructor y propiedades
	public Numerica(int valor) {
		
		this.valor = valor;
	}
	
	public String getValor() {
		
		return Integer.toString(this.valor);
	}
}