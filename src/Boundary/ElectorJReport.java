package Boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entity.JasperReportEntities;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.LayoutStyle.ComponentPlacement;


public class ElectorJReport extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElectorJReport frame = new ElectorJReport();
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
	public ElectorJReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnElectorBallots = new JButton("Turnout by Ballot");
		btnElectorBallots.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JasperReportEntities jasperReportEntities = new JasperReportEntities();
				jasperReportEntities.compileElectorBallotReport().setVisible(true);
			}
		});
		
		JButton btnTurnoutCity = new JButton("Turnout by City");
		btnTurnoutCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JasperReportEntities jasperReportEntities = new JasperReportEntities();
				jasperReportEntities.compileElectorCityReport().setVisible(true);
			}
		});
		
		JButton btnTurnoutNational = new JButton("National Turnout");
		btnTurnoutNational.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JasperReportEntities jasperReportEntities = new JasperReportEntities();
				jasperReportEntities.compileElectorNationalReport().setVisible(true);
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnElectorBallots)
					.addGap(18)
					.addComponent(btnTurnoutCity)
					.addGap(18)
					.addComponent(btnTurnoutNational)
					.addContainerGap(67, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTurnoutCity)
						.addComponent(btnElectorBallots)
						.addComponent(btnTurnoutNational))
					.addContainerGap(183, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
	
}
