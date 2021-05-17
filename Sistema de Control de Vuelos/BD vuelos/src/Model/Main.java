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
        ClienteVuelos cliente= new ClienteVuelos();
        Thread hilo = new Thread(cliente);
        hilo.start();
    }
}
