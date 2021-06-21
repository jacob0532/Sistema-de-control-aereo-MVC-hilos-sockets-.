/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Meih55
 */
public class Pista{
    int numero;
    int estado;
    String tamano;
    
    public Pista(int num, int es, String tam){
        this.tamano=tam;
        this.numero=num;
        this.estado=es;
    }

    @Override
    public String toString() {
        return "Pista{" + "numero=" + numero + ", estado=" + estado + ", tamano=" + tamano + '}';
    }
}
