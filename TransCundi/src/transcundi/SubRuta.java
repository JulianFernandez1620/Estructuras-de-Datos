package transcundi;

public class SubRuta {
	private Municipio municipio;
	private int costo=0;
	private int tiempo=0;
	private int distancia=0;
	
	public SubRuta(Municipio comienzo) {
		this.municipio = comienzo;
	}
	
	public SubRuta(Municipio comienzo, Municipio fin) {
		this.municipio = comienzo;
	}
	public SubRuta(Municipio comienzo,int costo,int tiempo,int distancia) {
		this.municipio = comienzo;
		this.costo = costo;
		this.tiempo=tiempo;
		this.distancia=distancia;
	}
	
	//getters
	public Municipio getMunicipio() {
		return municipio;
	}
	
	public int getCosto() {
		return costo;
	}
	
	public int getTiempo() {
		return tiempo;
	}
	
	public int getDistancia() {
		return distancia;
	}
	
	//setters
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public void setComienzo(Municipio comienzo) {
		this.municipio = comienzo;
	}
	
	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	@Override
	public String toString() {
		return municipio+" $"+String.valueOf(costo)+" "+String.valueOf(tiempo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubRuta other = (SubRuta) obj;
		if (costo != other.costo)
			return false;
		if (tiempo != other.tiempo)
			return false;
		return true;
	}
	
	
}
