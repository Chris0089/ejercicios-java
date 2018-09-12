package chat;

import java.awt.event.ActionListener;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class Chat extends java.awt.Frame {
    private javax.swing.JButton boton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JTextArea text_area;
    private javax.swing.JTextField text_field_1;
    private javax.swing.JTextField text_field_2;
    
    private Receptor ar;
    private DatagramSocket socketEmision;
    public Chat() {
        ar=new Receptor();
        ar.start();
        initComponents();
    }                       
    private void initComponents() {
        
        panel1 = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        text_field_2 = new javax.swing.JTextField();
        label2 = new javax.swing.JLabel();
        text_field_1 = new javax.swing.JTextField();
        panel2 = new javax.swing.JPanel();
        boton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        text_area = new javax.swing.JTextArea();
        
        setMinimumSize(new java.awt.Dimension(500, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        label1.setText("IP");
        panel1.add(label1);

        text_field_2.setText("192.168.100.4");
        panel1.add(text_field_2);

        label2.setText("Mensaje");
        panel1.add(label2);

        text_field_1.setText("Escribe tu mensaje");
        panel1.add(text_field_1);

        add(panel1, java.awt.BorderLayout.NORTH);

        boton.setText("Enviar");
        boton.setHideActionText(true);
        panel2.add(boton);
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
             botonActionPerformed(evt);
            }
        });
        add(panel2, java.awt.BorderLayout.SOUTH);

        text_area.setEditable(false);
        text_area.setColumns(20);
        text_area.setRows(5);
        text_area.setPreferredSize(new java.awt.Dimension(350, 350));
        jScrollPane1.setViewportView(text_area);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }
    private void exitForm(java.awt.event.WindowEvent evt) {                          
        System.exit(0);
    }       
    private void botonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String ip=text_field_2.getText();
        String mensaje=text_field_1.getText();
        Emisor(ip,mensaje);
        
    }   

    class Receptor extends Thread{
        DatagramSocket socketRecepcion;
        DatagramPacket dp;
        
        byte[] buffer=new byte[1024];
        int puertoEntrada=3122;
        
        public void run(){
            try {
                socketRecepcion = new DatagramSocket(puertoEntrada);
                byte[] buffer=new byte[1024];
                dp = new DatagramPacket(buffer,buffer.length);
                while(true){
                    socketRecepcion.receive(dp);
                    text_area.append("148.202.135.58 "+dp.getAddress().getHostAddress()+": ");
                    text_area.append((new String(buffer,0,dp.getLength()))+" \n");
                }
            } catch (SocketException ex) {
                Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }
    public void Emisor(String ip, String mensaje)
    {
        byte[] buffer;
        buffer=mensaje.getBytes();
        DatagramPacket dp;
        try {
            dp=new DatagramPacket(buffer,buffer.length,InetAddress.getByName(ip),3122);
            try {     
                socketEmision.send(dp);
            } catch (IOException ex) {
                Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
         
   
    }
    public void abreEmisor(){
        int puertoSalida=5686;
        try {
            socketEmision=new DatagramSocket(puertoSalida);
        } catch (SocketException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Chat ventana = new Chat();
                ventana.setVisible(true);
                ventana.abreEmisor();
            }
        
        });
    }
           
}