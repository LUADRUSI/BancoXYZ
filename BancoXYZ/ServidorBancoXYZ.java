package BancoXYZ;

import java.net.*;
import java.io.*;

/**
 * 
 * @author luadrusi
 *
 */
public class ServidorBancoXYZ {
	
	//Establecer puerto de escucha buscar el puerto correpondiente eje 57884
	public static final int Port = 57884;
	public static void main(String[] args) throws IOException {
		ServerSocket socketServidor = null;
		
	// En caso que no se conecte al servidor
		try { socketServidor = new ServerSocket(Port);
		} catch (IOException e) {
			System.out.println("Negativo para escucha puerto =" + Port);
			System.exit(-1);
		}	
			
	// Se inician las variables	en caso de conexion exitosa
		Socket socketCliente = null;
		BufferedReader entrada = null;
		PrintWriter salida = null;
		
		System.out.println("A la escucha de " + socketCliente);
		try {
			//Bloqueado hasta recivir peticion del cliente
			socketCliente = socketServidor.accept();
			System.out.println("Conectado con " + socketCliente);
			//Se establece canal de entrada
			entrada = new BufferedReader(new 
					InputStreamReader(socketCliente.getInputStream()));
			//Aqui se incorporan las clases para conectar a la BD y metodos
			//Invocando metodos o clases despues de terminar la transaccion
			//Se establece canal de salida
			salida = new PrintWriter(new BufferedWriter(new 
					OutputStreamWriter(socketCliente.getOutputStream())), true);
			
			//Mantener la comunicacion abierta hasta que el cliente indique terminado
			//en este caso adios
			while (true){
				String str = entrada.readLine();
				System.out.println("Cliente " + str);
				salida.println(str);
				if (str.equals("Adios"))
					System.out.println("Peticion de terminar recibida");
					break;
			}
		} catch (IOException e) {
				System.out.println("IOExceptio " + e.getMessage());
		}
		salida.close();
		entrada.close();
		
	}
}
