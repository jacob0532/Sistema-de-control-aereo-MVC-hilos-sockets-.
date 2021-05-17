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
public class Pista implements Comparable<Pista>{
    private int numero;
    private int estado;
    
    public Pista(int num, int es){
        this.numero=num;
        this.estado=es;
    }

    @Override
    public String toString() {
        return "Pista{" + "numero=" + numero + ", estado=" + estado + '}';
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
