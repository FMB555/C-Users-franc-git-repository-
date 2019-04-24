package App;

import MecanicasDeAlmacenamiento.DiccionarioMultipleDinamico;
import Metodos.File;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiccionarioMultipleDinamico diccionario = File.CargarDiccionario("B");
		diccionario.Imprimir();
		
		//2-a
		for(int i=0; i<diccionario.cantClaves; i++) {
			int cantEstaciones = 0;
			for(int j=0; j<=diccionario.elementos[i].cantValores; j++) {
				cantEstaciones++;
			}
			
			System.out.println("La linea " + diccionario.elementos[i].clave + " tiene " +
								cantEstaciones + " estaciones");
		}
		System.out.println();
		
		//2-b
		File.MostrarPorcentajeEstacionesConTransferencia();
	}

}
