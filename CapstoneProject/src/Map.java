import java.awt.Image;
import java.util.ArrayList;

import processing.core.PApplet;

/** A <code>Map</code> returns information to identify the country and return
 * additional information on the specific country.
 * 
 * @author Onuva Ekram
*/

public class Map {

	private int r, g, b, curr;
	private double xStart, width, yStart, height;
	private int[][] coords;
	
	
	/**
	 * Creates a new <code>Map</code> with a sensitivity of 5 pixels and default map settings
	 */
	public Map() {
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
	
	/**
	 * Creates a new <code>Map</code> with a sensitivity of 5 pixels and sets map settings with
	 * given information
	 * @param x top-left x-coordinate of map
	 * @param y top-left y-coordinate of map
	 * @param w width of map (pixels)
	 * @param h height of map (pixels)
	 */
	public Map(double x, double y, double w, double h) {
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
	
	/**
	 * Creates a new <code>Map</code> with a sensitivity of 5 pixels and sets map settings with
	 * given information
	 * @param x top-left x-coordinate of map
	 * @param y top-left y-coordinate of map
	 * @param w width of map (pixels)
	 * @param h height of map (pixels)
	 * @param sense sensitivity of mouse (pixels)
	 */
	public Map(double x, double y, double w, double h, int sense) {
		coords = new int[sense][2];
		curr = 0;
		r = 0;
		g = 0;
		b = 0;
		
		xStart = x;
		yStart = y;
		width = w;
		height = h;
	}
	
	/**
	 * Returns the name of the country located at (x,y) in PApplet draw; returns null otherwise
	 * @param draw given PApplet
	 * @param x given x-coordinate
	 * @param y given y-coordinate
	 * @return existing country at (x,y); null otherwise
	 */
	public String getCountry(PApplet draw, int x, int y) {
		
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
	
	private String findCountry(int x, int y) {
		
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
	
	/**
	 * Returns the capital of the given country; if given country is not in Africa
	 * or in the list of countries recorded in this <code>Map</code>, returns null
	 * @param s given country
	 * @return capital of given country, if country does not exist in <code>Map</code>,
	 * returns null
	 */
	public String getCapital(String s) {
		
		if (s.equalsIgnoreCase("The Gambia") || s.equalsIgnoreCase("Gambia")) return "Banjul";
		else if (s.equalsIgnoreCase("Liberia")) return "Monrovia";
		else if (s.equalsIgnoreCase("Benin")) return "Porto-Novo";
		else if (s.equalsIgnoreCase("Egypt")) return "Cairo";
		else if (s.equalsIgnoreCase("Zimbabwe")) return "Harare";
		else if (s.equalsIgnoreCase("Ghana")) return "Accra";
		else if (s.equalsIgnoreCase("Gabon")) return "Libreville";
		else if (s.equalsIgnoreCase("South Africa")) return "Cape Town, Pretoria, Bloemfontien";
		else if (s.equalsIgnoreCase("Eritrea")) return "Asmara";
		else if (s.equalsIgnoreCase("Sengal")) return "Dakar";
		else if (s.equalsIgnoreCase("Burkina Faso")) return "Ouagadougou";
		else if (s.equalsIgnoreCase("Somalia")) return "Mogadishu";
		else if (s.equalsIgnoreCase("Mozambique")) return "Maputo";
		else if (s.equalsIgnoreCase("The Comoros") || s.equalsIgnoreCase("Comoros")) return "Moroni";
		else if (s.equalsIgnoreCase("Madagascar")) return "Antananarivo";
		else if (s.equalsIgnoreCase("Angola")) return "Luanda";
		else if (s.equalsIgnoreCase("Uganda")) return "Kampala";
		else if(s.equalsIgnoreCase("Morocco")) return "Rabat";
		else if(s.equalsIgnoreCase("Western Sahara")) return "Laayoune";
		else if(s.equalsIgnoreCase("Algeria")) return "Algiers";
		else if(s.equalsIgnoreCase("Libya")) return "Tripoli";
		else if(s.equalsIgnoreCase("Sudan")) return "Khaartoum";
		else if(s.equalsIgnoreCase("Tunisia")) return "Tunis";
		else if(s.equalsIgnoreCase("Ethiopia")) return "Addis Ababa";
		else if(s.equalsIgnoreCase("Kenya")) return "Nairobi";
		else if(s.equalsIgnoreCase("Tanzania")) return "Dodoma";
		else if(s.equalsIgnoreCase("Malawi")) return "Lilongwe";
		else if(s.equalsIgnoreCase("Zambia")) return "Lusaka";
		else if(s.equalsIgnoreCase("Eswatini")) return "Mbabane and Lobamba";
		else if(s.equalsIgnoreCase("Djibouti")) return "Djibouti";
		else if(s.equalsIgnoreCase("Lesotho")) return "Maseru";
		else if(s.equalsIgnoreCase("Botswana")) return "Gaborone";
		else if(s.equalsIgnoreCase("Namibia")) return "Windhoek";
		else if(s.equalsIgnoreCase("Central African Republic") || s.equalsIgnoreCase("African Republic")) return "Bangui";
		else if(s.equalsIgnoreCase("Republic of the Congo") || s.equalsIgnoreCase("Congo Republic")) return "Brazzaville";
		else if(s.equalsIgnoreCase("Equatorial Guinea")) return "Malabo";
		else if(s.equalsIgnoreCase("Democratic Republic of the Congo")) return "Kinshasa";
		else if(s.equalsIgnoreCase("Cameroon")) return "Yaoundé";
		else if(s.equalsIgnoreCase("Rwanda")) return "Kigali";
		else if(s.equalsIgnoreCase("Burundi")) return "Gitega";
		else if(s.equalsIgnoreCase("Chad")) return "N'Djamena";
		else if(s.equalsIgnoreCase("Niger")) return "Niamey";
		else if(s.equalsIgnoreCase("Mali")) return "Bamako";
		else if(s.equalsIgnoreCase("Mauritania")) return "Nouakchott";
		else if(s.equalsIgnoreCase("Guinea")) return "Conakry";
		else if(s.equalsIgnoreCase("Nigeria")) return "Abuja";
		else if(s.equalsIgnoreCase("Togo")) return "Lomé";
		else if(s.equalsIgnoreCase("South Sudan")) return "Juba";
		else if(s.equalsIgnoreCase("Guinea-Bissau")) return "Bissau";
		else if(s.equalsIgnoreCase("Sierra Leone")) return "Freetown";
		else if(s.equalsIgnoreCase("Côte D'Ivore")) return "Yamoussoukro";
		else return null;
		
	}
	
	/**
	 * Returns pictures of the given country in an <code>ArrayList</code>; if given country 
	 * is not in Africa or in the list of countries recorded in this <code>Map</code>, returns
	 * an empty <code>ArrayList</code>
	 * @param s given country
	 * @return an <code>ArrayList</code> of pictures of given country, if country does not exist in <code>Map</code>,
	 * returns an empty <code>ArrayList</code>
	 */
	public ArrayList<String> getPics(String s) {
		return null;
		
	}
	
	/**
	 * Returns random information on the given country; if given country is not in Africa
	 * or in the list of countries recorded in this <code>Map</code>, returns null
	 * @param s given country
	 * @return random information of given country, if country does not exist in <code>Map</code>,
	 * returns null
	 */
	public String getRInfo(String s) {
		return s;
		
	}
	
	/**
	 * Returns a <code>String</code> of the current RGB values in this <code>Map</code>
	 * @return a <code>String</code> of the current RGB values in this <code>Map</code>
	 */
	public String getRGB() {
		return r + ", " + g + ", " + b;
	}
	
	private String nearC(PApplet draw, int x, int y) {
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
	
	private String nearNorth(PApplet draw, int x, int y) {
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
	
	private String nearSouth(PApplet draw, int x, int y) {
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
	
	private String nearEast(PApplet draw, int x, int y) {
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
	
	private String nearWest(PApplet draw, int x, int y) {
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
	
	private void reset() {
		for (int i = 0; i < coords.length; i++) {
			for (int j = 0; j < coords[i].length; j++) {
				coords[i][j] = -1;
			}
		}
	}
	
	private boolean foundSameIndex(int x, int y) {
		
		for(int i = 0; i < coords.length; i++) {
			if (coords[i][0] == x && coords[i][1] == y) return true;
		}
		
		return false;
	}
	
}
