package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Linija extends Oblik{
	private Tacka tPocetna;
	private Tacka tKrajnja;
	public static int brojac;


	public Linija(){
		brojac++;
	}
	public Linija(Tacka tPocetna, Tacka tKrajnja){
		this.tPocetna = tPocetna;
		this.tKrajnja = tKrajnja;
		brojac++;
	}
	public Linija(Tacka tPocetna, Tacka tKrajnja, Color boja){
		this(tPocetna, tKrajnja);
		setBoja(boja);
	}
	
	public void pomeriZa(int x, int y){
		tPocetna.setX(tPocetna.getX()+x);
		tPocetna.setY(tPocetna.getY()+y);
		tKrajnja.setX(tKrajnja.getX()+x);
		tKrajnja.setY(tKrajnja.getY()+y);
	}

	public double duzina(){
		return tPocetna.udaljenost(tKrajnja);
	}
	public boolean equals(Object obj){
		if(obj instanceof Linija){
			Linija pomocna = (Linija) obj;
			if(tPocetna.equals(pomocna.tPocetna) && tKrajnja.equals(pomocna.tKrajnja))
				return true;
			else
				return false;
		}
		else
			return false;
	}
	//(xPocetne,yPocetne)-->(xKrajnje,yKrajnje)
	public String toString(){
		return tPocetna+"-->"+tKrajnja;
	}
	public void selektovan(Graphics g){
		g.setColor(Color.BLUE);
		tPocetna.selektovan(g);
		tKrajnja.selektovan(g);
		sredinaLinije().selektovan(g);

	}
	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawLine(tPocetna.getX(), tPocetna.getY(), tKrajnja.getX(), tKrajnja.getY());
		if(isSelektovan())
			selektovan(g);
	}
	public boolean sadrzi(int x, int y){
		Tacka pomocna = new Tacka(x, y);
		if((tPocetna.udaljenost(pomocna)+tKrajnja.udaljenost(pomocna))-duzina()<=0.5)
			return true;
		else
			return false;
	}
	

	public Tacka sredinaLinije(){
		int xSredine = (tPocetna.getX() + tKrajnja.getX())/2;
		int ySredine = (tPocetna.getY() + tKrajnja.getY())/2;
		Tacka sredinaLinije = new Tacka(xSredine, ySredine);
		return sredinaLinije;
	}
	public int compareTo(Object o) {
		if(o instanceof Linija){
			Linija pomocna = (Linija) o;
			return (int)this.duzina()-(int)pomocna.duzina();
		}
		else 
			return 0;
	}
	public Tacka gettPocetna(){
		return tPocetna;
	}
	public Tacka gettKrajnja(){
		return tKrajnja;
	}
	public void settPocetna(Tacka tPocetna){
		this.tPocetna = tPocetna;
	}
	public void settKrajnja(Tacka tKrajnja){
		this.tKrajnja = tKrajnja;
	}
	@Override
	public void popuni(Graphics g) {
		// TODO Auto-generated method stub

	}


}
