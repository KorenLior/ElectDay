package Boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.BasicConfigurator;

import javax.swing.JDesktopPane;
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMenu;
	private JMenuItem mntmManageViewReports;
	private JMenuItem mntmExit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		BasicConfigurator.configure();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 540);
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMenu = new JMenu("menu");
		menuBar.add(mnMenu);
		
		mntmManageViewReports = new JMenuItem("View Reports");
		mntmManageViewReports.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (true)
				{
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
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		BallotVoteCountManagement ballotVoteCountManagement = new BallotVoteCountManagement();
		ballotVoteCountManagement.setSize(597, 469);
		ballotVoteCountManagement.setLocation(0, 0);
		desktopPane.add(ballotVoteCountManagement);
		ballotVoteCountManagement.show();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

}
