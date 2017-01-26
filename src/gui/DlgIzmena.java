package gui;

import geometrija.*;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JSeparator;

public class DlgIzmena extends JDialog {
	private JTextField txtXTacka;
	private JTextField txtYTacka;
	private JTextField txtXPocetna;
	private JTextField txtYPocetna;
	private JTextField txtXKrajnja;
	private JTextField txtYKrajnja;
	private JTextField txtXGLK;
	private JTextField txtYGLK;
	private JTextField txtDuzStraniceKvadrata;
	private JTextField txtXGLP;
	private JTextField txtYGLP;
	private JTextField txtSirina;
	private JTextField txtVisina;
	private JTextField txtXC;
	private JTextField txtYC;
	private JTextField txtPoluprecnik;
	private int izbor;
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private boolean provera;
	private Color bojaRama;
	private Color bojaFil;
	private JButton btnOkvirLinija;
	private JButton btnOkvirTacka;
	private JButton btnOkvirKvadrat;
	private JButton btnPopuniKvadrat;
	private JButton btnOkvirKrug;
	private JButton btnPopuniKrug;
	private JButton btnOk;
	private JButton btnCancel;
	private JButton btnOkvirPravougaonik;
	private JButton btnPopuniPravougaonik;



	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DlgIzmena dialog = new DlgIzmena();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgIzmena() {
		setResizable(false);
		setTitle("Modifikacija");

		setModalityType(ModalityType.APPLICATION_MODAL);
		setModal(true);
		setBounds(100, 100, 277, 349);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel pnlTacka = new JPanel();
		tabbedPane.addTab("Ta\u010Dka", null, pnlTacka, null);

		JPanel pnlLinija = new JPanel();
		tabbedPane.addTab("Linija", null, pnlLinija, null);

		JPanel pnlKvadrat = new JPanel();
		tabbedPane.addTab("Kvadrat", null, pnlKvadrat, null);

		JPanel pnlPravougaonik = new JPanel();
		tabbedPane.addTab("Pravougaonik", null, pnlPravougaonik, null);

		JPanel pnlKrug = new JPanel();
		tabbedPane.addTab("Krug", null, pnlKrug, null);
		GridBagLayout gbl_pnlTacka = new GridBagLayout();
		gbl_pnlTacka.columnWidths = new int[]{59, 72, 114, 0};
		gbl_pnlTacka.rowHeights = new int[]{20, 26, 0, 0, 25, 0};
		gbl_pnlTacka.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlTacka.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlTacka.setLayout(gbl_pnlTacka);

		JLabel lblKoordinateTake = new JLabel("Koordinate ta\u010Dke");
		lblKoordinateTake.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblKoordinateTake = new GridBagConstraints();
		gbc_lblKoordinateTake.gridwidth = 3;
		gbc_lblKoordinateTake.insets = new Insets(0, 0, 5, 0);
		gbc_lblKoordinateTake.gridx = 0;
		gbc_lblKoordinateTake.gridy = 0;
		pnlTacka.add(lblKoordinateTake, gbc_lblKoordinateTake);

		JLabel lblXTacka = new JLabel("X:");
		GridBagConstraints gbc_lblXTacka = new GridBagConstraints();
		gbc_lblXTacka.anchor = GridBagConstraints.EAST;
		gbc_lblXTacka.insets = new Insets(0, 0, 5, 5);
		gbc_lblXTacka.gridx = 1;
		gbc_lblXTacka.gridy = 1;
		pnlTacka.add(lblXTacka, gbc_lblXTacka);

		txtXTacka = new JTextField();
		GridBagConstraints gbc_txtXTacka = new GridBagConstraints();
		gbc_txtXTacka.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXTacka.anchor = GridBagConstraints.NORTH;
		gbc_txtXTacka.insets = new Insets(0, 0, 5, 0);
		gbc_txtXTacka.gridx = 2;
		gbc_txtXTacka.gridy = 1;
		pnlTacka.add(txtXTacka, gbc_txtXTacka);
		txtXTacka.setColumns(10);

		JLabel lblYTacka = new JLabel("Y:");
		GridBagConstraints gbc_lblYTacka = new GridBagConstraints();
		gbc_lblYTacka.anchor = GridBagConstraints.EAST;
		gbc_lblYTacka.insets = new Insets(0, 0, 5, 5);
		gbc_lblYTacka.gridx = 1;
		gbc_lblYTacka.gridy = 2;
		pnlTacka.add(lblYTacka, gbc_lblYTacka);

		txtYTacka = new JTextField();
		GridBagConstraints gbc_txtYTacka = new GridBagConstraints();
		gbc_txtYTacka.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYTacka.anchor = GridBagConstraints.NORTH;
		gbc_txtYTacka.insets = new Insets(0, 0, 5, 0);
		gbc_txtYTacka.gridx = 2;
		gbc_txtYTacka.gridy = 2;
		pnlTacka.add(txtYTacka, gbc_txtYTacka);
		txtYTacka.setColumns(10);

		JLabel lblBojaTake = new JLabel("Boja ta\u010Dke:");
		GridBagConstraints gbc_lblBojaTake = new GridBagConstraints();
		gbc_lblBojaTake.insets = new Insets(0, 0, 0, 5);
		gbc_lblBojaTake.gridx = 1;
		gbc_lblBojaTake.gridy = 4;
		pnlTacka.add(lblBojaTake, gbc_lblBojaTake);

		btnOkvirTacka = new JButton("");
		GridBagConstraints gbc_btnOkvirTacka = new GridBagConstraints();
		gbc_btnOkvirTacka.fill = GridBagConstraints.BOTH;
		gbc_btnOkvirTacka.gridx = 2;
		gbc_btnOkvirTacka.gridy = 4;
		pnlTacka.add(btnOkvirTacka, gbc_btnOkvirTacka);





		GridBagLayout gbl_pnlLinija = new GridBagLayout();
		gbl_pnlLinija.columnWidths = new int[]{56, 77, 114, 0};
		gbl_pnlLinija.rowHeights = new int[]{20, 20, 20, 0, 20, 26, 0, 0, 25, 0};
		gbl_pnlLinija.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlLinija.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlLinija.setLayout(gbl_pnlLinija);

		JLabel lblPocetnaTacka = new JLabel("Po\u010Detna ta\u010Dka");
		lblPocetnaTacka.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblPocetnaTacka = new GridBagConstraints();
		gbc_lblPocetnaTacka.gridwidth = 3;
		gbc_lblPocetnaTacka.insets = new Insets(0, 0, 5, 0);
		gbc_lblPocetnaTacka.gridx = 0;
		gbc_lblPocetnaTacka.gridy = 0;
		pnlLinija.add(lblPocetnaTacka, gbc_lblPocetnaTacka);

		JLabel lblXPocetna = new JLabel("X:");
		GridBagConstraints gbc_lblXPocetna = new GridBagConstraints();
		gbc_lblXPocetna.anchor = GridBagConstraints.EAST;
		gbc_lblXPocetna.insets = new Insets(0, 0, 5, 5);
		gbc_lblXPocetna.gridx = 1;
		gbc_lblXPocetna.gridy = 1;
		pnlLinija.add(lblXPocetna, gbc_lblXPocetna);

		txtXPocetna = new JTextField();
		GridBagConstraints gbc_txtXPocetna = new GridBagConstraints();
		gbc_txtXPocetna.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXPocetna.anchor = GridBagConstraints.NORTH;
		gbc_txtXPocetna.insets = new Insets(0, 0, 5, 0);
		gbc_txtXPocetna.gridx = 2;
		gbc_txtXPocetna.gridy = 1;
		pnlLinija.add(txtXPocetna, gbc_txtXPocetna);
		txtXPocetna.setColumns(10);

		JLabel lblYPocetna = new JLabel("Y:");
		GridBagConstraints gbc_lblYPocetna = new GridBagConstraints();
		gbc_lblYPocetna.anchor = GridBagConstraints.EAST;
		gbc_lblYPocetna.insets = new Insets(0, 0, 5, 5);
		gbc_lblYPocetna.gridx = 1;
		gbc_lblYPocetna.gridy = 2;
		pnlLinija.add(lblYPocetna, gbc_lblYPocetna);

		txtYPocetna = new JTextField();
		GridBagConstraints gbc_txtYPocetna = new GridBagConstraints();
		gbc_txtYPocetna.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYPocetna.anchor = GridBagConstraints.NORTH;
		gbc_txtYPocetna.insets = new Insets(0, 0, 5, 0);
		gbc_txtYPocetna.gridx = 2;
		gbc_txtYPocetna.gridy = 2;
		pnlLinija.add(txtYPocetna, gbc_txtYPocetna);
		txtYPocetna.setColumns(10);

		JSeparator separatorLinija = new JSeparator();
		GridBagConstraints gbc_separatorLinija = new GridBagConstraints();
		gbc_separatorLinija.gridwidth = 2;
		gbc_separatorLinija.fill = GridBagConstraints.HORIZONTAL;
		gbc_separatorLinija.insets = new Insets(0, 0, 5, 0);
		gbc_separatorLinija.gridx = 1;
		gbc_separatorLinija.gridy = 3;
		pnlLinija.add(separatorLinija, gbc_separatorLinija);

		JLabel lblKrajnjaTacka = new JLabel("Krajnja ta\u010Dka");
		lblKrajnjaTacka.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblKrajnjaTacka = new GridBagConstraints();
		gbc_lblKrajnjaTacka.gridwidth = 3;
		gbc_lblKrajnjaTacka.insets = new Insets(0, 0, 5, 0);
		gbc_lblKrajnjaTacka.gridx = 0;
		gbc_lblKrajnjaTacka.gridy = 4;
		pnlLinija.add(lblKrajnjaTacka, gbc_lblKrajnjaTacka);

		JLabel lblXKrajnja = new JLabel("X:");
		GridBagConstraints gbc_lblXKrajnja = new GridBagConstraints();
		gbc_lblXKrajnja.anchor = GridBagConstraints.EAST;
		gbc_lblXKrajnja.insets = new Insets(0, 0, 5, 5);
		gbc_lblXKrajnja.gridx = 1;
		gbc_lblXKrajnja.gridy = 5;
		pnlLinija.add(lblXKrajnja, gbc_lblXKrajnja);

		txtXKrajnja = new JTextField();
		txtXKrajnja.setColumns(10);
		GridBagConstraints gbc_txtXKrajnja = new GridBagConstraints();
		gbc_txtXKrajnja.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXKrajnja.anchor = GridBagConstraints.NORTH;
		gbc_txtXKrajnja.insets = new Insets(0, 0, 5, 0);
		gbc_txtXKrajnja.gridx = 2;
		gbc_txtXKrajnja.gridy = 5;
		pnlLinija.add(txtXKrajnja, gbc_txtXKrajnja);

		JLabel lblYKrajnja = new JLabel("Y:");
		GridBagConstraints gbc_lblYKrajnja = new GridBagConstraints();
		gbc_lblYKrajnja.anchor = GridBagConstraints.EAST;
		gbc_lblYKrajnja.insets = new Insets(0, 0, 5, 5);
		gbc_lblYKrajnja.gridx = 1;
		gbc_lblYKrajnja.gridy = 6;
		pnlLinija.add(lblYKrajnja, gbc_lblYKrajnja);

		txtYKrajnja = new JTextField();
		txtYKrajnja.setColumns(10);
		GridBagConstraints gbc_txtYKrajnja = new GridBagConstraints();
		gbc_txtYKrajnja.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYKrajnja.anchor = GridBagConstraints.NORTH;
		gbc_txtYKrajnja.insets = new Insets(0, 0, 5, 0);
		gbc_txtYKrajnja.gridx = 2;
		gbc_txtYKrajnja.gridy = 6;
		pnlLinija.add(txtYKrajnja, gbc_txtYKrajnja);

		JLabel lblBojaLinije = new JLabel("Boja linije:");
		GridBagConstraints gbc_lblBojaLinije = new GridBagConstraints();
		gbc_lblBojaLinije.insets = new Insets(0, 0, 0, 5);
		gbc_lblBojaLinije.gridx = 1;
		gbc_lblBojaLinije.gridy = 8;
		pnlLinija.add(lblBojaLinije, gbc_lblBojaLinije);

		btnOkvirLinija = new JButton("");

		GridBagConstraints gbc_btnOkvirLinija = new GridBagConstraints();
		gbc_btnOkvirLinija.fill = GridBagConstraints.BOTH;
		gbc_btnOkvirLinija.gridx = 2;
		gbc_btnOkvirLinija.gridy = 8;
		pnlLinija.add(btnOkvirLinija, gbc_btnOkvirLinija);



		GridBagLayout gbl_pnlKvadrat = new GridBagLayout();
		gbl_pnlKvadrat.columnWidths = new int[]{117, 114, 0};
		gbl_pnlKvadrat.rowHeights = new int[]{20, 20, 20, 0, 26, 0, 30, 24, 0};
		gbl_pnlKvadrat.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlKvadrat.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlKvadrat.setLayout(gbl_pnlKvadrat);

		JLabel lblKvadratTackaGL = new JLabel("Ta\u010Dka gore levo");
		lblKvadratTackaGL.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblKvadratTackaGL = new GridBagConstraints();
		gbc_lblKvadratTackaGL.gridwidth = 2;
		gbc_lblKvadratTackaGL.insets = new Insets(0, 0, 5, 0);
		gbc_lblKvadratTackaGL.gridx = 0;
		gbc_lblKvadratTackaGL.gridy = 0;
		pnlKvadrat.add(lblKvadratTackaGL, gbc_lblKvadratTackaGL);

		JLabel lblXGLK = new JLabel("X:");
		GridBagConstraints gbc_lblXGLK = new GridBagConstraints();
		gbc_lblXGLK.anchor = GridBagConstraints.EAST;
		gbc_lblXGLK.insets = new Insets(0, 0, 5, 5);
		gbc_lblXGLK.gridx = 0;
		gbc_lblXGLK.gridy = 1;
		pnlKvadrat.add(lblXGLK, gbc_lblXGLK);

		txtXGLK = new JTextField();
		txtXGLK.setColumns(10);
		GridBagConstraints gbc_txtXGLK = new GridBagConstraints();
		gbc_txtXGLK.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXGLK.anchor = GridBagConstraints.NORTH;
		gbc_txtXGLK.insets = new Insets(0, 0, 5, 0);
		gbc_txtXGLK.gridx = 1;
		gbc_txtXGLK.gridy = 1;
		pnlKvadrat.add(txtXGLK, gbc_txtXGLK);

		JLabel lblYGLK = new JLabel("Y:");
		GridBagConstraints gbc_lblYGLK = new GridBagConstraints();
		gbc_lblYGLK.anchor = GridBagConstraints.EAST;
		gbc_lblYGLK.insets = new Insets(0, 0, 5, 5);
		gbc_lblYGLK.gridx = 0;
		gbc_lblYGLK.gridy = 2;
		pnlKvadrat.add(lblYGLK, gbc_lblYGLK);

		txtYGLK = new JTextField();
		txtYGLK.setColumns(10);
		GridBagConstraints gbc_txtYGLK = new GridBagConstraints();
		gbc_txtYGLK.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYGLK.anchor = GridBagConstraints.NORTH;
		gbc_txtYGLK.insets = new Insets(0, 0, 5, 0);
		gbc_txtYGLK.gridx = 1;
		gbc_txtYGLK.gridy = 2;
		pnlKvadrat.add(txtYGLK, gbc_txtYGLK);

		JLabel lblDuzStranice = new JLabel("Du\u017Eina stranice:");
		GridBagConstraints gbc_lblDuzStranice = new GridBagConstraints();
		gbc_lblDuzStranice.anchor = GridBagConstraints.EAST;
		gbc_lblDuzStranice.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuzStranice.gridx = 0;
		gbc_lblDuzStranice.gridy = 4;
		pnlKvadrat.add(lblDuzStranice, gbc_lblDuzStranice);

		txtDuzStraniceKvadrata = new JTextField();
		txtDuzStraniceKvadrata.setColumns(10);
		GridBagConstraints gbc_txtDuzStraniceKvadrata = new GridBagConstraints();
		gbc_txtDuzStraniceKvadrata.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDuzStraniceKvadrata.anchor = GridBagConstraints.NORTH;
		gbc_txtDuzStraniceKvadrata.insets = new Insets(0, 0, 5, 0);
		gbc_txtDuzStraniceKvadrata.gridx = 1;
		gbc_txtDuzStraniceKvadrata.gridy = 4;
		pnlKvadrat.add(txtDuzStraniceKvadrata, gbc_txtDuzStraniceKvadrata);

		JLabel lblBojaOkviraKvadrata = new JLabel("Boja Okvira:");
		GridBagConstraints gbc_lblBojaOkviraKvadrata = new GridBagConstraints();
		gbc_lblBojaOkviraKvadrata.insets = new Insets(0, 0, 5, 5);
		gbc_lblBojaOkviraKvadrata.gridx = 0;
		gbc_lblBojaOkviraKvadrata.gridy = 6;
		pnlKvadrat.add(lblBojaOkviraKvadrata, gbc_lblBojaOkviraKvadrata);


		btnOkvirKvadrat = new JButton("");
		GridBagConstraints gbc_btnOkvirKvadrat = new GridBagConstraints();
		gbc_btnOkvirKvadrat.fill = GridBagConstraints.BOTH;
		gbc_btnOkvirKvadrat.insets = new Insets(0, 0, 5, 0);
		gbc_btnOkvirKvadrat.gridx = 1;
		gbc_btnOkvirKvadrat.gridy = 6;
		pnlKvadrat.add(btnOkvirKvadrat, gbc_btnOkvirKvadrat);

		JLabel lblBojaUnutranjostiKvadrata = new JLabel("Boja Unutra\u0161njosti:");
		GridBagConstraints gbc_lblBojaUnutranjostiKvadrata = new GridBagConstraints();
		gbc_lblBojaUnutranjostiKvadrata.insets = new Insets(0, 0, 0, 5);
		gbc_lblBojaUnutranjostiKvadrata.gridx = 0;
		gbc_lblBojaUnutranjostiKvadrata.gridy = 7;
		pnlKvadrat.add(lblBojaUnutranjostiKvadrata, gbc_lblBojaUnutranjostiKvadrata);


		btnPopuniKvadrat = new JButton("");

		GridBagConstraints gbc_btnPopuniKvadrat = new GridBagConstraints();
		gbc_btnPopuniKvadrat.fill = GridBagConstraints.BOTH;
		gbc_btnPopuniKvadrat.gridx = 1;
		gbc_btnPopuniKvadrat.gridy = 7;
		pnlKvadrat.add(btnPopuniKvadrat, gbc_btnPopuniKvadrat);

		GridBagLayout gbl_pnlPravougaonik = new GridBagLayout();
		gbl_pnlPravougaonik.columnWidths = new int[]{36, 65, 114, 0};
		gbl_pnlPravougaonik.rowHeights = new int[]{20, 20, 20, 0, 20, 26, 30, 24, 0};
		gbl_pnlPravougaonik.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlPravougaonik.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlPravougaonik.setLayout(gbl_pnlPravougaonik);

		JLabel lblTackaGoreLevo = new JLabel("Ta\u010Dka gore levo");
		lblTackaGoreLevo.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblTackaGoreLevo = new GridBagConstraints();
		gbc_lblTackaGoreLevo.gridwidth = 2;
		gbc_lblTackaGoreLevo.insets = new Insets(0, 0, 5, 0);
		gbc_lblTackaGoreLevo.gridx = 1;
		gbc_lblTackaGoreLevo.gridy = 0;
		pnlPravougaonik.add(lblTackaGoreLevo, gbc_lblTackaGoreLevo);

		JLabel lblXGLP = new JLabel("X:");
		GridBagConstraints gbc_lblXGLP = new GridBagConstraints();
		gbc_lblXGLP.anchor = GridBagConstraints.EAST;
		gbc_lblXGLP.insets = new Insets(0, 0, 5, 5);
		gbc_lblXGLP.gridx = 1;
		gbc_lblXGLP.gridy = 1;
		pnlPravougaonik.add(lblXGLP, gbc_lblXGLP);

		txtXGLP = new JTextField();
		txtXGLP.setColumns(10);
		GridBagConstraints gbc_txtXGLP = new GridBagConstraints();
		gbc_txtXGLP.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXGLP.anchor = GridBagConstraints.NORTH;
		gbc_txtXGLP.insets = new Insets(0, 0, 5, 0);
		gbc_txtXGLP.gridx = 2;
		gbc_txtXGLP.gridy = 1;
		pnlPravougaonik.add(txtXGLP, gbc_txtXGLP);

		JLabel lblYGLP = new JLabel("Y:");
		GridBagConstraints gbc_lblYGLP = new GridBagConstraints();
		gbc_lblYGLP.anchor = GridBagConstraints.EAST;
		gbc_lblYGLP.insets = new Insets(0, 0, 5, 5);
		gbc_lblYGLP.gridx = 1;
		gbc_lblYGLP.gridy = 2;
		pnlPravougaonik.add(lblYGLP, gbc_lblYGLP);

		txtYGLP = new JTextField();
		txtYGLP.setColumns(10);
		GridBagConstraints gbc_txtYGLP = new GridBagConstraints();
		gbc_txtYGLP.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYGLP.anchor = GridBagConstraints.NORTH;
		gbc_txtYGLP.insets = new Insets(0, 0, 5, 0);
		gbc_txtYGLP.gridx = 2;
		gbc_txtYGLP.gridy = 2;
		pnlPravougaonik.add(txtYGLP, gbc_txtYGLP);

		JSeparator separatorPravougaonik = new JSeparator();
		GridBagConstraints gbc_separatorPravougaonik = new GridBagConstraints();
		gbc_separatorPravougaonik.gridwidth = 2;
		gbc_separatorPravougaonik.fill = GridBagConstraints.HORIZONTAL;
		gbc_separatorPravougaonik.insets = new Insets(0, 0, 5, 0);
		gbc_separatorPravougaonik.gridx = 1;
		gbc_separatorPravougaonik.gridy = 3;
		pnlPravougaonik.add(separatorPravougaonik, gbc_separatorPravougaonik);

		JLabel lblSirina = new JLabel("\u0160irina:");
		GridBagConstraints gbc_lblSirina = new GridBagConstraints();
		gbc_lblSirina.anchor = GridBagConstraints.EAST;
		gbc_lblSirina.insets = new Insets(0, 0, 5, 5);
		gbc_lblSirina.gridx = 1;
		gbc_lblSirina.gridy = 4;
		pnlPravougaonik.add(lblSirina, gbc_lblSirina);

		txtSirina = new JTextField();
		txtSirina.setColumns(10);
		GridBagConstraints gbc_txtSirina = new GridBagConstraints();
		gbc_txtSirina.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSirina.anchor = GridBagConstraints.NORTH;
		gbc_txtSirina.insets = new Insets(0, 0, 5, 0);
		gbc_txtSirina.gridx = 2;
		gbc_txtSirina.gridy = 4;
		pnlPravougaonik.add(txtSirina, gbc_txtSirina);

		JLabel lblVisina = new JLabel("Visina:");
		GridBagConstraints gbc_lblVisina = new GridBagConstraints();
		gbc_lblVisina.anchor = GridBagConstraints.EAST;
		gbc_lblVisina.insets = new Insets(0, 0, 5, 5);
		gbc_lblVisina.gridx = 1;
		gbc_lblVisina.gridy = 5;
		pnlPravougaonik.add(lblVisina, gbc_lblVisina);

		txtVisina = new JTextField();
		txtVisina.setColumns(10);
		GridBagConstraints gbc_txtVisina = new GridBagConstraints();
		gbc_txtVisina.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVisina.anchor = GridBagConstraints.NORTH;
		gbc_txtVisina.insets = new Insets(0, 0, 5, 0);
		gbc_txtVisina.gridx = 2;
		gbc_txtVisina.gridy = 5;
		pnlPravougaonik.add(txtVisina, gbc_txtVisina);

		JLabel lblBojaOkviraPravougaonika = new JLabel("Boja okvira:");
		GridBagConstraints gbc_lblBojaOkviraPravougaonika = new GridBagConstraints();
		gbc_lblBojaOkviraPravougaonika.gridwidth = 2;
		gbc_lblBojaOkviraPravougaonika.insets = new Insets(0, 0, 5, 5);
		gbc_lblBojaOkviraPravougaonika.gridx = 0;
		gbc_lblBojaOkviraPravougaonika.gridy = 6;
		pnlPravougaonik.add(lblBojaOkviraPravougaonika, gbc_lblBojaOkviraPravougaonika);

		btnOkvirPravougaonik = new JButton("");
		GridBagConstraints gbc_btnOkvirPravougaonik = new GridBagConstraints();
		gbc_btnOkvirPravougaonik.fill = GridBagConstraints.BOTH;
		gbc_btnOkvirPravougaonik.insets = new Insets(0, 0, 5, 0);
		gbc_btnOkvirPravougaonik.gridx = 2;
		gbc_btnOkvirPravougaonik.gridy = 6;
		pnlPravougaonik.add(btnOkvirPravougaonik, gbc_btnOkvirPravougaonik);

		JLabel lblBojaUnutrasnjostiPravougaonika = new JLabel("Boja unutra\u0161njosti");
		GridBagConstraints gbc_lblBojaUnutrasnjostiPravougaonika = new GridBagConstraints();
		gbc_lblBojaUnutrasnjostiPravougaonika.gridwidth = 2;
		gbc_lblBojaUnutrasnjostiPravougaonika.insets = new Insets(0, 0, 0, 5);
		gbc_lblBojaUnutrasnjostiPravougaonika.gridx = 0;
		gbc_lblBojaUnutrasnjostiPravougaonika.gridy = 7;
		pnlPravougaonik.add(lblBojaUnutrasnjostiPravougaonika, gbc_lblBojaUnutrasnjostiPravougaonika);


		btnPopuniPravougaonik = new JButton("");
		GridBagConstraints gbc_btnPopuniPravougaonik = new GridBagConstraints();
		gbc_btnPopuniPravougaonik.fill = GridBagConstraints.BOTH;
		gbc_btnPopuniPravougaonik.gridx = 2;
		gbc_btnPopuniPravougaonik.gridy = 7;
		pnlPravougaonik.add(btnPopuniPravougaonik, gbc_btnPopuniPravougaonik);

		GridBagLayout gbl_pnlKrug = new GridBagLayout();
		gbl_pnlKrug.columnWidths = new int[]{96, 22, 26};
		gbl_pnlKrug.rowHeights = new int[]{20, 20, 26, 0, 26, 0, 32, 24, 0};
		gbl_pnlKrug.columnWeights = new double[]{0.0, 0.0, 1.0};
		gbl_pnlKrug.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlKrug.setLayout(gbl_pnlKrug);

		JLabel lblTakaCentar = new JLabel("Ta\u010Dka centar");
		lblTakaCentar.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblTakaCentar = new GridBagConstraints();
		gbc_lblTakaCentar.gridwidth = 3;
		gbc_lblTakaCentar.insets = new Insets(0, 0, 5, 0);
		gbc_lblTakaCentar.gridx = 0;
		gbc_lblTakaCentar.gridy = 0;
		pnlKrug.add(lblTakaCentar, gbc_lblTakaCentar);

		JLabel lblXC = new JLabel("X:");
		GridBagConstraints gbc_lblXC = new GridBagConstraints();
		gbc_lblXC.anchor = GridBagConstraints.EAST;
		gbc_lblXC.insets = new Insets(0, 0, 5, 5);
		gbc_lblXC.gridx = 1;
		gbc_lblXC.gridy = 1;
		pnlKrug.add(lblXC, gbc_lblXC);

		txtXC = new JTextField();
		txtXC.setColumns(10);
		GridBagConstraints gbc_txtXC = new GridBagConstraints();
		gbc_txtXC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXC.anchor = GridBagConstraints.NORTH;
		gbc_txtXC.insets = new Insets(0, 0, 5, 0);
		gbc_txtXC.gridx = 2;
		gbc_txtXC.gridy = 1;
		pnlKrug.add(txtXC, gbc_txtXC);

		JLabel lblYC = new JLabel("Y:");
		GridBagConstraints gbc_lblYC = new GridBagConstraints();
		gbc_lblYC.anchor = GridBagConstraints.EAST;
		gbc_lblYC.insets = new Insets(0, 0, 5, 5);
		gbc_lblYC.gridx = 1;
		gbc_lblYC.gridy = 2;
		pnlKrug.add(lblYC, gbc_lblYC);

		txtYC = new JTextField();
		txtYC.setColumns(10);
		GridBagConstraints gbc_txtYC = new GridBagConstraints();
		gbc_txtYC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYC.anchor = GridBagConstraints.NORTH;
		gbc_txtYC.insets = new Insets(0, 0, 5, 0);
		gbc_txtYC.gridx = 2;
		gbc_txtYC.gridy = 2;
		pnlKrug.add(txtYC, gbc_txtYC);

		JSeparator separatorKrug = new JSeparator();
		GridBagConstraints gbc_separatorKrug = new GridBagConstraints();
		gbc_separatorKrug.gridwidth = 2;
		gbc_separatorKrug.fill = GridBagConstraints.HORIZONTAL;
		gbc_separatorKrug.insets = new Insets(0, 0, 5, 0);
		gbc_separatorKrug.gridx = 1;
		gbc_separatorKrug.gridy = 3;
		pnlKrug.add(separatorKrug, gbc_separatorKrug);

		JLabel lblPoluprecnik = new JLabel("Polupre\u010Dnik:");
		GridBagConstraints gbc_lblPoluprecnik = new GridBagConstraints();
		gbc_lblPoluprecnik.gridwidth = 2;
		gbc_lblPoluprecnik.anchor = GridBagConstraints.EAST;
		gbc_lblPoluprecnik.insets = new Insets(0, 0, 5, 5);
		gbc_lblPoluprecnik.gridx = 0;
		gbc_lblPoluprecnik.gridy = 4;
		pnlKrug.add(lblPoluprecnik, gbc_lblPoluprecnik);

		txtPoluprecnik = new JTextField();
		txtPoluprecnik.setColumns(10);
		GridBagConstraints gbc_txtPoluprecnik = new GridBagConstraints();
		gbc_txtPoluprecnik.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPoluprecnik.insets = new Insets(0, 0, 5, 0);
		gbc_txtPoluprecnik.gridx = 2;
		gbc_txtPoluprecnik.gridy = 4;
		pnlKrug.add(txtPoluprecnik, gbc_txtPoluprecnik);

		JLabel lblBojaOkviraKruga = new JLabel("Boja okvira:");
		GridBagConstraints gbc_lblBojaOkviraKruga = new GridBagConstraints();
		gbc_lblBojaOkviraKruga.insets = new Insets(0, 0, 5, 5);
		gbc_lblBojaOkviraKruga.gridx = 0;
		gbc_lblBojaOkviraKruga.gridy = 6;
		pnlKrug.add(lblBojaOkviraKruga, gbc_lblBojaOkviraKruga);

		btnOkvirKrug = new JButton("");

		GridBagConstraints gbc_btnOkvirKrug = new GridBagConstraints();
		gbc_btnOkvirKrug.fill = GridBagConstraints.BOTH;
		gbc_btnOkvirKrug.insets = new Insets(0, 0, 5, 0);
		gbc_btnOkvirKrug.gridwidth = 2;
		gbc_btnOkvirKrug.gridx = 1;
		gbc_btnOkvirKrug.gridy = 6;
		pnlKrug.add(btnOkvirKrug, gbc_btnOkvirKrug);

		JLabel lblBojaUnutranjosti = new JLabel("Boja unutra\u0161njosti:");
		GridBagConstraints gbc_lblBojaUnutranjosti = new GridBagConstraints();
		gbc_lblBojaUnutranjosti.insets = new Insets(0, 0, 0, 5);
		gbc_lblBojaUnutranjosti.gridx = 0;
		gbc_lblBojaUnutranjosti.gridy = 7;
		pnlKrug.add(lblBojaUnutranjosti, gbc_lblBojaUnutranjosti);




		btnPopuniKrug = new JButton("");

		GridBagConstraints gbc_btnPopuniKrug = new GridBagConstraints();
		gbc_btnPopuniKrug.fill = GridBagConstraints.BOTH;
		gbc_btnPopuniKrug.gridwidth = 2;
		gbc_btnPopuniKrug.gridx = 1;
		gbc_btnPopuniKrug.gridy = 7;
		pnlKrug.add(btnPopuniKrug, gbc_btnPopuniKrug);


		JPanel pnlBtn = new JPanel();
		getContentPane().add(pnlBtn, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlBtn = new GridBagLayout();
		gbl_pnlBtn.columnWidths = new int[]{54, 0, 0};
		gbl_pnlBtn.rowHeights = new int[]{26, 0};
		gbl_pnlBtn.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_pnlBtn.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlBtn.setLayout(gbl_pnlBtn);


		btnOk = new JButton("Potvrdi");

		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOk.anchor = GridBagConstraints.NORTH;
		gbc_btnOk.insets = new Insets(0, 0, 0, 5);
		gbc_btnOk.gridx = 0;
		gbc_btnOk.gridy = 0;
		pnlBtn.add(btnOk, gbc_btnOk);


		btnCancel = new JButton("Poni\u0161ti");

		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancel.anchor = GridBagConstraints.NORTH;
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 0;
		pnlBtn.add(btnCancel, gbc_btnCancel);



		btnOkvirTacka.setBackground(bojaRama);
		btnOkvirTacka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				bojaRama = JColorChooser.showDialog(null, "Boja rama", bojaRama);
				if (bojaRama!=null) {
					btnOkvirTacka.setBackground(bojaRama);
				}
			}
		});

		btnOkvirLinija.setBackground(bojaRama);
		btnOkvirLinija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bojaRama = JColorChooser.showDialog(null, "Boja rama", bojaRama);
				if (bojaRama!=null) {
					btnOkvirLinija.setBackground(bojaRama);
				}			
			}
		});	

		btnOkvirKvadrat.setBackground(bojaRama);
		btnOkvirKvadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bojaRama = JColorChooser.showDialog(null, "Boja rama", bojaRama);
				if (bojaRama!=null) {
					btnOkvirKvadrat.setBackground(bojaRama);
				}	
			}
		});		

		btnPopuniKvadrat.setBackground(bojaFil);
		btnPopuniKvadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bojaFil = JColorChooser.showDialog(null, "Boja rama", bojaFil);
				if (bojaFil!=null) {
					btnPopuniKvadrat.setBackground(bojaFil);
				}	
			}
		});	


		btnOkvirPravougaonik.setBackground(bojaRama);
		btnOkvirPravougaonik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bojaRama = JColorChooser.showDialog(null, "Boja rama", bojaRama);
				if (bojaRama!=null) {
					btnOkvirPravougaonik.setBackground(bojaRama);
				}	
			}
		});	

		btnPopuniPravougaonik.setBackground(bojaFil);
		btnPopuniPravougaonik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bojaFil = JColorChooser.showDialog(null, "Boja rama", bojaFil);
				if (bojaFil!=null) {
					btnPopuniPravougaonik.setBackground(bojaFil);
				}	
			}
		});

		btnOkvirKrug.setBackground(bojaRama);
		btnOkvirKrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bojaRama = JColorChooser.showDialog(null, "Boja rama", bojaRama);
				if (bojaRama!=null) {
					btnOkvirKrug.setBackground(bojaRama);
				}	
			}
		});	

		btnPopuniKrug.setBackground(bojaFil);
		btnPopuniKrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bojaFil = JColorChooser.showDialog(null, "Boja rama", bojaFil);
				if (bojaFil!=null) {
					btnPopuniKrug.setBackground(bojaFil);
				}	
			}
		});


		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				provera = true;
				proveraValidnostiUnosa(izbor);
				if(isProvera()){
					dispose();
				}
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}

	public void postaviTabove(int izbor) {

		for (int i = 0; i < tabbedPane.getTabCount(); i++) {

			tabbedPane.setEnabledAt(i, false);

		}
		this.izbor = izbor;
		tabbedPane.setEnabledAt(izbor, true);
		tabbedPane.setSelectedIndex(izbor);

	}

	private void proveraValidnostiUnosa(int izbor) {


		if (izbor == 0) {			// tacka
			if(!txtXTacka.getText().isEmpty() && !txtYTacka.getText().isEmpty())
			{
				daLiJeBroj(txtXTacka);
				daLiJeBroj(txtYTacka);
			}
			else {
				JOptionPane.showMessageDialog(null, "Polja ne smeju biti prazna", "Greska", JOptionPane.WARNING_MESSAGE);
				provera = false;
			}
		} else if (izbor == 1) {	// linija
			if(!txtXPocetna.getText().isEmpty() && !txtYPocetna.getText().isEmpty() && !txtXKrajnja.getText().isEmpty() && !txtYKrajnja.getText().isEmpty())
			{
				daLiJeBroj(txtXPocetna);
				daLiJeBroj(txtYPocetna);
				daLiJeBroj(txtXKrajnja);
				daLiJeBroj(txtYKrajnja);
			}
			else {
				JOptionPane.showMessageDialog(null, "Polja ne smeju biti prazna", "Greska", JOptionPane.WARNING_MESSAGE);
				provera = false;
			}
		} else if (izbor == 2) {	// kvadrat
			if(!txtXGLK.getText().isEmpty() && !txtYGLK.getText().isEmpty() && !txtDuzStraniceKvadrata.getText().isEmpty())
			{
				daLiJeBroj(txtXGLK);
				daLiJeBroj(txtYGLK);
				daLiJeBroj(txtDuzStraniceKvadrata);
			}
			else {
				JOptionPane.showMessageDialog(null, "Polja ne smeju biti prazna", "Greska", JOptionPane.WARNING_MESSAGE);
				provera = false;
			}
		} else if (izbor == 3) { 	// pravougaonik
			if(!txtXGLP.getText().isEmpty() && !txtYGLP.getText().isEmpty() && !txtSirina.getText().isEmpty() && !txtVisina.getText().isEmpty())
			{
				daLiJeBroj(txtXGLP);
				daLiJeBroj(txtYGLP);
				daLiJeBroj(txtSirina);
				daLiJeBroj(txtVisina);
			}
			else {
				JOptionPane.showMessageDialog(null, "Polja ne smeju biti prazna", "Greska", JOptionPane.WARNING_MESSAGE);
				provera = false;
			}
		} else if (izbor == 4) {	// krug
			if(!txtPoluprecnik.getText().isEmpty() && !txtXC.getText().isEmpty() && !txtYC.getText().isEmpty() )
			{
				daLiJeBroj(txtPoluprecnik);
				daLiJeBroj(txtXC);
				daLiJeBroj(txtYC);
			}
			else {
				JOptionPane.showMessageDialog(null, "Polja ne smeju biti prazna", "Greska", JOptionPane.WARNING_MESSAGE);
				provera = false;
			}
		}
	}



	public void daLiJeBroj(JTextField j){

		try{
			Integer.parseUnsignedInt(j.getText());
			provera &= true;
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Uneta je nepravilna vrednost: "+j.getText() , "Greska", JOptionPane.WARNING_MESSAGE);
			j.requestFocus();
			provera = false;
		}

	}

	public void izmeni(Oblik o){
		if(o instanceof Tacka){
			((Tacka) o).setX(getXTacka());
			((Tacka) o).setY(getYTacka());
			((Tacka) o).setBoja(bojaRama);

		}
		else if(o instanceof Linija){
			((Linija) o).gettPocetna().setX(getXPocetna());
			((Linija) o).gettPocetna().setY(getYPocetna());
			((Linija) o).gettKrajnja().setX(getXKrajnja());
			((Linija) o).gettKrajnja().setY(getYKrajnja());
			((Linija) o).setBoja(bojaRama);
		}
		else if(o instanceof Pravougaonik){
			((Pravougaonik) o).getGoreLevo().setX(getXGLP());
			((Pravougaonik) o).getGoreLevo().setY(getYGLP());
			((Pravougaonik) o).setVisina(getVisina());
			((Pravougaonik) o).setDuzinaStranice(getSirina());
			((Pravougaonik) o).setBoja(bojaRama);
			((Pravougaonik) o).setBojaUnutrasnjosti(bojaFil);
		}
		else if(o instanceof Kvadrat){
			((Kvadrat) o).getGoreLevo().setX(getXGLK());
			((Kvadrat) o).getGoreLevo().setY(getYGLK());
			((Kvadrat) o).setDuzinaStranice(getDuzStranice());
			((Kvadrat) o).setBoja(bojaRama);
			((Kvadrat) o).setBojaUnutrasnjosti(bojaFil);
		}
		else if(o instanceof Krug){
			((Krug) o).getCentar().setX(getXC());
			((Krug) o).getCentar().setY(getYC());
			((Krug) o).setR(getPoluprecnik());
			((Krug) o).setBoja(bojaRama);
			((Krug) o).setBojaUnutrasnjosti(bojaFil);

		}
	}

	public void postaviPolja(Oblik o){

		bojaRama = o.getBoja();
		if (o instanceof PovrsinskiOblik) {
			bojaFil = ((PovrsinskiOblik) o).getBojaUnutrasnjosti();
		}
		if(o instanceof Tacka){
			setTxtXTacka(((Tacka) o).getX());
			setTxtYTacka(((Tacka) o).getY());
			btnOkvirTacka.setBackground(o.getBoja());
		}
		else if(o instanceof Linija){
			setTxtXPocetna(((Linija) o).gettPocetna().getX());
			setTxtYPocetna(((Linija) o).gettPocetna().getY());

			setTxtXKrajnja(((Linija) o).gettKrajnja().getX());
			setTxtYKrajnja(((Linija) o).gettKrajnja().getY());
			btnOkvirLinija.setBackground(o.getBoja());

		}
		else if(o instanceof Pravougaonik){
			setTxtXGLP(((Pravougaonik) o).getGoreLevo().getX());
			setTxtYGLP(((Pravougaonik) o).getGoreLevo().getY());
			setTxtVisina(((Pravougaonik) o).getVisina());
			setTxtSirina(((Pravougaonik) o).getDuzinaStranice());
			btnOkvirPravougaonik.setBackground(o.getBoja());		
			btnPopuniPravougaonik.setBackground(((Pravougaonik) o).getBojaUnutrasnjosti());
		}
		else if(o instanceof Kvadrat){
			setTxtXGLK(((Kvadrat) o).getGoreLevo().getX());
			setTxtYGLK(((Kvadrat) o).getGoreLevo().getY());
			setTxtDuzStranice(((Kvadrat) o).getDuzinaStranice());
			btnOkvirKvadrat.setBackground(o.getBoja());		
			btnPopuniKvadrat.setBackground(((Kvadrat) o).getBojaUnutrasnjosti());
		}
		else if(o instanceof Krug){
			setTxtXC(((Krug) o).getCentar().getX());
			setTxtYC(((Krug) o).getCentar().getY());
			setTxtPoluprecnik(((Krug) o).getR());
			btnOkvirKrug.setBackground(o.getBoja());		
			btnPopuniKrug.setBackground(((Krug) o).getBojaUnutrasnjosti());

		}
	}



	public boolean isProvera() {
		return provera;
	}



	public int getXTacka() {
		return Integer.parseInt(txtXTacka.getText());
	}

	public int getYTacka() {
		return Integer.parseInt(txtYTacka.getText());
	}

	public int getXPocetna() {
		return Integer.parseInt(txtXPocetna.getText());
	}

	public int getYPocetna() {
		return Integer.parseInt(txtYPocetna.getText());
	}

	public int getXKrajnja() {
		return Integer.parseInt(txtXKrajnja.getText());
	}

	public int getYKrajnja() {
		return Integer.parseInt(txtYKrajnja.getText());
	}

	public int getXGLK() {
		return Integer.parseInt(txtXGLK.getText());
	}

	public int getYGLK() {
		return Integer.parseInt(txtYGLK.getText());
	}

	public int getDuzStranice() {
		return Integer.parseInt(txtDuzStraniceKvadrata.getText());
	}

	public int getXGLP() {
		return Integer.parseInt(txtXGLP.getText());
	}

	public int getYGLP() {
		return Integer.parseInt(txtYGLP.getText());
	}

	public int getSirina() {
		return Integer.parseInt(txtSirina.getText());
	}

	public int getVisina() {
		return Integer.parseInt(txtVisina.getText());
	}

	public int getXC() {
		return Integer.parseInt(txtXC.getText());
	}

	public int getYC() {
		return Integer.parseInt(txtYC.getText());
	}

	public int getPoluprecnik() {
		return Integer.parseInt(txtPoluprecnik.getText());
	}


	public void setTxtXTacka(int txtXTacka) {
		this.txtXTacka.setText(Integer.toString(txtXTacka));
	}

	public void setTxtYTacka(int txtYTacka) {
		this.txtYTacka.setText(Integer.toString(txtYTacka));
	}

	public void setTxtXPocetna(int txtXPocetna) {
		this.txtXPocetna.setText(Integer.toString(txtXPocetna));
	}

	public void setTxtYPocetna(int txtYPocetna) {
		this.txtYPocetna.setText(Integer.toString(txtYPocetna));
	}

	public void setTxtXKrajnja(int txtXKrajnja) {
		this.txtXKrajnja.setText(Integer.toString(txtXKrajnja));
	}

	public void setTxtYKrajnja(int txtYKrajnja) {
		this.txtYKrajnja.setText(Integer.toString(txtYKrajnja));
	}

	public void setTxtXGLK(int txtXGLK) {
		this.txtXGLK.setText(Integer.toString(txtXGLK));
	}

	public void setTxtYGLK(int txtYGLK) {
		this.txtYGLK.setText(Integer.toString(txtYGLK));
	}

	public void setTxtDuzStranice(int txtDuzStranice) {
		this.txtDuzStraniceKvadrata.setText(Integer.toString(txtDuzStranice));
	}

	public void setTxtXGLP(int txtXGLP) {
		this.txtXGLP.setText(Integer.toString(txtXGLP));
	}

	public void setTxtYGLP(int txtYGLP) {
		this.txtYGLP.setText(Integer.toString(txtYGLP));
	}

	public void setTxtSirina(int txtSirina) {
		this.txtSirina.setText(Integer.toString(txtSirina));
	}

	public void setTxtVisina(int txtVisina) {
		this.txtVisina.setText(Integer.toString(txtVisina));
	}

	public void setTxtXC(int txtXC) {
		this.txtXC.setText(Integer.toString(txtXC));
	}

	public void setTxtYC(int txtYC) {
		this.txtYC.setText(Integer.toString(txtYC));
	}

	public void setTxtPoluprecnik(int txtPoluprecnik) {
		this.txtPoluprecnik.setText(Integer.toString(txtPoluprecnik));
	}

}
