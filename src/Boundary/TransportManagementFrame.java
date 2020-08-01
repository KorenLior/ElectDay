package Boundary;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.sql.Time;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Control.PartiesCTRL;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class TransportManagementFrame extends JFrame {
	private JTextField voterTransportIdNumber;
	private JTable transportDataTable;
	private JMenuBar menuBar;
	private JMenu mnManage;
	private JMenuItem mntmElectorBook;
	private JMenuItem mntmManageSystem;
	private JMenuItem mntmLogRide;
	private JMenuItem mntmReportCount;
	private JMenuItem mntmViewReports;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransportManagementFrame frame = new TransportManagementFrame();
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
	public TransportManagementFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 337);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnManage = new JMenu("menu");
		menuBar.add(mnManage);
		
		mntmElectorBook = new JMenuItem("Elector Book");
		mntmElectorBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				appEngine.electorBook();
			}
		});
		mnManage.add(mntmElectorBook);
		
		mntmLogRide = new JMenuItem("Log Rides");
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
		
		JLabel lblReportTransport = new JLabel("Transport Report");
		lblReportTransport.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		voterTransportIdNumber = new JTextField();
		voterTransportIdNumber.setText("Enter Voter ID");
		voterTransportIdNumber.setColumns(10);
		
		JComboBox<String> comboBoxPickUp = new JComboBox<String>();
		comboBoxPickUp.setModel(new DefaultComboBoxModel(new String[] {"8:00", "8:15", "8:30", "8:45", "9:00", "9:15", "9:30", "9:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00"}));
		comboBoxPickUp.setToolTipText("Pickup Hour");
		
		JComboBox<String> comboBoxReturnHour = new JComboBox<String>();
		comboBoxReturnHour.setModel(new DefaultComboBoxModel(new String[] {"8:00", "8:15", "8:30", "8:45", "9:00", "9:15", "9:30", "9:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00"}));
		comboBoxReturnHour.setToolTipText("Return Hour");
		
		JLabel lblNewLabel = new JLabel("Pick up Hour");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		JLabel lblRetunHour = new JLabel("Retun Hour");
		lblRetunHour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		JScrollPane transportDataScrollPane = new JScrollPane();
		
		/* result.add(elector);
		 result.add(name);
		 result.add(electorAddress);
		 result.add(ballotAddress);
		 result.add(assignedTime.toString());
		 result.add(assignedID);
		 result.add(assignedName);
		 result.add(driverId);
		 result.add(pickupT);
		 result.add(returnT);*/
		Vector<Vector<Object>> ridersTable = appEngine.getRiders();
		Vector<Object> ridersColumnNames = new Vector<Object>();
		ridersColumnNames.add("Elector Id");
		ridersColumnNames.add("Elector Name");
		ridersColumnNames.add("Elector Phone");
		ridersColumnNames.add("Elector Address");
		ridersColumnNames.add("Ballot Address");
		ridersColumnNames.add("Ballot");
		ridersColumnNames.add("Assigned Ride Time");
		ridersColumnNames.add("Assigned Driver ID");
		ridersColumnNames.add("Assigned Driver Name");
		ridersColumnNames.add("Driver ID");
		ridersColumnNames.add("Pickup Time");
		ridersColumnNames.add("Return Time");
		transportDataTable = new JTable(ridersTable, ridersColumnNames);
		transportDataScrollPane.setViewportView(transportDataTable);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int elector = Integer.parseInt(voterTransportIdNumber.getText());
					String pickUp = (String)comboBoxPickUp.getSelectedItem();
					String returnTime = (String)comboBoxReturnHour.getSelectedItem();
					appEngine.setRide(elector, pickUp, returnTime);
				}
				catch (Exception e) {
					System.out.println("setRide failure");
				}
				transportDataTable = new JTable(appEngine.getRiders(), ridersColumnNames);
				transportDataScrollPane.setViewportView(transportDataTable);
			}
		});
		submitButton.setForeground(Color.DARK_GRAY);
		submitButton.setBackground(Color.DARK_GRAY);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblReportTransport, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(voterTransportIdNumber, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(127)
					.addComponent(lblRetunHour, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(comboBoxPickUp, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(127)
					.addComponent(comboBoxReturnHour, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(158)
					.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(transportDataScrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
					.addGap(8))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblReportTransport, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(voterTransportIdNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblRetunHour))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxPickUp, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxReturnHour, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addComponent(submitButton)
					.addGap(9)
					.addComponent(transportDataScrollPane, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
					.addGap(17))
		);
		getContentPane().setLayout(groupLayout);

	}
}
