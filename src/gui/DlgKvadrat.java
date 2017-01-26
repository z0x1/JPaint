package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgKvadrat extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDuzinaStranice;
	private static int duzinaStranice;
	private static boolean daLiCrtati = false;
	private static Color bojaRama, bojaUnutrasnjosti;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgKvadrat dialog = new DlgKvadrat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgKvadrat() {
		setTitle("Kvadrat");
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 234, 121);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblDuzinaStranice = new JLabel("Du\u017Eina Stranice:");
		
		txtDuzinaStranice = new JTextField();
		txtDuzinaStranice.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDuzinaStranice)
					.addGap(13)
					.addComponent(txtDuzinaStranice, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDuzinaStranice)
						.addComponent(txtDuzinaStranice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							duzinaStranice = Integer.parseUnsignedInt(txtDuzinaStranice.getText());
							dispose();
							daLiCrtati = true;
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Polja moraju biti popunjena\n   pozitivnim brojevima!", "GRESKA!", JOptionPane.WARNING_MESSAGE);
							txtDuzinaStranice.setText("");
							txtDuzinaStranice.requestFocus();
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Poni\u0161ti");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						daLiCrtati = false;
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	
	public static int getDuzinaStranice() {
		return duzinaStranice;
	}
	public JTextField getTxtDuzinaStranice() {
		return txtDuzinaStranice;
	}
	
	public static boolean isDaLiCrtati() {
		return daLiCrtati;
	}
	public static void setDaLiCrtati(boolean daLiCrtati) {
		DlgKvadrat.daLiCrtati = daLiCrtati;
	}
	
	public static Color getBojaRama() {
		return bojaRama;
	}
	public static Color getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}
	
}
