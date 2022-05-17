import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import processing.core.PApplet;

/**
 * A study mode where users directly interact with information from the map
 * @author diya
 *
 */
public class StudyMode {

	String current;
	private DrawingSurface surface;
	boolean pressed, facts;
	Map map;
	
	/**
	 * sets default settings
	 */
	public StudyMode()
	{
		map = new Map(200, 80, 600, 591);
		pressed = false;
		facts = false;
	}
	
	/**
	 * draws map, and displays information
	 * @param draw
	 */
	public void draw(PApplet draw)
	{
		draw.background(255);
		
		draw.image(draw.loadImage("fileData/map.png"), draw.width/2 - 300, draw.height/2 - (591f/2));
		
		if (draw.mousePressed && !pressed) {
			pressed = true;
			current = map.getCountry(draw, draw.mouseX, draw.mouseY);
			int answer = JOptionPane.showConfirmDialog(null, current + "\nCapital: " + map.getCapital(current) + "\nFun Fact: " + map.getRInfo(current) + "\nMore fun facts?", current, JOptionPane.YES_NO_OPTION);
			if (answer == JOptionPane.YES_OPTION) facts = true;
			if (answer == JOptionPane.NO_OPTION || answer == JOptionPane.CLOSED_OPTION) facts = false;
		}
		else if (!draw.mousePressed) pressed = false;
		if (facts) {
			int answer = JOptionPane.showConfirmDialog(null, current + "\nCapital: " + map.getCapital(current) + "\nFun Fact: " + map.getRInfo(current) + "\nMore fun facts?", current, JOptionPane.YES_NO_OPTION);
			if (answer == JOptionPane.YES_OPTION) facts = true;
			if (answer == JOptionPane.NO_OPTION || answer == JOptionPane.CLOSED_OPTION) facts = false;
		}
		
	}
}
