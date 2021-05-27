/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Meih55
 */
public class Aeropuerto {
    public ArrayList<Vuelo> vuelos=new ArrayList<>();
    public ArrayList<Puerta> puertas=new ArrayList<>();
    public ArrayList<Pista> pistas=new ArrayList<>();

    public void printVuelos(){
        for(int i=0;i<vuelos.size();i++){
            System.out.println("\n Vuelo "+i+" : "+vuelos.get(i).toString());
        }
    }

    public void printPistas(){
        for(int i=0;i<pistas.size();i++){
            System.out.println("\n "+pistas.get(i).toString());
        }
    }

    public void setVuelos(ArrayList<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }
    
    public void printPuertas(){
        for(int i=0;i<puertas.size();i++){
            System.out.println("\n "+puertas.get(i).toString());
        }
    }
    
    public void sortVuelos(){
       Collections.sort(vuelos);
    }
    
}
