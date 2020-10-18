package transcundi;

public class SubRuta {
	private String comienzo;
	private String fin;
	private int costo=0;
	private int tiempo=0;
	
	public SubRuta(String comienzo, String fin, int costo) {
		this.comienzo = comienzo;
		this.fin = fin;
		this.costo = costo;
	}
	public SubRuta(String comienzo, String fin, int costo,int tiempo) {
		this.comienzo = comienzo;
		this.fin = fin;
		this.costo = costo;
		this.tiempo=tiempo;
	}
	
	//getters
	public String getComienzo() {
		return comienzo;
	}
	
	public String getFin() {
		return fin;
	}
	
	public int getCosto() {
		return costo;
	}
	
	public int getTiempo() {
		return tiempo;
	}
	//setters
	
	public void setComienzo(String comienzo) {
		this.comienzo = comienzo;
	}
	
	public void setFin(String fin) {
		this.fin = fin;
	}
	
	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	@Override
	public String toString() {
		return comienzo+"->"+fin+" $"+String.valueOf(costo)+" "+String.valueOf(tiempo);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + costo;
		result = prime * result + ((fin == null) ? 0 : fin.hashCode());
		result = prime * result + tiempo;
		return result;
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
		if (fin == null) {
			if (other.fin != null)
				return false;
		} else if (!fin.equals(other.fin))
			return false;
		if (tiempo != other.tiempo)
			return false;
		return true;
	}
	
	
}
