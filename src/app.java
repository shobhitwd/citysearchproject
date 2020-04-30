import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class app {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app window = new app();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public app() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("City Classified and Search Project");
		frame.setBounds(100, 100, 520, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Admin Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminlogin alogin = new adminlogin();
				alogin.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(95, 156, 124, 48);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Viewer Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userlogin ulogin = new userlogin();
				ulogin.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(298, 156, 124, 48);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Advertisements");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewadvert advert = new viewadvert();
				advert.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(185, 280, 156, 48);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("City Classified and Search Project");
		lblNewLabel.setForeground(new Color(204, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(54, 0, 424, 62);
		frame.getContentPane().add(lblNewLabel);
		ImageIcon MyImage = new ImageIcon(app.class.getResource("/rajwada.jpg"));
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(520, 435, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		JLabel lblbackimage = new JLabel("New label");
		lblbackimage.setIcon(new ImageIcon(newImg));
		lblbackimage.setBounds(0, 0, 504, 396);
		frame.getContentPane().add(lblbackimage);
	}
}
