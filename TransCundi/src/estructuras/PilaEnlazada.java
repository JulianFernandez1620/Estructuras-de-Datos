package estructuras;

public class PilaEnlazada<T> {
	private Nodo<T> top=null;
	private int len=0;
	private int aviso;private boolean bool=false;
	
	
	public PilaEnlazada() {}
	
	public PilaEnlazada(int x) {
		aviso=x;
		bool=true;
	}
	
	public int getLen() {
		return len;
	}
	
	public boolean empty(){
        return len<=0;
        }
	
	public boolean aviso() {
		if (bool) {if (!(aviso>len)){System.out.println("Espacio en memoria excedido");return true;}}
		return false;
	}

	public void push(T x) {
		aviso();
		len++;
		if (len==1) {
			top=new Nodo<T>(x);
		}else {
			Nodo<T> parcial = new Nodo<T>(x);
			parcial.next=top;
			top=parcial;
		}
	}
	
	public T pop() {
		if (empty()){throw new RuntimeException("la pila está vacia");}
		if (len==1) {
			Nodo<T> parcial = top;
			top=null;len--;
			return parcial.dato;
		}else{
			Nodo<T> parcial = top;
			top=top.next;len--;
			return parcial.dato;
		}
		
	}
	
	public T peek() {
		if (empty()){throw new RuntimeException("la pila está vacia");}
		return top.dato;
	}
	
	public String toString() {
		String cadena="TOP:"+String.valueOf(peek())+"\nTOP";
		Nodo<T> headNueva=top;
		for (int i=0;i<len;i++) {
			cadena=cadena+"->"+headNueva;
			headNueva=headNueva.next;
		}
		return cadena;
	}
	
	public static void main(String[] args){
    	PilaEnlazada<Integer> miEstructura= new PilaEnlazada<>();
    	miEstructura.push(2);
    	miEstructura.push(1);
    	miEstructura.push(4);
    	System.out.println(miEstructura);
    	
    	
    }
}
