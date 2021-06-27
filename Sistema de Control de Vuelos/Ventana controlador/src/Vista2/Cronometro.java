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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author yeico
 */
public class Cronometro implements Runnable{
    JLabel refContador;
    JPanel refPanel;
    JButton refBoton;
    ClienteControlador refClienteControlador;
    String mensaje;
    JLabel refContadorTraslado;

    public Cronometro(JLabel refContadorTraslado,String mensaje,ClienteControlador refClienteControlador,JLabel refContador, JPanel refPanel,JButton refBoton) {
        this.refContador = refContador;
        this.refPanel = refPanel;
        this.refBoton = refBoton;
        this.refClienteControlador = refClienteControlador;
        this.mensaje = mensaje;
        this.refContadorTraslado = refContadorTraslado;
    }
    
    
    
    @Override
    public void run() {
        int contador = Integer.parseInt(refContador.getText());
        while(true){
            try {
                refContador.setText(String.valueOf(contador));
                refPanel.updateUI();
                TimeUnit.SECONDS.sleep(1);
                contador-=1;
                if(contador==0){
                    refContador.setText("10");
                    refContador.setForeground(new Color(242,242,242));
                    refBoton.setIcon(null);
                    refBoton.setEnabled(true);
                    refClienteControlador.enviarMsg(mensaje);
                    break;
                }
            } catch (Exception e) {
                e.toString();
            }
            
        }
        if(refContadorTraslado!=null){
            Cronometro2 c = new Cronometro2(refClienteControlador,refContadorTraslado);
            Thread hilo4 = new Thread(c);
            hilo4.start();
        }
        else{
            refClienteControlador.enviarMsg("860-cambiar estado");
        }
    }
    
}
