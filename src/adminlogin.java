

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.*;  
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class adminlogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAsd;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminlogin frame = new adminlogin();
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
	public adminlogin() {
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setSize(500, 360);
		txtAsd = new JTextField();
		txtAsd.setBackground(new Color(255, 255, 255));
		txtAsd.setToolTipText("");
		txtAsd.setBounds(257, 121, 142, 35);
		contentPane.add(txtAsd);
		txtAsd.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/city","root","root"); 
					Statement stmt=con.createStatement();  
					ResultSet rs=stmt.executeQuery("select * from users"); 
					String u1 = txtAsd.getText();
					String u2 = passwordField.getText();
					int flag = 0;
					while(rs.next()) 
					{
						String u3 = rs.getString(2);
						String u4 = rs.getString(3);
						String u5 = rs.getString(4);
						String u6 = "admin";
						if(u1.equals(u3) && u4.equals(u2) && u5.equals(u6))
						{
							flag = 1;
							adminmenu admin = new adminmenu();
							admin.setVisible(true);
							dispose();
						}
					}
					if(flag==0)
					{
						JOptionPane.showMessageDialog(null, "Incorrect login details");
						txtAsd.setText(null);
						passwordField.setText(null);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnNewButton.setBounds(257, 307, 142, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Enter your Username");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(25, 122, 167, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your Password");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(25, 202, 167, 32);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(257, 203, 142, 35);
		contentPane.add(passwordField);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app app = new app();
				app.frame.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(70, 307, 122, 35);
		contentPane.add(btnHome);
		
		JLabel lblNewLabel_2 = new JLabel("Admin Login Arena!");
		lblNewLabel_2.setForeground(new Color(255, 204, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(141, 11, 212, 43);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("User Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userlogin ulogin = new userlogin();
				ulogin.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(167, 375, 122, 35);
		contentPane.add(btnNewButton_1);
		ImageIcon MyImage = new ImageIcon(app.class.getResource("/rajwada.jpg"));
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(520, 435, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		JLabel lblbackimage = new JLabel("New label");
		lblbackimage.setIcon(new ImageIcon(newImg));
		lblbackimage.setBounds(0, 0, 484, 421);
		getContentPane().add(lblbackimage);
	}
}
