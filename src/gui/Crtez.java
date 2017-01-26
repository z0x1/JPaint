package gui;

import geometrija.*;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

public class Crtez extends JComponent {
	int x;
	int y;
	int xPoz, yPoz;
	int xEnd, xStart;
	int yEnd, yStart;
	int linijaFlag = 0;
	int temp;
	int pozicijaSelektovanog;

	int tX, tY;
	int rX, rY;
	boolean stanjeDrag = false;

	public ArrayList<Oblik> lista = new ArrayList<Oblik>();

	public ArrayList<Oblik> listaUndo = new ArrayList<Oblik>();

	public ArrayList<Oblik> selektovani = new ArrayList<>();
	private Oblik b;
	private Graphics2D g;
	private Pravougaonik ctk;
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {

	}

	public Crtez() {

		setOpaque(true);
		setBackground(Color.WHITE);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				stanjeDrag = false;

				tX = e.getX();
				tY = e.getY();


				if (Aplikacija.staRadim == CrtOpcija.TACKA) {
					lista.add(new Tacka(e.getX(), e.getY(), Aplikacija.getBojaRama()));
				} 
				else if (Aplikacija.staRadim == CrtOpcija.LINIJA) {
					if (linijaFlag == 0) {
						xStart = e.getX();
						yStart = e.getY();
						linijaFlag = 1;
					} else {
						lista.add(new Linija(new Tacka(xStart, yStart), new Tacka(e.getX(), e.getY()),
								Aplikacija.getBojaRama()));
						linijaFlag = 0;
					}
				} 
				else if (Aplikacija.staRadim == CrtOpcija.KVADRAT) {
					DlgKvadrat d1 = new DlgKvadrat();
					d1.setVisible(true);
					if (DlgKvadrat.isDaLiCrtati()) {
						Kvadrat kv1 = new Kvadrat(new Tacka(e.getX(), e.getY()), DlgKvadrat.getDuzinaStranice(),
								Aplikacija.getBojaRama());
						kv1.setBojaUnutrasnjosti(Aplikacija.getBojaUnutrasnjosti());
						lista.add(kv1);
					}
				} 
				else if (Aplikacija.staRadim == CrtOpcija.PRAVOUGAONIK) {
					DlgPravougaonik d2 = new DlgPravougaonik();
					d2.setVisible(true);
					if (DlgPravougaonik.isDaLiCrtati()) {
						Pravougaonik pr1 = new Pravougaonik(new Tacka(e.getX(), e.getY()),
								DlgPravougaonik.getDuzinaStranice(), DlgPravougaonik.getVisina(),
								Aplikacija.getBojaRama());
						pr1.setBojaUnutrasnjosti(Aplikacija.getBojaUnutrasnjosti());
						lista.add(pr1);
					}
				} 
				else if (Aplikacija.staRadim == CrtOpcija.KRUG) {
					DlgKrug d3 = new DlgKrug();
					d3.setVisible(true);
					if (DlgKrug.isDaLiCrtati()) {
						Krug kr1 = new Krug(new Tacka(e.getX(), e.getY()), DlgKrug.getPoluprecnik(),
								Aplikacija.getBojaRama());
						kr1.setBojaUnutrasnjosti(Aplikacija.getBojaUnutrasnjosti());
						lista.add(kr1);
					}
				} 
				else if (Aplikacija.staRadim == CrtOpcija.SELEKTUJ) {
					selektovanje(e.getX(), e.getY());
				} 
				else if(Aplikacija.staRadim == CrtOpcija.MODIFIKUJ) {
					//selektovanje(e.getX(), e.getY());
					modifikacija();
				}

				else if(Aplikacija.staRadim == CrtOpcija.KANTICA) {
					selektovanje(e.getX(), e.getY());
					kantica();

				}

				else if(Aplikacija.staRadim == CrtOpcija.PIPETA) {
					selektovanje(e.getX(), e.getY());
					pipetica();

				}



			}

		});

		addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) {

				Aplikacija.getLblPozKursoraX().setText("X:"+ (int)e.getX());
				Aplikacija.getLblPozKurosoraY().setText("Y:" +(int)e.getY());


				if (Aplikacija.staRadim == CrtOpcija.POMERI) {
					pomeranje(e.getX(), e.getY());
				}
				else if (Aplikacija.staRadim == CrtOpcija.DRGKVADRAT) {

					Kvadrat kvd = new Kvadrat(new Tacka(tX, tY), Math.abs(Math.max(tX - e.getX(), tY - e.getY())),
							Aplikacija.getBojaRama());
					kvd.setBojaUnutrasnjosti(Aplikacija.getBojaUnutrasnjosti());

					//if (!lista.isEmpty()) {
					if (stanjeDrag == true) {
						lista.remove(lista.size() - 1);
					} else {
						stanjeDrag = true;
					}

					//}
					lista.add(kvd);

				}

				else if (Aplikacija.staRadim == CrtOpcija.DRGPRAVOUGAONIK) {

					Pravougaonik pd = new Pravougaonik(new Tacka(tX, tY), Math.abs(tX - e.getX()),
							Math.abs(tY - e.getY()), Aplikacija.getBojaRama());
					pd.setBojaUnutrasnjosti(Aplikacija.getBojaUnutrasnjosti());

					//if (!lista.isEmpty()) {
					if (stanjeDrag == true) {
						lista.remove(lista.size() - 1);
					} else {
						stanjeDrag = true;
					}

					//}
					lista.add(pd);
				} 
				else if (Aplikacija.staRadim == CrtOpcija.DRGKRUG) {

					Krug kgd = new Krug(new Tacka(tX, tY), Math.min(Math.abs(tX - e.getX()), Math.abs(tY - e.getY())),
							Aplikacija.getBojaRama());
					kgd.setBojaUnutrasnjosti(Aplikacija.getBojaUnutrasnjosti());

					//if (!lista.isEmpty()) {
					if (stanjeDrag == true) {
						lista.remove(lista.size() - 1);
					} else {
						stanjeDrag = true;
					}

					//}
					lista.add(kgd);
				}
				else if(Aplikacija.staRadim == CrtOpcija.CETKA){

					Linija cetka = new Linija(new Tacka(tX,tY),new Tacka(e.getX(),e.getY()), Aplikacija.getBojaRama());
					tX=e.getX();
					tY=e.getY();
					lista.add(cetka);

				}

				else if(Aplikacija.staRadim == CrtOpcija.DRGLINIJA){
					Linija ldrg = new Linija(new Tacka(tX, tY), new Tacka(e.getX(), e.getY()), Aplikacija.getBojaRama());
					if (stanjeDrag == true) {
						lista.remove(lista.size() - 1);
					} else {
						stanjeDrag = true;
					}
					lista.add(ldrg);

				}

			}
			@Override
			public void mouseMoved(MouseEvent arg0) {
				Aplikacija.getLblPozKursoraX().setText("X:"+ (int)arg0.getX());
				Aplikacija.getLblPozKurosoraY().setText("Y:" +(int)arg0.getY());
			}
		});

		// repaint

	}

	public void paintComponent(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		
		/////zoki///////

		g.setColor(new Color(0, 0, 0, 120));
		g.setFont(new Font("Arial Bold", Font.BOLD,22));
		g.drawString("ZOKI LOWARA", getWidth()-160, getHeight()-20);

		g.setFont(new Font("Arial Bold", Font.ITALIC,10));
		g.drawString("Trial version", getWidth()-75, getHeight()-8);
		
		
		/////zoki///////
		
		

		if (Aplikacija.staRadim == CrtOpcija.OBRISI_SVE) {
			lista.clear();
			Aplikacija.staRadim = CrtOpcija.DEFAULT;
		}

		if(Aplikacija.staRadim == CrtOpcija.OBRISI)
		{
			brisanje();
		}


		if (Aplikacija.staRadim == CrtOpcija.UNDO) {
			if (!lista.isEmpty()) {
				listaUndo.add(lista.get(lista.size() - 1));
				lista.remove(lista.size() - 1);
			}
			Aplikacija.staRadim = CrtOpcija.DEFAULT;
		}
		if (Aplikacija.staRadim == CrtOpcija.REDO) {
			if (!listaUndo.isEmpty()) {
				lista.add(listaUndo.get(listaUndo.size() - 1));
				listaUndo.remove(listaUndo.size() - 1);
			}

			Aplikacija.staRadim = CrtOpcija.DEFAULT;
		}

		lista.forEach((a) -> {
			a.popuni(g);
			a.crtajSe(g);
		});
		getRootPane().validate();
		getRootPane().repaint();

	}

	public void selektovanje(int x, int y) {

		selektovani.clear();

		lista.forEach((a) -> {
			a.setSelektovan(false);
			if (a.sadrzi(x, y))
				selektovani.add(a);
		});

		if (!selektovani.isEmpty()) {
			selektovani.get(selektovani.size() - 1).setSelektovan(true);
		} 

	}

	public void modifikacija(){
		if (!selektovani.isEmpty()) {
			lista.forEach((a) -> {
				if (a.isSelektovan()) {
					b = a;
					pozicijaSelektovanog = lista.indexOf(a);
				}
			});
			if (b instanceof Krug) {
				DlgIzmena dg = new DlgIzmena();
				dg.postaviTabove(4);
				dg.postaviPolja(b);
				dg.setVisible(true);
				if(dg.isProvera()){
					dg.izmeni(b);
				}
			}
			else if (b instanceof Pravougaonik) {
				DlgIzmena dp = new DlgIzmena();
				dp.postaviTabove(3);
				dp.postaviPolja(b);
				dp.setVisible(true);
				if(dp.isProvera()){
					dp.izmeni(b);
				}

			} 
			else if (b instanceof Kvadrat ) {
				DlgIzmena dk = new DlgIzmena();
				dk.postaviTabove(2);
				dk.postaviPolja(b);
				dk.setVisible(true);
				if (dk.isProvera()) {
					dk.izmeni(b);
				}
			} 
			else if(b instanceof Linija){
				DlgIzmena dl = new DlgIzmena();
				dl.postaviTabove(1);
				dl.postaviPolja(b);
				dl.setVisible(true);
				if(dl.isProvera()){
					dl.izmeni(b);
				}
			}
			else if(b instanceof Tacka){
				DlgIzmena dt = new DlgIzmena();
				dt.postaviTabove(0);
				dt.postaviPolja(b);
				dt.setVisible(true);
				if(dt.isProvera()){
					dt.izmeni(b);
				}
			}
			Aplikacija.staRadim = CrtOpcija.DEFAULT;
		}
	}
	public void brisanje(){
		if (!selektovani.isEmpty()) {
			lista.forEach((a) -> {
				if (a.isSelektovan()) {
					temp = lista.indexOf(a);
				}
			});

			lista.remove(lista.get(temp));
			selektovani.clear();

			Aplikacija.staRadim = CrtOpcija.DEFAULT;
		} 
	}

	public void pomeranje(int x, int y){
		if (!selektovani.isEmpty()) {
			b = selektovani.get(selektovani.size() - 1);
			if(b instanceof Kvadrat){
				((Kvadrat)b).pomeriNa(x, y);
			} 
			else if (b instanceof Krug)
			{
				((Krug)b).pomeriNa(x, y);
			}
			else if (b instanceof Linija) {
				((Linija) b).pomeriZa(x - ((Linija) b).gettPocetna().getX(), y - ((Linija) b).gettPocetna().getY());
			} 
			else if (b instanceof Tacka) {
				((Tacka) b).pomeriNa(x, y);
			}
		}
	}

	public void kantica(){
		if (!selektovani.isEmpty()) {
			lista.forEach((a) -> {
				if (a.isSelektovan()) {
					temp = lista.indexOf(a);
				}
			});

			if(lista.get(temp) instanceof PovrsinskiOblik){
				((PovrsinskiOblik)lista.get(temp)).setBojaUnutrasnjosti(Aplikacija.getBojaUnutrasnjosti());
				lista.get(temp).setBoja(Aplikacija.getBojaRama());
			}
			else
			{
				lista.get(temp).setBoja(Aplikacija.getBojaRama());
			}
			selektovani.clear();

		} 
	}

	public void pipetica(){
		if (!selektovani.isEmpty()) {
			lista.forEach((a) -> {
				if (a.isSelektovan()) {
					temp = lista.indexOf(a);
				}
			});

			if(lista.get(temp) instanceof PovrsinskiOblik){
				Aplikacija.setBojaUnutrasnjosti(((PovrsinskiOblik)lista.get(temp)).getBojaUnutrasnjosti());
				Aplikacija.setBojaRama(lista.get(temp).getBoja());
				Aplikacija.getBtnBojaRama().setBackground(lista.get(temp).getBoja());
				Aplikacija.getBtnBojaUnutrasnjosti().setBackground(((PovrsinskiOblik)lista.get(temp)).getBojaUnutrasnjosti());

			}
			else
			{
				Aplikacija.setBojaRama(lista.get(temp).getBoja());
				Aplikacija.getBtnBojaRama().setBackground(lista.get(temp).getBoja());
				
			}
			selektovani.clear();

		} 
		else {
			Aplikacija.setBojaUnutrasnjosti(Color.WHITE);
			Aplikacija.setBojaRama(Color.BLACK);
			Aplikacija.getBtnBojaRama().setBackground(Color.BLACK);
			Aplikacija.getBtnBojaUnutrasnjosti().setBackground(Color.WHITE);
		}

	}
}