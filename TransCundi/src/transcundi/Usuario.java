package transcundi;

public class Usuario<T> {
	private String usuario;
	private String contrase�a;
	private T referencia;
	
	public String getUsuario() {
		return usuario;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public T getReferencia() {
		return referencia;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public void setReferencia(T referencia) {
		this.referencia = referencia;
	}
	@Override
	public String toString() {
		return (String)referencia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((referencia == null) ? 0 : referencia.hashCode());
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario<T> other = (Usuario<T>) obj;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		return true;
	}
	
	
	
}
