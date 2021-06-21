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
public class Main {

    
    public static void main(String[] args){
        Aeropuerto aeropuerto = new Aeropuerto();
        Json.leerJSON(aeropuerto);
        aeropuerto.sortVuelos();
        /*System.out.println(aeropuerto.getVuelos());
        System.out.println("-------------------------------------------------------------------------\n");
            System.out.println(aeropuerto.getPistas());
        System.out.println("-------------------------------------------------------------------------\n");
        System.out.println(aeropuerto.getPuertas());
        System.out.println("-------------------------------------------------------------------------\n");*/
        ClienteVuelos cliente= new ClienteVuelos(aeropuerto);
        Thread hilo = new Thread(cliente);
        hilo.start();
    }
}
