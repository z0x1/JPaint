package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Kvadrat extends PovrsinskiOblik implements Pomerljiv{
	protected Tacka goreLevo;
	protected int duzinaStranice;


	public Kvadrat(){

	}
	public Kvadrat(Tacka goreLevo, int stranica){
		this.goreLevo = goreLevo;
		this.duzinaStranice = stranica;
	}
	public Kvadrat(Tacka goreLevo, int stranica, Color boja){
		this(goreLevo, stranica);
		setBoja(boja);
	}
	public void pomeriNa(int x, int y){
		goreLevo.pomeriNa(x, y);
	}
	public void pomeriZa(int x, int y){
		goreLevo.pomeriZa(x, y);
	}
	public double povrsina(){
		return duzinaStranice * duzinaStranice;
	}
	public double obim(){
		return 4 * duzinaStranice;
	}
	public boolean equals(Object obj){
		if(obj instanceof Kvadrat){
			Kvadrat pomocni = (Kvadrat) obj;
			if(goreLevo.equals(pomocni.goreLevo) && duzinaStranice == pomocni.duzinaStranice)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	public String toString(){
		return "Tacka gore levo="+goreLevo+", duzina stranice="+duzinaStranice;
	}

	public void selektovan(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY())).selektovan(g);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+duzinaStranice)).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY()), dijagonala().gettKrajnja()).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+duzinaStranice), dijagonala().gettKrajnja()).selektovan(g);
	}
	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), duzinaStranice, duzinaStranice);
		if(isSelektovan())
			selektovan(g);
	}
	public boolean sadrzi(int x, int y) {
		if(this.getGoreLevo().getX()<=x 
				&& x<=(this.getGoreLevo().getX() + duzinaStranice)
				&& this.getGoreLevo().getY()<=y 
				&& y<=(this.getGoreLevo().getY() + duzinaStranice))
			return true;
		else 
			return false;

	}
	public Linija dijagonala(){
		return new Linija(goreLevo, new Tacka(goreLevo.getX()+duzinaStranice, goreLevo.getY()+duzinaStranice));
	}
	public Tacka centar(){
		return dijagonala().sredinaLinije();
	}
	public void popuni(Graphics g){
		g.setColor(getBojaUnutrasnjosti());
		g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, duzinaStranice-1, duzinaStranice-1);
	}
	public int compareTo(Object o) {
		if(o instanceof Kvadrat){
			Kvadrat pomocni = (Kvadrat) o;
			return (int) (this.povrsina()-pomocni.povrsina());
		}
		else 
			return 0;
	}

	public Tacka getGoreLevo() {
		return goreLevo;
	}
	public int getDuzinaStranice() {
		return duzinaStranice;
	}
	public void setGoreLevo(Tacka goreLevo) {
		this.goreLevo = goreLevo;
	}
	public void setDuzinaStranice(int duzinaStranice) {
		this.duzinaStranice = duzinaStranice;
	}

}
