/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketclient;

/**
 *
 * @author yeico
 */

import java.net.*;
import java.io.*;
public class Cliente {
    Socket cliente;
    int puerto = 9000;
    String ip = "127.0.0.1";
    BufferedReader entrada, teclado;
    PrintStream salida;
    public void iniciar(){
       try{
           cliente = new Socket(ip,puerto);
           entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream())); 
           teclado = new BufferedReader(new InputStreamReader(System.in));
           String tec = teclado.readLine();
           salida = new PrintStream(cliente.getOutputStream());
           salida.println("ESTO FUE LO QUE ENVIE: " + tec);
           String msg = entrada.readLine();
           System.out.println("ESTO FUE LO QUE RECIBI: " + msg);
           entrada.close();
           salida.close();
           teclado.close();
           cliente.close(); 
       } catch(Exception e){}
    }
    
    
}
