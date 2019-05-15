package App;

import MecanicasDeAlmacenamiento.DiccionarioMultipleDinamico;
import Metodos.File;

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
		System.out.print(" \n\n\n");
		diccionarioCombinaciones.Imprimir();
	}

}
