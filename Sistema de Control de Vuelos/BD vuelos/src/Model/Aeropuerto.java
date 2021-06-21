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
    
    

    public String getVuelos(){
        String var="";
        for(int i=0;i<vuelos.size();i++){
            var+="\n Vuelo "+i+" : "+vuelos.get(i).toString();
        }
        return var;
    }


    public void setVuelos(ArrayList<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }
    
    
    
    public void sortVuelos(){
       Collections.sort(vuelos);
    }
    
    public boolean notificarVuelo(String relojTiempo){
        for (int i = 0; i < vuelos.size(); i++) {
            if(vuelos.get(i).tiempo.equals(relojTiempo)){
                return true; //requiere aterrizar crear lista de aviones
            } 
        }
        return false; //ningun avion requiere aterrizar
    }
    public ArrayList<Vuelo> enListarVuelos(String relojTiempo){
        ArrayList<Vuelo> lista = new ArrayList<>();
        for (int i = 0; i < vuelos.size(); i++) {
            if(vuelos.get(i).tiempo.equals(relojTiempo)){
                lista.add(vuelos.get(i));
            } 
        }
        return lista; 
    }
}
