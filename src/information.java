import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;

public class information extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					information frame = new information();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public information() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 494, 314);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		try {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/city","root","root");  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from information");  
		table.setModel(DbUtils.resultSetToTableModel(rs));
	} catch (Exception e1) {
			e1.printStackTrace();
		}

		
		JLabel lblNewLabel = new JLabel("City Information Table");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(163, 11, 217, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Goto Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app app = new app();
				app.frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(287, 47, 217, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usermenu menu = new usermenu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 47, 217, 23);
		contentPane.add(btnNewButton_1);
	}
}
