package Boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Control.PartiesCTRL;


public class ElectorBook extends JFrame {

	private JPanel contentPane;
	private JTable tableElectors;
	private JMenuBar menuBar;
	private JMenu mnManage;
	private JMenuItem mntmElectorBook;
	private JMenuItem mntmManageSystem;
	private JMenuItem mntmLogRide;
	private JMenuItem mntmReportCount;
	private JMenuItem mntmViewReports;
	private JButton btnRefresh;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElectorBook frame = new ElectorBook();
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
	public ElectorBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnManage = new JMenu("menu");
		menuBar.add(mnManage);
		
		mntmElectorBook = new JMenuItem("Elector Book");
		mnManage.add(mntmElectorBook);
		
		mntmLogRide = new JMenuItem("Log Rides");
		mntmLogRide.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				appEngine.logRides();
			}
		});
		mnManage.add(mntmLogRide);
		
		mntmReportCount = new JMenuItem("Count Votes");
		mntmReportCount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				appEngine.countVotes();
			}
		});
		mnManage.add(mntmReportCount);
		
		mntmViewReports = new JMenuItem("View Reports");
		mntmViewReports.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				appEngine.electorReports();
			}
		});
		mnManage.add(mntmViewReports);
		
		mntmManageSystem = new JMenuItem("System Management");
		mntmManageSystem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				appEngine.systemManage();
			}
		});
		mnManage.add(mntmManageSystem);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnElectorTurnout = new JButton("Report Elector Turnout");
		btnElectorTurnout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog popup = new ElectorTurnoutUpdateForm();
				popup.setVisible(true);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnRefresh = new JButton("Refresh Table");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vector<String> columnNames = new Vector<String>();
				columnNames.add("Ballot");
				columnNames.add("ID");
				columnNames.add("Last Name");
				columnNames.add("First Name");
				columnNames.add("Address");
				columnNames.add("Phone");
				columnNames.add("Vote Time");
				tableElectors = new JTable(appEngine.getElectorsTable(),columnNames);
				scrollPane.setViewportView(tableElectors);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(btnElectorTurnout)
					.addGap(182)
					.addComponent(btnRefresh)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnElectorTurnout)
						.addComponent(btnRefresh))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
		);
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Ballot");
		columnNames.add("ID");
		columnNames.add("Last Name");
		columnNames.add("First Name");
		columnNames.add("Address");
		columnNames.add("Phone");
		columnNames.add("Vote Time");
		tableElectors = new JTable(appEngine.getElectorsTable(),columnNames);
		scrollPane.setViewportView(tableElectors);
		contentPane.setLayout(gl_contentPane);
	}


}
