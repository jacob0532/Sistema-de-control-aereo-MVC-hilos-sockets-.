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
public class Vuelo {
    private String nombre;
    private String estado;
    private String tipo;
    
    public Vuelo(String pNombre,String pEstado, String pTipo){
        this.nombre=pNombre;
        this.estado=pEstado;
        this.tipo=pTipo;
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

    @Override
    public String toString() {
        return "Vuelo{" + "nombre=" + nombre + ", estado=" + estado + ", tipo=" + tipo + '}';
    }
    
    
}
