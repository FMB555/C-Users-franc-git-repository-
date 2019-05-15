package Implementacion.Estatico;

import Api.ABBTDA;

public class ABB implements ABBTDA {

	class nodo{
		int dato;
		ABBTDA izq, der;
	}
	nodo primero;
	
	@Override
	public void inicializarArbol() {
		// TODO Auto-generated method stub
		primero = null;
	}

	@Override
	public int raiz() {
		// TODO Auto-generated method stub
		return this.primero.dato;
	}

	@Override
	public ABBTDA hijoIzq() {
		// TODO Auto-generated method stub
		return this.primero.izq;
	}

	@Override
	public ABBTDA hijoDer() {
		// TODO Auto-generated method stub
		return this.primero.der;
	}

	@Override
	public boolean arbolVacio() {
		// TODO Auto-generated method stub
		return this.primero == null;
	}

	@Override
	public void Agregar(int x) {
		// TODO Auto-generated method stub
		if(this.arbolVacio()) {
			nodo nuevo = new nodo();
			nuevo.dato = x;
			nuevo.izq = new ABB();
			nuevo.izq.inicializarArbol();
			nuevo.der = new ABB();
			nuevo.der.inicializarArbol();
			primero = nuevo;
		}
		else if (this.primero.dato > x) {
			this.primero.izq.Agregar(x);
		}
		else {
			this.primero.der.Agregar(x);
		}
	}

}
