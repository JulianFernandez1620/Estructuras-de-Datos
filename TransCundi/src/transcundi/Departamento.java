package transcundi;

import java.io.*;
import java.util.Scanner;

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
    
    public Departamento(int x,int y){
        this.lugares = new ListaDinamica<Municipio>(x);
        this.empresas = new ListaDinamica<Empresa>(y);
        //this.cantidad = 10;
    }
    
    
    
    
    public ListaDinamica<Municipio> getLugares() {
		return lugares;
	}
    

	public ListaDinamica<Empresa> getEmpresas() {
		return empresas;
	}

	public ListaDinamica<Usuario> getUsuarios() {
		return usuarios;
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
					cadena=cadena+lugares.getElemento(i).referencias.getElemento(j).getMunicipio().getNombre()+" ";
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
								String[] subRuta= paradas[k].split(",");
								int  x=estaLugar(subRuta[0]);
								miRuta.paradas.agregarTail(new SubRuta(lugares.getElemento(x),Integer.parseInt(subRuta[1]),Integer.parseInt(subRuta[2]),Integer.parseInt(subRuta[3])));
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
					cadena=cadena+empresas.getElemento(i).rutas.getElemento(j).informacionDeRuta()+" ";
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
			Empresa miEmpresa= new Empresa("ronda1 Empresa N° "+String.valueOf(k+1));
			for (int i=0;i<rutas;i++) {
				Ruta miRuta= new Ruta("ruta "+String.valueOf(i+1),miEmpresa);
				int valor = (int) Math.floor(Math.random()*lugares.getNumeroElementos());
				SubRuta p=new SubRuta(lugares.getElemento(valor));
				miRuta.paradas.agregarTail(p);
				for (int j=0;j<(int) Math.floor(Math.random()*10+4);j++) {
					int referencia=(int) Math.floor(Math.random()*(p.getMunicipio().getNumeroReferencias()));
					if (!miRuta.esta(p.getMunicipio().referencias.getElemento(referencia).getMunicipio())) {
						miRuta.paradas.agregarTail(new SubRuta(p.getMunicipio().referencias.getElemento(referencia).getMunicipio(),(int) Math.floor(Math.random()*1000+100)+p.getCosto(),p.getTiempo()+p.getMunicipio().referencias.getElemento(referencia).getTiempo(),p.getDistancia()+p.getMunicipio().referencias.getElemento(referencia).getDistancia()));
						p=miRuta.paradas.getTailDato();
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
		if(buscarInicio<0) {
			if (estaLugar(x.toUpperCase())>=0) {
				buscarInicio=estaLugar(x.toUpperCase());
				x=x.toUpperCase();
			}else if(estaLugar(x.toLowerCase())>=0) {
				buscarInicio=estaLugar(x.toLowerCase());
				x=x.toLowerCase();
			}
		}if(buscarFin<0) {
			if (estaLugar(y.toUpperCase())>=0) {
				buscarFin=estaLugar(y.toUpperCase());
				y=y.toUpperCase();
			}else if(estaLugar(y.toLowerCase())>=0) {
				buscarFin=estaLugar(y.toLowerCase());
				y=y.toLowerCase();
			}
		}
		if (buscarInicio>=0 && buscarFin>=0) {
			Municipio inicio=lugares.getElemento(buscarInicio);
			Municipio fin=lugares.getElemento(buscarFin);
			int conteo = 0;
			Ruta costo=null;Ruta tiempo=null;Ruta distancia=null;
			for (int i=0;i<inicio.rutas.getNumeroElementos();i++) {
				Ruta miRuta=inicio.rutas.getElemento(i).esta(inicio,fin);
				if (miRuta!=null) {
					conteo++;
					if(costo == null) {
						costo=miRuta;
						tiempo=miRuta;
						distancia=miRuta;
					}else{
						//System.out.print("comparando costo: "+costo.paradas.getTailDato().getCosto());System.out.println(">"+miRuta.paradas.getTailDato().getCosto());
						//System.out.print("comparando tiempo: "+tiempo.paradas.getTailDato().getTiempo());System.out.println(">"+miRuta.paradas.getTailDato().getDistancia());
						//System.out.print("comparando distancia: "+distancia.paradas.getTailDato().getDistancia());System.out.println(">"+miRuta.paradas.getTailDato().getDistancia());
						if(costo.paradas.getTailDato().getCosto()>miRuta.paradas.getTailDato().getCosto()) {
							costo=miRuta;
						}else if(tiempo.paradas.getTailDato().getTiempo()>miRuta.paradas.getTailDato().getTiempo()) {
							tiempo=miRuta;
						}else if(distancia.paradas.getTailDato().getDistancia()>miRuta.paradas.getTailDato().getDistancia()) {
							distancia=miRuta;
						}
					}
				}
			}
			if (costo==null) {
				System.out.println("no hay ruta");
			}else {
				System.out.println("Buscando Rutas de "+x+" a "+y+"\n");
				System.out.println("Ruta de menor costo:\n"+costo.getEmpresa().getNombre()+" "+costo.getNombre()+"\t$"+costo.paradas.getTailDato().getCosto()+" pesos");
				System.out.println(costo.paradas()+"\n");
				System.out.println("Ruta de menor tiempo:\n"+tiempo.getEmpresa().getNombre()+" "+tiempo.getNombre()+"\t"+tiempo.paradas.getTailDato().getTiempo()+" minutos");
				System.out.println(tiempo.paradas()+"\n");
				System.out.println("Ruta de menor distancia:\n"+distancia.getEmpresa().getNombre()+" "+distancia.getNombre()+"\t"+distancia.paradas.getTailDato().getDistancia()+" km");
				System.out.println(distancia.paradas()+"\n");
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
		System.out.println("1.\tConsultar Ruta\n2.\tIngresar Usuario\n\n3.\tCerrar");
		try {
			Scanner leer=new Scanner(System.in);
			String x=leer.nextLine();
			while(!x.equals("1") && !x.equals("2") && !x.equals("3")) {
				x=leer.nextLine();
			}
			if (x.equals("1")) {
				System.out.println("Ingresar salida:");
				String salida=leer.nextLine();
				System.out.println("Ingresar Destino:");
				String destino=leer.nextLine();
				buscarRuta(salida,destino);
			}else if(x.equals("2")) {
				
			}else if(x.equals("3")) {
				return;
			}
		}finally {
			
		}
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
