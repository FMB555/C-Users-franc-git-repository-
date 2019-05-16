package Metodos;

import Api.ConjuntoTDA;
import Api.DiccionarioMultipleDinamicoTDA;


public class Ejercicio2C {
	
	
	public void Ej_2_C(DiccionarioMultipleDinamicoTDA diccionarioEstaciones) {
		ConjuntoTDA claves = diccionarioEstaciones.Claves();
		ConjuntoTDA clavesRestantes;
		ConjuntoTDA valores;
		String clave;
		String valorAux;
		while(!claves.ConjuntoVacio()) {
			clave = claves.Elegir();
			claves.Sacar(clave);
			valores = diccionarioEstaciones.Recuperar(clave);
			clavesRestantes = MetodosColaEstatica.CrearCopia(claves);
			while(!valores.ConjuntoVacio()) {
				
				valorAux = valores.Elegir();
				valores.Sacar(valorAux);
				if(Repetido2(valorAux, clavesRestantes, diccionarioEstaciones))
					System.out.print(clave + " " + valorAux + "\n" );
			}
		}
		return;
	
	}
	
	public static boolean Repetido2(String valor, ConjuntoTDA conjuntoClavesRestantes, DiccionarioMultipleDinamicoTDA diccionarioEstaciones) {
		String claveAux, valorAux;
		ConjuntoTDA valores;
		while(!conjuntoClavesRestantes.ConjuntoVacio()) {
			claveAux = conjuntoClavesRestantes.Elegir();
			conjuntoClavesRestantes.Sacar(claveAux);
			
			valores = diccionarioEstaciones.Recuperar(claveAux);
			
			while(!valores.ConjuntoVacio()) {
				valorAux = valores.Elegir();
				valores.Sacar(valorAux);
				if(valor.compareTo(valorAux) != 0) {
					return true;
				}
			}
			
		}
		
		return false;
	} 
	
	public static boolean Repetido(String valor, ConjuntoTDA conjuntoClavesRestantes, DiccionarioMultipleDinamicoTDA diccionarioEstaciones) {
		String clave;
		ConjuntoTDA valores;
		while(!conjuntoClavesRestantes.ConjuntoVacio()) {
			clave = conjuntoClavesRestantes.Elegir();
			conjuntoClavesRestantes.Sacar(clave);
			valores = diccionarioEstaciones.Recuperar(clave);
			if(Pertenece(valor, valores)) {
				return true;
			}
		}
		return false;
	}
	
	
	public static boolean Pertenece(String valor, ConjuntoTDA valores) {
		boolean pertenece = false;
	/*	String valorAux;
		valor = valor.replace(" ","");
		while(!valores.ConjuntoVacio()) {
			valorAux = valores.Elegir();
			valores.Sacar(valorAux);
			valorAux = valorAux.replace(" ","");
			if(valorAux.compareTo(valor) == 0) {
				pertenece = true;
				break;
			}
		}*/
		pertenece = valores.Pertenece(valor);
		System.out.print(valor + " " + pertenece + "\n");
		return pertenece;  //pertenece;
	}
	
}
