package MecanicasDeAlmacenamiento;

import ElementoDeGuardado.Estatico.ConjuntoTDA;

public class ConjuntoEstatico implements ConjuntoTDA{
	private int[] vector;
	private int ultimo;
	public void InicializarConjunto() {
		ultimo = 0;
		vector = new int[100];
	}
	public void Agregar(int x) {
		if (!this.Pertenece(x)) {
			vector[ultimo] = x;
			ultimo++;
		}
	}
	public boolean ConjuntoVacio() {
		return ultimo == 0;
	}
	public boolean Pertenece(int x) {
		int i = 0;
		while (i < ultimo && vector[i]!= x) {
			i++;
		}
		return i < ultimo;
	}
	public int Elegir() {
		return vector[ultimo - 1];
	}
	public void Sacar(int x) {
		int i = 0;
		while(i<ultimo && vector[i]!= x) {
			i++;
		}
		if (i < ultimo) {
			vector[i] = vector[ultimo - 1];
			ultimo--;
		}
	}
}
