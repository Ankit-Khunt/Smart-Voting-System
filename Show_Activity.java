package OnlineVotingSystem;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Show_Activity extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTable table_1;
    private JButton b1;

    public static void main(String[] args) {
        new Show_Activity().setVisible(true);
    }

    public void UserVote() {
        try {
            conn con = new conn();
            String sql = "select * from UserVote";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public Show_Activity() {
        setBounds(400, 200, 810, 594);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(40, 51, 708, 217);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(224, 255, 255));
        table.setForeground(new Color(128, 128, 0));
        table.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        scrollPane.setViewportView(table);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Voting Details",
                    TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 128)));
        panel.setForeground(new Color(0, 128, 128));
        panel.setBounds(26, 36, 737, 240);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
        
        JLabel l1 = new JLabel("Back");
	l1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
		setVisible(false);
		Home home = new Home();
		home.setVisible(true);
            }
	});
	l1.setForeground(new Color(204, 0, 102));
	l1.setFont(new Font("Tahoma", Font.BOLD, 18));
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("OnlineVotingSystem/icons/tenth.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1.setIcon(i3);
	l1.setBounds(690, 13, 96, 27);
	contentPane.add(l1);

        UserVote();

    }
}
