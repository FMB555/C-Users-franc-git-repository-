package Metodos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Implementacion.Dinamico.DiccionarioMultipleDinamico;

public class File {
	
	private static String NOMBRE_ARCHIVO_DE_CONFIGURACION = "Config.txt";
	private static String PATH_NOMBRE_CARPETA_DE_ARCHIVOS = "\\src\\Archivos\\";
	
	static class Elem{
		String nombreArchivo;
		String nombreDato;
	}

	public static void CargarDiccionario(DiccionarioMultipleDinamico diccionarioEstaciones, DiccionarioMultipleDinamico diccionarioCombinaciones)  {
		
	
		
		ArrayList<Elem> listaDeArchivos;
		Elem archivo;
		listaDeArchivos = ObtenerListaDeArchivos();
		for(int i = 0; i < listaDeArchivos.size();i++) {
			archivo =  listaDeArchivos.get(i);
			LeerArchvioCSV(diccionarioEstaciones, diccionarioCombinaciones, archivo);
		}

	}
	
		
	private static String ObtenerPathDeCarpetaDeArchivos() {
		return System.getProperty("user.dir") + PATH_NOMBRE_CARPETA_DE_ARCHIVOS;
	}
	
	
	private static ArrayList<Elem> ObtenerListaDeArchivos(){
		ArrayList<Elem> ListaConNombresDeArchivos = new ArrayList<Elem>();
		Elem aux;
		String [] values;
		FileReader fr;
		BufferedReader br;
		String path = ObtenerPathDeCarpetaDeArchivos();
		String line = null;

		try
		{
			fr = new FileReader(path + NOMBRE_ARCHIVO_DE_CONFIGURACION);
			br = new BufferedReader(fr);
			
			while ((line = br.readLine()) != null) {
				values = line.split(";");
				aux = new Elem();
				aux.nombreArchivo = values[0];
				aux.nombreDato = values[1];
				ListaConNombresDeArchivos.add(aux);
			}
		}
		catch (IOException e)
		{
			System.out.print("El archivo de configuracion con al lista de archivos csv no se encontro");
		}
		
		return ListaConNombresDeArchivos;
	}
	
	
	public static void LeerArchvioCSV(DiccionarioMultipleDinamico diccionarioEstaciones, DiccionarioMultipleDinamico diccionarioCombinaciones, Elem archivo) {
		
		BufferedReader br = null;
		FileReader fr = null;
		String line = null;
		String[] values = null;
		String path = ObtenerPathDeCarpetaDeArchivos();
		
		try {
			fr = new FileReader(path + archivo.nombreArchivo);
			br = new BufferedReader(fr);
			
			while ((line = br.readLine()) != null) {
		        values = line.split(";");
		        AgregarAlDiccionarioConFormato(diccionarioEstaciones, diccionarioCombinaciones, values, archivo);	        
		    }
			
			br.close();
			
		} catch (IOException e) {
			System.out.print("No se encontro el archivo : " + archivo + "\n");
		}
	}
	
	private static void AgregarAlDiccionarioConFormato(DiccionarioMultipleDinamico diccionarioEstaciones, DiccionarioMultipleDinamico diccionarioCombinaciones, String[] values, Elem archivo) {
		
		if(values.length != 0) {
				FormatoEstacion(diccionarioEstaciones, values, archivo.nombreDato);
			if(values.length == 4) 
				FormatoCombinacion(diccionarioCombinaciones, values, archivo.nombreDato);
		}
		
	}
	
	private static void FormatoCombinacion(DiccionarioMultipleDinamico diccionario, String[] values, String nombre) {
		String clave = values[3];
		diccionario.Agregar(values[1], nombre);
		diccionario.Agregar(values[1], values[2]);
		diccionario.Agregar(values[3], nombre);
		diccionario.Agregar(values[3], values[2]);
	}
	
	private static void FormatoEstacion(DiccionarioMultipleDinamico diccionario, String[] values, String nombre) {
		diccionario.Agregar(nombre, values[1]);
	}
}
