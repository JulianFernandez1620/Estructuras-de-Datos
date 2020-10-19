package transcundi;

import java.util.Scanner;

public class Vehiculo {
	private String matricula;
	private String modelo;
	private Imagen soat;
	private Imagen tecnoMecanica;
	private Imagen seguro;
	private int capacidad = 10;
	private boolean ocupado = false;
	private ParadaEmpresa ubicacion;
	
	public Vehiculo(String matricula) {
		this.matricula = matricula;
	}
	
	//getters
		
		public String getMatricula() {
			return matricula;
		}
		public ParadaEmpresa getUnbicacion() {
			return ubicacion;
		}

		public void setUnbicacion(ParadaEmpresa unbicacion) {
			this.ubicacion = unbicacion;
		}

		public String getModelo() {
			return modelo;
		}
		public Imagen getSoat() {
			return soat;
		}
		public Imagen getTecnoMecanica() {
			return tecnoMecanica;
		}
		public Imagen getSeguro() {
			return seguro;
		}
		
		public void setCapacidad(int capacidad) {
			this.capacidad = capacidad;
		}

		//setters
		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		public void setSoat(Imagen soat) {
			this.soat = soat;
		}
		public void setTecnoMecanica(Imagen tecnoMecanica) {
			this.tecnoMecanica = tecnoMecanica;
		}
		public void setSeguro(Imagen seguro) {
			this.seguro = seguro;
		}
		
		public int getCapacidad() {
			return capacidad;
		}
		
		public boolean isOcupado() {
			return ocupado;
		}

		public void setOcupado() {
			this.ocupado = !ocupado;
		}

		public void pregunta() {
			
		}
		@Override
		public String toString() {
			return matricula+" ocupado:"+String.valueOf(ocupado)+ " capacidad:"+String.valueOf(capacidad)+ " ubicacion:";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
			Vehiculo other = (Vehiculo) obj;
			if (matricula == null) {
				if (other.matricula != null)
					return false;
			} else if (!matricula.equals(other.matricula))
				return false;
			return true;
		}
		
		
}
