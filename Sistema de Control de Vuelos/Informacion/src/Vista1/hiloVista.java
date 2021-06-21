/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista1;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yeico
 */
public class hiloVista implements Runnable {
    ClienteInformacion refVista;

    public hiloVista(ClienteInformacion refVista) {
        this.refVista = refVista;
    }
    @Override
    public void run(){
        try {
            while(true){
                mostrarInformacion();
                sleep(2000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(hiloVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void mostrarInformacion(){
        for (int i = 0; i < refVista.listaDeVuelosGlobal.length-refVista.avionesEliminados; i++) {
            if(refVista.panelInformacion.getComponent(i).getY()+10>1300){
                refVista.panelInformacion.getComponent(i).setBounds(10,10, 820, 50);  
            }
            else{
                refVista.panelInformacion.getComponent(i).setBounds(10,refVista.panelInformacion.getComponent(i).getY()+70, 820, 50);  
            }
                     
        }
        refVista.panelInformacion.updateUI();
        
    }
    
}
