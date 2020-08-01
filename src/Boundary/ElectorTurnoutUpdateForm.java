package Boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ElectorTurnoutUpdateForm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtElectorId;
	private int electorId = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ElectorTurnoutUpdateForm dialog = new ElectorTurnoutUpdateForm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ElectorTurnoutUpdateForm() {
		setBounds(100, 100, 372, 187);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		txtElectorId = new JTextField();
		txtElectorId.setText("Elector ID");
		txtElectorId.setColumns(10);
		JLabel lblElector = new JLabel("Elector Not Loaded");
		
		
		
		
		JButton btnLoad = new JButton("Load Elector");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String loaded  = null;
				loaded = appEngine.getElector(Integer.parseInt(txtElectorId.getText()));
				if (loaded!=null) {
					lblElector.setText(loaded);
					electorId = Integer.parseInt(txtElectorId.getText());
				}
				else {
					electorId = -1;
				}
			}
		});
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(txtElectorId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLoad)
					.addContainerGap(163, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(lblElector, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
					.addGap(1))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtElectorId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLoad))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblElector, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnVoted = new JButton("Elector Voted");
				btnVoted.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (electorId!=-1) {
							appEngine.setElectorTurnoutTime(electorId);
							electorId = -1;
							closeGui();
						}
					}
				});
				btnVoted.setActionCommand("OK");
				buttonPane.add(btnVoted);
				getRootPane().setDefaultButton(btnVoted);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						closeGui();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void closeGui() {
		this.dispose();
	}
	private void setId(int id) {
		electorId = id;
	}
}
