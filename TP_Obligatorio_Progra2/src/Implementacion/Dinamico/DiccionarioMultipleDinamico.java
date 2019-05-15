package Implementacion.Dinamico;

import Api.ConjuntoTDA;
import Api.DiccionarioMultipleDinamicoTDA;
import Implementacion.Estatico.ConjuntoEstatico;

public class DiccionarioMultipleDinamico implements DiccionarioMultipleDinamicoTDA{
	class Elemento{
		String clave;
		String[] valores;
		int cantValores;
	}
	Elemento[] elementos; 
	int cantClaves;
	public void InicializarDiccionario() {
		elementos = new Elemento[100]; 
		cantClaves = 0; 
	}
	public void Agregar(String archivoNombre , String values){ 
		int posC = ClaveIndice(archivoNombre);
		if(this.Pertenece(archivoNombre, values)) {
			if (posC==-1) { 
				posC = cantClaves; 
				elementos[posC]= new Elemento(); 
				elementos[posC].clave = archivoNombre; 
				elementos[posC].cantValores = 0; 
				elementos[posC].valores = new String [100]; 
				cantClaves++; 
			}
			Elemento e = elementos[posC]; 
			int posV = ValorIndice(e, values); 
			if (posV==-1) { 
				e.valores[e.cantValores] = values;
				e.cantValores++; 
			}
		}
	}
	
	private boolean Pertenece(String archivoNombre , String values) {
		ConjuntoTDA valoresExistente = this.Recuperar(archivoNombre);	
		return !valoresExistente.Pertenece(values);
		
	}
	
	private int ClaveIndice(String clave){ 
		int i = cantClaves-1; 	
		while(i>=0 && elementos[i].clave!=clave) {
			i--;  
		}
		return i;
	}
	public void Eliminar(String clave) { 
		int pos = ClaveIndice(clave); 
		if (pos!=-1) { 
			elementos[pos] = elementos[cantClaves -1]; 
			cantClaves--; 
		}
	}
	private int ValorIndice(Elemento e, String values) { 
		int i = e.cantValores -1; 
		while(i>=0 && e.valores[i]!=values) {
			i--; 
		}
		return i;
	}
	public void EliminarValor(String clave , String valor) { 
		int posC = ClaveIndice(clave); 
		
		if (posC!=-1) { 
			Elemento e = elementos[posC ]; 
			int posV = ValorIndice(e, valor);
			if (posV !=-1) { 
				e.valores[posV] = e.valores[e.cantValores -1]; 
				e.cantValores--;  
				if (e.cantValores==0) { 
					Eliminar(clave); 
				} 
			}
		}
	}
	public ConjuntoTDA Recuperar(String clave) { 
		ConjuntoTDA c= new ConjuntoEstatico(); 
		c.InicializarConjunto();
		int pos = ClaveIndice(clave); 
		if (pos!=-1) { 
			Elemento e= elementos[pos]; 
			for(int i=0; i<e.cantValores; i++){
				c.Agregar(e.valores[i]);
				} 
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

	public void Imprimir() {
		int i = 0;
		while(i < this.cantClaves) {
			System.out.print(this.elementos[i].clave + ": \n");
			for(int j = 0; j < this.elementos[i].cantValores; j++) {
				System.out.print(this.elementos[i].valores[j] + "\n");
			}
			i++;
			System.out.print("\n");
		}
	}

}
