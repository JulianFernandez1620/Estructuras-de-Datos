package estructuras;

public class Nodo<T> {
	public T dato;
	public Nodo<T> next=null;
	
	public Nodo(T dato) {
		this.dato=dato;
	}

	public String toString() {
		return String.valueOf(dato);
	}
	
}