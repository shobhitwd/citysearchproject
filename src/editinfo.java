import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class editinfo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textName;
	private JTextField textAddress;
	private JTextField textContact;
	private JTextField textType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editinfo frame = new editinfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    public void reload()
	{
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
	}
	/**
	 * Create the frame.
	 */
	public editinfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit City Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(156, 11, 206, 27);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Info");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				String address = textAddress.getText();
				String contact = textContact.getText();
				String type = textType.getText();
				if(name.isEmpty() || address.isEmpty() || contact.isEmpty() || type.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter all the fields.");
				}
				else
				{
					try {
						Class.forName("com.mysql.jdbc.Driver");  
						Connection con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/city","root","root");  
						PreparedStatement pst = con.prepareStatement("INSERT INTO information(Name, Address, Contact, Type) VALUES(?, ?, ?, ?)"); 
						pst.setNString(1, name);
						pst.setNString(2, address);
						pst.setNString(3, contact);
						pst.setNString(4, type);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Information Inserted Successfully.");
						textName.setText(null);
						textAddress.setText(null);
						textContact.setText(null);
						textType.setText(null);
						reload();
					} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
			}
		});
		btnNewButton.setBounds(361, 273, 106, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete Info");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				if(name.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter the name to be deleted.");
				}
				else
				{
					try {
						Class.forName("com.mysql.jdbc.Driver");  
						Connection con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/city","root","root");  
						PreparedStatement pst = con.prepareStatement("DELETE from information where Name=?"); 
						pst.setNString(1, name);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Information Deleted Successfully");
						textName.setText(null);
						textAddress.setText(null);
						textContact.setText(null);
						textType.setText(null);
						reload();
					} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
			}
		});
		btnNewButton_1.setBounds(361, 330, 106, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Home");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app app = new app();
				app.frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(218, 330, 106, 35);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 501, 216);
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
		
		textName = new JTextField();
		textName.setBounds(101, 274, 86, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textAddress = new JTextField();
		textAddress.setBounds(101, 314, 86, 20);
		contentPane.add(textAddress);
		textAddress.setColumns(10);
		
		textContact = new JTextField();
		textContact.setBounds(101, 355, 86, 20);
		contentPane.add(textContact);
		textContact.setColumns(10);
		
		textType = new JTextField();
		textType.setBounds(101, 391, 86, 20);
		contentPane.add(textType);
		textType.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Name");
		lblNewLabel_1.setBounds(10, 277, 81, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Address");
		lblNewLabel_2.setBounds(10, 317, 81, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Contact");
		lblNewLabel_3.setBounds(10, 358, 81, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Enter Type");
		lblNewLabel_4.setBounds(10, 394, 81, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminmenu menu = new adminmenu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(361, 386, 106, 35);
		contentPane.add(btnNewButton_3);
	}
}
