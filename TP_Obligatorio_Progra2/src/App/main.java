package App;

import Implementacion.Dinamico.DiccionarioMultipleDinamico;
import Metodos.File;
import Metodos.Ejercicio2C;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DiccionarioMultipleDinamico dicionarioEstaciones = null, diccionarioCombinaciones = null;
		
		dicionarioEstaciones = new DiccionarioMultipleDinamico();
		dicionarioEstaciones.InicializarDiccionario();
		
		diccionarioCombinaciones = new DiccionarioMultipleDinamico();
		diccionarioCombinaciones.InicializarDiccionario();
		
		File.CargarDiccionario(dicionarioEstaciones, diccionarioCombinaciones);
		dicionarioEstaciones.Imprimir();
		System.out.print(" ARRANCA EL SIGUIENTE DICCIONARIO\n\n\n");
		diccionarioCombinaciones.Imprimir();
		
		Ejercicio2C algo = new Ejercicio2C();
		algo.Ej_2_C(dicionarioEstaciones);
		
		
		
	}

}
