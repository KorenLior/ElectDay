package Boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class BallotVoteCountManagement extends JFrame {

	private JLayeredPane contentPane;
	private JTextField tfBallot;
	private JTextField tfEmployeeID;

	private final Action actionValid = new SwingActionValid();
	private JButton btnLogin;
	private JButton btnSaveVote;

	private JLabel lblNewLabel_2;
	private JComboBox<String> comboBoxPartyList;
	private JCheckBox chckbxVoteValid;
	private VoteLogCTRL voteLogCTRL = new VoteLogCTRL();
	private JLabel lblEmployee;
	private JLabel lblBallot;
	private JButton btnCloseBallot;

	private JMenuBar menuBar;
	private JMenu mnMenu;
	private JMenuItem mntmManageViewReports;
	private JMenuItem mntmExit;
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
		setBounds(100, 100, 587, 394);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMenu = new JMenu("menu");
		menuBar.add(mnMenu);
		
		mntmManageViewReports = new JMenuItem("View Reports");
		mntmManageViewReports.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (voteLogCTRL.isManager())
				{
					System.out.println("fghfghfgh");
					ElectorJReport newFrame = new ElectorJReport();
					newFrame.setVisible(true);
					//set default close operation
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
				else
				{
					System.out.println("Login as Manager to view reports");
				}
			}
		});
		mntmManageViewReports.setText("View Reports");
		mntmManageViewReports.setEnabled(true);
		mnMenu.add(mntmManageViewReports);
		
		mntmExit = new JMenuItem("New menu item");
		mnMenu.add(mntmExit);
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
						System.out.println("SAVE EXCEPTION: "+tfBallot.getText() +" " + tfEmployeeID.getText() +" "+
								chckbxVoteValid.isSelected()+ " " + (String)comboBoxPartyList.getSelectedItem());
					}
				}
			}
		});
		
		
		
		
		tfBallot = new JTextField();
		tfBallot.setToolTipText("Ballot Number");
		tfBallot.setColumns(10);
		
		tfEmployeeID = new JTextField();
		tfEmployeeID.setToolTipText("EmployeeID");
		tfEmployeeID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("EmployeeID");
		
		JLabel lblNewLabel_1 = new JLabel("Ballot");
		
		btnLogin = new JButton("Report Ballot Votes");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					voteLogCTRL.login( Integer.parseInt(tfEmployeeID.getText()), Integer.parseInt(tfBallot.getText()) );
				}
				catch (Exception loginFailExcetion)
				{
					voteLogCTRL = new VoteLogCTRL();
				}
				if (voteLogCTRL.isLogged())
				{
					lblEmployee.setText(voteLogCTRL.getEmployee());
					lblBallot.setText(voteLogCTRL.getBallot());
					btnSaveVote.setEnabled(true);
				}
			}
		});
		
		lblNewLabel_2 = new JLabel("ENTER VALID EMPLOYEE ID AND BALLOT NUMBER TO REPORT VOTE COUNTING");
		
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
		
		lblEmployee = new JLabel("UNIDENTIFIED EMPLOYEE");
		
		lblBallot = new JLabel("UNIDENTIFIED BALLOT");
		
		btnCloseBallot = new JButton("Close Ballot");
		btnCloseBallot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (voteLogCTRL.isLogged())
				{
					voteLogCTRL.closeBallot();
					lblEmployee.setText(voteLogCTRL.getEmployee());
					lblBallot.setText(voteLogCTRL.getBallot());
					btnSaveVote.setEnabled(true);
				}
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(chckbxVoteValid, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBoxPartyList, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnSaveVote)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfEmployeeID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfBallot, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnLogin))))
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEmployee, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblBallot, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCloseBallot)))
					.addGap(88))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(tfEmployeeID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(tfBallot, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLogin))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblEmployee, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBallot)
						.addComponent(btnCloseBallot))
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxVoteValid)
						.addComponent(comboBoxPartyList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSaveVote))
					.addGap(18)
					.addGap(114))
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
