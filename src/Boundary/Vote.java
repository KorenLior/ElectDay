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

public class Vote extends JFrame {

	private JPanel contentPane;
	private JTextField tfBallot;
	private JTextField tfEmployeeID;
	private final Action saveVote = new SwingActionSave();
	private final Action actionValid = new SwingActionValid();
	private JButton btnLogin;
	private final Action Login = new SwingActionLogin();
	private JLabel lblNewLabel_2;
	private boolean login = false;
	private int empID;
	private int ballotNum;
	private JComboBox<String> comboBoxPartyList;
	private JCheckBox chckbxVoteValid;
	private VoteLogCTRL voteLogCTRL = new VoteLogCTRL();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vote frame = new Vote();
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
	public Vote() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 394);
		contentPane = new JPanel();
		contentPane.setToolTipText("EmployeeID");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		PartiesCTRL partiesCtrl = new PartiesCTRL();
		
		JButton btnSaveVote = new JButton("Save Vote");
		btnSaveVote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSaveVote.setAction(saveVote);
		btnSaveVote.setText("Save Vote");
		JButton btnCancel = new JButton("Cancel");
		
		tfBallot = new JTextField();
		tfBallot.setToolTipText("Ballot Number");
		tfBallot.setColumns(10);
		
		tfEmployeeID = new JTextField();
		tfEmployeeID.setToolTipText("EmployeeID");
		tfEmployeeID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("EmployeeID");
		
		JLabel lblNewLabel_1 = new JLabel("Ballot");
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogin.setAction(Login);
		btnLogin.setText("Report Ballot Votes");
		
		lblNewLabel_2 = new JLabel("ENTER VALID EMPLOYEE ID AND BALLOT NUMBER\r\nTO REPORT VOTE COUNTING");
		
		chckbxVoteValid = new JCheckBox("Vote Valid");
		chckbxVoteValid.setAction(actionValid);
		
		comboBoxPartyList = new JComboBox();
		comboBoxPartyList.addItem("Blank Vote");
		ArrayList<String> parties = partiesCtrl.getParties();
		for (String party : parties)
		{
			comboBoxPartyList.addItem(party);
		}
		comboBoxPartyList.disable();
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
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
										.addComponent(btnCancel)
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
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(90, Short.MAX_VALUE))
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
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxVoteValid)
						.addComponent(comboBoxPartyList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSaveVote))
					.addGap(18)
					.addComponent(btnCancel)
					.addGap(114))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private class SwingActionSave extends AbstractAction {
		public SwingActionSave() {
			putValue(NAME, "saveVote");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			VoteLogCTRL voteLogCtrl = new VoteLogCTRL();
			try {
				voteLogCtrl.logVote(Integer.parseInt(tfBallot.getText()), Integer.parseInt(tfEmployeeID.getText()),
						chckbxVoteValid.isSelected(), (String)comboBoxPartyList.getSelectedItem());
			}
			catch (Exception logVote)
			{
				System.out.println("NOT LOGGED EXCEPTION: "+tfBallot.getText() +" " + tfEmployeeID.getText() +" "+
						chckbxVoteValid.isSelected()+ " " + (String)comboBoxPartyList.getSelectedItem());
			}
		}
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
	private class SwingActionLogin extends AbstractAction {
		public SwingActionLogin() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
