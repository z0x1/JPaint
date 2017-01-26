package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Tacka extends Oblik implements Pomerljiv{
	private int x;
	private int y;


	public Tacka(){

	}	
	public Tacka(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Tacka(int x, int y, Color boja){
		this(x, y);
		setBoja(boja);
	}

	public void pomeriNa(int x, int y){
		this.x = x;
		setY(y);
	}
	public void pomeriZa(int x, int y){
		this.x = this.x+x;
		setY(getY()+y);
	}
	public double udaljenost(Tacka t2){
		double dx = t2.x-this.x;
		double dy = t2.getY()-this.y;
		double d = Math.sqrt(dx*dx + dy*dy);
		return d;

	}
	public boolean equals(Object obj){
		if(obj instanceof Tacka){
			Tacka pomocna = (Tacka) obj;
			if(x == pomocna.getX() && y == pomocna.y)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	// (x,y)
	public String toString(){
		return "("+x+","+y+")";
	}
	
	public void selektovan(Graphics g){
		g.setColor(Color.BLUE);
		g.drawRect(x-3, y-3, 6, 6);
	}
	public boolean sadrzi(int x, int y){
		Tacka pomocna = new Tacka(x, y);
		if(pomocna.udaljenost(this)<=2)
			return true;
		else
			return false;
	}
	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y-2, x, y+2);
		
		if(isSelektovan())
			selektovan(g);

	}

	public int compareTo(Object o) {
		if(o instanceof Tacka){
			Tacka pomocna = (Tacka) o;
			Tacka nula = new Tacka(0, 0);
			return (int) (this.udaljenost(nula) - pomocna.udaljenost(nula));
		}
		else 
			return 0;
	}	

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	@Override
	public void popuni(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
