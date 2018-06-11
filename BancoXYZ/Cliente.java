package BancoXYZ;
/* Creacion de una clase para cliente quien se comunica con el servidor 
 del BancoXYZ */

import java.net.*;
import java.io.*;

/**

 * @author luadrusi
 *
 */

public class Cliente {
	public static void main(String[] args) throws IOException {
		Socket socketCliente = null;
		BufferedReader entrada = null;
		PrintWriter salida = null;
		/*Creacion de un socket cliente, conectado con el servidor que 
		 * previamente esta a la escucha, en el 
		 * mismo equipo por el puerto 4444 
		 */
		try {
			//Se le indica al cliente con que direccion conectarse
			socketCliente = new Socket("local host", 57884);
			//Establecemos canal de entrada
			entrada = new BufferedReader(new 
					InputStreamReader(socketCliente.getInputStream()));
			//Establecemos canal de salida
			salida = new PrintWriter(new BufferedWriter(new 
					OutputStreamWriter(socketCliente.getOutputStream())), true);
		} catch (IOException e) {
			System.err.println("Negativo establecer canales de E/S para esta conexion");
			System.exit(-1);
		}
		BufferedReader stdIn = new BufferedReader(new 
				InputStreamReader(System.in));
		String linea;
		
		try {
			while (true){
				//Leer entrada usuario
				linea = stdIn.readLine();
				//Envia al servidor
				salida.println(linea);
				linea = entrada.readLine();
				System.out.println("El servidor recibio un" + linea);
				if (linea.equals("Adios"))
				break;
			}
		} catch (IOException e) {
			System.out.println("IOExceptio " + e.getMessage());
		}
	}
			
}
