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

public class postadvert extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textName;
	private JTextField textDes;
	private JTextField textPrice;
	private JTextField textContact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					postadvert frame = new postadvert();
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
			ResultSet rs=stmt.executeQuery("select * from advert");  
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (Exception e1) {
				e1.printStackTrace();
			}
	}
	/**
	 * Create the frame.
	 */
	public postadvert() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Post Advertisement");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(156, 11, 206, 27);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Post Advertisement");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				String description = textDes.getText();
				String price = textPrice.getText();
				String contact = textContact.getText();
				if(name.isEmpty() || description.isEmpty() || price.isEmpty() || contact.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter all the fields.");
				}
				else
				{
					try {
						Class.forName("com.mysql.jdbc.Driver");  
						Connection con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/city","root","root");  
						PreparedStatement pst = con.prepareStatement("INSERT INTO advert(Name, Description, Price, Contact) VALUES(?, ?, ?, ?)"); 
						pst.setNString(1, name);
						pst.setNString(2, description);
						pst.setNString(3, price);
						pst.setNString(4, contact);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Advertisement Posted Successfully!.");
						textName.setText(null);
						textDes.setText(null);
						textPrice.setText(null);
						textContact.setText(null);
						reload();
					} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
			}
		});
		btnNewButton.setBounds(311, 273, 156, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Home");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app app = new app();
				app.frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(311, 386, 156, 35);
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
			ResultSet rs=stmt.executeQuery("select * from advert");  
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (Exception e1) {
				e1.printStackTrace();
			}
		
		textName = new JTextField();
		textName.setBounds(143, 273, 122, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textDes = new JTextField();
		textDes.setBounds(143, 314, 122, 20);
		contentPane.add(textDes);
		textDes.setColumns(10);
		
		textPrice = new JTextField();
		textPrice.setBounds(143, 355, 122, 20);
		contentPane.add(textPrice);
		textPrice.setColumns(10);
		
		textContact = new JTextField();
		textContact.setBounds(143, 393, 122, 20);
		contentPane.add(textContact);
		textContact.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Name");
		lblNewLabel_1.setBounds(10, 277, 81, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Description");
		lblNewLabel_2.setBounds(10, 317, 95, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Price");
		lblNewLabel_3.setBounds(10, 358, 81, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Enter Contact");
		lblNewLabel_4.setBounds(10, 394, 81, 14);
		contentPane.add(lblNewLabel_4);
	}
}
