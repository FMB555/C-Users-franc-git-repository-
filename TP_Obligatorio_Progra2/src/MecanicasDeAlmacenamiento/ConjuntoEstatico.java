package MecanicasDeAlmacenamiento;

import ElementoDeGuardado.Estatico.ConjuntoTDA;

public class ConjuntoEstatico implements ConjuntoTDA{
	private String[] vector;
	private int ultimo;
	public void InicializarConjunto() {
		ultimo = 0;
		vector = new String[100];
	}
	public void Agregar(String x) {
		if (!this.Pertenece(x)) {
			vector[ultimo] = x;
			ultimo++;
		}
	}
	public boolean ConjuntoVacio() {
		return ultimo == 0;
	}
	public boolean Pertenece(String x) {
		int i = 0;
		while (i < ultimo && vector[i]!= x) {
			i++;
		}
		return i < ultimo;
	}
	public String Elegir() {
		return vector[ultimo - 1];
	}
	public void Sacar(String x) {
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
