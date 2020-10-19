package transcundi;

import estructuras.*;
public class Ruta{
	private String nombre;
	private int minima;
	private int horaInicio;
	private int horaFinal;
	private Empresa empresa;
	protected ListaEnlazada<SubRuta> paradas;
	protected ColaEnlazada<Vehiculo> vehiculosEnRuta;
	/*
	private double latitudMax;
	private double latitudMin;
	private double longitudMax;
	private double longitudMin;
	*/
	
	public Ruta(Empresa empresa){
        this.empresa=empresa;
        paradas= new ListaEnlazada<SubRuta>();
    }
	
	public Ruta(String nombre,Empresa empresa){
        this.empresa=empresa;
        this.nombre=nombre;
        paradas= new ListaEnlazada<SubRuta>();
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
		
		public ListaEnlazada<SubRuta> getParadas() {
			return paradas;
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
	
		public void setParadas(ListaEnlazada<SubRuta> paradas) {
			this.paradas = paradas;
		}
		
	public void nombrar() {
			this.nombre = paradas.getHeadDato().getMunicipio().getNombre()+"->"+paradas.getTailDato().getMunicipio().getNombre();
	}
	
	public boolean esta(Municipio x) {
		Nodo<SubRuta> miNodo=paradas.getHead();
		do {
			if(miNodo.dato.getMunicipio()==x) {return true;}
		}while((miNodo=miNodo.next)!=null);
		return false;
	}
	
	public Ruta esta(Municipio x,Municipio y) {
		Nodo<SubRuta> miNodo=paradas.getHead();
		Ruta miRuta = new Ruta(nombre, empresa);
		SubRuta menos=null;
		boolean si=false;
		do {
			if(miNodo.dato.getMunicipio()==x) {menos=miNodo.dato;miRuta.paradas.agregarTail(new SubRuta(x,0,0,0));si=true;
			}
			else if (si) {
				if(miNodo.dato.getMunicipio()==y){
					miRuta.paradas.agregarTail(new SubRuta(y,(miNodo.dato.getCosto()-menos.getCosto()),(miNodo.dato.getTiempo()-menos.getTiempo()),(miNodo.dato.getDistancia()-menos.getDistancia())));
					return miRuta;
				}else {
					miRuta.paradas.agregarTail(new SubRuta(miNodo.dato.getMunicipio(),(miNodo.dato.getCosto()-menos.getCosto()),(miNodo.dato.getTiempo()-menos.getTiempo()),(miNodo.dato.getDistancia()-menos.getDistancia())));
				}
			}
		}while((miNodo=miNodo.next)!=null);
		return null;
	}
	
	public String paradas() {
		Nodo<SubRuta> x=paradas.getHead();
		String cadena= x.dato.getMunicipio().getNombre()+" ";
		while(x.next!=null) {
			x=x.next;
			cadena=cadena+x.dato.getMunicipio().getNombre()+" ";
		}
		return cadena.trim().replace(" ", "->");
	}
	
	public String informacionDeRuta() {
		Nodo<SubRuta> x=paradas.getHead();
		String cadena= x.dato.getMunicipio().getNombre()+","+String.valueOf(x.dato.getCosto())+","+String.valueOf(x.dato.getTiempo())
		+","+String.valueOf(x.dato.getDistancia())+" ";
		while(x.next!=null) {
			x=x.next;
			cadena=cadena+x.dato.getMunicipio().getNombre()+","+String.valueOf(x.dato.getCosto())+","+String.valueOf(x.dato.getTiempo())
			+","+String.valueOf(x.dato.getDistancia())+" ";
		}
		return cadena.trim().replace(" ", "->");
	}
	
	public boolean menorParadas(Ruta x) {
		if (paradas.getLen()<x.paradas.getLen()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean menorTiempo(Ruta x) {
		if (paradas.getTailDato().getTiempo()<x.paradas.getTailDato().getTiempo()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean menorCosto(Ruta x) {
		if (paradas.getTailDato().getCosto()<x.paradas.getTailDato().getCosto()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
    public String toString() {
		return nombre+"\n"+paradas();
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
