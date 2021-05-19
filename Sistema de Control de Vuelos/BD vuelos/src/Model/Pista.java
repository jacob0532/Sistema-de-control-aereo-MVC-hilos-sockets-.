/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Meih55
 */
public class Pista implements Comparable<Pista>{
    private int numero;
    private int estado;
    private String tamano;
    
    public Pista(int num, int es, String tam){
        this.tamano=tam;
        this.numero=num;
        this.estado=es;
    }

    @Override
    public String toString() {
        return "Pista{" + "numero=" + numero + ", estado=" + estado + ", tamano=" + tamano + '}';
    }



    @Override
    public int compareTo(Pista p) {
        if(p.estado==estado){
            return 0;
        }
        else if(p.estado<estado){
            return 1;
        }
        else{
            return -1;
        }
    }
}
