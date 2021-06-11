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
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import static java.awt.image.ImageObserver.ABORT;

public class Home extends JFrame implements ActionListener{

	private JPanel contentPane;
        private JButton b1,b2,b3,b4,b5,b6;

	public static void main(String[] args) {
            new Home().setVisible(true);
	}
        
        public Home() {
	
            setBounds(400, 0, 750, 500);
            contentPane = new JPanel();
            setContentPane(contentPane);
            contentPane.setLayout(null);

            
            JMenuBar menuBar = new JMenuBar();
            menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 0), new Color(128, 128, 128)));
            menuBar.setBackground(Color.CYAN);
            menuBar.setBounds(0, 10, 1000, 35);
            contentPane.add(menuBar);

            JMenu mnExit = new JMenu("Exit");
            mnExit.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
            
            
            JMenuItem mntmLogout = new JMenuItem("Logout");
            mntmLogout.setBackground(new Color(211, 211, 211));
            mntmLogout.setForeground(new Color(105, 105, 105));
            mntmLogout.addActionListener(this);
            mnExit.add(mntmLogout);
            
            JMenuItem mntmExit = new JMenuItem("Exit");
            mntmExit.setForeground(new Color(105, 105, 105));
            mntmExit.setBackground(new Color(211, 211, 211));
            mntmExit.addActionListener(this);
            mnExit.add(mntmExit);
                
            

            

            JMenu mnRecord = new JMenu("Record");
            mnRecord.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
            

            JMenuItem Leaders_details = new JMenuItem("Leaders Details");
            Leaders_details.addActionListener(this);
            Leaders_details.setBackground(new Color(211, 211, 211));
            Leaders_details.setForeground(Color.DARK_GRAY);
            mnRecord.add(Leaders_details);

            
            
            menuBar.add(mnRecord);
           // menuBar.add(mnHelp);
            menuBar.add(mnExit);

            
            JLabel l1 = new JLabel("Online Voting System");
            l1.setForeground(new Color(204, 51, 102));
            l1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 30));
            l1.setBounds(268, 30, 701, 80);
            contentPane.add(l1);

            JLabel l2 = new JLabel("");
            l2.setVerticalAlignment(SwingConstants.TOP);
            ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("OnlineVotingSystem/icons/second.png"));
            Image i2 = i1.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            l2 = new JLabel(i3);
            l2.setBounds(60, 140, 159, 152);
            contentPane.add(l2);

            JLabel l3 = new JLabel("");
            ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("OnlineVotingSystem/icons/third.png"));
            Image i5 = i4.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
            ImageIcon i6 = new ImageIcon(i5);
            l3 = new JLabel(i6);
            l3.setBounds(500, 160, 134, 128);
            contentPane.add(l3);

            
            b1 = new JButton("Add Leader");
            b1.addActionListener(this);
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.WHITE);
            b1.setBounds(60, 320, 159, 44);
            contentPane.add(b1);

            b2 = new JButton("Show Activity");
            b2.addActionListener(this);
            b2.setBackground(Color.BLACK);
            b2.setForeground(Color.WHITE);
            b2.setBounds(500, 320, 139, 44);
            contentPane.add(b2);

           
            JPanel panel = new JPanel();
            panel.setBorder(new TitledBorder(new LineBorder(new Color(250, 60, 114), 2), "VOtind Management", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(220, 20, 60)));
            panel.setBounds(20, 120, 700, 260);
            panel.setBackground(Color.WHITE);
            contentPane.add(panel);

            

           
            
            getContentPane().setBackground(Color.WHITE);
            contentPane.setBackground(Color.WHITE);
	}
        
        
        public void actionPerformed(ActionEvent ae){
            String msg = ae.getActionCommand();
            if(msg.equals("Logout")){
                setVisible(false);
		new Login_User().setVisible(true);
            }else if(msg.equals("Exit")){
                System.exit(ABORT);
            
            }
            
            else if(msg.equals("Leaders Details")){
                setVisible(false);
		new Leaders_Details().setVisible(true);
            }
            if(ae.getSource() == b1){
                this.setVisible(false);
                new Add_Leader().setVisible(true);
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new Show_Activity().setVisible(true);
            }
            
            
            
           
            
            }
            
        }
