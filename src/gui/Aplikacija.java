package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.event.MouseMotionAdapter;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.Font;
import javax.swing.JToggleButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Aplikacija {

	private JFrame frmPaint; 
	public static String staRadim = "DEFAULT";
	private static Color bojaUnutrasnjosti = Color.WHITE;                                   //new Color(255, 255, 255, 0);
	private static Color bojaRama = Color.BLACK;
	private JToggleButton tglbtnTacka;
	private JToggleButton tglbtnLinija;
	private JToggleButton tglbtnKvadrat;
	private JToggleButton tglbtnPravougaonik;
	private JToggleButton tglbtnKrug;
	private static JButton btnBojaRama;
	private static JButton btnBojaUnutrasnjosti;
	private JToggleButton tglbtnSelektuj;
	private JToggleButton tglbtnModifikuj;
	private JToggleButton tglbtnObrisi;
	private JToggleButton tglbtnPomeri;
	private JToggleButton tglbtnDragPravougaonik;
	private JToggleButton tglbtnDragKvadrat;
	private JToggleButton tglbtnDragkrug;
	private JToggleButton tglbtnCetka;
	private JToggleButton tglbtnObrisiSve;
	private JButton btnUndo;
	private JButton btnRedo;
	private JComponent pnlCrtez;
	private static JLabel lblPozKurosoraY;
	private static JLabel lblPozKursoraX;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblBojaOkvira;
	private JLabel lblBojaUnutrasnjosti;
	private JSeparator separator;
	private JSeparator separator_1;
	private JToggleButton tglbtnDragLinija;
	private JToggleButton tglbtnKanticaBoje;
	private JToggleButton tglbtnPipeta;
	private JSeparator separator_2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws MalformedURLException {  
						////^zoki exception////
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
			
	        
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplikacija window = new Aplikacija();
					window.frmPaint.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
		////z0x1////
		
		URL url = Aplikacija.class.getResource("/ikonice/Z0X1.gif");
		Icon icon = new ImageIcon(url);
		JLabel label = new JLabel(icon);
		
		JFrame f = new JFrame("Error: z0x1 je upao u vas sistem");
		f.getContentPane().add(label);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation((int)(screenSize.getWidth()/4),(int)screenSize.getHeight()/4);
		f.setVisible(true);
		f.setAlwaysOnTop(true);
		
		/////z0x1////
	}


	/**
	 * Create the application.
	 */
	public Aplikacija() {
		inicijalizacija();
		akcije();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void inicijalizacija() {
		frmPaint = new JFrame();
		frmPaint.setTitle("z0x1");
		frmPaint.setBounds(100, 100, 966, 612);
		frmPaint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pnlCrtez = new Crtez();
		pnlCrtez.setOpaque(true);
		pnlCrtez.setBackground(Color.WHITE);
		pnlCrtez.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		frmPaint.getContentPane().add(pnlCrtez, BorderLayout.CENTER);
		pnlCrtez.setLayout(null);

		JPanel pnlOdabir = new JPanel();
		pnlOdabir.setBackground(UIManager.getColor("MenuItem.background"));
		frmPaint.getContentPane().add(pnlOdabir, BorderLayout.NORTH);
		GridBagLayout gbl_pnlOdabir = new GridBagLayout();
		gbl_pnlOdabir.columnWidths = new int[]{32, 32, 32, 32, 0, 0, 133, 33, 32, 32, 32, 32, 0, 57, 32, 36, 33, 60, 0};
		gbl_pnlOdabir.rowHeights = new int[]{25, 0, 33, 0};
		gbl_pnlOdabir.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlOdabir.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlOdabir.setLayout(gbl_pnlOdabir);
		btnUndo = new JButton("");		
		btnUndo.setIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/undo.png")));
		btnUndo.setToolTipText("Undo");
		GridBagConstraints gbc_btnUndo = new GridBagConstraints();
		gbc_btnUndo.anchor = GridBagConstraints.WEST;
		gbc_btnUndo.insets = new Insets(0, 0, 5, 5);
		gbc_btnUndo.gridx = 0;
		gbc_btnUndo.gridy = 0;
		pnlOdabir.add(btnUndo, gbc_btnUndo);
		btnRedo = new JButton("");	
		btnRedo.setIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/redo.png")));
		btnRedo.setToolTipText("Redo");
		GridBagConstraints gbc_btnRedo = new GridBagConstraints();
		gbc_btnRedo.anchor = GridBagConstraints.WEST;
		gbc_btnRedo.insets = new Insets(0, 0, 5, 5);
		gbc_btnRedo.gridx = 1;
		gbc_btnRedo.gridy = 0;
		pnlOdabir.add(btnRedo, gbc_btnRedo);
		tglbtnPomeri = new JToggleButton("");		
		tglbtnPomeri.setSelectedIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/pomeranje_selekt.png")));
		tglbtnPomeri.setIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/pomeranje.png")));
		tglbtnPomeri.setToolTipText("Pomeranje oblika");
		buttonGroup.add(tglbtnPomeri);
		GridBagConstraints gbc_tglbtnPomeri = new GridBagConstraints();
		gbc_tglbtnPomeri.anchor = GridBagConstraints.WEST;
		gbc_tglbtnPomeri.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPomeri.gridx = 2;
		gbc_tglbtnPomeri.gridy = 0;
		pnlOdabir.add(tglbtnPomeri, gbc_tglbtnPomeri);
		tglbtnModifikuj = new JToggleButton("");
		tglbtnModifikuj.setIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/modif_ne.png")));
		tglbtnModifikuj.setSelectedIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/modif_selekt.png")));
		buttonGroup.add(tglbtnModifikuj);
		tglbtnModifikuj.setToolTipText("Modifikacija \r\nselektovanog \r\noblika");
		GridBagConstraints gbc_tglbtnModifikuj = new GridBagConstraints();
		gbc_tglbtnModifikuj.anchor = GridBagConstraints.WEST;
		gbc_tglbtnModifikuj.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnModifikuj.gridx = 3;
		gbc_tglbtnModifikuj.gridy = 0;
		pnlOdabir.add(tglbtnModifikuj, gbc_tglbtnModifikuj);

		JLabel lblOpcija1 = new JLabel("Crtanje putem dijaloga");
		lblOpcija1.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblOpcija1 = new GridBagConstraints();
		gbc_lblOpcija1.anchor = GridBagConstraints.WEST;
		gbc_lblOpcija1.insets = new Insets(0, 0, 5, 5);
		gbc_lblOpcija1.gridx = 6;
		gbc_lblOpcija1.gridy = 0;
		pnlOdabir.add(lblOpcija1, gbc_lblOpcija1);
		tglbtnTacka = new JToggleButton("");
		tglbtnTacka.setIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/tacka.png")));
		tglbtnTacka.setSelectedIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/tacka_selekt.png")));
		tglbtnTacka.setToolTipText("Crtanje ta\u010Dke putem dijaloga");
		buttonGroup.add(tglbtnTacka);
		GridBagConstraints gbc_tglbtnTacka = new GridBagConstraints();
		gbc_tglbtnTacka.anchor = GridBagConstraints.WEST;
		gbc_tglbtnTacka.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnTacka.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnTacka.gridx = 7;
		gbc_tglbtnTacka.gridy = 0;
		pnlOdabir.add(tglbtnTacka, gbc_tglbtnTacka);
		tglbtnLinija = new JToggleButton("");
		tglbtnLinija.setSelectedIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/linija_selekt.png")));
		tglbtnLinija.setIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/linija.png")));
		tglbtnLinija.setToolTipText("Crtanje linije putem dijaloga");
		buttonGroup.add(tglbtnLinija);
		GridBagConstraints gbc_tglbtnLinija = new GridBagConstraints();
		gbc_tglbtnLinija.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnLinija.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnLinija.gridx = 8;
		gbc_tglbtnLinija.gridy = 0;
		pnlOdabir.add(tglbtnLinija, gbc_tglbtnLinija);
		tglbtnKvadrat = new JToggleButton("");
		tglbtnKvadrat.setSelectedIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/kvadratDLG_selekt.png")));
		tglbtnKvadrat.setIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/kvadratDLG.png")));
		tglbtnKvadrat.setToolTipText("Crtanje kvadrata putem dijaloga");
		buttonGroup.add(tglbtnKvadrat);
		GridBagConstraints gbc_tglbtnKvadrat = new GridBagConstraints();
		gbc_tglbtnKvadrat.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnKvadrat.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnKvadrat.gridx = 9;
		gbc_tglbtnKvadrat.gridy = 0;
		pnlOdabir.add(tglbtnKvadrat, gbc_tglbtnKvadrat);
		tglbtnPravougaonik = new JToggleButton("");
		tglbtnPravougaonik.setIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/pravougaonikDialog.png")));
		tglbtnPravougaonik.setSelectedIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/pravougaonikDlg_selekt.png")));
		tglbtnPravougaonik.setToolTipText("Crtanje pravougaonika putem dijaloga");
		buttonGroup.add(tglbtnPravougaonik);
		GridBagConstraints gbc_tglbtnPravougaonik = new GridBagConstraints();
		gbc_tglbtnPravougaonik.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnPravougaonik.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPravougaonik.gridx = 10;
		gbc_tglbtnPravougaonik.gridy = 0;
		pnlOdabir.add(tglbtnPravougaonik, gbc_tglbtnPravougaonik);
		tglbtnKrug = new JToggleButton("");
		tglbtnKrug.setSelectedIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/krugDLG_selekt.png")));
		tglbtnKrug.setIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/krugDLG.png")));
		tglbtnKrug.setToolTipText("Crtanje kruga putem dijaloga");
		buttonGroup.add(tglbtnKrug);
		GridBagConstraints gbc_tglbtnKrug = new GridBagConstraints();
		gbc_tglbtnKrug.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnKrug.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnKrug.gridx = 11;
		gbc_tglbtnKrug.gridy = 0;
		pnlOdabir.add(tglbtnKrug, gbc_tglbtnKrug);

		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.fill = GridBagConstraints.VERTICAL;
		gbc_separator_2.gridheight = 3;
		gbc_separator_2.insets = new Insets(0, 0, 5, 5);
		gbc_separator_2.gridx = 12;
		gbc_separator_2.gridy = 0;
		pnlOdabir.add(separator_2, gbc_separator_2);

		tglbtnPipeta = new JToggleButton("");
		tglbtnPipeta.setToolTipText("Uzimanje uzorka boje");
		tglbtnPipeta.setIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/pipeta.png")));
		buttonGroup.add(tglbtnPipeta);

		GridBagConstraints gbc_tglbtnPipeta = new GridBagConstraints();
		gbc_tglbtnPipeta.fill = GridBagConstraints.VERTICAL;
		gbc_tglbtnPipeta.anchor = GridBagConstraints.EAST;
		gbc_tglbtnPipeta.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPipeta.gridx = 13;
		gbc_tglbtnPipeta.gridy = 0;
		pnlOdabir.add(tglbtnPipeta, gbc_tglbtnPipeta);
		btnBojaRama = new JButton("");				
		btnBojaRama.setBackground(Color.BLACK);
		btnBojaRama.setToolTipText("Biranje boje okvira objekta i boje tacke i linije");
		GridBagConstraints gbc_btnBojaRama = new GridBagConstraints();
		gbc_btnBojaRama.fill = GridBagConstraints.BOTH;
		gbc_btnBojaRama.insets = new Insets(0, 0, 5, 5);
		gbc_btnBojaRama.gridx = 14;
		gbc_btnBojaRama.gridy = 0;
		pnlOdabir.add(btnBojaRama, gbc_btnBojaRama);

		lblBojaOkvira = new JLabel("Okvir");
		GridBagConstraints gbc_lblBojaOkvira = new GridBagConstraints();
		gbc_lblBojaOkvira.anchor = GridBagConstraints.WEST;
		gbc_lblBojaOkvira.insets = new Insets(0, 0, 5, 5);
		gbc_lblBojaOkvira.gridx = 15;
		gbc_lblBojaOkvira.gridy = 0;
		pnlOdabir.add(lblBojaOkvira, gbc_lblBojaOkvira);

		lblPozKursoraX = new JLabel("");
		GridBagConstraints gbc_lblPozKursoraX = new GridBagConstraints();
		gbc_lblPozKursoraX.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblPozKursoraX.insets = new Insets(0, 0, 5, 0);
		gbc_lblPozKursoraX.gridx = 17;
		gbc_lblPozKursoraX.gridy = 0;
		pnlOdabir.add(lblPozKursoraX, gbc_lblPozKursoraX);

		separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 7;
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 5;
		gbc_separator.gridy = 1;
		pnlOdabir.add(separator, gbc_separator);
		tglbtnObrisiSve = new JToggleButton("");
		tglbtnObrisiSve.setToolTipText("Obri\u0161i sve");
		buttonGroup.add(tglbtnObrisiSve);
		tglbtnObrisiSve.setIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/obrisisve.png")));
		GridBagConstraints gbc_tglbtnObrisiSve = new GridBagConstraints();
		gbc_tglbtnObrisiSve.anchor = GridBagConstraints.NORTHWEST;
		gbc_tglbtnObrisiSve.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnObrisiSve.gridx = 0;
		gbc_tglbtnObrisiSve.gridy = 2;
		pnlOdabir.add(tglbtnObrisiSve, gbc_tglbtnObrisiSve);

		tglbtnKanticaBoje = new JToggleButton("");
		tglbtnKanticaBoje.setToolTipText("Farbanje oblika");
		tglbtnKanticaBoje.setIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/kantica.png")));

		buttonGroup.add(tglbtnKanticaBoje);
		GridBagConstraints gbc_tglbtnKanticaBoje = new GridBagConstraints();
		gbc_tglbtnKanticaBoje.fill = GridBagConstraints.BOTH;
		gbc_tglbtnKanticaBoje.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnKanticaBoje.gridx = 1;
		gbc_tglbtnKanticaBoje.gridy = 2;
		pnlOdabir.add(tglbtnKanticaBoje, gbc_tglbtnKanticaBoje);
		tglbtnSelektuj = new JToggleButton("");
		tglbtnSelektuj.setIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/selekt.png")));
		tglbtnSelektuj.setSelectedIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/selekt_selekt.png")));
		buttonGroup.add(tglbtnSelektuj);
		tglbtnSelektuj.setToolTipText("Selektovanje iscrtanih oblika");
		GridBagConstraints gbc_tglbtnSelektuj = new GridBagConstraints();
		gbc_tglbtnSelektuj.anchor = GridBagConstraints.NORTHWEST;
		gbc_tglbtnSelektuj.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnSelektuj.gridx = 2;
		gbc_tglbtnSelektuj.gridy = 2;
		pnlOdabir.add(tglbtnSelektuj, gbc_tglbtnSelektuj);
		tglbtnObrisi = new JToggleButton("");
		tglbtnObrisi.setIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/eraser.png")));
		buttonGroup.add(tglbtnObrisi);
		tglbtnObrisi.setToolTipText("Brisanje selektovanog oblika");
		GridBagConstraints gbc_tglbtnObrisi = new GridBagConstraints();
		gbc_tglbtnObrisi.anchor = GridBagConstraints.NORTHWEST;
		gbc_tglbtnObrisi.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnObrisi.gridx = 3;
		gbc_tglbtnObrisi.gridy = 2;
		pnlOdabir.add(tglbtnObrisi, gbc_tglbtnObrisi);

		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.VERTICAL;
		gbc_separator_1.gridheight = 3;
		gbc_separator_1.insets = new Insets(0, 0, 0, 5);
		gbc_separator_1.gridx = 4;
		gbc_separator_1.gridy = 0;
		pnlOdabir.add(separator_1, gbc_separator_1);

		JLabel lblOpcija2 = new JLabel("Crtanje putem mi\u0161a");
		lblOpcija2.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblOpcija2 = new GridBagConstraints();
		gbc_lblOpcija2.anchor = GridBagConstraints.WEST;
		gbc_lblOpcija2.insets = new Insets(0, 0, 0, 5);
		gbc_lblOpcija2.gridx = 6;
		gbc_lblOpcija2.gridy = 2;
		pnlOdabir.add(lblOpcija2, gbc_lblOpcija2);

		tglbtnCetka = new JToggleButton("");
		tglbtnCetka.setSelectedIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/olovka_selekt.png")));
		tglbtnCetka.setIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/olovka.png")));
		tglbtnCetka.setToolTipText("Olovka");
		buttonGroup.add(tglbtnCetka);
		GridBagConstraints gbc_tglbtnCetka = new GridBagConstraints();
		gbc_tglbtnCetka.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnCetka.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnCetka.gridx = 7;
		gbc_tglbtnCetka.gridy = 2;
		pnlOdabir.add(tglbtnCetka, gbc_tglbtnCetka);

		tglbtnDragLinija = new JToggleButton("");
		tglbtnDragLinija.setToolTipText("Crtanje linije");

		tglbtnDragLinija.setSelectedIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/linija_selekt.png")));
		tglbtnDragLinija.setIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/linija.png")));
		buttonGroup.add(tglbtnDragLinija);
		GridBagConstraints gbc_tglbtnDragLinija = new GridBagConstraints();
		gbc_tglbtnDragLinija.fill = GridBagConstraints.BOTH;
		gbc_tglbtnDragLinija.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnDragLinija.gridx = 8;
		gbc_tglbtnDragLinija.gridy = 2;
		pnlOdabir.add(tglbtnDragLinija, gbc_tglbtnDragLinija);
		tglbtnDragKvadrat = new JToggleButton("");
		tglbtnDragKvadrat.setToolTipText("Crtanje kvadrata");
		tglbtnDragKvadrat.setSelectedIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/Kvadrat_selekt.png")));
		tglbtnDragKvadrat.setIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/Kvadrat.png")));
		buttonGroup.add(tglbtnDragKvadrat);
		GridBagConstraints gbc_tglbtnDragKvadrat = new GridBagConstraints();
		gbc_tglbtnDragKvadrat.anchor = GridBagConstraints.NORTH;
		gbc_tglbtnDragKvadrat.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnDragKvadrat.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnDragKvadrat.gridx = 9;
		gbc_tglbtnDragKvadrat.gridy = 2;
		pnlOdabir.add(tglbtnDragKvadrat, gbc_tglbtnDragKvadrat);

		tglbtnDragPravougaonik = new JToggleButton("");
		tglbtnDragPravougaonik.setToolTipText("Crtanje pravougaonika");
		tglbtnDragPravougaonik.setIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/Pravougaonik.png")));
		tglbtnDragPravougaonik.setSelectedIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/Pravougaonik_selekt.png")));
		buttonGroup.add(tglbtnDragPravougaonik);
		GridBagConstraints gbc_tglbtnDragPravougaonik = new GridBagConstraints();
		gbc_tglbtnDragPravougaonik.anchor = GridBagConstraints.NORTH;
		gbc_tglbtnDragPravougaonik.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnDragPravougaonik.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnDragPravougaonik.gridx = 10;
		gbc_tglbtnDragPravougaonik.gridy = 2;
		pnlOdabir.add(tglbtnDragPravougaonik, gbc_tglbtnDragPravougaonik);
		tglbtnDragkrug = new JToggleButton("");
		tglbtnDragkrug.setToolTipText("Crtanje kruga");
		tglbtnDragkrug.setIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/krug.png")));
		tglbtnDragkrug.setSelectedIcon(new ImageIcon(Aplikacija.class.getResource("/ikonice/krug_selekt.png")));
		buttonGroup.add(tglbtnDragkrug);
		GridBagConstraints gbc_tglbtnDragkrug = new GridBagConstraints();
		gbc_tglbtnDragkrug.anchor = GridBagConstraints.NORTH;
		gbc_tglbtnDragkrug.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnDragkrug.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnDragkrug.gridx = 11;
		gbc_tglbtnDragkrug.gridy = 2;
		pnlOdabir.add(tglbtnDragkrug, gbc_tglbtnDragkrug);
		btnBojaUnutrasnjosti = new JButton("");				
		btnBojaUnutrasnjosti.setBackground(Color.WHITE);
		btnBojaUnutrasnjosti.setToolTipText("Biranje boje unutra\u0161njosti objekta");
		GridBagConstraints gbc_btnBojaUnutrasnjosti = new GridBagConstraints();
		gbc_btnBojaUnutrasnjosti.fill = GridBagConstraints.BOTH;
		gbc_btnBojaUnutrasnjosti.insets = new Insets(0, 0, 0, 5);
		gbc_btnBojaUnutrasnjosti.gridx = 14;
		gbc_btnBojaUnutrasnjosti.gridy = 2;
		pnlOdabir.add(btnBojaUnutrasnjosti, gbc_btnBojaUnutrasnjosti);

		lblBojaUnutrasnjosti = new JLabel("Popuna");
		GridBagConstraints gbc_lblBojaUnutrasnjosti = new GridBagConstraints();
		gbc_lblBojaUnutrasnjosti.anchor = GridBagConstraints.WEST;
		gbc_lblBojaUnutrasnjosti.insets = new Insets(0, 0, 0, 5);
		gbc_lblBojaUnutrasnjosti.gridx = 15;
		gbc_lblBojaUnutrasnjosti.gridy = 2;
		pnlOdabir.add(lblBojaUnutrasnjosti, gbc_lblBojaUnutrasnjosti);

		lblPozKurosoraY = new JLabel("");
		GridBagConstraints gbc_lblPozKurosoraY = new GridBagConstraints();
		gbc_lblPozKurosoraY.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPozKurosoraY.gridx = 17;
		gbc_lblPozKurosoraY.gridy = 2;
		pnlOdabir.add(lblPozKurosoraY, gbc_lblPozKurosoraY);
	}




	private void akcije(){
		tglbtnTacka.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "TACKA";
			}
		});

		tglbtnLinija.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "LINIJA";
			}
		});

		tglbtnKvadrat.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "KVADRAT";
			}
		});

		tglbtnPravougaonik.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "PRAVOUGAONIK";
			}
		});

		tglbtnKrug.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "KRUG";
			}
		});

		tglbtnObrisiSve.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "OBRISI_SVE";
			}
		});

		tglbtnSelektuj.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "SELEKTUJ";
			}
		});

		tglbtnModifikuj.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "MODIFIKUJ";
			}
		});

		tglbtnObrisi.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "OBRISI";
			}
		});

		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staRadim = "UNDO";
			}
		});

		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staRadim = "REDO";
			}
		});

		tglbtnPomeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staRadim = "POMERI";
			}
		});

		btnBojaRama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bojaRama = JColorChooser.showDialog(null, "Boja rama", bojaRama);
				if(bojaRama!=null){
					btnBojaRama.setBackground(bojaRama);
				}
			}
		});

		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bojaUnutrasnjosti = JColorChooser.showDialog(null, "Unutrasnjosti", bojaUnutrasnjosti);
				if(bojaUnutrasnjosti!=null){
					btnBojaUnutrasnjosti.setBackground(bojaUnutrasnjosti);
				}
			}
		});

		tglbtnDragLinija.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "DRGLINIJA";
			}
		});

		tglbtnDragPravougaonik.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "DRGPRAVOUGAONIK";
			}
		});

		tglbtnDragKvadrat.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "DRGKVADRAT";
			}
		});

		tglbtnDragkrug.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "DRGKRUG";
			}
		});
		tglbtnCetka.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				staRadim = "CETKA";
			}
		});

		tglbtnKanticaBoje.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				staRadim = "KANTICA";
			}
		});

		tglbtnPipeta.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				staRadim = "PIPETA";
			}
		});
	}



	public static Color getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public static Color getBojaRama() {
		return bojaRama;
	}

	public static JLabel getLblPozKurosoraY() {
		return lblPozKurosoraY;
	}

	public static JLabel getLblPozKursoraX() {
		return lblPozKursoraX;
	}
	public static void setBojaUnutrasnjosti(Color bojaUnutrasnjosti) {
		Aplikacija.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}


	public static void setBojaRama(Color bojaRama) {
		Aplikacija.bojaRama = bojaRama;
	}
	public static JButton getBtnBojaRama() {
		return btnBojaRama;
	}


	public static JButton getBtnBojaUnutrasnjosti() {
		return btnBojaUnutrasnjosti;
	}
}
