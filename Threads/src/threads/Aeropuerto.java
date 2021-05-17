/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.ArrayList;

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

    public void initPuertas(){
        for(int i=0;i<20;i++){
            Puerta e= new Puerta(i,0);
            puertas.add(e);
        }
    }
    
    public void initPistas(){
        for(int i=0;i<20;i++){
            Pista e= new Pista(i,0);
            pistas.add(e);
        }
    }
    
    public void printPistas(){
        for(int i=0;i<pistas.size();i++){
            System.out.println("\n Pista "+i+" : "+pistas.get(i).toString());
        }
    }
    
    public void printPuertas(){
        for(int i=0;i<puertas.size();i++){
            System.out.println("\n Puerta "+i+" : "+puertas.get(i).toString());
        }
    }
    
}
