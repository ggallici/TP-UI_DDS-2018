package dominio;

import com.google.gson.annotations.SerializedName;

public interface Nota
{
	public boolean esAprobatoria();
	
	@SerializedName("value")
	public String getValor();
}