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
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    TextArea panelAterrizaje = new TextArea();
    TextArea panelTaxi = new TextArea();
    TextArea panelInformacion = new TextArea();
    boolean ejecutar = true;
    ArrayList<String> listaAviones = new ArrayList<>();
    ArrayList<String> listaAvionesDesembarque = new ArrayList<>();
    ArrayList<String> listaAvionesPuerta = new ArrayList<>();
    public ClienteControlador() {
        super("Ventana controlador");
        this.setPreferredSize(new Dimension(820, 820));
        initComponents2();
        setLocationRelativeTo(null);
        panelPrincipal.setPreferredSize(new Dimension(800,800));
        panelPrincipal.setOpaque(true);
        panelPrincipal2=new JScrollPane();
        panelPrincipal2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panelPrincipal2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelPrincipal2.setBounds(0, 0, 800, 750);
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

            while(ejecutar){
                this.setVisible(true);
                mensaje = in.readUTF();
                String[] listaMensaje = mensaje.split("-");
                String[] aviones;
                System.out.println(mensaje);
                if ("01".equals(listaMensaje[0])) {
                    panelAterrizaje.setText(panelAterrizaje.getText()+listaMensaje[1]);
                    panelPrincipal.updateUI();
                    this.enviarMsg("03-pistas libres?");
                    aviones = listaMensaje[1].split(";");
                    for (int i = 0; i < aviones.length; i++) {
                        listaAviones.add(aviones[i]);
                    } 
                }
                if("02".equals(listaMensaje[0])){
                    panelAterrizaje.setText(panelAterrizaje.getText());
                    panelPrincipal.updateUI();
                    this.enviarMsg("00-inicio");
                }
                if("04".equals(listaMensaje[0])){
                    panelInformacion.setText(panelInformacion.getText()+listaMensaje[1]);
                    panelPrincipal.updateUI();
                    this.enviarMsg("00-inicio");
                }
                if("05".equals(listaMensaje[0])){
                    panelInformacion.setText(panelInformacion.getText()+listaMensaje[1]);
                    panelPrincipal.updateUI();
                    this.enviarMsg("00-inicio");
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

        label = new JLabel("Informacion del controlador:");
        label.setBounds(30, 500, 500, 200);
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setForeground(new Color(0, 0, 0));
        panelPrincipal.add(label);
        
        contadorAterrizaje1 = new JLabel("10");
        contadorAterrizaje1.setFont(new Font("Arial", Font.BOLD, 20));
        contadorAterrizaje1.setBounds(35, 110, 50, 50);
        contadorAterrizaje1.setForeground(new Color(242,242,242));
        panelPrincipal.add(contadorAterrizaje1);
        
        contadorAterrizaje2 = new JLabel("10");
        contadorAterrizaje2.setFont(new Font("Arial", Font.BOLD, 20));
        contadorAterrizaje2.setBounds(121, 160, 50, 50);
        contadorAterrizaje2.setForeground(new Color(242,242,242));
        panelPrincipal.add(contadorAterrizaje2);
        
        contadorAterrizaje3 = new JLabel("10");
        contadorAterrizaje3.setFont(new Font("Arial", Font.BOLD, 20));
        contadorAterrizaje3.setBounds(207, 210, 50, 50);
        contadorAterrizaje3.setForeground(new Color(242,242,242));
        panelPrincipal.add(contadorAterrizaje3);
        
        
        contadorDesembarque1 = new JLabel("10");
        contadorDesembarque1.setFont(new Font("Arial", Font.BOLD, 20));
        contadorDesembarque1.setBounds(637, 300, 50, 50);
        contadorDesembarque1.setForeground(new Color(242,242,242));
        panelPrincipal.add(contadorDesembarque1);
        
        contadorDesembarque2 = new JLabel("10");
        contadorDesembarque2.setFont(new Font("Arial", Font.BOLD, 20));
        contadorDesembarque2.setBounds(600, 400, 50, 50);
        contadorDesembarque2.setForeground(new Color(242,242,242));
        panelPrincipal.add(contadorDesembarque2);
        
        contadorDesembarque3 = new JLabel("10");
        contadorDesembarque3.setFont(new Font("Arial", Font.BOLD, 20));
        contadorDesembarque3.setBounds(550, 500, 50, 50);
        contadorDesembarque3.setForeground(new Color(242,242,242));
        panelPrincipal.add(contadorDesembarque3);
        
        pistaPuertaPequeña = new JLabel("Traslado de la pista a la puerta (Pequeña):");
        pistaPuertaPequeña.setFont(new Font("Arial", Font.BOLD, 20));
        pistaPuertaPequeña.setBounds(300, 20, 600, 50);
        pistaPuertaPequeña.setForeground(new Color(0,0,0));
        panelPrincipal.add(pistaPuertaPequeña);
        
        pistaPuertaMediana = new JLabel("Traslado de la pista a la puerta (Mediana):");
        pistaPuertaMediana.setFont(new Font("Arial", Font.BOLD, 20));
        pistaPuertaMediana.setBounds(300, 40, 600, 50);
        pistaPuertaMediana.setForeground(new Color(0,0,0));
        panelPrincipal.add(pistaPuertaMediana);
        
        pistaPuertaGrande = new JLabel("Traslado de la pista a la puerta (Grande):");
        pistaPuertaGrande.setFont(new Font("Arial", Font.BOLD, 20));
        pistaPuertaGrande.setBounds(300, 60, 600, 50);
        pistaPuertaGrande.setForeground(new Color(0,0,0));
        panelPrincipal.add(pistaPuertaGrande);

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
        panelAterrizaje.setVisible(true);
        panelAterrizaje.setBackground(new Color(255, 0, 0));
        panelAterrizaje.setBounds(10, 330, 500, 100);
        panelAterrizaje.setEditable(false);
        panelPrincipal.add(panelAterrizaje);


        
        panelTaxi.setVisible(true);
        panelTaxi.setBackground(new Color(0, 255, 0));
        panelTaxi.setBounds(10, 480, 500, 100);
        panelTaxi.setEditable(false);
        panelPrincipal.add(panelTaxi);


        
        panelInformacion.setVisible(true);
        panelInformacion.setForeground(Color.RED);
        panelInformacion.setBackground(new Color(255, 255, 255));
        panelInformacion.setBounds(10, 630, 500, 100);
        panelInformacion.setEditable(false);
        panelPrincipal.add(panelInformacion);

        
    }
    
    
    
    public static void main(String args[]) {
        ClienteControlador cliente = new ClienteControlador();
        Thread hilo = new Thread(cliente);
        hilo.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
    private ImageIcon icon;
    private JLabel label;
    private JButton button;
    public JLabel contadorAterrizaje1;
    public JLabel contadorAterrizaje2;
    public JLabel contadorAterrizaje3;
    public JLabel contadorDesembarque1;
    public JLabel contadorDesembarque2;
    public JLabel contadorDesembarque3;
    public JLabel pistaPuertaPequeña;
    public JLabel pistaPuertaMediana;
    public JLabel pistaPuertaGrande;
    private JButton button1;
    private JScrollPane panelPrincipal2;
    
    
    
     @Override
    public void actionPerformed(ActionEvent e) {
        String string = e.getActionCommand();

        if (string.equals("pista0")) {
            this.enviarMsg("857-cambiarEstado");
            sacarAviones();
            char index = string.charAt(string.length() - 1);
            icon = createIcon("/Imagenes/rojo.png", 70, 70);
            buttons[Character.getNumericValue(index)].setIcon(icon);
            buttons[Character.getNumericValue(index)].setEnabled(false);
            contadorAterrizaje1.setForeground(Color.red);
            this.enviarMsg("999-Pequeña");
            Cronometro a = new Cronometro(pistaPuertaPequeña,"999-Pequeña",this,contadorAterrizaje1,panelPrincipal,buttons[Character.getNumericValue(index)]);
            Thread hilo3 = new Thread(a);
            hilo3.start();
        }
        if (string.equals("pista1")) {
            this.enviarMsg("857-cambiarEstado");
            sacarAviones();
            char index = string.charAt(string.length() - 1);
            icon = createIcon("/Imagenes/rojo.png", 70, 70);
            buttons[Character.getNumericValue(index)].setIcon(icon);
            buttons[Character.getNumericValue(index)].setEnabled(false);
            contadorAterrizaje2.setForeground(Color.red);
            this.enviarMsg("999-Mediana");
            Cronometro a = new Cronometro(pistaPuertaMediana,"999-Mediana",this,contadorAterrizaje2,panelPrincipal,buttons[Character.getNumericValue(index)]);
            Thread hilo3 = new Thread(a);
            hilo3.start();
        }
        if (string.equals("pista2")) {
            this.enviarMsg("857-cambiarEstado");
            sacarAviones();
            char index = string.charAt(string.length() - 1);
            icon = createIcon("/Imagenes/rojo.png", 70, 70);
            buttons[Character.getNumericValue(index)].setIcon(icon);
            buttons[Character.getNumericValue(index)].setEnabled(false);
            contadorAterrizaje3.setForeground(Color.red);
            this.enviarMsg("999-Grande");
            Cronometro a = new Cronometro(pistaPuertaGrande,"999-Grande",this,contadorAterrizaje3,panelPrincipal,buttons[Character.getNumericValue(index)]);
            Thread hilo3 = new Thread(a);
            hilo3.start();
        }
        if (string.equals("puerta0")) {
            sacarAvionesTaxi();
            this.enviarMsg("859-ESTADO = LLEGANDO PUERTA 0");
            char index = string.charAt(string.length() - 1);
            icon = createIcon("/Imagenes/azul.png", 70, 70);
            buttons[Character.getNumericValue(index) + 3].setIcon(icon);
            buttons[Character.getNumericValue(index) + 3].setEnabled(false);
            contadorDesembarque1.setForeground(Color.blue);
            this.enviarMsg("998-Pequeña");
            Cronometro a = new Cronometro(null,"998-Pequeña",this,contadorDesembarque1,panelPrincipal,buttons[Character.getNumericValue(index)+3]);
            Thread hilo3 = new Thread(a);
            hilo3.start();
        }
        if (string.equals("puerta1")) {
            sacarAvionesTaxi();
            this.enviarMsg("859-ESTADO = LLEGANDO PUERTA 1");
            char index = string.charAt(string.length() - 1);
            icon = createIcon("/Imagenes/azul.png", 70, 70);
            buttons[Character.getNumericValue(index) + 3].setIcon(icon);
            buttons[Character.getNumericValue(index) + 3].setEnabled(false);
            contadorDesembarque2.setForeground(Color.blue);
            this.enviarMsg("998-Mediana");
            Cronometro a = new Cronometro(null,"998-Mediana",this,contadorDesembarque2,panelPrincipal,buttons[Character.getNumericValue(index)+3]);
            Thread hilo3 = new Thread(a);
            hilo3.start();
        }
        if (string.equals("puerta2")) {
            sacarAvionesTaxi();
            this.enviarMsg("859-ESTADO = LLEGANDO PUERTA 2");
            char index = string.charAt(string.length() - 1);
            icon = createIcon("/Imagenes/azul.png", 70, 70);
            buttons[Character.getNumericValue(index) + 3].setIcon(icon);
            buttons[Character.getNumericValue(index) + 3].setEnabled(false);
            contadorDesembarque3.setForeground(Color.blue);
            this.enviarMsg("998-Grande");
            Cronometro a = new Cronometro(null,"998-Grande",this,contadorDesembarque3,panelPrincipal,buttons[Character.getNumericValue(index)+3]);
            Thread hilo3 = new Thread(a);
            hilo3.start();
        }
                
    }
    public void sacarAviones(){
        if (!listaAviones.isEmpty()) {
            listaAvionesDesembarque.add(listaAviones.get(0));
            listaAviones.remove(0);       
        }
        actualizarPanelAterrizaje();
    }
    
    public void sacarAvionesTaxi(){
        String[] listaAvionesTaxi = panelTaxi.getText().split("\n");
        String avionesTaxi = "";
        for (int i = 1; i < listaAvionesTaxi.length; i++) {
            avionesTaxi+=listaAvionesTaxi[i]+"\n";
        }
        panelTaxi.setText(avionesTaxi);
        panelPrincipal.updateUI();
    }
    
    public void actualizarPanelAterrizaje(){
        String a = "";
        for (int i = 0; i < listaAviones.size(); i++) {
            a+=listaAviones.get(i);
        }
        panelAterrizaje.setText(a);
        panelPrincipal.updateUI();
        
    }
}
