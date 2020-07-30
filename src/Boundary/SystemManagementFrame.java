package Boundary;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class SystemManagementFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemManagementFrame frame = new SystemManagementFrame();
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
	public SystemManagementFrame() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton importFormsBtn = new JButton("Import Forms");
		importFormsBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 11));
		importFormsBtn.setBounds(151, 79, 126, 32);
		getContentPane().add(importFormsBtn);
		
		JButton btnUpdateCurrentForms = new JButton("Update");
		btnUpdateCurrentForms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdateCurrentForms.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 11));
		btnUpdateCurrentForms.setBounds(151, 167, 126, 32);
		getContentPane().add(btnUpdateCurrentForms);
		
		JLabel lblNewLabel = new JLabel("System Management");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(130, 11, 164, 14);
		getContentPane().add(lblNewLabel);

	}

}
