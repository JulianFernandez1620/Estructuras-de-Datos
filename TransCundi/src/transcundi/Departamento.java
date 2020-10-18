package transcundi;

import java.io.*;
import javax.swing.*;	
import estructuras.ListaDinamica;

public class Departamento {

    private ListaDinamica<Municipio> lugares;
    private ListaDinamica<Empresa> empresas;
    private ListaDinamica<Usuario> usuarios;
    
    //constructor
    public Departamento(){
        this.lugares = new ListaDinamica<Municipio>(10);
        this.empresas = new ListaDinamica<Empresa>(10);
        //this.cantidad = 10;
    }
    
    public Departamento(int x){
        this.lugares = new ListaDinamica<Municipio>(x);
        this.empresas = new ListaDinamica<Empresa>(50);
        //this.cantidad = 10;
    }
    
    
    //metodos
    public int estaLugar(String nombre) {
    	for(int i=0; i<lugares.getNumeroElementos();i++) {
    		String busqueda=lugares.getElemento(i).getNombre();
    		if(busqueda.equals(nombre)) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    public int estaEmpresa(String nombre) {
    	for(int i=0; i<empresas.getNumeroElementos();i++) {
    		String busqueda=empresas.getElemento(i).getNombre();
    		if(busqueda.equals(nombre)) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    public int estaUsuario(String nombre) {
    	for(int i=0; i<usuarios.getNumeroElementos();i++) {
    		String busqueda=usuarios.getElemento(i).getUsuario();
    		if(busqueda.equals(nombre)) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    public void leerLugares(String archivo) {
		try {
			BufferedReader bf= new BufferedReader(new FileReader(archivo));
			String lectura;
			while ((lectura=bf.readLine())!= null) {
				String[] metodo=lectura.split("@");
				if (metodo.length==1) {
					String[] info=metodo[0].split(",");
					int busqueda=estaLugar(info[0]);
					if(busqueda<0){
			        	Municipio miNodo= new Municipio(info[0]);
			            
			            if (info.length>1) {
			            	miNodo.setlatitud(Double.valueOf(info[1]));
			            	miNodo.setlongitud(Double.valueOf(info[2]));
			            }
			            
			            lugares.agregar(miNodo);
			            
			        }
				}else if((metodo.length==2)){
					String[] info=metodo[0].split(",");
					String[] conexiones =metodo[1].split(" ");
					int busqueda=estaLugar(info[0]);
					if(busqueda<0){
						Municipio miNodo= new Municipio(info[0]);
			            if (info.length>1) {
			            	miNodo.setlatitud(Double.valueOf(info[1]));
			            	miNodo.setlongitud(Double.valueOf(info[2]));
			            }
			            lugares.agregar(miNodo);
			            for(int i=0; i<conexiones.length; i++){
			            	String[] sub=conexiones[i].split(",");
			            	int busquedafor=estaLugar(sub[0]);
			                if(busquedafor<0){
			                    Municipio miCo = new Municipio(sub[0]);
			                    
			                    if (sub.length>1) {
			                    	miCo.setlatitud(Double.valueOf(sub[1]));
			                    	miCo.setlongitud(Double.valueOf(sub[2]));
			                    }
			                    
			                    Municipio.conectar(miNodo,miCo);
			                    this.lugares.agregar(miCo);
			                }else{
			                	Municipio.conectar(miNodo,lugares.getElemento(busquedafor));
			                }
			            }
			        }else{
			            for(int i=0; i<conexiones.length; i++){
			            	String[] sub=conexiones[i].split(",");
			            	int busquedafor=estaLugar(sub[0]);
			                if(busquedafor<0){
			                    Municipio miCo = new Municipio(sub[0]);
			                    
			                    if (sub.length>1) {
			                    	miCo.setlatitud(Double.valueOf(sub[1]));
			                    	miCo.setlongitud(Double.valueOf(sub[2]));
			                    }
			                    
			                    Municipio.conectar(lugares.getElemento(busqueda),miCo);
			                    lugares.agregar(miCo);
			                }else{
			                	Municipio.conectar(lugares.getElemento(busqueda),lugares.getElemento(busquedafor));
			                }
			            }
			        }
				}
			}
			bf.close();
			
		}catch(Exception e){
			System.out.println("Error leyendo Municipios");
		}
		
	}
	
	public void guardarLugares(String archivo) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
			String guardar="";
			for (int i=0;i<lugares.getNumeroElementos();i++) {
				String cadena=lugares.getElemento(i).getNombre()+"@";
				for (int j=0;j<lugares.getElemento(i).getNumeroReferencias();j++) {
					cadena=cadena+lugares.getElemento(i).referencias.getElemento(j).getNombre()+" ";
				}
				guardar=guardar+cadena.trim()+"\n";
			 }
			bw.write(guardar);
			bw.close();
			
		}catch(Exception e){
			System.out.println("Error leyendo Municipios");
		}
		
	}
	
	public void leerEmpresas(String archivo) {
		try {
			BufferedReader bf= new BufferedReader(new FileReader(archivo));
			String lectura;
			while((lectura=bf.readLine())!= null) {
				if (estaEmpresa(lectura)<0){
					Empresa miEmpresa=new Empresa(lectura);
					if ((lectura=bf.readLine())!= null) {
						String[] empleados= lectura.split(" ");
						for (int j=0;j<empleados.length;j++) {
							Empleado miEmpleado=new Empleado(empleados[j]);
							miEmpresa.agregarEmpleado(miEmpleado);
						}
					}if ((lectura=bf.readLine())!= null) {
						String[] vehiculos= lectura.split(" ");
						for (int j=0;j<vehiculos.length;j++) {
							Vehiculo miVehiculo=new Vehiculo(vehiculos[j]);
							miEmpresa.agregarVehiculo(miVehiculo);
						}
					}if ((lectura=bf.readLine())!= null) {
						String[] rutas= lectura.split(" ");
						for (int j=0;j<rutas.length;j++) {
							Ruta miRuta=new Ruta(miEmpresa);
							String[] paradas = rutas[j].split("->");
							for (int k=0;k<paradas.length;k++) {
								miRuta.paradas.agregarTail(lugares.getElemento(estaLugar(paradas[k])));
								int  x=estaLugar(paradas[k]);
								lugares.getElemento(x).rutas.agregar(miRuta);
							}
							miRuta.nombrar();
							miEmpresa.rutas.agregar(miRuta);
						}
					}
					empresas.agregar(miEmpresa);
				}
			}
			bf.close();
			
		}catch(Exception e){
			System.out.println("Error leyendo Empresas");
		}
	}
	
	public void guardarEmpresas(String archivo) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
			String guardar="";
			for (int i=0;i<empresas.getNumeroElementos();i++) {
				String cadena=empresas.getElemento(i).getNombre()+"\n";
				for (int j=0;j<empresas.getElemento(i).empleados.getNumeroElementos();j++) {
					cadena=cadena+empresas.getElemento(i).empleados.getElemento(j).getNombresApellidos()+" ";
				}
				cadena=cadena+"\n";
				for (int j=0;j<empresas.getElemento(i).vehiculos.getNumeroElementos();j++) {
					cadena=cadena+empresas.getElemento(i).vehiculos.getElemento(j).getMatricula()+" ";
				}
				cadena=cadena+"\n";
				for (int j=0;j<empresas.getElemento(i).rutas.getNumeroElementos();j++) {
					cadena=cadena+empresas.getElemento(i).rutas.getElemento(j).ruta()+" ";
				}
				guardar=guardar+cadena+"\n";
			}
				
			bw.write(guardar);
			bw.close();
			
		}catch(Exception e){
			System.out.println("Error leyendo Municipios");
		}
		
	}
	
	public void crearDatos(int empresas,int rutas,int empleados, int vehiculos) {
		for (int k=0;k<empresas;k++) {
			Empresa miEmpresa= new Empresa("Empresa N° "+String.valueOf(k+1));
			for (int i=0;i<rutas;i++) {
				Ruta miRuta= new Ruta("ruta "+String.valueOf(i+1),miEmpresa);
				int valor = (int) Math.floor(Math.random()*lugares.getNumeroElementos());
				Municipio p=lugares.getElemento(valor);
				miRuta.paradas.agregarTail(p);
				for (int j=0;j<(int) Math.floor(Math.random()*10+4);j++) {
					int referencia=(int) Math.floor(Math.random()*(p.getNumeroReferencias()));
					if (!miRuta.esta(p.getreferencia(referencia))) {
						miRuta.paradas.agregarTail(p.referencias.getElemento(referencia));
						p=p.referencias.getElemento(referencia);
					}
				}
				miRuta.nombrar();
				miEmpresa.agregarRuta(miRuta);
			}
			for (int i=0;i<empleados;i++) {
				Empleado miEmpleado = new Empleado("empleado"+String.valueOf(i+1));
				miEmpresa.agregarEmpleado(miEmpleado);
			}
			for (int i=0;i<vehiculos;i++) {
				Vehiculo miVehiculo = new Vehiculo("Vehiculo"+String.valueOf(i+1));
				miEmpresa.agregarVehiculo(miVehiculo);
			}
			
			this.empresas.agregar(miEmpresa);
		}
	}
		
	public void buscarRuta(String x,String y) {
		int buscarInicio=estaLugar(x); int buscarFin=estaLugar(y);
		if (buscarInicio>=0 && buscarFin>=0) {
			Municipio inicio=lugares.getElemento(buscarInicio);
			Municipio fin=lugares.getElemento(buscarFin);
			int ofertas=0;
			for (int i=0;i<inicio.rutas.getNumeroElementos();i++) {
				if (inicio.rutas.getElemento(i).esta(fin)) {
					System.out.print("Tomar ruta "+inicio.rutas.getElemento(i).getNombre()+" ofrecida por "+inicio.rutas.getElemento(i).getEmpresa().getNombre()+" en "+x+" hasta "+y+"\n");
					ofertas++;
				}
			}
			if (ofertas<1) {
				System.out.println("no hay ruta directa");
			}else {
				System.out.println();
			}
		}else {
			if (buscarInicio<0 && buscarFin<0) {
				System.out.println("PUNTOS DESCONOCIDOS");
			}else if(buscarInicio<0){
				System.out.println("PUNTO SALIDA DESCONOCIDO");
			}else {
				System.out.println("PUNTO LLEGADA DESCONOCIDO");
			}
			
		}
		
	}
	
	public void agregarLugar() {
		
	}
	
	public void borrarLugar() {
		
	}
	
	public void agregarEmpresa() {
		
	}
	
	public void borrarEmpresa() {
		
	}
	
	
	//imprimir
	public void imprimirLugares() {
		 for (int i=0;i<lugares.getNumeroElementos();i++) {
			 System.out.println((i+1)+" "+lugares.getElemento(i));
		 }
		 System.out.println("Fin");
	 }
	
	public void imprimirLugaresRutas() {
		 for (int i=0;i<lugares.getNumeroElementos();i++) {
			 System.out.println((i+1)+" "+lugares.getElemento(i).getNombre());
			 for (int j=0;j<lugares.getElemento(i).rutas.getNumeroElementos();j++) {
				 System.out.println("\t"+(j+1)+" "+lugares.getElemento(i).rutas.getElemento(j).getNombre());
			 }
		 }
		 System.out.println("Fin");
	 }
	 
	public void imprimirEmpresas() {
		 for (int i=0;i<empresas.getNumeroElementos();i++) {
			 System.out.println((i+1)+" "+empresas.getElemento(i));
		 }
		 System.out.println("Fin");
	 }
	
	
	//interfaz Grafica
	public void iniciar() {
		
	}
	
	public void ejecutar() {
		JFrame frame = new JFrame("TrasCundi");
		frame.setSize(300,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		JButton bienvenido = new JButton("Bienvenido");
		bienvenido.setBounds(150-60, 10, 120, 40);
		panel.add(bienvenido);
		
		JButton botonIr=new JButton("IR");
		botonIr.setBounds(150-40,60, 80, 20);
		panel.add(botonIr);
		
		JOptionPane botonIngresar=new JOptionPane("Ingresar");
		botonIngresar.setBounds(150-40,90, 80, 20);
		panel.add(botonIngresar);
		
		JButton botonIngresar1=new JButton("hhtgbfbfgb");
		botonIngresar1.setBounds(150-40,120, 80, 20);
		panel.add(botonIngresar1);
		
		frame.setVisible(true);
	}
}
