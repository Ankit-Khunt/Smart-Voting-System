/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineVotingSystem;

/**
 *
 * @author Ankit Khunt
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login_User extends JFrame implements ActionListener{

	private JPanel panel;
	private JTextField textField,textField_1;
	private JPasswordField passwordField;
        private JButton b1,b2,b3,b4;
        


	public Login_User() {
            
	setBackground(new Color(169, 169, 169));	
        setBounds(600, 300, 600, 400);
		
        panel = new JPanel();
	panel.setBackground(new Color(176, 224, 230));
	setContentPane(panel);
	panel.setLayout(null);

	JLabel l1 = new JLabel("Adhar No : ");
	l1.setBounds(124, 100, 95, 24);
	panel.add(l1);

        JLabel l6 = new JLabel("UserName: ");
	l6.setBounds(124, 125, 95, 24);
	panel.add(l6);

	JLabel l2 = new JLabel("Password : ");
	l2.setBounds(124, 150, 95, 24);
	panel.add(l2);

	textField = new JTextField();
	textField.setBounds(210, 100, 157, 20);
	panel.add(textField);
        
	textField_1 = new JTextField();
	textField_1.setBounds(210, 125, 157, 20);
	panel.add(textField_1);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(210, 150, 157, 20);
	panel.add(passwordField);

	

	b1 = new JButton("Login");
	b1.addActionListener(this);
                
	b1.setForeground(new Color(46, 139, 87));
	b1.setBackground(new Color(250, 250, 210));
	b1.setBounds(149, 190, 113, 39);
	panel.add(b1);
		
        b2 = new JButton("SignUp");
	b2.addActionListener(this);
	
	b2.setForeground(new Color(139, 69, 19));
	b2.setBackground(new Color(255, 235, 205));
	b2.setBounds(289, 190, 113, 39);
	panel.add(b2);

	b3 = new JButton("Forgot Password");
	b3.addActionListener(this);
	
        b3.setForeground(new Color(205, 92, 92));
	b3.setBackground(new Color(253, 245, 230));
	b3.setBounds(199, 250, 179, 39);
	panel.add(b3);
        
        b4=new JButton("Sign in Admin");
        b4.addActionListener(this);
        b4.setForeground(Color.blue);
        b4.setBackground(Color.white);
        b4.setBounds(430, 190, 113, 39);
        panel.add(b4);

	JLabel l5 = new JLabel("Trouble in Login?");
	l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
	l5.setForeground(new Color(255, 0, 0));
	l5.setBounds(70, 260, 130, 20);
	panel.add(l5);

		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(176, 224, 230));
		panel2.setBounds(24, 40, 434, 263);
		panel.add(panel2);
	}
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                Boolean status = false;
		try {
                    conn con = new conn();
                    String sql = "select * from users where Adhar_No=? and UserName=? and Password=?";
                    PreparedStatement st = con.c.prepareStatement(sql);

                    st.setString(1, textField.getText());
                    st.setString(2, textField_1.getText());
                    st.setString(3, passwordField.getText());

                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        this.setVisible(false);
                        new Loading2().setVisible(true);
                    } else
			JOptionPane.showMessageDialog(null, "Invalid Login...!.");
                       
		} catch (Exception e2) {
                    e2.printStackTrace();
		}
            }
            if(ae.getSource() == b2){
                setVisible(false);
		Signup su = new Signup();
		su.setVisible(true);
            }   
            if(ae.getSource() == b3){
                this.setVisible(false);
		Forgot forgot = new Forgot();
		forgot.setVisible(true);
            }
            if(ae.getSource()==b4){
                this.setVisible(false);
                new Admin_Login().setVisible(true);
                
            }
        }
        
  	public static void main(String[] args) {
                new Login_User().setVisible(true);
	}

}