/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

/**
 *
 * @author yeico
 */
public class ClienteControlador extends javax.swing.JFrame implements ActionListener, Runnable{
    private JButton[] buttons = new JButton[10];
    //Declaramos las variables necesarias para la conexion y comunicacion
    private Socket cliente;
    private DataInputStream in;
    private DataOutputStream out;
    //El puerto debe ser el mismo en el que escucha el servidor
    private int puerto = 2027;
    //Si estamos en nuestra misma maquina usamos localhost si no la ip de la maquina servidor
    private String host = "localhost";
    private String mensaje = "";
    
    public ClienteControlador() {
        super("Ventana controlador");
        this.setPreferredSize(new Dimension(820, 820));
        initComponents2();
        setLocationRelativeTo(null);
        panelPrincipal.setPreferredSize(new Dimension(780,750));
        panelPrincipal.setOpaque(true);
        panelPrincipal2=new JScrollPane();
        panelPrincipal2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panelPrincipal2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelPrincipal2.setBounds(0, 0, 805, 780);
        panelPrincipal2.setViewportView(panelPrincipal);
        panelPrincipal.setLayout(null);
        this.add(panelPrincipal2);
        this.setResizable(false);
        scrollPanel();
        displayLabels();
        displayLabels2();
       
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
                System.out.println(mensaje);
                if ("inicio".equals(mensaje)) {
                    this.enviarMsg("hola");
                }
                if ("hola".equals(mensaje)) {
                    this.enviarMsg("Como estas?"); 
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(835, 799));

        panelPrincipal.setPreferredSize(new java.awt.Dimension(835, 799));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    private void initComponents2(){
        panelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 835, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 799, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    
    
     private void displayLabels() {
        //int ancho = 150;
        //int largo = 130;
        int ancho=110;
        int largo=85;
        //int x=20;
        //int y=60;
        int x = 0;
        int y = 0;

        //System.out.println("Objetos en cola: "+colaSize());
        for (int i = 0; i < 3; i++) {
            button = new JButton();
            button.setBackground(new Color(245, 129, 28));
            button.setBounds(x, y, largo, ancho);
            //x += 126;
            //ancho += 50;
            
            x+=86;
            ancho+=50;
            button.addActionListener(this);
            buttons[i] = button;
            button.setActionCommand("pista" + i);
            panelPrincipal.add(button);

        }

        label = new JLabel("Requiere aterrizar:");
        label.setBounds(30, 200, 500, 200);
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setForeground(new Color(0, 0, 0));
        panelPrincipal.add(label);

        label = new JLabel("Requiere desembarcar:");
        label.setBounds(30, 350, 500, 200);
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setForeground(new Color(0, 0, 0));
        panelPrincipal.add(label);

        label = new JLabel("Desembarcando:");
        label.setBounds(30, 500, 500, 200);
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setForeground(new Color(0, 0, 0));
        panelPrincipal.add(label);
        
        contadorAterrizaje = new JLabel("10");
        contadorAterrizaje.setFont(new Font("Arial", Font.BOLD, 20));
        contadorAterrizaje.setBounds(35, 110, 50, 50);
        contadorAterrizaje.setForeground(new Color(242,242,242));
        panelPrincipal.add(contadorAterrizaje);
        
        
        contadorDesembarque = new JLabel("10");
        contadorDesembarque.setFont(new Font("Arial", Font.BOLD, 20));
        contadorDesembarque.setBounds(637, 300, 50, 50);
        contadorDesembarque.setForeground(new Color(242,242,242));
        panelPrincipal.add(contadorDesembarque);
        
        pistaPuerta = new JLabel("Traslado de la pista a la puerta: 10");
        pistaPuerta.setFont(new Font("Arial", Font.BOLD, 20));
        pistaPuerta.setBounds(400, 20, 400, 50);
        pistaPuerta.setForeground(new Color(0,0,0));
        panelPrincipal.add(pistaPuerta);

    }

    private void displayLabels2() {
//        int ancho = 130;
//        int largo = 150;
        
        int ancho = 85;
        int largo = 110;
        //int x=875;
        //int y=300;
        int x=677;
        int y=300;

        for (int i = 0; i < 3; i++) {
            button = new JButton();
            button.setBackground(new Color(1, 173, 216));
            button.setBounds(x, y, largo, ancho);
//            x -= 50;
//            y += 126;
//            largo += 50;
            x -= 50;
            y += 86;
            largo += 50;
            button.addActionListener(this);
            buttons[i + 3] = button;
            button.setActionCommand("puerta" + i);
            panelPrincipal.add(button);

            //panelPrincipal.add(button);
        }

    }

    private JLabel createLabel(ImageIcon icon) {
        JLabel label = new JLabel(icon, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setForeground(new Color(0, 0, 0));
        return label;
    }

    private ImageIcon createIcon(String path, int anchoLabel, int largoLabel) {
        ImageIcon icono = new ImageIcon(getClass().getResource(path));
        Image image = icono.getImage();
        Image newimg = image.getScaledInstance(anchoLabel, largoLabel, java.awt.Image.SCALE_SMOOTH);
        icono = new ImageIcon(newimg);
        return icono;
    }

    private void scrollPanel() {
        JPanel panelAterrizaje = new JPanel();
        panelAterrizaje.setOpaque(true);
        panelAterrizaje.setBackground(new Color(0, 0, 255));
        JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane1.setBounds(10, 630, 400, 100);
        panelAterrizaje.setPreferredSize(new Dimension(200, 0));
        scrollPane1.setViewportView(panelAterrizaje);
        panelPrincipal.add(scrollPane1);
        panelAterrizaje.setLayout(null);

        JPanel panelTaxi = new JPanel();
        panelTaxi.setOpaque(true);
        panelTaxi.setBackground(new Color(0, 255, 0));
        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane2.setBounds(10, 480, 400, 100);
        panelTaxi.setPreferredSize(new Dimension(200, 0));
        scrollPane2.setViewportView(panelTaxi);
        panelPrincipal.add(scrollPane2);
        panelTaxi.setLayout(null);

        JPanel panelDesembarque = new JPanel();
        panelDesembarque.setOpaque(true);
        panelDesembarque.setBackground(new Color(255, 0, 0));
        JScrollPane scrollPane3 = new JScrollPane();
        scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane3.setBounds(10, 330, 400, 100);
        panelDesembarque.setPreferredSize(new Dimension(200, 0));
        scrollPane3.setViewportView(panelDesembarque);
        panelPrincipal.add(scrollPane3);
        panelDesembarque.setLayout(null);
        
    }
    
    
    
    public static void main(String args[]) {
        ClienteControlador cliente = new ClienteControlador();
        Thread hilo = new Thread(cliente);
        hilo.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
    private ImageIcon icon;
    private JLabel label;
    private JButton button;
    private JLabel contadorAterrizaje;
    private JLabel contadorDesembarque;
    private JLabel pistaPuerta;
    private JButton button1;
    private JScrollPane panelPrincipal2;
    
    
    
     @Override
    public void actionPerformed(ActionEvent e) {
        String string = e.getActionCommand();
        for(int i=0;i<3;i++){
            if (string.equals("pista"+i)) {
                char index = string.charAt(string.length() - 1);
                icon = createIcon("/Imagenes/rojo.png", 70, 70);
                buttons[Character.getNumericValue(index)].setIcon(icon);
                contadorAterrizaje.setForeground(Color.red);
            }
        
        }
                
        for(int i=0;i<3;i++){
            if (string.equals("puerta"+i)) {
                char index = string.charAt(string.length() - 1);
                icon = createIcon("/Imagenes/azul.png", 70, 70);
                buttons[Character.getNumericValue(index) + 3].setIcon(icon);
                //System.out.println("Ragedog \n");
                contadorDesembarque.setForeground(Color.blue);
            }
        }

    }
}
