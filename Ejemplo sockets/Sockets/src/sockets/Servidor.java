/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

/**
 *
 * @author yeico
 */
import java.net.*;
import java.io.*;

public class Servidor {
    ServerSocket server;
    Socket socket;
    int puerto = 9000;
    BufferedReader entrada;
    DataOutputStream salida;
    public void iniciar(){
       try{
           server = new ServerSocket(puerto);
           socket = new Socket();
           socket = server.accept();
           
           entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           String mensaje = entrada.readLine();
           System.out.println("lo que recibi: "+mensaje);
           salida = new DataOutputStream(socket.getOutputStream());
           salida.writeUTF("Adios Mundo");
           socket.close();
           
       } catch(Exception e){}
    }
    
    
}
