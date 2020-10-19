package transcundi;

import estructuras.ListaDinamica;

public class Municipio {
	private String nombre="sin definir";
	
    private double latitud;         
    private double longitud;
    protected ListaDinamica<MunicipioVecino> referencias;
    protected ListaDinamica<Ruta> rutas;
    protected ListaDinamica<Terminal> terminales;
    
    public Municipio(String municipio){
        this.nombre=municipio.toUpperCase();
        this.referencias= new ListaDinamica<MunicipioVecino>(10);
        this.rutas= new ListaDinamica<Ruta>(1000);
        
    }
    public Municipio(String municipio,int x){
        this.nombre=municipio.toUpperCase();
        this.referencias= new ListaDinamica<MunicipioVecino>(x);
        this.rutas= new ListaDinamica<Ruta>(x);
    }
    
    //setters
    public void setlatitud(double x){
        this.latitud=x;
    }
	public void setlongitud(double x){
        this.longitud =x;
    }
    public void setNombre(String x){
        this.nombre =x.toUpperCase();
    }
    
    //getters
    public int getReferenciasLen(){
        return referencias.getLen();
    }
    public int getNumeroReferencias(){
        return referencias.getNumeroElementos();
    }
    public double getlatitud(){
        return this.latitud;
    }
    public double getlongitud(){
        return this.longitud;
    }
    public String getNombre(){
        return this.nombre;
    }
    
    public void agregarRuta(){
    	
    }
    
    static void conectar(Municipio x,Municipio y){
    	for (int i=0;i<x.referencias.getLen();i++) {
    		if(x.referencias.getElemento(i) ==null || i==x.referencias.getLen()-1){
        		x.referencias.agregar(new MunicipioVecino(y));
        		break;
    		}else if(x.referencias.getElemento(i).getMunicipio() == y ){
    			return;
        	}
        }for (int i=0;i<y.referencias.getLen();i++) {
			if(y.referencias.getElemento(i) ==null || i==y.referencias.getLen()-1){
        		y.referencias.agregar(new MunicipioVecino(x));
        		break;
        	}else if(y.referencias.getElemento(i).getMunicipio() ==x){
        		break;
        	}
        }
    }
    
    static void desconetar(Municipio x,Municipio y) {
    	boolean si=false;
		for (int i=0;i<x.referencias.getLen();i++) {
			if(x.referencias.getElemento(i).getMunicipio() ==y ){
				si=true;
        	}
        }if (!si) {
			for (int i=0;i<y.referencias.getLen();i++) {
				if(y.referencias.getElemento(i).getMunicipio() ==x){
	        		break;
	        	}
	        }
        }
    }

    @Override
    public String toString() {
        String cadena="";
        if(nombre !="sin definir"){
            cadena=cadena+this.nombre.replaceAll("_", " ");
        }
        if(longitud !=0.0){
            cadena=cadena+" = Longitud:"+String.valueOf(this.longitud);
        }
        if(latitud !=0.0){
            cadena=cadena+", Latitud:"+String.valueOf(this.latitud);
        }
        if(referencias.getNumeroElementos()>0){
            cadena=cadena+"\n\tLIMITES:\n\t";
            for (int i=0;i<referencias.getNumeroElementos();i++) {
            	if(referencias.getElemento(i)!=null ){
            	cadena=cadena+(i+1)+". "+referencias.getElemento(i).getMunicipio().getNombre().replaceAll("_", " ")+"\n\t";
            	}else{
            		break;
            	}
            }
        }
        return cadena;
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Municipio other = (Municipio) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}
