package Boundary;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Time;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransportManagementFrame extends JInternalFrame {
	private JTextField voterTransportIdNumber;
	private JTable transportDataTable;

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblReportTransport = new JLabel("Transport Report");
		lblReportTransport.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblReportTransport.setBounds(10, 0, 173, 35);
		getContentPane().add(lblReportTransport);
		
		voterTransportIdNumber = new JTextField();
		voterTransportIdNumber.setText("Enter Voter ID");
		voterTransportIdNumber.setBounds(20, 46, 109, 20);
		getContentPane().add(voterTransportIdNumber);
		voterTransportIdNumber.setColumns(10);
		
		JComboBox<String> comboBoxPickUp = new JComboBox<String>();
		comboBoxPickUp.setModel(new DefaultComboBoxModel(new String[] {"8:00", "8:15", "8:30", "8:45", "9:00", "9:15", "9:30", "9:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00"}));
		comboBoxPickUp.setToolTipText("Pickup Hour");
		comboBoxPickUp.setBounds(51, 101, 78, 22);
		getContentPane().add(comboBoxPickUp);
		
		JComboBox<String> comboBoxReturnHour = new JComboBox<String>();
		comboBoxReturnHour.setModel(new DefaultComboBoxModel(new String[] {"8:00", "8:15", "8:30", "8:45", "9:00", "9:15", "9:30", "9:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00"}));
		comboBoxReturnHour.setToolTipText("Return Hour");
		comboBoxReturnHour.setBounds(256, 101, 78, 22);
		getContentPane().add(comboBoxReturnHour);
		
		JLabel lblNewLabel = new JLabel("Pick up Hour");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(51, 76, 78, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblRetunHour = new JLabel("Retun Hour");
		lblRetunHour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblRetunHour.setBounds(256, 76, 78, 14);
		getContentPane().add(lblRetunHour);
		
		JScrollPane transportDataScrollPane = new JScrollPane();
		transportDataScrollPane.setBounds(10, 176, 414, 83);
		getContentPane().add(transportDataScrollPane);
		
		
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
					
				}
			}
		});
		submitButton.setForeground(Color.DARK_GRAY);
		submitButton.setBackground(Color.DARK_GRAY);
		submitButton.setBounds(158, 144, 89, 23);
		getContentPane().add(submitButton);

	}
}
