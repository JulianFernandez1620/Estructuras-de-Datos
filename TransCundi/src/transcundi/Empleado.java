package transcundi;

public class Empleado {
	private String documentoIdentidad;
	private Imagen imagendocumentoIdentidad;
	private String identificacionEmpresa;
	private Imagen imagendoidentificacionEmpresa;
	private String nombresApellidos;
	private String numeroCelular;
	private Vehiculo vehiculo;
	
	public Empleado(String nombresApellidos) {
		this.nombresApellidos = nombresApellidos;
	}

	//getters
		public String getDocumentoIdentidad() {
			return documentoIdentidad;
		}
	
		public Imagen getImagendocumentoIdentidad() {
			return imagendocumentoIdentidad;
		}
	
		public String getIdentificacionEmpresa() {
			return identificacionEmpresa;
		}
	
		public Imagen getImagendoidentificacionEmpresa() {
			return imagendoidentificacionEmpresa;
		}
	
		public String getNombresApellidos() {
			return nombresApellidos;
		}
	
		public String getNumeroCelular() {
			return numeroCelular;
		}
	
		public Vehiculo getVehiculo() {
			return vehiculo;
		}

		//setters
		public void setDocumentoIdentidad(String documentoIdentidad) {
			this.documentoIdentidad = documentoIdentidad;
		}

		public void setImagendocumentoIdentidad(Imagen imagendocumentoIdentidad) {
			this.imagendocumentoIdentidad = imagendocumentoIdentidad;
		}

		public void setIdentificacionEmpresa(String identificacionEmpresa) {
			this.identificacionEmpresa = identificacionEmpresa;
		}

		public void setImagendoidentificacionEmpresa(Imagen imagendoidentificacionEmpresa) {
			this.imagendoidentificacionEmpresa = imagendoidentificacionEmpresa;
		}

		public void setNombresApellidos(String nombresApellidos) {
			this.nombresApellidos = nombresApellidos;
		}

		public void setNumeroCelular(String numeroCelular) {
			this.numeroCelular = numeroCelular;
		}

		public void setVehiculo(Vehiculo vehiculo) {
			this.vehiculo = vehiculo;
		}

	@Override
    public String toString() {
        return nombresApellidos+"-"+documentoIdentidad;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documentoIdentidad == null) ? 0 : documentoIdentidad.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (documentoIdentidad == null) {
			if (other.documentoIdentidad != null)
				return false;
		} else if (!documentoIdentidad.equals(other.documentoIdentidad))
			return false;
		return true;
	}
	
	
}
