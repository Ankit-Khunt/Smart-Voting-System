/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineVotingSystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;


/**
 *
 * @author Ankit Khunt
 */
public class UserHome extends JFrame implements ActionListener  {
    
    private JPanel contentPane ;
    private JTable table;
     private JTextField search;
      JTextField t1;
       JTextField t2;
        JTextField t3;
    
    private JButton b1,b2,b3,b4;
    
    public static void main (String[] args){
        new UserHome().setVisible(true);
    }
    
        
          public void Leader_table() {
	try {
            conn con = new conn();
            String sql = "select * from Leaders";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
	} catch (Exception e) {
	
	}
    }
    
    public UserHome(){
        
        setBounds(400,0,750,800);
        contentPane=new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel l1 = new JLabel("Name");
            l1.setForeground(new Color(204, 51, 102));
            l1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
            l1.setBounds(70, 30, 100, 30);
            contentPane.add(l1);
            
            
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(20, 100, 700, 300);
	contentPane.add(scrollPane);
        
        table = new JTable();
	table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
		search.setText(table.getModel().getValueAt(row, 1).toString());
            }
	});
        table.setBackground(Color.ORANGE);
	table.setForeground(Color.DARK_GRAY);
	table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	scrollPane.setViewportView(table);
        Leader_table();

        JLabel l4 = new JLabel("Leader ID");
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setForeground(new Color(47, 79, 79));
	l4.setBounds(47, 500, 100, 23);
	contentPane.add(l4);

	JLabel l2 = new JLabel("Name");
	l2.setForeground(new Color(47, 79, 79));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(47, 520, 100, 23);
	contentPane.add(l2);

	JLabel l3 = new JLabel("Icon");
	l3.setForeground(new Color(47, 79, 79));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(47, 540, 100, 23);
	contentPane.add(l3);
        
        t1 = new JTextField();
	t1.setForeground(new Color(47, 79, 79));
	t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t1.setBounds(150, 505, 130, 20);
	contentPane.add(t1);
        
         t2 = new JTextField();
	t2.setForeground(new Color(47, 79, 79));
	t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t2.setBounds(150, 525, 130, 20);
	contentPane.add(t2);

         t3 = new JTextField();
	t3.setForeground(new Color(47, 79, 79));
	t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t3.setBounds(150, 545, 130, 20);
	contentPane.add(t3);
        
        
	b1 = new JButton("Go");
	b1.addActionListener(this);
	b1.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	b1.setBounds(350, 500, 100, 30);
        contentPane.add(b1);
        
          b4 = new JButton("Back");
	b4.addActionListener(this);
	b4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	b4.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	b4.setBounds(350, 540, 100, 33);
	b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        contentPane.add(b4);
        
        b3 = new JButton("VOTE");
	b3.addActionListener(this);
	b3.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
	b3.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
	b3.setBounds(200, 630, 100, 30);
        contentPane.add(b3);
        
        JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Issue-Book",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
	panel.setFont(new Font("Tahoma", Font.BOLD, 14));
	panel.setBounds(10, 450, 500, 288);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);
        
        
        
       

        
        
        
        
            
          
            
            
            
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        try{
            conn con = new conn();
            if(ae.getSource() == b1){
                String sql = "select * from leaders where Leader_id = ?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, t1.getText());
		ResultSet rs = st.executeQuery();
		
                while (rs.next()) {
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("icon"));
                   
		}
		st.close();
		rs.close();
		
              }
            
            if(ae.getSource() == b4){
                this.setVisible(false);
		new Login_User().setVisible(true);
			
            }
            
            if(ae.getSource() == b3){
                    try{
                String sql = "insert into UserVote(Leader_id,name,icon) values(?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, t1.getText());
		st.setString(2, t2.getText());
		st.setString(3, t2.getText());
		
		int i = st.executeUpdate();
		if (i > 0)
                    JOptionPane.showMessageDialog(null, "Thank You for your Vote");
		else
                    JOptionPane.showMessageDialog(null, "error");
                    }catch(Exception e){
                        e.printStackTrace();
                                }
            }
            
            
            
            
            
            
            
    }
        
        
        
        
        catch(Exception e){
            
        }
    
    
    
    
    
    
    





    
    
    
}
}
