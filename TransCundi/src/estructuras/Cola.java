package estructuras;

class Cola<T> {
    private static final int N = 10;
    private Object[] array;
    private int top;
    private int tail;
    private int elementos;
    
    public Cola(){
    	array = new Object[N];
    	top=0;tail=0;elementos=0;
    }
    
    public Cola(int n){
    	array = new Object[n];
    	top=0;tail=0;elementos=0;
    }

    public int getLen() {
		return array.length;
	}

    public int getCapacidad() {
		return array.length-elementos;
	}
    
    public boolean empty(){
        return elementos<=0;
    }
    
    public boolean full(){
        return elementos>=array.length;
    }

    public void encolar(T num){
        if (full()){throw new RuntimeException("la cola está llena");}
        array[tail]= num; tail=(tail+1)%array.length;  elementos++;
    }

    @SuppressWarnings("unchecked")
	public T desencolar(){
        if (empty()){throw new RuntimeException("la cola está vacia");}
        int indice =top; elementos--; top=(top+1)%array.length; return (T)array[indice];
    }
    @SuppressWarnings("unchecked")
	public T peekHead(){
        if (empty()){throw new RuntimeException("la cola está vacia");}
        return (T)array[top];
    }

    @SuppressWarnings("unchecked")
	public T peekTail(){
        if (empty()){throw new RuntimeException("la ola está vacia");}
        return (T)array[(array.length-tail-1)];
    }
    
    public String toString(){
    	String cadena="TOP:"+String.valueOf(peekHead())+" COLA:"+String.valueOf(peekTail())+"\n"+"TOP";
		for (int i=0;i<elementos;i++) {
			cadena=cadena+"->"+array[(top+i)%array.length];
		}
		return cadena=cadena+"->COLA";
		 
	}
    
    public static void main(String[] args){
    	Cola<Integer> miEstructura= new Cola<>(8);
    	miEstructura.encolar(1);
    	miEstructura.encolar(2);
    	miEstructura.encolar(3);
    	miEstructura.encolar(4);
    	miEstructura.encolar(5);
    	miEstructura.encolar(6);
    	miEstructura.encolar(7);
    	miEstructura.encolar(8);
    	System.out.println(miEstructura);
    	miEstructura.desencolar();
    	miEstructura.desencolar();
    	System.out.println(miEstructura);
    }
}
