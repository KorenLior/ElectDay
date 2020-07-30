package Boundary;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

public class LoginFrame extends JInternalFrame {
	private JTextField loginTextField;

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel headerTopLabel = new JLabel("ElectDay");
		headerTopLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		headerTopLabel.setBounds(168, 39, 79, 21);
		getContentPane().add(headerTopLabel);
		
		JButton btnLoginFrame = new JButton("Login");
		btnLoginFrame.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 14));
		btnLoginFrame.setForeground(Color.DARK_GRAY);
		btnLoginFrame.setBounds(168, 187, 89, 23);
		getContentPane().add(btnLoginFrame);
		
		loginTextField = new JTextField();
		loginTextField.setText("Please Enter Your ID Number");
		loginTextField.setForeground(Color.GRAY);
		loginTextField.setBounds(108, 119, 193, 20);
		getContentPane().add(loginTextField);
		loginTextField.setColumns(10);

	}
}
