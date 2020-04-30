import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class adminmenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminmenu frame = new adminmenu();
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
	public adminmenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Post/Edit Information");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editinfo info = new editinfo();
				info.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(45, 205, 175, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Post Advertisement");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postadvert post = new postadvert();
				post.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(286, 205, 175, 33);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Available Actions -:");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(33, 111, 210, 47);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Home");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app app = new app();
				app.frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(45, 280, 175, 33);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("City Information Admin Panel");
		lblNewLabel_1.setForeground(new Color(204, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(86, 11, 375, 33);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminlogin alogin = new adminlogin();
				alogin.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(293, 281, 168, 31);
		contentPane.add(btnNewButton_3);
		ImageIcon MyImage = new ImageIcon(app.class.getResource("/rajwada.jpg"));
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(520, 435, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		JLabel lblbackimage = new JLabel("New label");
		lblbackimage.setIcon(new ImageIcon(newImg));
		lblbackimage.setBounds(0, 0, 517, 405);
		getContentPane().add(lblbackimage);
		

	}
}
