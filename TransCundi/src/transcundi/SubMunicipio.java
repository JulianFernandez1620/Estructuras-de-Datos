package transcundi;

import estructuras.ListaDinamica;

public class SubMunicipio extends Municipio{
	
	private Municipio municipio;
	protected ListaDinamica<Municipio> hacia;

	public SubMunicipio(String municipio,Municipio x) {
		super(municipio);
		this.municipio=x;
		hacia = new ListaDinamica<Municipio>(1);
	}

	public SubMunicipio(String municipio, int x,Municipio y) {
		super(municipio, x);
		this.municipio=y;
		hacia = new ListaDinamica<Municipio>(x);
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public ListaDinamica<Municipio> getHacia() {
		return hacia;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public void setHacia(ListaDinamica<Municipio> hacia) {
		this.hacia = hacia;
	}
}
