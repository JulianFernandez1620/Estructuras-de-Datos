package estructuras;

public class DiccionarioDinamico<T,E> {
	private Object[][] lista;
	private int numeroElementos=0;
	
	public DiccionarioDinamico() {
		lista = new Object[10][2];
	}
	
	public DiccionarioDinamico(int x) {
		lista = new Object[x][2];
	}
	
	//getters
		public Object[][] getLista() {
			return lista;
		}
	
		public int getNumeroElementos() {
			return numeroElementos;
		}
	
		public int getLen() {
			return lista.length;
		}
		
		@SuppressWarnings("unchecked")
		public E getValor(T t) {
			for (int i=0; i<numeroElementos;i++) {
				if (lista[i][0]==t) {
					return (E)lista[i][1];
				}
			}
			return null;
		}
		
	//setters
		public void setLista(Object[][] lista) {
			this.lista = lista;
		}
		
		public void setValor(int x,E e) {
			if (x<0){throw new RuntimeException("accediendo a indice Negativo");}
			else if(x>=lista.length) {throw new RuntimeException("accediendo a indice fuera de rango");}
			lista[x][1]=e;
		}
		
		public void setValor(T t,E e) {
			for (int i=0;i<numeroElementos; i++) {
				if (lista[i][0]==t) {
					lista[i][1]=e;	
				}else if(lista[i][0]==null) {
					break;
				}
			}
		}
	
	public void expandir() {
		Object[][] suplente= new Object[lista.length*2][2];
		System.arraycopy(lista, 0, suplente, 0, lista.length);
		lista=suplente;
	}	
		
	public void ajustarNulos() {
		if (numeroElementos<lista.length) {
		Object[][] suplente= new Object[numeroElementos][2];
		System.arraycopy(lista, 0, suplente, 0, numeroElementos);
		lista=suplente;
		}
	}
	
	public void agregar(T t,E e) {
		if (numeroElementos>=lista.length){expandir();}
		if(!contieneLlave(t)) {
			lista[numeroElementos][0]=t;
			lista[numeroElementos][1]=e;
			numeroElementos++;
		}
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
				if (lista[i][0]==x) {
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
					 if(lista[i][0]==x) {
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
	
	public boolean contieneLlave(T t) {
		for (int i=0; i<numeroElementos;i++) {
			if (lista[i][0]==t) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contieneValor(E e) {
		for (int i=0; i<numeroElementos;i++) {
			if (lista[i][1]==e) {
				return true;
			}
		}
		return false;
	}
	
	public Object[] getElemento(int x) {
		if (x<0){throw new RuntimeException("accediendo a indice Negativo");}
		else if(x>=lista.length) {throw new RuntimeException("accediendo a indice fuera de rango");}
		return lista[x];
	}
	
	public int getIndice(Object[] x) {
		for(int i=0;i<lista.length;i++) {
			if (lista[i]==x) {return i;}
			else if(lista[i]==null) {break;}
		}
		return -1;
	}
	
	public String toString(){
		String cadena="";
		for (int i=0; i<numeroElementos;i++) {
			cadena= cadena+String.valueOf(lista[i][0])+":"+String.valueOf(lista[i][1])+",";
		}
		if (numeroElementos<lista.length) {
			cadena=cadena+"| "+((lista.length)-numeroElementos)+" espacio/s null";
		}
		return cadena;
	}
	
	public static void main(String[] args) {
		Diccionario<String,Integer> x= new Diccionario<String , Integer>(4);
		x.agregar("primero", 1);
		x.agregar("segundo", 2);
		x.agregar("tercero", 3);
		System.out.println(x.getLen());
		System.out.println(x.contieneValor(6));
	}
}
