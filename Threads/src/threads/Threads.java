/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author Meih55
 */
public class Threads{
    private Aeropuerto aeropuerto=new Aeropuerto();
    
    public Threads(){
        Json.leerJSON(aeropuerto);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        int n=8;
//        for(int i=0;i<n;i++){
//            Thread obj= new Thread(new thread());
//            obj.start();
//        }
        Threads thread=new Threads();
        thread.aeropuerto.printVuelos();
        System.out.println("-------------------------------------------------------------------------\n");
        thread.aeropuerto.initPistas();
        thread.aeropuerto.initPuertas();
        thread.aeropuerto.printPistas();
        System.out.println("-------------------------------------------------------------------------\n");
        thread.aeropuerto.printPuertas();
        System.out.println("-------------------------------------------------------------------------\n");
        
    }
    


    
}
