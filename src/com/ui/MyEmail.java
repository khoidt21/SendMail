/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ui;

import com.business.MyMail;
import com.entity.MailMessage;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.entity.SMTPServer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import javax.xml.ws.Action;
/**
 *
 * @author ADMIN
 */
public class MyEmail extends javax.swing.JFrame implements ActionListener{

    JTextField txtFrom = new JTextField();
    JTextField txtTo = new JTextField();
    JTextField txtSubject = new JTextField();
    JTextField txtUserName = new JTextField();
    JPasswordField txtPassword = new JPasswordField();
    JComboBox<String> cbxServer = new JComboBox<String>();
    JTextArea txtMessage = new JTextArea();
    JButton btnSend = new JButton("Send E-Mail");
    File attackFile = null;
    JFrame frame = null;
    JButton btnAttack = new JButton("Choose File");
    JPanel panelTop;
    MailMessage mailMessage;
    MyMail myMail;
    SMTPServer sMTPServer;
    final JLabel lblFile = new JLabel();
        
    /**
     * Creates new form MyEmail
     */
    public MyEmail() {
        
        initComponents();
    }
    // ham createAndShowGUI
    public void createAndShowGUI(){
        JFrame frame = new JFrame("Send E-Mail Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPanel(frame.getContentPane());
        frame.pack();
        frame.setSize(700,700);
        frame.setVisible(true);
        centreWindow(frame);
    }
    // ham hien thi fragme o giua man hinh 
    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
   
    public void addComponentsToPanel(Container containerPanel){
        
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain,BoxLayout.Y_AXIS));
        panelMain.setBorder(new EmptyBorder(10,10, 10, 10));
        
        // tao panel cho UI tren cung
        panelTop = new JPanel();
        panelTop.setLayout(new GridLayout(8,2,10,10));
        panelTop.add(new JLabel("From:"));
        panelTop.add(txtFrom);
        panelTop.add(new JLabel("To:"));
        panelTop.add(txtTo);
        panelTop.add(new JLabel("Subject:"));
        panelTop.add(txtSubject);
        panelTop.add(new JLabel("SMTP Server:"));
        panelTop.add(cbxServer);
        // add gia tri vao JCombobox Server
        cbxServer.addItem("smtp.gmail.com (SSL)");
        cbxServer.addItem("smtp.gmail.com (TLS)");
        cbxServer.addItem("smtp.mail.yahoo.com (SSL)");
        cbxServer.addItem("outlook.office365.com (SSL)");
        cbxServer.addItem("pop.aol.com (SSL)");
        
        panelTop.add(new JLabel("Username:"));
        panelTop.add(txtUserName);
        panelTop.add(new JLabel("Password:"));
        panelTop.add(txtPassword);
        panelTop.add(new JLabel("Attack File:"));
        
       
        panelTop.add(lblFile);
        // button xu ly Choose File 
        btnAttack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                int returnValue = jFileChooser.showDialog(null,"Choose File");
   
                if(returnValue == JFileChooser.APPROVE_OPTION){
                    lblFile.setText(jFileChooser.getSelectedFile().toString());
                }
            }
        });
        
        panelTop.add(btnAttack);
        
        // tao panel cho phan giua from
        JPanel panelMiddle = new JPanel();
        panelMiddle.setBorder(BorderFactory.createEmptyBorder(12,0,0,0));
        panelMiddle.setLayout(new BorderLayout(10,10));
        panelMiddle.add(new JLabel("Message:"),BorderLayout.NORTH);
         
        panelMiddle.add(txtMessage,BorderLayout.CENTER);
        
        // tao panel cho nut bam 
        JPanel panelBottom = new JPanel();
        panelBottom.add(btnSend);
        btnSend.addActionListener(this);
        // add cac panel vao panelMain 
        panelMain.add(panelTop);
        panelMain.add(panelMiddle);
        panelMain.add(panelBottom);
        // add PanelMain vao containerPanel 
        containerPanel.add(panelMain);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 802, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MyEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyEmail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnSend){
            
            myMail = new MyMail();
            sMTPServer = new SMTPServer();
               
            if(cbxServer.getSelectedIndex()==0){
                sMTPServer.setServer("smtp.gmail.com");
                sMTPServer.setPort("465");
            }
            else if(cbxServer.getSelectedIndex()==1){
                sMTPServer.setServer("smtp.gmail.com");
                sMTPServer.setPort("587");
            }
            else if(cbxServer.getSelectedIndex()==2){
                sMTPServer.setServer("pop.mail.yahoo.com");
                sMTPServer.setPort("995");
            }
            else if(cbxServer.getSelectedIndex()==3){
                sMTPServer.setServer("outlook.office365.com");
                sMTPServer.setPort("995");
            }else if(cbxServer.getSelectedIndex()==4){
                sMTPServer.setServer("pop.aol.com");
                sMTPServer.setPort("995");
            }
            Session session = myMail.getMailSession(sMTPServer,txtFrom.getText(),new String(txtPassword.getPassword()));
            MailMessage mailMessage = new MailMessage(txtFrom.getText(),txtTo.getText(),txtSubject.getText(),txtMessage.getText(),lblFile.getText());
            // set image to messageDialog
            ImageIcon icon = new ImageIcon("src/images/java.png");
            Image image = icon.getImage();
            Image newimg = image.getScaledInstance(50, 50,java.awt.Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(newimg);
            
            try{
                   if(myMail.SendMail(mailMessage, session)){                 
                      JOptionPane.showMessageDialog(frame,"Message sent to "+ txtTo.getText(),
                            "Message", JOptionPane.PLAIN_MESSAGE, imageIcon);
                   }
                   else{
                       JOptionPane.showMessageDialog(frame,"Message sent to error","Message",JOptionPane.ERROR_MESSAGE,imageIcon);
                   }
                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(frame,"Message sent to have exception","Message",JOptionPane.ERROR_MESSAGE,imageIcon);
            }
            
         }
    
    }
}
