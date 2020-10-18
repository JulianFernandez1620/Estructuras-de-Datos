package estructuras;

public class ColaEnlazada<T> {
	private Nodo<T> top;
    private Nodo<T> tail;
    private int len=0;
	private int aviso;private boolean bool=false;
	
	public ColaEnlazada() {}
	
	public ColaEnlazada(int x) {
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

	public void encolar(T x) {
		aviso();
		if (len==0) {
			top=new Nodo<T>(x);
		}else if (len==1) {
			Nodo<T> parcial = new Nodo<T>(x);
			top.next=parcial;
			tail=parcial;
		}else {
			Nodo<T> parcial = new Nodo<T>(x);
			tail.next=parcial;
			tail=parcial;
		}
		len++;
	}
	
	public T desencolar() {
		if (empty()){throw new RuntimeException("la cola está vacia");}
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
	
	public T peekHead() {
		if (empty()){throw new RuntimeException("la cola está vacia");}
		return top.dato;
	}
	
	public T peekTail() {
		if (empty()){throw new RuntimeException("la cola está vacia");}
		else if(len==1) {
			return top.dato;
		}
		return tail.dato;
	}
	
	public String toString() {
		String cadena="TOP:"+String.valueOf(peekHead())+" COLA:"+String.valueOf(peekTail())+"\n"+"TOP";
		Nodo<T> headNueva=top;
		for (int i=0;i<len;i++) {
			cadena=cadena+"->"+headNueva;
			headNueva=headNueva.next;
		}
		return cadena=cadena+"->COLA";
	}
	
	public static void main(String[] args){
		ColaEnlazada<Integer> miEstructura= new ColaEnlazada<>(8);
    	miEstructura.encolar(1);
    	miEstructura.encolar(1);
    	miEstructura.encolar(1);
    	miEstructura.encolar(1);
    	miEstructura.encolar(1);
    	System.out.println(miEstructura);
    }
    
}
