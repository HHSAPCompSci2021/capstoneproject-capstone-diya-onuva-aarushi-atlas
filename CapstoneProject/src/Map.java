import java.awt.Image;
import java.util.ArrayList;

import processing.core.PApplet;

public class Map {

	public Map()
	{
		
	}
	
	public String getCountry(int r, int g, int b)
	{
		
		if (r == 50 && g == 65 && b == 203) return "Morocco";
		else if (r == 112 && g == 143 && b == 215) return "Algeria";
//		int r = PApplet.round(draw.red(draw.color(draw.get(draw.mouseX, draw.mouseY))));
//		int g = PApplet.round(draw.green(draw.color(draw.get(draw.mouseX, draw.mouseY))));
//		int b = PApplet.round(draw.blue(draw.color(draw.get(draw.mouseX, draw.mouseY))));
//		
//		Map m = new Map();
//		System.out.println(m.getCountry(r,  g,  b));
//		
		return null;
		
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
	
	public void draw(PApplet draw)
	{
		
	}
}
