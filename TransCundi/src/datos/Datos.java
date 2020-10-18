package datos;

import java.io.*;
import java.util.Date;
import estructuras.ListaDinamica;

public class Datos {
	private String nombre;
	private String ruta;
	private String actual;
	private String anterior;
	private String borrar;
	private Date fecha=new Date();	
	private ListaDinamica<String> cadena=new ListaDinamica<String>(100);
	private BufferedWriter bw;
	private BufferedReader bf;
	
	public Datos(String nombre,String ruta) {
		this.nombre=nombre;this.ruta=ruta;
	}
	public ListaDinamica<String> leer() throws IOException {
		try {
			bf= new BufferedReader(new FileReader(ruta));
			String lectura;
			while ((lectura=bf.readLine())!= null) {
				cadena.agregar(lectura.toUpperCase());
				System.out.println(lectura);
			}
			bf.close();
		}catch(Exception e){
			System.out.println("error");
		}
		cadena.recortarNulos();
		if (cadena.getNumeroElementos()>0)
			return cadena;
		else
			return null;
	}
	
	public static void main(String[] args) throws IOException {
		Datos ejemplo=new Datos("Datos","C:\\Users\\juanp\\Desktop\\Programacion Diego\\Trabajos\\TransCundi\\Txt\\Ejemplo");
		ejemplo.leer();
	}
}
