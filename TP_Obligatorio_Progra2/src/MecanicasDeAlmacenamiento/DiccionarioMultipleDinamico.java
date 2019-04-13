package MecanicasDeAlmacenamiento;

import ElementoDeGuardado.Estatico.ConjuntoTDA;
import ElementosDeGuardado.Dinamico.DiccionarioMultipleDinamicoTDA;

public class DiccionarioMultipleDinamico implements DiccionarioMultipleDinamicoTDA{
	class Elemento{
		int clave;
		int[] valores;
		int cantValores;
	}
	Elemento[] elementos; 
	int cantClaves;
	public void InicializarDiccionario() {
		elementos = new Elemento[100]; 
		cantClaves = 0; 
	}
	public void Agregar(int clave , int valor){ 
		int posC = Clave2Indice(clave);
		if (posC==-1) { 
			posC = cantClaves; 
			elementos[posC]= new Elemento(); 
			elementos[posC].clave = clave; 
			elementos[posC].cantValores = 0; 
			elementos[posC].valores = new int [100]; 
			cantClaves++; 
		}
		Elemento e = elementos[posC]; 
		int posV = Valor2Indice(e, valor); 
		if (posV==-1) { 
			e.valores[e.cantValores] = valor;
			e.cantValores++; 
		}
	}
	private int Clave2Indice(int clave){ 
		int i = cantClaves-1; 	
		while(i>=0 && elementos[i].clave!=clave) {
			i--;  
		}
		return i;
	}
	public void Eliminar(int clave) { 
		int pos = Clave2Indice(clave); 
		if (pos!=-1) { 
			elementos[pos] = elementos[cantClaves -1]; 
			cantClaves--; 
		}
	}
	private int Valor2Indice(Elemento e, int valor) { 
		int i = e.cantValores -1; 
		while(i>=0 && e.valores[i]!=valor) {
			i--; 
		}
		return i;
	}
	public void EliminarValor(int clave , int valor) { 
		int posC = Clave2Indice(clave); 
		
		if (posC!=-1) { 
			Elemento e = elementos[posC ]; 
			int posV = Valor2Indice(e, valor);
			if (posV !=-1) { 
				e.valores[posV] = e.valores[e.cantValores -1]; 
				e.cantValores--;  
				if (e.cantValores==0) { 
					Eliminar(clave); 
				} 
			}
		}
	}
	public ConjuntoTDA Recuperar(int clave) { 
		ConjuntoTDA c= new ConjuntoEstatico(); 
		c.InicializarConjunto();
		int pos = Clave2Indice(clave); 
		if (pos!=-1) { 
			Elemento e= elementos[pos]; 
			for(int i=0; i<e.cantValores; i++){
				c.Agregar(e.valores[i]); } 
			} 
		return c;
	}
	public ConjuntoTDA Claves() { 
		ConjuntoTDA c= new ConjuntoEstatico(); 
		c.InicializarConjunto();
		for( int i=0; i<cantClaves; i++){ 
			c.Agregar(elementos[i].clave); 
			} 
		return c;
	} 
}
