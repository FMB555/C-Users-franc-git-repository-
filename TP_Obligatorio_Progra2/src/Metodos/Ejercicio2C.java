package Metodos;

import Api.ConjuntoTDA;
import Api.DiccionarioMultipleDinamicoTDA;
import Implementacion.Dinamico.DiccionarioMultipleDinamico;
import Implementacion.Estatico.ConjuntoEstatico;

public class Ejercicio2C {
	
	
	public void Ej_2_C(DiccionarioMultipleDinamicoTDA diccionarioEstaciones) {
		
		DiccionarioMultipleDinamicoTDA diccionario = new DiccionarioMultipleDinamico();
		diccionario.InicializarDiccionario();
		
		ConjuntoTDA conjuntoClaves = diccionarioEstaciones.Claves();
		ConjuntoTDA conjuntoValores;
		
		String claveAux, valorAux;
		
		
		while(!conjuntoClaves.ConjuntoVacio()) {
			claveAux = conjuntoClaves.Elegir();
			conjuntoClaves.Sacar(claveAux);
			conjuntoValores = diccionarioEstaciones.Recuperar(claveAux);
			while(!conjuntoValores.ConjuntoVacio()) {
				valorAux = conjuntoValores.Elegir();
				conjuntoValores.Sacar(valorAux);
				diccionario.Agregar(valorAux, claveAux);
			}
		}
		diccionario.Imprimir();
	}
	
}
