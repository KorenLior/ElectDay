package Boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.BasicConfigurator;

import Control.PartiesCTRL;
import Control.VoteLogCTRL;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Button;

public class BallotVoteCountManagement extends JFrame{

	private JLayeredPane contentPane;
	private JTextField tfBallot;

	private final Action actionValid = new SwingActionValid();
	private JButton btnLogin;
	private JButton btnSaveVote;
	private JComboBox<String> comboBoxPartyList;
	private JCheckBox chckbxVoteValid;
	private VoteLogCTRL voteLogCTRL = new VoteLogCTRL();
	private JLabel lblBallot;
	private JButton btnCloseBallot;
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
					BallotVoteCountManagement frame = new BallotVoteCountManagement();
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
	public BallotVoteCountManagement() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 321);
		
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
		mntmLogRide.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				appEngine.logRides();
			}
		});
		mnManage.add(mntmLogRide);
		
		mntmReportCount = new JMenuItem("Count Votes");
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
		
		
		
		
		contentPane = new JLayeredPane();
		contentPane.setToolTipText("EmployeeID");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		PartiesCTRL partiesCtrl = new PartiesCTRL();
		
		btnSaveVote = new JButton("Save Vote");
		btnSaveVote.setEnabled(false);
		btnSaveVote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (voteLogCTRL.isLogged())
				{
					try {
						if (chckbxVoteValid.isSelected())
						{
							voteLogCTRL.logVote("Yes", (String)comboBoxPartyList.getSelectedItem());
						}
						else
						{
							voteLogCTRL.logVote("No", null);
						}
					}
					catch (Exception logVote)
					{
						System.out.println("SAVE EXCEPTION: "+tfBallot.getText() +" "+
								chckbxVoteValid.isSelected()+ " " + (String)comboBoxPartyList.getSelectedItem());
					}
				}
			}
		});
		
		
		
		
		tfBallot = new JTextField();
		tfBallot.setToolTipText("Ballot Number");
		tfBallot.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ballot");
		
		btnLogin = new JButton("Report Ballot Votes");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					voteLogCTRL.login( appEngine.getEmployeeId(), Integer.parseInt(tfBallot.getText()) );
				}
				catch (Exception loginFailExcetion)
				{
					voteLogCTRL = new VoteLogCTRL();
				}
				if (voteLogCTRL.isLogged())
				{
					lblBallot.setText(voteLogCTRL.getBallot());
					btnSaveVote.setEnabled(true);
					btnCloseBallot.setEnabled(true);
				}
			}
		});
		
		chckbxVoteValid = new JCheckBox("Vote Valid");
		chckbxVoteValid.setAction(actionValid);
		chckbxVoteValid.setText("Vote Valid");
		comboBoxPartyList = new JComboBox();
		ArrayList<String> parties = partiesCtrl.getParties();
		for (String party : parties)
		{
			comboBoxPartyList.addItem(party);
		}
		comboBoxPartyList.disable();
		
		lblBallot = new JLabel("UNIDENTIFIED BALLOT");
		
		btnCloseBallot = new JButton("Close Ballot");
		btnCloseBallot.setEnabled(false);
		btnCloseBallot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (voteLogCTRL.isLogged())
				{
					voteLogCTRL.closeBallot();
					lblBallot.setText(voteLogCTRL.getBallot());
					btnSaveVote.setEnabled(true);
				}
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(chckbxVoteValid, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBoxPartyList, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnSaveVote))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblBallot, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCloseBallot)))
							.addGap(88))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfBallot, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLogin)
							.addContainerGap(282, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(tfBallot, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLogin))
					.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBallot)
						.addComponent(btnCloseBallot))
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxVoteValid)
						.addComponent(comboBoxPartyList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSaveVote))
					.addGap(132))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	
	
	private class SwingActionValid extends AbstractAction {
		public SwingActionValid() {
			putValue(NAME, "actionValid");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if (chckbxVoteValid.isSelected())
			{
				comboBoxPartyList.enable();
			}
			else
			{
				comboBoxPartyList.disable();
			}
		}
	}
	
	

	
}
