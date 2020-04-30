import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class usermenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usermenu frame = new usermenu();
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
	public usermenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("City Information!");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(131, 11, 236, 44);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Post Advertisements");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postadvert post = new postadvert();
				post.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(43, 195, 163, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Advertisements");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewadvert view = new viewadvert();
				view.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewadvert ad = new viewadvert();
				ad.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(296, 195, 169, 44);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Home");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app app = new app();
				app.frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(296, 303, 169, 39);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View City Information");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				information info = new information();
				info.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(43, 303, 163, 39);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Available Actions ");
		lblNewLabel_1.setForeground(new Color(255, 204, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(37, 126, 231, 30);
		contentPane.add(lblNewLabel_1);
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userlogin ulogin = new userlogin();
				ulogin.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(176, 368, 173, 39);
		contentPane.add(btnNewButton_4);
		ImageIcon MyImage = new ImageIcon(app.class.getResource("/rajwada.jpg"));
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(520, 435, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		JLabel lblbackimage = new JLabel("New label");
		lblbackimage.setIcon(new ImageIcon(newImg));
		lblbackimage.setBounds(0, 3, 517, 428);
		getContentPane().add(lblbackimage);
		

	}

}
