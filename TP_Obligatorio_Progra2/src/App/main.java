package App;

import MecanicasDeAlmacenamiento.ConjuntoEstatico;
import MecanicasDeAlmacenamiento.DiccionarioMultipleDinamico;
import Metodos.File;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiccionarioMultipleDinamico dicionario = File.CargarDiccionario("B");
		dicionario.Imprimir();
	}

}
