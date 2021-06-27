/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author yeico
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.DefaultCaret;


public class ClienteVuelos implements Runnable{
    //Declaramos las variables necesarias para la conexion y comunicacion
    private Socket cliente;
    private DataInputStream in;
    private DataOutputStream out;
    //El puerto debe ser el mismo en el que escucha el servidor
    private int puerto = 2027;
    //Si estamos en nuestra misma maquina usamos localhost si no la ip de la maquina servidor
    private String host = "localhost";
    private String mensaje = "";
    Aeropuerto aeropuerto;
    ArrayList<String> tiempos = new ArrayList<>(Arrays.asList("00:00","01:00","02:00","03:00","04:00"
    ,"05:00","06:00","07:00","08:00","09:00","10:00","11:00","12:00","13:00"
    ,"14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00"
    ,"23:00"));
    String tiempo = "00:00";
    boolean bandera = true;
    //Constructor recibe como parametro el panel donde se mostraran los mensajes
    public ClienteVuelos(Aeropuerto a){
        aeropuerto = a;
        try {
            cliente = new Socket(host,puerto);
            in = new DataInputStream(cliente.getInputStream());
            out = new DataOutputStream(cliente.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void run() {
        int k = 0;
        try{
            //Ciclo infinito que escucha por mensajes del servidor y los muestra en el panel
            while(bandera){
                mensaje = in.readUTF();
                String[] listaMensaje = mensaje.split("-");
                //System.out.println(mensaje);
                //System.out.println(listaMensaje[1]);
                if ("000".equals(listaMensaje[0])) {
                    mensaje = "001-";
                    for (int i = 0; i < aeropuerto.vuelos.size(); i++) {
                        mensaje+=aeropuerto.vuelos.get(i).toString();
                    }
                    this.enviarMsg(mensaje);
                }
                if ("00".equals(listaMensaje[0])) {
                    mensaje = "";
                    if(k>23){
                        k=0;
                        bandera=false;
                    }
                    tiempo = tiempos.get(k);
                    k+=1;
                    if(aeropuerto.notificarVuelo(tiempo)){
                        ArrayList<Vuelo> listaVuelos = aeropuerto.enListarVuelos(tiempo);
                        for (int i = 0; i < listaVuelos.size(); i++) {
                            mensaje += listaVuelos.get(i).toString() + ";";
                        }
                        this.enviarMsg("01-"+mensaje); //si hay un vuelo proximo a aterrizar
                        this.enviarMsg("444-"+tiempo);
                        
                    }
                    else{
                        this.enviarMsg("02-No hay vuelos proximos a aterrizar."); 
                        this.enviarMsg("444-"+tiempo);
                    }
                    //pistas y puertas lo maneje servidor y el ventana controlador le pide a el
                }
                TimeUnit.SECONDS.sleep(6);
               
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Funcion sirve para enviar mensajes al servidor
    public void enviarMsg(String msg){
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
