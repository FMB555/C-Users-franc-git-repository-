package Api;

public interface ABBTDA {
	void inicializarArbol();
	int raiz();
	ABBTDA hijoIzq();
	ABBTDA hijoDer();
	boolean arbolVacio();
	void Agregar(int x);
}
