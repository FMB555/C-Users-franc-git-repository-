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
	
	public void Agregar(String clave , String valor){ 
		int posc = this.ClaveIndice(clave);
		if(posc == this.cantClaves) {
			this.elementos[posc] = new Elemento();
			this.elementos[posc].clave = clave;
			this.elementos[posc].valores = new String [100];
			this.elementos[posc].valores[0] = valor;
			this.elementos[posc].cantValores = 1;
			this.cantClaves++;
		}
		int j;	
		for(j=0; j < this.elementos[posc].cantValores && this.elementos[posc].valores[j].compareTo(valor) != 0; j++);
			if(j == this.elementos[posc].cantValores) {
				this.elementos[posc].valores[j] = valor;
				this.elementos[posc].cantValores++;
			}
	}
	

	private int ClaveIndice(String clave){ 
		int i = 0 ;  	
		 while(i< this.cantClaves && elementos[i].clave.compareTo(clave) != 0) {
			i++;  
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

