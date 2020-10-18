package estructuras;

public class ListaDinamica<T> {
	private Object[] lista;
	private int numeroElementos=0;
	

	
	public ListaDinamica() {
		lista = new Object[10];
	}
	
	public ListaDinamica(int x) {
		lista = new Object[x];
	}
	
	public void setLista(Object[] lista) {
		this.lista = lista;
	}

	public Object[] getLista() {
		return lista;
	}

	public int getLen() {
		return lista.length;
	}
	
	public int getNumeroElementos() {
		return numeroElementos;
	}

	public void expandir() {
		Object[] suplente= new Object[lista.length*2];
		System.arraycopy(lista, 0, suplente, 0, lista.length);
		lista=suplente;
	}
	
	public void recortarNulos() {
		if (numeroElementos<lista.length) {
		Object[] suplente= new Object[numeroElementos];
		System.arraycopy(lista, 0, suplente, 0, numeroElementos);
		lista=suplente;
		}
	}
	
	
	public void agregar(T o) {
		if (numeroElementos>=lista.length){expandir();}
		lista[numeroElementos]=o;
		numeroElementos++;
	}
	
	public void eliminar(int x) {
		if (x<0 || x>=numeroElementos) {throw new RuntimeException("eliminarOrdenado indice menor a 0");}
		if (x==numeroElementos-1) {
			numeroElementos--;
		}else{
			lista[x]=lista[numeroElementos-1];numeroElementos--;
		}
	}
	
	public void eliminar(T x) {
		if (x!=lista[numeroElementos-1]) {
			for (int i=0;i<numeroElementos-1;i++) {
				if (lista[i]==x) {
					eliminar(i);
				}
			}
		}else {
			numeroElementos--;
		}
	}
	
	public void eliminarOrdenado(int x) {
		if (x<0 || x>=numeroElementos) {throw new RuntimeException("eliminarOrdenado indice menor a 0");}
		if (x==numeroElementos-1) {
			numeroElementos--;
		}else {
			for (int i=x;i<numeroElementos-1;i++) {
				lista[i]=lista[i+1];
			}
			numeroElementos--;
		}
	}
	
	public void eliminarOrdenado(T x) {
		if (x==lista[numeroElementos-1]) {
			numeroElementos--;
		}else {
			boolean borrado=false;
			for (int i=0;i<numeroElementos-1;i++) {
				if (!borrado) {
					 if(lista[i]==x) {
						borrado=true;
						lista[i]=lista[i+1];
					 }
				}else{
					lista[i]=lista[i+1];
				}
			}
			numeroElementos--;
		}
	}
	
	@SuppressWarnings("unchecked")
	public T getElemento(int x) {
		if (x<0){throw new RuntimeException("accediendo a indice Negativo");}
		else if(x>=lista.length) {throw new RuntimeException("accediendo a indice fuera de rango");}
		return (T)lista[x];
	}
	
	public int getIndice(T x) {
		for(int i=0;i<lista.length;i++) {
			if (lista[i]==x) {return i;}
			else if(lista[i]==null) {break;}
		}
		return -1;
	}
	
	public void setElemento(int x,T dato) {
		if (x<0){throw new RuntimeException("accediendo a indice Negativo");}
		else if(x>=lista.length) {throw new RuntimeException("accediendo a indice fuera de rango");}
		lista[x]=dato;
	}
	
	public String toString(){
		String cadena="";
		for (int i=0; i<numeroElementos;i++) {
			cadena= cadena+lista[i]+" ";
		}
		if (numeroElementos<lista.length-1) {
			cadena=cadena+"| "+((lista.length-1)-numeroElementos)+" espacio/s null";
		}
		return cadena;
	}
	
	public static void main(String[] args) {
		ListaDinamica<Integer> lista = new ListaDinamica<Integer>();
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		lista.agregar(4);
		lista.agregar(5);
		lista.agregar(6);
		lista.agregar(7);
		lista.agregar(8);
		lista.agregar(9);
		System.out.println(lista.getLen());
		System.out.println(lista);
		lista.eliminar(3);
		System.out.println(lista.getLen());
		System.out.println(lista);
		lista.recortarNulos();
		System.out.println(lista.getLen());
		System.out.println(lista);
	}
	
	
	
	
}
