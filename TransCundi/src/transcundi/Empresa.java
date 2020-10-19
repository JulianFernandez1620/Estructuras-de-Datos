package transcundi;

import java.util.Scanner;

import estructuras.ListaDinamica;

public class Empresa {
	private String nombre;
	protected ListaDinamica<Ruta> rutas;
	protected ListaDinamica<Empleado> empleados;
	protected ListaDinamica<Vehiculo> vehiculos;
	protected ListaDinamica<ParadaEmpresa> terminales;

	public Empresa(String nombre) {
		this.nombre = nombre;
		 rutas=new ListaDinamica<Ruta>(100);
		 empleados= new ListaDinamica<Empleado>(10);
		 vehiculos= new ListaDinamica<Vehiculo>(10);
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
	}
	
	public void ocuparVehiculo(int x,int capacidad,Ruta ruta) {
		for (int i=0;i<vehiculos.getNumeroElementos();i++) {
			if (vehiculos.getElemento(i).getCapacidad()>=capacidad && !vehiculos.getElemento(i).isOcupado()) {
				ruta.vehiculosEnRuta.encolar(vehiculos.getElemento(i));
				vehiculos.getElemento(i).setOcupado();
			}
		}
	}
	
	public void preguntarGetters() {
		try {
			System.out.println("1. empleados\n2. vehiculos\n3. Rutas\n\n4. Cerrar");
			Scanner leer=new Scanner(System.in);
			String x=leer.nextLine();
			while(!x.equals("1") && !x.equals("2") && !x.equals("3") && !x.equals("4")) {
				x=leer.nextLine();
			}
			if (x.equals("1")) {
				for (int j=0;j<empleados.getNumeroElementos();j++) {
					System.out.println(empleados.getElemento(j));
				}
			}else if(x.equals("2")) {
				for (int j=0;j<vehiculos.getNumeroElementos();j++) {
					System.out.println(vehiculos.getElemento(j));
				}
			}else if(x.equals("3")) {
				for (int j=0;j<rutas.getNumeroElementos();j++) {
					System.out.println(rutas.getElemento(j));
				}
			}else if(x.equals("4")) {
				return;
			}
		}finally {
			
		}
	}
	@Override
	public String toString() {
		String cadena="";
		for (int j=0;j<empleados.getNumeroElementos();j++) {
			cadena=cadena+empleados.getElemento(j).getNombresApellidos()+"\n";
		}for (int j=0;j<vehiculos.getNumeroElementos();j++) {
			cadena=cadena+vehiculos.getElemento(j).getMatricula()+"\n";
		}
		for (int j=0;j<rutas.getNumeroElementos();j++) {
			cadena=cadena+rutas.getElemento(j).paradas()+"\n";
		}
		return this.nombre+"\n"+cadena;
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
