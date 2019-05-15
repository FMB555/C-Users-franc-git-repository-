package Api;

public interface ConjuntoTDA {
	void InicializarConjunto();
	String Elegir();
	void Sacar(String x);
	void Agregar(String x);
	boolean ConjuntoVacio();
	boolean Pertenece(String x);
}
