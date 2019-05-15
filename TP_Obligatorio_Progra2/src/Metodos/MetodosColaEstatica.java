package Metodos;

import Api.ConjuntoTDA;
import Implementacion.Estatico.ConjuntoEstatico;

public class MetodosColaEstatica {
	
	public static ConjuntoTDA CrearCopia(ConjuntoTDA conjuntoOriginal) {
		ConjuntoTDA conjuntoCopia = new ConjuntoEstatico();
		conjuntoCopia.InicializarConjunto();
		
		ConjuntoTDA conjuntoAux = new ConjuntoEstatico();
		conjuntoAux.InicializarConjunto();
		
		String elemAux;
		
		while(!conjuntoOriginal.ConjuntoVacio()) {
			elemAux = conjuntoOriginal.Elegir();
			conjuntoOriginal.Sacar(elemAux);
			conjuntoAux.Agregar(elemAux);
		}
		
		while(!conjuntoAux.ConjuntoVacio()) {
			elemAux = conjuntoAux.Elegir();
			conjuntoAux.Sacar(elemAux);
			conjuntoOriginal.Agregar(elemAux);
			conjuntoCopia.Agregar(elemAux);
		}
		
		return conjuntoCopia;
	}
	
	
}
