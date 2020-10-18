package transcundi;

import estructuras.*;
import java.util.Timer;

public class Ruta {
	private String nombre;
	private int minima;
	private int horaInicio;
	private int horaFinal;
	private Empresa empresa;
	protected ListaEnlazada<Municipio> paradas;
	protected ListaDinamica<SubRuta> subRutas;
	protected ColaEnlazada<Vehiculo> buses;
	protected ListaDinamica<Timer> horarios;
	/*
	private double latitudMax;
	private double latitudMin;
	private double longitudMax;
	private double longitudMin;
	*/
	
	public Ruta(Empresa empresa){
        this.empresa=empresa;
        paradas= new ListaEnlazada<Municipio>();
    	subRutas= new ListaDinamica<SubRuta>();
    	buses= new ColaEnlazada<Vehiculo> ();
    	horarios= new ListaDinamica<Timer>();
    }
	
	public Ruta(String nombre,Empresa empresa){
        this.empresa=empresa;
        this.nombre=nombre;
        paradas= new ListaEnlazada<Municipio>();
    	subRutas= new ListaDinamica<SubRuta>();
    	buses= new ColaEnlazada<Vehiculo> ();
    	horarios= new ListaDinamica<Timer>();
    }
	//getters
		public String getNombre() {
			return nombre;
		}
	
		public int getMinima(){
			return minima;
		}
	
		public int getHoraInicio() {
			return horaInicio;
		}
	
		public int getHoraFinal() {
			return horaFinal;
		}
	
		public Empresa getEmpresa() {
			return empresa;
		}
		
		public ListaEnlazada<Municipio> getParadas() {
			return paradas;
		}
		
		public ListaDinamica<SubRuta> getValores() {
			return subRutas;
		}
	
		public int getValorEspecifico (String comienza, String fin) {
			for (int i=0;i<subRutas.getNumeroElementos();i++) {
				if(subRutas.getElemento(i).getComienzo().equals(comienza) && subRutas.getElemento(i).getComienzo().equals(fin)) {
					return subRutas.getElemento(i).getCosto();
				}
			}
			return 0;
		}
	
	
	//setters
		public void setNombre(String ruta) {
			this.nombre = ruta;
		}
		
		public void setMinima(int minima) {
			this.minima = minima;
		}
	
		public void setHoraInicio(int horaInicio) {
			this.horaInicio = horaInicio;
		}
	
		public void setHoraFinal(int horaFinal) {
			this.horaFinal = horaFinal;
		}
	
		public void setEmpresa(Empresa empresa) {
			this.empresa = empresa;
		}
	
		public void setParadas(ListaEnlazada<Municipio> paradas) {
			this.paradas = paradas;
		}
		
		public void setValores(ListaDinamica<SubRuta> valores) {
			this.subRutas = valores;
		}
		
		public void setValorEspecifico (String comienza, String fin, int valor) {
			for (int i=0;i<subRutas.getNumeroElementos();i++) {
				if(subRutas.getElemento(i).getComienzo().equals(comienza) && subRutas.getElemento(i).getComienzo().equals(fin)) {
					subRutas.getElemento(i).setCosto(valor);
				}
			}
		}
		
	public void nombrar() {
			this.nombre = paradas.getHeadDato().getNombre()+"->"+paradas.getTailDato().getNombre();
	}
	
	public boolean esta(Municipio x) {
		Nodo<Municipio> miNodo=paradas.getHead();
		do {
			if(miNodo.dato==x) {return true;}
		}while((miNodo=miNodo.next)!=null);
		return false;
	}
	
	public String ruta() {
		Nodo<Municipio> x=paradas.getHead();
		String cadena= x.dato.getNombre()+" ";
		while(x.next!=null) {
			x=x.next;
			cadena=cadena+x.dato.getNombre()+" ";
		}
		return cadena.trim().replace(" ", "->");
	}

	@Override
    public String toString() {
		String cadena="sin definir toString";
        return cadena;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Ruta other = (Ruta) obj;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
}
