package Boundary;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class SystemManagementFrame extends JFrame {
	private JTable tableSecondaryBranch;
	private JTable tableMainBranch;
	private JTable tableEmployees;
	private JTextField txtMain;
	private JTextField txtManagerID;
	private JTextField txtDeputyId1;
	private JTextField txtDeputyId2;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 588);
		
		
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
		
		
		JButton btnImport = new JButton("Import System Data");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnImport.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 11));
		JComboBox<Integer> comboBoxMain = new JComboBox<Integer>();
		ArrayList<Integer> mainBranches = appEngine.getMainBranches();
		for (Integer mainBranch:mainBranches) {
			comboBoxMain.addItem(mainBranch);
		}
		JComboBox<Integer> comboBoxSecondary = new JComboBox<Integer>();
		ArrayList<Integer> SecondaryBranches = appEngine.getSecondaryBranches();
		for (Integer secondaryBranch:SecondaryBranches) {
			comboBoxSecondary.addItem(secondaryBranch);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		JScrollPane scrollPane_1 = new JScrollPane();
		JScrollPane scrollPane_2 = new JScrollPane();
		
		Vector<Object> tblEmployeeColumnNames = new Vector<Object>();
		tblEmployeeColumnNames.add("Branch");
		tblEmployeeColumnNames.add("ID");
		tblEmployeeColumnNames.add("Name");
		tblEmployeeColumnNames.add("Phone");
		tableEmployees = new JTable(appEngine.getTblEmployees(), tblEmployeeColumnNames);
		scrollPane_2.setViewportView(tableEmployees);
		
		Vector<Object> tblMainBranchColumnNames = new Vector<Object>();
		tblMainBranchColumnNames.add("Branch");
		tblMainBranchColumnNames.add("Manager ID");
		tblMainBranchColumnNames.add("Manager Name");
		tblMainBranchColumnNames.add("Manager Phone");
		tblMainBranchColumnNames.add("Deputy1 ID");
		tblMainBranchColumnNames.add("Deputy2 ID");
		tableMainBranch = new JTable(appEngine.getTblMainBranch(), tblMainBranchColumnNames);
		scrollPane_1.setViewportView(tableMainBranch);
		
		Vector<Object> tblSecondaryBranchColumnNames = new Vector<Object>();
		tblSecondaryBranchColumnNames.add("MainBranch");
		tblSecondaryBranchColumnNames.add("Branch");
		tblSecondaryBranchColumnNames.add("Manager ID");
		tblSecondaryBranchColumnNames.add("Manager Name");
		tblSecondaryBranchColumnNames.add("Manager Phone");
		tableSecondaryBranch = new JTable(appEngine.getTblSecondaryBranch(), tblSecondaryBranchColumnNames);
		scrollPane.setViewportView(tableSecondaryBranch);
		
		
		
		JButton btnNewMain = new JButton("Create Main Branch");
		btnNewMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int branch, manager, deputy1, deputy2;
				try {
					branch = Integer.parseInt(txtMain.getText());
					manager = Integer.parseInt(txtManagerID.getText());
					deputy1 = Integer.parseInt(txtDeputyId1.getText());
					deputy2 = Integer.parseInt(txtDeputyId2.getText());
					appEngine.newMain(branch, manager, deputy1 , deputy2);
					tableMainBranch = new JTable(appEngine.getTblMainBranch(), tblMainBranchColumnNames);
					scrollPane_1.setViewportView(tableMainBranch);
					comboBoxMain.removeAll();
					ArrayList<Integer> mainBranches = appEngine.getMainBranches();
					for (Integer mainBranch:mainBranches) {
						comboBoxMain.addItem(mainBranch);
					}
				}
				catch (Exception e2) {
					System.out.println("unable to parse branch, manager or deputy");
				}
			}
		});
		btnNewMain.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 11));
		
		JLabel lblNewLabel = new JLabel("System Management");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		
		
		txtMain = new JTextField();
		txtMain.setText("Main Branch Number");
		txtMain.setColumns(10);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Main:");
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Secondary:");
		
		JButton btnLink = new JButton("Link Branches");
		btnLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int main = (Integer)comboBoxMain.getSelectedItem();
					int secondary = (Integer)comboBoxSecondary.getSelectedItem();
					appEngine.setSecondary(main,secondary);
					tableSecondaryBranch = new JTable(appEngine.getTblSecondaryBranch(), tblSecondaryBranchColumnNames);
					scrollPane.setViewportView(tableSecondaryBranch);
				}
				catch (Exception e) {
					
				}
			}
		});
		
		txtManagerID = new JTextField();
		txtManagerID.setText("Manager ID");
		txtManagerID.setColumns(10);
		
		txtDeputyId1 = new JTextField();
		txtDeputyId1.setText("Deputy ID 1");
		txtDeputyId1.setColumns(10);
		
		txtDeputyId2 = new JTextField();
		txtDeputyId2.setText("Deputy ID 2");
		txtDeputyId2.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(146)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addGap(55)
							.addComponent(btnImport, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addGap(21))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBoxMain, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBoxSecondary, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnLink))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtMain, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtManagerID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtDeputyId1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtDeputyId2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(btnNewMain)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnImport))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtMain, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtManagerID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDeputyId1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDeputyId2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewMain))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(comboBoxSecondary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLink)
						.addComponent(comboBoxMain, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		
		getContentPane().setLayout(groupLayout);

	}

}
