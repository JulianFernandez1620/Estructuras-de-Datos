package estructuras;

public class ListaEnlazada<T> {
	private Nodo<T> head=null;
	private Nodo<T> tail=null;
	private int len=0;
	
	public ListaEnlazada() {
	}
	
	public int getLen() {
		return len;
	}
	
	public Nodo<T> getHead() {
		return head;
	}

	public Nodo<T> getTail() {
		return tail;
	}
	
	public T getHeadDato() {
		return head.dato;
	}

	public T getTailDato() {
		return tail.dato;
	}

	public void agregarHead(T x) {
		len++;
		if (len==1) {
			head=new Nodo<T>(x);
		}else {
			Nodo<T> parcial = new Nodo<T>(x);
			parcial.next=head;
			head=parcial;
		}
	}
	
	public void agregarTail(T x) {
		len++;
		if (len==1){
			head=new Nodo<T>(x);
		}else if (len==2){
			head.next=new Nodo<T>(x);
			tail=head.next;
		}else {
			tail.next = new Nodo<T>(x);
			tail=tail.next;
		}
	}
	
	public void agregarPosicion(T dato, int posicion) {
		if (posicion<0){throw new RuntimeException("Error agregando posicion, Posicion Negativa");}
		if (posicion>=len){throw new RuntimeException("Error agregando posicion, posicion mayor a len");}
		len++;
		if (posicion==1){
			agregarHead(dato);
		}else if (posicion==len-1){
			agregarTail(dato);
		}else {
			Nodo<T> headNueva=head;
			for(int i=0;i<posicion-1;i++) {
				head=head.next;
			}
	        Nodo<T> micopia = head.next; 
	        Nodo<T> miNodo = new Nodo<T>(dato);
	        head.next=miNodo;
	        miNodo.next=micopia;
	        head=headNueva;
		}
		
	}
	
	public void eliminar(T x) {
		if (len<0){throw new RuntimeException("lista Enlazada Vacia");}
		Nodo<T> headNueva=head;
		if (headNueva.dato==x) {eliminarHead();}
		for(int i=1;i<len-1;i++) {
			if(headNueva.next.dato==x && i==len-2) {
				eliminarTail();
			}else if(headNueva.next.dato==x){
				headNueva.next=headNueva.next.next;
			}
			headNueva = headNueva.next;
        }
	}
	
	public void eliminarHead() {
		if (len<0){throw new RuntimeException("lista Enlazada Vacia");}
		if (len==1) {
			head=null;
		}else if(len==2){
			head=head.next;
			tail=null;
		}else {
			head=head.next;
		}
		len--;
	}
	
	public void eliminarTail() {
		if (len==0){throw new RuntimeException("lista Enlazada Vacia");}
		if(len==1){
			head=null;
		}else if(len==2){
			head.next=null;
			tail=null;
		}else {
			Nodo<T> headNueva=head;
			for(int i=0;i<len-2;i++) {
				head = head.next;
	        }
	        Nodo<T> micopia=head.next;micopia=micopia.next;
	        head.next=null;
	        tail=head;
	        head=headNueva;
	            
        }
		len--;
	}
	
	public void eliminarPosicion(int posicion) {
		if (posicion<0){throw new RuntimeException("Error eliminando posicion, Posicion negativa");}
		if (posicion>=len){throw new RuntimeException("Error eliminando posicion, posicion mayor a longitud de ListaEnlazada");}
		if (posicion==0){
			eliminarHead();
		}else if (posicion==len-1){
			eliminarTail();
		}else {
			Nodo<T> headNueva=head;
			for(int i=0;i<posicion-1;i++) {
				head = head.next;
			}
	        Nodo<T> micopia=head.next;micopia=micopia.next;
	        head.next=micopia;
	        head=headNueva;
		}
		len--;
	}
	
	public void imprimirListaEnlazada() {
		Nodo<T> headNueva=head;
		for (int i=0;i<len;i++) {
			System.out.println(headNueva);
			headNueva=headNueva.next;
		}
	}
	
	public String toString() {
		String cadena="";
		Nodo<T> headNueva=head;
		for (int i=0;i<len;i++) {
			cadena=cadena+headNueva+" ";
			headNueva=headNueva.next;
		}
		return cadena.trim(); 
	}
	
	public static void main(String[] args){
    	ListaEnlazada<Integer> miEstructura= new ListaEnlazada<>();
    	miEstructura.agregarHead(1);
    	miEstructura.agregarTail(2);
    	miEstructura.agregarTail(3);
    	System.out.println("len: "+miEstructura.getLen());
    	System.out.println(miEstructura);
    }
	
}
