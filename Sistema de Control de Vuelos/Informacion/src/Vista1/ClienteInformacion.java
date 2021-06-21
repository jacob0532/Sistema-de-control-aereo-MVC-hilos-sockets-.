/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista1;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author yeico
 */
public class ClienteInformacion extends javax.swing.JFrame implements Runnable{
    //Declaramos las variables necesarias para la conexion y comunicacion
    private Socket cliente;
    private DataInputStream in;
    private DataOutputStream out;
    //El puerto debe ser el mismo en el que escucha el servidor
    private int puerto = 2027;
    //Si estamos en nuestra misma maquina usamos localhost si no la ip de la maquina servidor
    private String host = "localhost";
    private String mensaje = "";
    String [] listaDeVuelosGlobal = new String[0];
    ArrayList<String> listaVuelosAterrizando = new ArrayList<>();
    ArrayList<String> listaVuelosTaxi = new ArrayList<>();
    ArrayList<String> listaVuelosPuerta = new ArrayList<>();
    int avionesEliminados = 0;
    public ClienteInformacion() {
        initComponents();
        try {
            cliente = new Socket(host,puerto);
            in = new DataInputStream(cliente.getInputStream());
            out = new DataOutputStream(cliente.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        try{
            //Ciclo infinito que escucha por mensajes del servidor y los muestra en el panel
            while(true){
                this.setVisible(true);
                mensaje = in.readUTF();
                String[] listaMensaje = mensaje.split("-");
                if("001".equals(listaMensaje[0])){
                    listaDeVuelosGlobal = listaMensaje[1].split("\n");
                    rellenarPanel(listaDeVuelosGlobal);
                    hiloVista h = new hiloVista(this);
                    Thread hilo6 = new Thread(h);
                    hilo6.start();
                    this.enviarMsg("00-inicio");
                }
                if ("444".equals(listaMensaje[0])) {
                    System.out.println(listaMensaje[1]);
                    lblReloj.setText(listaMensaje[1]);
                }
                if ("857".equals(listaMensaje[0])) {
                    String[] var = listaDeVuelosGlobal[listaVuelosAterrizando.size()].split(",");
                    var[1] = "ESTADO = ATERRIZANDO";
                    String var2 = "";
                    for (int i = 0; i < var.length; i++) {
                        var2+=var[i]+",";
                    }                    
                    listaDeVuelosGlobal[listaVuelosAterrizando.size()] = var2;
                    rellenarPanel(escribirSalida(listaDeVuelosGlobal));
                    listaVuelosAterrizando.add(var2);
                    
                }
                
                if ("858".equals(listaMensaje[0])) {
                    String[] var = listaDeVuelosGlobal[listaVuelosTaxi.size()].split(",");
                    var[1] = "ESTADO = TRANSITANDO PISTA";
                    String var2 = "";
                    for (int i = 0; i < var.length; i++) {
                        var2+=var[i]+",";
                    }
                    listaDeVuelosGlobal[listaVuelosTaxi.size()] = var2;
                    rellenarPanel(escribirSalida(listaDeVuelosGlobal));
                    listaVuelosTaxi.add(var2);
                }
                
                if ("859".equals(listaMensaje[0])) {
                    String[] var = listaDeVuelosGlobal[listaVuelosPuerta.size()].split(",");
                    var[1] = listaMensaje[1];
                    String var2 = "";
                    for (int i = 0; i < var.length; i++) {
                        var2+=var[i]+",";
                    }
                    listaDeVuelosGlobal[listaVuelosPuerta.size()] = var2;
                    rellenarPanel(escribirSalida(listaDeVuelosGlobal));
                    listaVuelosPuerta.add(var2);
                }
                
                if ("860".equals(listaMensaje[0])) {
                    avionesEliminados+=1;
                    rellenarPanel(escribirSalida(listaDeVuelosGlobal));

                }
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Funcion sirve para enviar mensajes al servidor
    public void enviarMsg(String msg){
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String[] escribirSalida(String[] listaDeVuelos){
        String salida = "";
        for (int i = avionesEliminados; i < listaDeVuelos.length; i++) {
            salida+=listaDeVuelos[i]+"\n";
        }
        return salida.split("\n");
    }
    
    
    
    public void rellenarPanel(String[] listaDeVuelos){
        panelInformacion.removeAll();
        for (int i = 0; i < listaDeVuelos.length; i++) {
            JLabel var = new JLabel();
            var.setBackground(Color.BLACK);
            var.setForeground(Color.WHITE);
            //System.out.println(String.valueOf(i)+"-"+a.vuelos.get(i).toString());
            var.setText(String.valueOf(i)+"-"+listaDeVuelos[i]);
            var.setOpaque(true);
            var.setBounds(10, 70*i+10, 820, 50);
            panelInformacion.add(var);
        }
        panelInformacion.updateUI();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelInformacion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblReloj = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.setLayout(null);

        panelInformacion.setBackground(new java.awt.Color(153, 0, 0));
        panelInformacion.setPreferredSize(new java.awt.Dimension(500, 500));
        panelInformacion.setLayout(null);
        jPanel1.add(panelInformacion);
        panelInformacion.setBounds(80, 60, 840, 470);

        jLabel1.setBackground(new java.awt.Color(153, 0, 0));
        jLabel1.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Airport information");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(340, 10, 330, 40);

        lblReloj.setBackground(new java.awt.Color(153, 0, 0));
        lblReloj.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReloj.setText("00:00");
        lblReloj.setOpaque(true);
        jPanel1.add(lblReloj);
        lblReloj.setBounds(880, 4, 110, 50);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        ClienteInformacion cliente= new ClienteInformacion();
        Thread hilo = new Thread(cliente);
        hilo.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblReloj;
    public javax.swing.JPanel panelInformacion;
    // End of variables declaration//GEN-END:variables
}
