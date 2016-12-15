/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.lab2.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author Estudiante
 */
public class Lab2 extends JFrame implements ActionListener {

    JTextField username = new JTextField(15);
    JTextField telephone = new JTextField(15);
    JTextArea information = new JTextArea(4, 15);
    JButton ok = new JButton("Ok");
    JButton clean = new JButton("Clean");
    String[] genders = {"Masculino", "Femenino"};
    JComboBox genderBox = new JComboBox(genders);

    public Lab2() {
        super("Information");
        setSize(300, 240);
        setLookAndFeel();
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        JLabel usernameLabel = new JLabel("Username: ");
        JLabel telephoneLabel = new JLabel("Telephone: ");
        JLabel genderLabel = new JLabel("Gender: ");
        JLabel informationLabel = new JLabel("result");

        usernameLabel.setName("lblName");
        telephoneLabel.setName("lblPhone");
        genderLabel.setName("lblGender");
        informationLabel.setName("lblResult");

        username.setName("username");
        telephone.setName("telephone");
        information.setName("Gender");
        ok.setName("ok");
        clean.setName("clean");
        information.setName("information");

        information.setLineWrap(true);
        information.setWrapStyleWord(true);

        ok.addActionListener(this);
        clean.addActionListener(this);

        panel.setName("Form");
        panel.add(usernameLabel);
        panel.add(username);
        panel.add(telephoneLabel);
        panel.add(telephone);
        panel.add(genderLabel);
        panel.add(genderBox);
        panel.add(ok);
        panel.add(clean);
        panel.add(informationLabel);
        panel.add(information);

        add(panel);

        setVisible(true); //sea visible
    }

    private static void setLookAndFeel() {  //look and feel de el proyecto por eso es estatico
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            // ignore error
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String info;
        if (source == ok) {
               info = "Username: "+ username.getText()+ "\n"+ 
                       "Phone: "+ telephone.getText() + "\n" + 
                       "Gender: " + genderBox.getSelectedItem();
               information.setText(info);
        }else{
            if (source == clean) {
                username.setText("");
                telephone.setText("");
                genderBox.setSelectedIndex(0);
                information.setText("");
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Lab2.setLookAndFeel();
        Lab2 lab = new Lab2();
    }

}
