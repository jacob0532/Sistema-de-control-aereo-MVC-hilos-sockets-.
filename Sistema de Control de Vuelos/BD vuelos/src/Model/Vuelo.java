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
public class Vuelo implements java.lang.Comparable<Vuelo>{
    private String nombre;
    private String estado;
    private String tipo;
    private String tamano;
    public String tiempo;


    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    
    public Vuelo(String pNombre,String pEstado, String pTipo, String pTamano,String pTiempo){
        this.nombre=pNombre;
        this.estado=pEstado;
        this.tipo=pTipo;
        this.tamano=pTamano;
        this.tiempo=pTiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public int getHora(){
        char temp=tiempo.charAt(0);
        char temp2=tiempo.charAt(1);
        String temp3=String.valueOf(temp)+String.valueOf(temp2);
        int hora=Integer.parseInt(temp3);
        return hora;
        
    }
    
    public int getMinutos(){
        char temp=tiempo.charAt(3);
        char temp2=tiempo.charAt(4);
        String temp3=String.valueOf(temp)+String.valueOf(temp2);
        int minutos=Integer.parseInt(temp3);
        return minutos;
    }
    
    
    @Override
    public String toString() {
        return "Vuelo{" + "nombre=" + nombre + ", estado=" + estado + ", tipo=" + tipo + ", tamano=" + tamano + ", tiempo=" + tiempo + "}\n";
    }

    @Override
    public int compareTo(Vuelo p) {
        int hora1=getHora();
        int hora2=p.getHora();
        int minutos1=getMinutos();
        int minutos2=p.getMinutos();
        if(hora1==hora2){
            if(minutos1==minutos2){
                return 0;
            }
            else if(minutos1>minutos2){
                return 1; 
            }
            else{
                return -1;
            }
        }
        else if(hora1>hora2){
            return 1;
        }
        
        else{
            return -1;
        }
    }
    







    
    
}
