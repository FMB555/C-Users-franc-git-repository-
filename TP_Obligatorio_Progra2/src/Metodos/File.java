package Metodos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import MecanicasDeAlmacenamiento.DiccionarioMultipleDinamico;

public class File {
	
	private static String NOMBRE_ARCHIVO_DE_CONFIGURACION = "Config.txt";
	private static String PATH_NOMBRE_CARPETA_DE_ARCHIVOS = "\\src\\Archivos\\";
	
	private static void FormatoB(DiccionarioMultipleDinamico diccionario, String[] values, String archivoNombre) {
		if(values.length == 4)	
			diccionario.Agregar(archivoNombre, values[1]);
	}
	
	private static void FormatoA(DiccionarioMultipleDinamico diccionario, String[] values, String archivoNombre) {
		diccionario.Agregar(archivoNombre, values[1]);
	}
	
	private static void AgregarAlDiccionarioConFormato(DiccionarioMultipleDinamico diccionario, String[] values, String formato, String archivoNombre) {
		
		switch(formato) {
			case "A":
				FormatoA(diccionario, values, archivoNombre);
				break;
			case "B":
				FormatoB(diccionario, values, archivoNombre);
				break;
			default:
				System.out.print("Formato no valido, intentalo de nuevo.");
				break;
		}
	}
		
	private static String ObtenerPathDeCarpetaDeArchivos() {
		return System.getProperty("user.dir") + PATH_NOMBRE_CARPETA_DE_ARCHIVOS;
	}
	
	
	private static ArrayList<String> ObtenerListaDeArchivos(){
		ArrayList<String> ListaConNombresDeArchivos = new ArrayList<String>();
		FileReader fr;
		BufferedReader br;
		String path = ObtenerPathDeCarpetaDeArchivos();
		String line = null;

		try
		{
			fr = new FileReader(path + NOMBRE_ARCHIVO_DE_CONFIGURACION);
			br = new BufferedReader(fr);
			
			while ((line = br.readLine()) != null) {
				ListaConNombresDeArchivos.add(line.toString());
			}
		}
		catch (IOException e)
		{
			System.out.print("El archivo de configuracion con al lista de archivos csv no se encontro");
		}
		
		return ListaConNombresDeArchivos;
	}
	
	
	public static void LeerArchvioCSVParaDiccionario(DiccionarioMultipleDinamico diccionario, String archivo, String formato) {
		
		BufferedReader br = null;
		FileReader fr = null;
		String line = null;
		String[] values = null;
		String path = ObtenerPathDeCarpetaDeArchivos();
		
		try {
			fr = new FileReader(path + archivo);
			br = new BufferedReader(fr);
			
			while ((line = br.readLine()) != null) {
		        values = line.split(";");
		        AgregarAlDiccionarioConFormato(diccionario, values, formato, archivo);	        
		    }
			
			br.close();
			
		} catch (IOException e) {
			System.out.print("No se encontro el archivo : " + archivo + "\n");
		}
	}
	
	
	public static DiccionarioMultipleDinamico CargarDiccionario(String formato)  {
		
		DiccionarioMultipleDinamico diccionario = new DiccionarioMultipleDinamico();
		diccionario.InicializarDiccionario();
		
		ArrayList<String> listaDeArchivos;
		String archivo;
		listaDeArchivos = ObtenerListaDeArchivos();
		for(int i = 0; i < listaDeArchivos.size();i++) {
			archivo =  listaDeArchivos.get(i);
			LeerArchvioCSVParaDiccionario(diccionario , archivo, formato);
		}
		
		return diccionario;
	}
	
	public static void LeerArchvioCSVParaPorcentaje(String archivo) {
		
		BufferedReader br = null;
		FileReader fr = null;
		String line = null;
		String[] values = null;
		String path = ObtenerPathDeCarpetaDeArchivos();
		
		try {
			fr = new FileReader(path + archivo);
			br = new BufferedReader(fr);
			
			int cantEstaciones = 0;
			int cantEstacionesConTransferencia = 0;
			
			while ((line = br.readLine()) != null) {
		        values = line.split(";");  
		        
		        if(values.length == 4) {
		        	cantEstacionesConTransferencia++;
		        }
		        
		        cantEstaciones++;
		    }

			float porcentaje = ((float)cantEstacionesConTransferencia/(float)cantEstaciones)*100;
			System.out.println("La linea " + archivo + " tiene un " + (int)porcentaje + 
								"% de estaciones con estaciones de transferencia");
			
			br.close();
			
		} catch (IOException e) {
			System.out.print("No se encontro el archivo : " + archivo + "\n");
		}
	}
	
	//2-b
	public static void MostrarPorcentajeEstacionesConTransferencia() {
		ArrayList<String> listaDeArchivos;
		String archivo;
		listaDeArchivos = ObtenerListaDeArchivos();
		for(int i = 0; i < listaDeArchivos.size();i++) {
			archivo =  listaDeArchivos.get(i);
			LeerArchvioCSVParaPorcentaje(archivo);
		}
	}
	
}
