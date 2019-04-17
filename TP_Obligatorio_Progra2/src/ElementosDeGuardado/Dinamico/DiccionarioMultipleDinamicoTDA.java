package ElementosDeGuardado.Dinamico;

import ElementoDeGuardado.Estatico.ConjuntoTDA;

public interface DiccionarioMultipleDinamicoTDA {
	void InicializarDiccionario(); 
	void Agregar(String clave , String valor); 
	void Eliminar(String clave); 
	void EliminarValor(String clave , String valor);
	ConjuntoTDA Recuperar(String clave); 
	ConjuntoTDA Claves(); 
}
