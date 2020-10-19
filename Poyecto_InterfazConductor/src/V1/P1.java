package V1;
import java.util.*;
import javax.swing.JOptionPane;


public class P1 {
	 public static void main(String args[] ) {
		
		Scanner in = new Scanner(System.in);
		String opcion=JOptionPane.showInputDialog(" Bienvenido, somos Transcundi ® Ingrese 1 si es conductor, Ingrese 2 si es un usuario.");
		

		Conductor[] misConductores= new Conductor[7]; 
		misConductores[0]=new Conductor("Paco Gómez","001","contra");
		misConductores[1]=new Conductor("Ana López","002","contra");
		misConductores[2]=new Conductor("María Martín","003","contra");
		misConductores[3]=new Conductor("Anonio Fernández","004","contra");
		misConductores[5]=new Conductor("María Hernández","005","contra");
		misConductores[6]=new Conductor("Mario Rodriguez","006","contra");
		
		if(opcion.equals("1")){
			String usuario=JOptionPane.showInputDialog("Ingrese su Usuario");
			String contrase=JOptionPane.showInputDialog("Ingrese su contraseña");
			int i=0;
			
			while(!misConductores[i].ConfContra(usuario, contrase)&&i<7) {
				i++;
			}
			if(i>=7)
				System.out.println("Contraseña o Usuarios incorrectos");
			else {
				String vehi=JOptionPane.showInputDialog("¿Desea ingresar un nuevo vehiculo? (si/no)");
					if(vehi.equalsIgnoreCase("si")) {
						String placa = JOptionPane.showInputDialog("Ingrese placa del vehiculo");
						String asientos = JOptionPane.showInputDialog("Ingrese el número de asientos");
						String empresa = JOptionPane.showInputDialog("Ingrese el nombre de la empresa del vehiculo");
						int ASIENTOS= Integer.parseInt(asientos);
						Vehiculo vehiculo = new Vehiculo(ASIENTOS, placa, empresa);
						System.out.println("Ingrese 1 si hay pasajeros que bajan, ingrese 2 si hay pasajeros que suben, ingrese 3 para salir");
					    while(in.hasNext()){
				            String s = in.next();
				            int num= Integer.parseInt(s);
				            if (num==1) {
				            	String pas=JOptionPane.showInputDialog("¿Cuántos pasajeros se bajarán?");
				            	vehiculo.Bajar(Integer.parseInt(pas));				            	
				            }
				            else if (num==2) {
				            	String pas1=JOptionPane.showInputDialog("¿Cuántos pasajeros se subirán?");
				            	vehiculo.Subir(Integer.parseInt(pas1));				            	
				            }
				            else {
				            	
				            System.out.println("Tenga un buen día");
				            }
				        }	
					}														
				}		
		}
		else if(opcion.equals("2"))
			System.out.println("Bienvenido Usuario");
		else
			System.out.println("Opción incorrecta");
		in.close();
	 }
	 
}

class Conductor{
	private String NombreConductor;
	private String NombredUsuario;
	private String ClaveUsua;
	
	public Conductor(String nombrec,String usuarioCond, String contras) {
		this.ClaveUsua=contras;
		this.NombreConductor=nombrec;
		this.NombredUsuario=usuarioCond;
	}
	
	public boolean ConfContra(String usua, String Contra) {	
		boolean Confirm=false;
		
		if (ClaveUsua.equals(Contra)&&NombredUsuario.equalsIgnoreCase(usua)) {
			Confirm=true;
			System.out.println("Bienvenido "+NombreConductor);
		}
		else
			Confirm=false;
		return Confirm;
	}	
}

class Vehiculo{
	
	private String placa;
	private int asientos;
	private String empresa;
	private IntStack Pilap = new IntStack(100);

	
	public Vehiculo(int as, String pl, String emp) {
		this.placa=pl;
		this.asientos=as;	
		this.empresa=emp;	
		//IntStack Pilap = new IntStack(asientos);
	}
	
	public void Bajar(int b) {
		if(!Pilap.empty()) { 
			
			for(int i=0; i<=b; i++) {
				if(!Pilap.empty())  
					Pilap.pop();
				else
					System.out.println("El vehiculo está vacío");
			}
			System.out.println("El vehiculo con placas "+placa+" de la empresa "+empresa +" tiene: " +(asientos-1-Pilap.peek())+" asientos disponibles");	
		
		}
		else {
			System.out.println("El vehiculo está vacío");
		}
	}
	
	public void Subir(int s) {
		for(int i=0; i<s; i++) {
			if(Pilap.empty())
				Pilap.push(1);
			else
				Pilap.push(Pilap.peek()+1);
			}
		System.out.println("El vehiculo con placas "+placa+" de la empresa "+empresa +" tiene: " +(asientos-Pilap.peek())+" asientos disponibles");		
		}
	
}


class IntStack {
    
    private int top;
    private  int sarray [];
    
    public IntStack(int n){ 
        
        top=0;
        sarray=new int [n];    
    }    
    public void  push (int item){
        if(full())
            throw new RuntimeException ("Stack is full");
        sarray[top]=item;
        top++;    
    } 
    public int pop() {
        if (empty())
            throw new RuntimeException ("Stack is empty");
            top--;
            return sarray[top];
    }  
    public boolean full() {
        return top>=sarray.length;
    }
    
    public boolean empty() {
        return top<=0;
    }
    
     public int peek() {
        if (empty())
            throw new RuntimeException ("Stack is empty");  
        return sarray[(top)-1];
}
        public int size() {
        return top;
    }
}

