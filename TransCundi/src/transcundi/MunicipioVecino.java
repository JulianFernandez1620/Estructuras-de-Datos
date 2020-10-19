package transcundi;

public class MunicipioVecino {
	private Municipio municipio=null;
	private int tiempo=8;
	private int distancia=20;
	
	public MunicipioVecino(Municipio municipio) {
		this.municipio = municipio;
	}
	
	public MunicipioVecino(Municipio municipio, int tiempo, int distancia) {
		this.municipio = municipio;
		this.tiempo = tiempo;
		this.distancia = distancia;
	}



	//getters
	public Municipio getMunicipio() {
		return municipio;
	}
	public int getTiempo() {
		return tiempo;
	}
	public int getDistancia() {
		return distancia;
	}
	
	//setters
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	
}
