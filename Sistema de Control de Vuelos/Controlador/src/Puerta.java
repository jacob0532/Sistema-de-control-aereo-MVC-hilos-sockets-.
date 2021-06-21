/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Meih55
 */
public class Puerta {
    int numero;
    int estado;
    String tamano;
    
    public Puerta(int num, int es, String tam){
        this.numero=num;
        this.estado=es;
        this.tamano=tam;
    }

    @Override
    public String toString() {
        return "Puerta{" + "numero=" + numero + ", estado=" + estado + ", tamano=" + tamano + '}';
    }

}
