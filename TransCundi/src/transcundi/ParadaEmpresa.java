package transcundi;

import estructuras.ColaEnlazada;

public class ParadaEmpresa {
	private String nombre;
	private Empresa empresa;
	protected ColaEnlazada<Vehiculo> parqueadero;
	
	public ParadaEmpresa(String nombre, Empresa empresa) {
		this.nombre = nombre;
		this.empresa = empresa;
	}

	public String getNombre() {
		return nombre;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}
