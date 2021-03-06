package Boundary;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel headerTopLabel = new JLabel("ElectDay");
		headerTopLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		headerTopLabel.setBounds(168, 39, 79, 21);
		getContentPane().add(headerTopLabel);
		
		JButton btnLoginFrame = new JButton("Login");
		btnLoginFrame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				appEngine.login(Integer.parseInt(txtId.getText()));
			}
		});
		btnLoginFrame.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 14));
		btnLoginFrame.setForeground(Color.DARK_GRAY);
		btnLoginFrame.setBounds(168, 187, 89, 23);
		getContentPane().add(btnLoginFrame);
		
		txtId = new JTextField();
		txtId.setText("Please Enter Your ID Number");
		txtId.setForeground(Color.GRAY);
		txtId.setBounds(108, 119, 193, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);

	}
}
