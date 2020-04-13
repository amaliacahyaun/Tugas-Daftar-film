/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daftarfilm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Daftarfilm {

        public static void main(String[] args) {
        GUI g = new GUI();
        //MVC_Daftarfilm mvcp = new MVC_Daftarfilm();
    }
}
class GUI extends JFrame {
   final JTextField fnama = new JTextField(10);
   final JPasswordField fpass = new JPasswordField(10);

   JLabel lnama = new JLabel(" Username ");
   JLabel lpass = new JLabel(" Password ");
   JButton btnSave = new JButton("Login");
   

public GUI() {
setTitle("Login");
	setDefaultCloseOperation(3);
	setSize(350,200);
        setLocation(500,275);
setLayout(null);
	add(lnama);
	add(fnama);
        add(lpass);
	add(fpass);
        add(btnSave);
   
lnama.setBounds(10,10,120,20);
fnama.setBounds(140,10,150,20);
lpass.setBounds(10,30,120,20);
fpass.setBounds(140,30,150,20);
btnSave.setBounds(135,130,100,20);

        
        btnSave.addActionListener(new ActionListener(){
       
             @Override
             public void actionPerformed(ActionEvent e){
                 if(fnama.getText().length()>0){
                     JOptionPane.showMessageDialog(null, "Selamat Login Anda Sukses");
                     MVC_Daftarfilm mvcp = new MVC_Daftarfilm();
                 }
            dispose();
             }
   });
        
               
        setVisible(true);
}
}
    
