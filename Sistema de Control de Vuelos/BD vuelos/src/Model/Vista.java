/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

/**
 *
 * @author Meih55
 */
public class Vista extends javax.swing.JFrame implements ActionListener {

    private JButton[] buttons = new JButton[10];

    /**
     * Creates new form Vista
     */
    public Vista() {
        super("Ventana controlador");
        this.setPreferredSize(new Dimension(1000, 950));
        initComponents();
        panelPrincipal.setPreferredSize(new Dimension(3500, 3500));
        scrollPanel();
        displayLabels();
        displayLabels2();
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void displayLabels() {
        int ancho = 150;
        int largo = 130;
        //int x=20;
        //int y=60;
        int x = 0;
        int y = 0;

        //System.out.println("Objetos en cola: "+colaSize());
        for (int i = 0; i < 3; i++) {
            button = new JButton();
            button.setBackground(new Color(245, 129, 28));
            button.setBounds(x, y, largo, ancho);
            x += 126;
            ancho += 50;
            button.addActionListener(this);
            buttons[i] = button;
            button.setActionCommand("pista" + i);
            panelPrincipal.add(button);

        }

        label = new JLabel("Requiere aterrizar:");
        label.setBounds(30, 200, 500, 200);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setForeground(new Color(0, 0, 0));
        panelPrincipal.add(label);

        label = new JLabel("Requiere desembarcar:");
        label.setBounds(30, 400, 500, 200);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setForeground(new Color(0, 0, 0));
        panelPrincipal.add(label);

        label = new JLabel("Desembarcando:");
        label.setBounds(30, 600, 500, 200);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setForeground(new Color(0, 0, 0));
        panelPrincipal.add(label);
        
        contadorAterrizaje = new JLabel("10");
        contadorAterrizaje.setFont(new Font("Arial", Font.BOLD, 20));
        contadorAterrizaje.setBounds(50, 150, 50, 50);
        contadorAterrizaje.setForeground(new Color(214,217,223));
        panelPrincipal.add(contadorAterrizaje);
        
        contadorDesembarque = new JLabel("10");
        contadorDesembarque.setFont(new Font("Arial", Font.BOLD, 20));
        contadorDesembarque.setBounds(800, 300, 50, 50);
        contadorDesembarque.setForeground(new Color(214,217,223));
        panelPrincipal.add(contadorDesembarque);
        
        pistaPuerta = new JLabel("Traslado de la pista a la puerta: 10");
        pistaPuerta.setFont(new Font("Arial", Font.BOLD, 20));
        pistaPuerta.setBounds(400, 20, 400, 50);
        pistaPuerta.setForeground(new Color(0,0,0));
        panelPrincipal.add(pistaPuerta);

    }

    private void displayLabels2() {
        int ancho = 130;
        int largo = 150;
        int x = 835;
        int y = 300;

        for (int i = 0; i < 3; i++) {
            button = new JButton();
            button.setBackground(new Color(1, 173, 216));
            button.setBounds(x, y, largo, ancho);
            x -= 50;
            y += 126;
            largo += 50;
            button.addActionListener(this);
            buttons[i + 3] = button;
            button.setActionCommand("puerta" + i);
            panelPrincipal.add(button);

            panelPrincipal.add(button);
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
        scrollPane1.setBounds(10, 730, 500, 150);
        panelAterrizaje.setPreferredSize(new Dimension(200, 0));
        scrollPane1.setViewportView(panelAterrizaje);
        panelPrincipal.add(scrollPane1);
        panelAterrizaje.setLayout(null);

        JPanel panelTaxi = new JPanel();
        panelTaxi.setOpaque(true);
        panelTaxi.setBackground(new Color(0, 255, 0));
        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane2.setBounds(10, 530, 500, 150);
        panelTaxi.setPreferredSize(new Dimension(200, 0));
        scrollPane2.setViewportView(panelTaxi);
        panelPrincipal.add(scrollPane2);
        panelTaxi.setLayout(null);

        JPanel panelDesembarque = new JPanel();
        panelDesembarque.setOpaque(true);
        panelDesembarque.setBackground(new Color(255, 0, 0));
        JScrollPane scrollPane3 = new JScrollPane();
        scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane3.setBounds(10, 330, 500, 150);
        panelDesembarque.setPreferredSize(new Dimension(200, 0));
        scrollPane3.setViewportView(panelDesembarque);
        panelPrincipal.add(scrollPane3);
        panelDesembarque.setLayout(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String string = e.getActionCommand();
        if (e.getActionCommand().equals("pista0")) {
            char index = string.charAt(string.length() - 1);
            icon = createIcon("/Imagenes/rojo.png", 100, 100);
            buttons[Character.getNumericValue(index)].setIcon(icon);
            //System.out.println("Ragedog \n");
            contadorAterrizaje.setForeground(Color.red);

        } else if (e.getActionCommand().equals("puerta0")) {
            char index = string.charAt(string.length() - 1);
            icon = createIcon("/Imagenes/azul.png", 100, 100);
            buttons[Character.getNumericValue(index) + 3].setIcon(icon);
            //System.out.println("Ragedog \n");
            contadorDesembarque.setForeground(Color.blue);
        }
    }
}