package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Oblik implements Comparable{
	private Color boja;
	protected boolean selektovan;

	public Oblik(){

	}
	public Oblik(Color boja){
		this.boja = boja;
	}
	public abstract void crtajSe(Graphics g);
	public abstract void selektovan(Graphics g);
	public abstract boolean sadrzi(int x, int y);
	public abstract void popuni(Graphics g);



	public Color getBoja() {
		return boja;
	}

	public void setBoja(Color boja) {
		this.boja = boja;
	}

	public boolean isSelektovan() {
		return selektovan;
	}
	public void setSelektovan(boolean selektovan) {
		this.selektovan = selektovan;
	}

}
