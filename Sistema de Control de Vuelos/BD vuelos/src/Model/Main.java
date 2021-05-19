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
    private Aeropuerto aeropuerto=new Aeropuerto();
   
    public Main(){
        Json.leerJSON(aeropuerto);
    }
    
    public static void main(String[] args){
        Main main= new Main();
        main.aeropuerto.sortVuelos();
        main.aeropuerto.printVuelos();
        System.out.println("-------------------------------------------------------------------------\n");
        main.aeropuerto.printPistas();
        System.out.println("-------------------------------------------------------------------------\n");
        main.aeropuerto.printPuertas();
        System.out.println("-------------------------------------------------------------------------\n");
        ClienteVuelos cliente= new ClienteVuelos();
        Thread hilo = new Thread(cliente);
        hilo.start();
    }
}
