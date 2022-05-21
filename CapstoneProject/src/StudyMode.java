import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import processing.core.PApplet;
import processing.core.PConstants;

/**
 * A study mode where users directly interact with information from the map
 * @author Diya Bengani
 *
 */
public class StudyMode extends Screen {

	private String current;
	private DrawingSurface draw;
	private boolean pressed, facts;
	private Map map;
	private float x, y;
	
	/**
	 * Sets default settings, initializes fields
	 * @param draw is a Drawing Surface
	 */
	public StudyMode(DrawingSurface draw)
	{
		super(1200, 750);
		this.draw = draw;
		map = new Map(DRAWING_WIDTH/2 - 300, 80, 600, 591);
		pressed = false;
		facts = false;
		x = -1;
		y = -1;
	}
	
	/**
	 * Draws the map and displays information about each country
	 * @post when countries are clicked, a window pops up with facts that can be continued to be seen by the user or exited
	 * @post rectangles are draw from the center
	 */
	public void draw()
	{
		draw.background(255);
		
		draw.rectMode(PConstants.CENTER);
		
		if (draw.mousePressed && x < 0 && y < 0) {
			x = draw.mouseX;
			y = draw.mouseY;
		}
		
		else if (!draw.mousePressed) {
			x = -1;
			y = -1;
		}
		
		draw.image(draw.loadImage("fileData/map2.png"), draw.width/2 - 300, 80);
		
		if (draw.mousePressed && x <= draw.width * 0.05f + draw.height * 0.05f && x >= draw.width * 0.05f - draw.height * 0.05f && y <= draw.height * 0.13f && y >= draw.height * 0.03f) 
		{
			draw.fill(30, 120, 0);
			draw.ellipse(draw.width * 0.05f, draw.height * 0.08f, draw.height * 0.1f * (2f/3f), draw.height * 0.1f * (2f/3f)); //Back button
			draw.image(draw.loadImage("fileData/smallHouse.png"), draw.width * 0.035f, draw.height * 0.0575f);
		}
		else {
			draw.fill(50, 140, 5);
			draw.ellipse(draw.width * 0.05f, draw.height * 0.08f, draw.height * 0.1f, draw.height * 0.1f); //Back button
			draw.image(draw.loadImage("fileData/house.png"), draw.width * 0.03f, draw.height * 0.05f);
		}
		if (draw.mousePressed && !pressed) {
			pressed = true;
			current = map.getCountry(draw, draw.mouseX, draw.mouseY);
			
			if (current != null)
			{
				int answer = JOptionPane.showConfirmDialog(null, current + "\nCapital: " + map.getCapital(current) + "\nFun Fact: " + map.getRInfo(current) + "\nMore fun facts?", current, JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) facts = true;
				if (answer == JOptionPane.NO_OPTION || answer == JOptionPane.CLOSED_OPTION) facts = false;
			}
		}
		else if (!draw.mousePressed) pressed = false;
		
		if (current != null)
		{
			if (facts) {
				int answer = JOptionPane.showConfirmDialog(null, current + "\nCapital: " + map.getCapital(current) + "\nFun Fact: " + map.getRInfo(current) + "\nMore fun facts?", current, JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) facts = true;
				if (answer == JOptionPane.NO_OPTION || answer == JOptionPane.CLOSED_OPTION) facts = false;
			}
		}
		
	}
	
	/**
	 * Purpose it to interpret and carry out actions when mouse is released
	 * @post if certain, indicated button is pressed and released by user, screen switches back to menu
	 */
	public void mouseReleased() {
		if (draw.mouseX <= draw.width * 0.05f + draw.height * 0.05f 
				&& draw.mouseX >= draw.width * 0.05f - draw.height * 0.05f 
				&& draw.mouseY <= draw.height * 0.13f && draw.mouseY >= draw.height * 0.03f
				&& x <= draw.width * 0.05f + draw.height * 0.05f 
				&& x >= draw.width * 0.05f - draw.height * 0.05f 
				&& y <= draw.height * 0.13f && y >= draw.height * 0.03f)
			draw.switchScreen(ScreenSwitcher.MENU_SCREEN);
	}
	
	
}
