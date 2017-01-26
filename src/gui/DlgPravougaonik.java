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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgPravougaonik extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDuzinaStranice;
	private JTextField txtVisina;
	private static int duzinaStranice;
	private static int visina;
	private static boolean daLiCrtati;
	private static Color bojaRama, bojaUnutrasnjosti;




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPravougaonik dialog = new DlgPravougaonik();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPravougaonik() {
		setTitle("Pravougaonik");
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 263, 159);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblDuzinaStranice = new JLabel("Du\u017Eina stranice:");

		JLabel lblVisina = new JLabel("Visina:");

		txtDuzinaStranice = new JTextField();
		txtDuzinaStranice.setColumns(10);

		txtVisina = new JTextField();
		txtVisina.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDuzinaStranice)
						.addComponent(lblVisina))
					.addGap(31)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtVisina, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addComponent(txtDuzinaStranice, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDuzinaStranice)
						.addComponent(txtDuzinaStranice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVisina)
						.addComponent(txtVisina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
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
							visina = Integer.parseUnsignedInt(txtVisina.getText());
							dispose();
							daLiCrtati = true;
						} catch (NumberFormatException e) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null, "Polja moraju biti popunjena\n   pozitivnim brojevima!", "GRESKA!", JOptionPane.WARNING_MESSAGE);
							txtDuzinaStranice.setText("");
							txtVisina.setText("");
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

	public static int getVisina() {
		return visina;
	}

	public static boolean isDaLiCrtati() {
		return daLiCrtati;
	}

	public static void setDaLiCrtati(boolean daLiCrtati) {
		DlgPravougaonik.daLiCrtati = daLiCrtati;
	}

	public static Color getBojaRama() {
		return bojaRama;
	}

	public static Color getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}
}
