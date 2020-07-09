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
import javax.swing.JLabel;


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
		contentPane.add(panel, BorderLayout.EAST);
		
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
		
		JLabel lblNewLabel = new JLabel("Elector Turnout");
		
		JLabel lblNewLabel_1 = new JLabel("Vote Count");
		
		JButton btnNewButton = new JButton("By Ballot");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JasperReportEntities jasperReportEntities = new JasperReportEntities();
				jasperReportEntities.compileVotesBallot().setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("By City");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JasperReportEntities jasperReportEntities = new JasperReportEntities();
				jasperReportEntities.compileVotesCity().setVisible(true);
			}
		});
		
		JButton btnNewButton_2 = new JButton("National");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JasperReportEntities jasperReportEntities = new JasperReportEntities();
				jasperReportEntities.compileVotesNational().setVisible(true);
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(197, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_2))
						.addComponent(lblNewLabel_1))
					.addGap(113))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(133)
					.addComponent(btnElectorBallots)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnTurnoutCity)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnTurnoutNational)))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTurnoutCity)
						.addComponent(btnTurnoutNational)
						.addComponent(btnElectorBallots))
					.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton))
					.addGap(63))
		);
		panel.setLayout(gl_panel);
	}
}
