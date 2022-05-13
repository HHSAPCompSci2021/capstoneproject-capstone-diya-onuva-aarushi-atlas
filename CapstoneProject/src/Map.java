import java.awt.Image;
import java.util.ArrayList;

import processing.core.PApplet;

public class Map {

	int r, g, b, curr;
	double xStart, width, yStart, height;
	private int[][] coords;
	
	public Map()
	{
		coords = new int[5][2];
		curr = 0;
		r = 0;
		g = 0;
		b = 0;
		
		xStart = 0;
		yStart = 0;
		width = 600;
		height = 591;
	}
	
	public Map(double x, double y, double w, double h)
	{
		coords = new int[5][2];
		curr = 0;
		r = 0;
		g = 0;
		b = 0;
		
		xStart = x;
		yStart = y;
		width = w;
		height = h;
	}
	
	public String getCountry(PApplet draw, int x, int y)
	{
		
		r = PApplet.round(draw.red(draw.color(draw.get(x, y))));
		g = PApplet.round(draw.green(draw.color(draw.get(x, y))));
		b = PApplet.round(draw.blue(draw.color(draw.get(x, y))));
		
		String s = findCountry(x, y);
		if (s != null) return s;
		//return s;
		reset();
		curr = 0;
		return nearC(draw, x, y);
		
	}
	
	public String findCountry(int x, int y) {
		
		if (r==255 && g==25 && b==25) {
			if (x < (width/12)+xStart) return "The Gambia";
			else if (x < (width/4)+xStart) return "Liberia";
			else if (x < (width/2)+xStart) return "Benin";
			else if (y < (height/2)+yStart) return "Egypt";
			else return "Zimbabwe";
		}
		else if (r==255 && g==25 && b==255) {
			if (x < (width/3)+xStart) return "Ghana";
			else if (x < (width * (7.0/15))+xStart) return "Gabon";
			else if (x < (width * (11.0/15))+xStart) return "South Africa";
			else return "Eritrea";
		}
		else if (r==25 && g==25 && b==255) {
			if (x < (width/6)+xStart) return "Sengal";
			else if (x < (width/2)+xStart) return "Burkina Faso";
			else return "Somalia";
		}
		else if (r==48 && g==168 && b==54) {
			if (x < (width * (5.0/6))+xStart) return "Mozambique";
			else if ((x < (width * (53.0/60))+xStart) && (y < (height * (140.0/197))+yStart)) return "The Comoros";
			else return "Madagascar";
		}
		else if (r==25 && g==255 && b==25) {
			if (x < (width * (5.0/8))+xStart) return "Angola";
			else return "Uganda";
		}
		else if(r==255 && g==197 && b==25) return "Morocco";
		else if(r==217 && g==202 && b==254) return "Western Sahara";
		else if(r==255 && g==44 && b==25) return "Algeria";
		else if(r==80 && g==129 && b==235) return "Libya";
		else if(r==199 && g==255 && b==25) return "Sudan";
		else if(r==93 && g==197 && b==25) return "Tunisia";
		else if(r==255 && g==25 && b==167) return "Ethiopia";
		else if(r==158 && g==25 && b==255) return "Kenya";
		else if(r==98 && g==48 && b==109) return "Tanzania";
		else if(r==255 && g==140 && b==25) return "Malawi";
		else if(r==255 && g==255 && b==174) return "Zambia";
		else if(r==250 && g==221 && b==188) return "Eswatini";
		else if(r==114 && g==25 && b==168) return "Djibouti";
		else if(r==141 && g==25 && b==255) return "Lesotho";
		else if(r==255 && g==25 && b==145) return "Botswana";
		else if(r==255 && g==103 && b==25) return "Namibia";
		else if(r==150 && g==25 && b==25) return "Central African Republic";
		else if(r==34 && g==26 && b==254) return "Republic of the Congo";
		else if(r==117 && g==197 && b==25) return "Equatorial Guinea";
		else if(r==217 && g==194 && b==85) return "Democratic Republic of the Congo";
		else if(r==96 && g==85 && b==25) return "Cameroon";
		else if(r==93 && g==25 && b==25) return "Rwanda";
		else if(r==165 && g==204 && b==206) return "Burundi";
		else if(r==58 && g==25 && b==152) return "Chad";
		else if(r==80 && g==25 && b==103) return "Niger";
		else if(r==76 && g==199 && b==25) return "Mali";
		else if(r==237 && g==121 && b==13) return "Mauritania";
		else if(r==112 && g==255 && b==25) return "Guinea";
		else if(r==255 && g==174 && b==25) return "Nigeria";
		else if(r==255 && g==255 && b==25) return "Togo";
		else if(r==170 && g==121 && b==66) return "South Sudan";
		else if(r==255 && g==2 && b==2) return "Guinea-Bissau";
		else if(r==25 && g==132 && b==25) return "Sierra Leone";
		else if(r==255 && g==123 && b==25) return "Côte D'Ivore";
		else return null;
	}
	
	public String getCapital(String s)
	{
		return s;
		
	}
	
	public ArrayList<String> getPics(String s)
	{
		return null;
		
	}
	
	public String getRInfo(String s)
	{
		return s;
		
	}
	
	public String nearC(PApplet draw, int x, int y) {
		if(x<0 || y<0 || x > draw.width || y > draw.height) return null;
		if (curr == coords.length) return null;
		if(foundSameIndex(x, y))return null;		
		
		coords[curr][0] = x;
		coords[curr][1] = y;
		curr++;
		
		r = PApplet.round(draw.red(draw.color(draw.get(x, y))));
		g = PApplet.round(draw.green(draw.color(draw.get(x, y))));
		b = PApplet.round(draw.blue(draw.color(draw.get(x, y))));
		
		String m = findCountry(x, y);
		if(m != null) return m;
		
		String n = nearNorth(draw, x, y-1);
		if (n!=null) return n;
		reset();
		curr=0;
		String e = nearEast(draw, x+1, y);
		if (e!=null) return e;
		reset();
		curr=0;
		String s = nearSouth(draw, x, y+1);
		if (s!=null) return s;
		reset();
		curr=0;
		String w = nearWest(draw, x-1, y);
		if (w!=null) return w;
		
		return null;
	}
	
	public String nearNorth(PApplet draw, int x, int y) {
		if(y<0) return null;
		if (curr == coords.length) return null;
		
		coords[curr][0] = x;
		coords[curr][1] = y;
		curr++;
		
		r = PApplet.round(draw.red(draw.color(draw.get(x, y))));
		g = PApplet.round(draw.green(draw.color(draw.get(x, y))));
		b = PApplet.round(draw.blue(draw.color(draw.get(x, y))));
		
		String m = findCountry(x, y);
		if(m != null) return m;
		
		String n = nearNorth(draw, x, y-1);
		return n;
	}
	
	public String nearSouth(PApplet draw, int x, int y) {
		if(y > draw.height) return null;
		if (curr == coords.length) return null;
		
		coords[curr][0] = x;
		coords[curr][1] = y;
		curr++;
		
		r = PApplet.round(draw.red(draw.color(draw.get(x, y))));
		g = PApplet.round(draw.green(draw.color(draw.get(x, y))));
		b = PApplet.round(draw.blue(draw.color(draw.get(x, y))));
		
		String m = findCountry(x, y);
		if(m != null) return m;
		
		String s = nearSouth(draw, x, y+1);
		return s;
	}
	
	public String nearEast(PApplet draw, int x, int y) {
		if(x > draw.width) return null;
		if (curr == coords.length) return null;
		
		coords[curr][0] = x;
		coords[curr][1] = y;
		curr++;
		
		r = PApplet.round(draw.red(draw.color(draw.get(x, y))));
		g = PApplet.round(draw.green(draw.color(draw.get(x, y))));
		b = PApplet.round(draw.blue(draw.color(draw.get(x, y))));
		
		String m = findCountry(x, y);
		if(m != null) return m;
		
		String e = nearEast(draw, x+1, y);
		return e;
	}
	
	public String nearWest(PApplet draw, int x, int y) {
		if(x<0) return null;
		if (curr == coords.length) return null;
		
		coords[curr][0] = x;
		coords[curr][1] = y;
		curr++;
		
		r = PApplet.round(draw.red(draw.color(draw.get(x, y))));
		g = PApplet.round(draw.green(draw.color(draw.get(x, y))));
		b = PApplet.round(draw.blue(draw.color(draw.get(x, y))));
		
		String m = findCountry(x, y);
		if(m != null) return m;
		
		String w = nearWest(draw, x-1, y);
		return w;
	}
	
	@SuppressWarnings("null")
	public void reset() {
		for (int i = 0; i < coords.length; i++) {
			for (int j = 0; j < coords[i].length; j++) {
				coords[i][j] = -1;
			}
		}
	}
	
	public boolean foundSameIndex(int x, int y) {
		
		for(int i = 0; i < coords.length; i++) {
			if (coords[i][0] == x && coords[i][1] == y) return true;
		}
		
		return false;
	}
	
	public String getRGB() {
		return r+", " +g+", "+b;
	}
}
