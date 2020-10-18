package estructuras;

class Pila<T> {
    private static final int N = 10;
    private Object[] array;
    private int top;
    
    
	public Pila(){
    	array = new Object[N];
        top=0;
    }
    public Pila(int n){
        array = new Object[n];
        top=0;
    }
    
    public int getLen() {
		return array.length;
	}
    
    public int getCapacidad() {
		return array.length-top;
	}
    
    public boolean empty(){
        return top<=0;
        }
    public boolean full(){
        return top>=array.length;
    }
    
    @SuppressWarnings("unchecked")
	public T pop (){
        if (empty()){throw new RuntimeException("la pila est� vacia");}
        top --;return (T)array[top];
    }
    public void push (T num){
        if (full()){throw new RuntimeException("la pila est� llena");}
        array[top]= num;top++;
    }
    
    public Object peek (){
        if (empty()){throw new RuntimeException("la pila est� vacia");}
        return array[top-1];
    }
    public String toString(){
    	String cadena="TOP:"+String.valueOf(peek())+"\nTOP";
		for (int i=top-1;i>=0;i--) {
			cadena=cadena+"->"+array[i];
		}
		return cadena;
		 
	}
    
    public static void main(String[] args){
    	Pila<Integer> pila= new Pila<>(3);
    	pila.push(3);
    	pila.push(2);
    	pila.push(1);
    	System.out.println(pila);
    }
	
}
