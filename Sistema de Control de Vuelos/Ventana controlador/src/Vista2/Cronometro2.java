/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista2;

import java.awt.Color;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author yeico
 */
public class Cronometro2 implements Runnable{
    ClienteControlador refClienteControlador2;
    JLabel refLabel;

    public Cronometro2(ClienteControlador refClienteControlador2,JLabel refLabel) {
        this.refClienteControlador2 = refClienteControlador2;
        this.refLabel = refLabel;
    }

    @Override
    public void run() {
        int contador = 10;
        String var = refLabel.getText();
        while(true){
            try {
                refLabel.setText(var+String.valueOf(contador));
                refClienteControlador2.panelPrincipal.updateUI();
                contador-=1;
                TimeUnit.SECONDS.sleep(1);
                if(contador==0){
                    refLabel.setText(var);
                    break;
                }
            } catch (Exception e) {
                e.toString();
            }
        }
        refClienteControlador2.enviarMsg("858-cambiarEstado");
        refClienteControlador2.panelTaxi.setText(refClienteControlador2.panelTaxi.getText()+refClienteControlador2.listaAvionesDesembarque.get(0));
        refClienteControlador2.listaAvionesDesembarque.remove(0);
    }
    
    
}
