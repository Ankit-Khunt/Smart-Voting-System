 
package OnlineVotingSystem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
        private JTextField textField_4;
            private JTextField textField_5;


    
    private JButton b1, b2;
    private JComboBox comboBox_1;


    public static void main(String[] args) {
        new Signup().setVisible(true);
    }

    public Signup() {
        setBounds(350,10,900,800);
        contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);
        
        JLabel lblAdharcard = new JLabel("Adharcard No   ");
	lblAdharcard.setForeground(Color.DARK_GRAY);
	lblAdharcard.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblAdharcard.setBounds(150, 120, 220, 26);
	contentPane.add(lblAdharcard);
        
        JLabel lblMobile = new JLabel("Mobile NO ");
	lblMobile.setForeground(Color.DARK_GRAY);
	lblMobile.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblMobile.setBounds(150, 150, 220, 26);
	contentPane.add(lblMobile);
        
        JLabel lblUserName = new JLabel("UserName ");
	lblUserName.setForeground(Color.DARK_GRAY);
	lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblUserName.setBounds(150, 180, 92, 26);
	contentPane.add(lblUserName);
        
        JLabel lblPassword = new JLabel("Password ");
	lblPassword.setForeground(Color.DARK_GRAY);
	lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblPassword.setBounds(150, 210, 92, 26);
	contentPane.add(lblPassword);
        
         JLabel lblScurityQus = new JLabel("Security Que ");
	lblScurityQus.setForeground(Color.DARK_GRAY);
	lblScurityQus.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblScurityQus.setBounds(150, 240, 200, 26);
	contentPane.add(lblScurityQus);
        
         JLabel lblAnswer = new JLabel("Answer ");
	lblAnswer.setForeground(Color.DARK_GRAY);
	lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblAnswer.setBounds(150, 270, 92, 26);
	contentPane.add(lblAnswer);
        
        textField_1 = new JTextField();
	textField_1.setBounds(300, 125, 148, 20);
	contentPane.add(textField_1);
	textField_1.setColumns(10);
        
         textField_2 = new JTextField();
	textField_2.setBounds(300, 155, 148, 20);
	contentPane.add(textField_2);
	textField_2.setColumns(10);
        
        textField_3 = new JTextField();
	textField_3.setBounds(300, 185, 148, 20);
	contentPane.add(textField_3);
	textField_3.setColumns(10);
        
         textField_4 = new JTextField();
	textField_4.setBounds(300, 215, 148, 20);
	contentPane.add(textField_4);
	textField_4.setColumns(10);
        
        
        
         comboBox_1 = new JComboBox();
	comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
			"Your child SuperHero?", "Your childhood Name ?" }));
	comboBox_1.setBounds(300, 245, 148, 20);
	contentPane.add(comboBox_1);
        
         textField_5 = new JTextField();
	textField_5.setBounds(300, 275, 148, 20);
	contentPane.add(textField_5);
	textField_5.setColumns(10);
        
        b1 = new JButton("Create");
	b1.addActionListener((ActionListener) this);
	b1.setFont(new Font("Tahoma", Font.BOLD, 13));
	b1.setBounds(180, 330, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener((ActionListener) this);
	b2.setFont(new Font("Tahoma", Font.BOLD, 13));
	b2.setBounds(300, 330, 100, 30);
	b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);
        
        
        
        JPanel panel = new JPanel();
	panel.setForeground(new Color(34, 139, 34));
	panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create-Account",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
	panel.setBounds(31, 10,700, 650);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);
        
        
        
          }
    
    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();
            
            if(ae.getSource() == b1){
                String sql = "insert into users(Adhar_No, Mobile_No, UserName, Password, Security_Q,Answers) values(?, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);

		st.setString(1, textField_1.getText());
                st.setString(2, textField_2.getText());
		st.setString(3, textField_3.getText());
                		st.setString(4, textField_4.getText());

                
		st.setString(5, (String) comboBox_1.getSelectedItem());
		st.setString(6, textField_5.getText());

		int i = st.executeUpdate();
		if (i > 0){
                    JOptionPane.showMessageDialog(null, "successfully Created");
                }

                textField_1.setText("");
                textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
                		textField_5.setText("");

            }
            if(ae.getSource() == b2){
                this.setVisible(false);
		new Login_User().setVisible(true);
			
            }
        }catch(Exception e){
            
        }
    }
}