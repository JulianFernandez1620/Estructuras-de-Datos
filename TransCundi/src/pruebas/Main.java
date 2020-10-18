package pruebas;

import transcundi.Departamento;

public class Main {

	public static void main(String[] args) {
		Departamento mapa= new Departamento(120);
		mapa.leerLugares("C:\\Users\\juanp\\Desktop\\Programacion Diego\\Trabajos\\TransCundi\\Txt\\CopiaMunicipios.txt");
		mapa.leerEmpresas("C:\\Users\\juanp\\Desktop\\Programacion Diego\\Trabajos\\TransCundi\\Txt\\Empresas.txt");
		mapa.guardarLugares("C:\\Users\\juanp\\Desktop\\Programacion Diego\\Trabajos\\TransCundi\\Txt\\CopiaMunicipios.txt");
		mapa.guardarEmpresas("C:\\Users\\juanp\\Desktop\\Programacion Diego\\Trabajos\\TransCundi\\Txt\\Empresas.txt");
		mapa.ejecutar();
	}
}
	