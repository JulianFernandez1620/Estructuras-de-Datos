package transcundi;

import java.util.Scanner;

import estructuras.ListaDinamica;

public class Empresa {
	private String nombre;
	protected ListaDinamica<Ruta> rutas;
	protected ListaDinamica<Empleado> empleados;
	protected ListaDinamica<Vehiculo> vehiculos;

	public Empresa(String nombre) {
		this.nombre = nombre;
		 rutas=new ListaDinamica<Ruta>();
		 empleados= new ListaDinamica<Empleado>();
		 vehiculos= new ListaDinamica<Vehiculo>();
	}

	//getters
		public String getNombre() {
			return nombre;
		}
		
		public ListaDinamica<Ruta> getRutas() {
			return rutas;
		}
		
		public Ruta getRutaEspecifica(String nombre) {
			for (int i=0; i<rutas.getLen(); i++) {
				if (rutas.getElemento(i).getNombre()==nombre) {
					return rutas.getElemento(i);
				}
			}
			return null;
		}
		
		public Ruta getRutaEspecifica(int nombre) {
			return rutas.getElemento(nombre);
		}
	
		public ListaDinamica<Empleado> getEmpleados() {
			return empleados;
		}
		
		public Empleado getEmpleadoEspecifico(String nombre) {
			for (int i=0; i<empleados.getLen(); i++) {
				if (empleados.getElemento(i).getDocumentoIdentidad()==nombre) {
					return empleados.getElemento(i);
				}
			}
			return null;
		}
	
		public ListaDinamica<Vehiculo> getVehiculos() {
			return vehiculos;
		}
		
		public Vehiculo getVehiculoEspecifico(String matricula) {
			for (int i=0; i<vehiculos.getLen(); i++) {
				if (vehiculos.getElemento(i).getMatricula()==nombre) {
					return vehiculos.getElemento(i);
				}
			}
			return null;
		}
	
	//setters
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
	
		public void setRutas(ListaDinamica<Ruta> rutas) {
			this.rutas = rutas;
		}
	
		public void setEmpleados(ListaDinamica<Empleado> empleados) {
			this.empleados = empleados;
		}
	
		public void setVehiculos(ListaDinamica<Vehiculo> vehiculos) {
			this.vehiculos = vehiculos;
		}
		
		
	public void agregarRuta(Ruta x) {
		rutas.agregar(x);
	}
	
	public void agregarVehiculo(Vehiculo x) {
		vehiculos.agregar(x);
	}
	
	public void agregarEmpleado(Empleado x) {
		empleados.agregar(x);
	}
	
	public void eliminarRuta(Ruta x) {
		rutas.eliminar(x);
	}
	
	public void eliminarVehiculo(Vehiculo x) {
		vehiculos.eliminar(x);
	}
	
	public void eliminarEmpleado(Empleado x) {
		empleados.eliminar(x);
	}
	
	public void determinarRuta(Ruta x) {
		System.out.println(x.);
	}
	
	public void ocuparVehiculo(int x,int capacidad,Ruta ruta) {
		for (int i=0;i<vehiculos.getNumeroElementos();i++) {
			if (vehiculos.getElemento(i).getCapacidad()>=capacidad && !vehiculos.getElemento(i).isOcupado()) {
				ruta.buses.encolar(vehiculos.getElemento(i));
				vehiculos.getElemento(i).setOcupado();
			}
		}
	}
	
	public void asignarHorarios() {
		System.out.println("ingresar horarios de la ruta separado por espacios");
		Scanner leer= new Scanner(System.in);
		String[] x=leer.split(" ");
		for
	}
	
	

	public void 
		
	@Override
	public String toString() {
		String cadena="";
		for (int j=0;j<empleados.getNumeroElementos();j++) {
			cadena=cadena+empleados.getElemento(j).getNombresApellidos()+"\n";
		}for (int j=0;j<vehiculos.getNumeroElementos();j++) {
			cadena=cadena+vehiculos.getElemento(j).getMatricula()+"\n";
		}
		for (int j=0;j<rutas.getNumeroElementos();j++) {
			cadena=cadena+rutas.getElemento(j).ruta()+"\n";
		}
		return this.nombre+"\n"+cadena;
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
		Empresa other = (Empresa) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
