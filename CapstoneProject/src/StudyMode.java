import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import processing.core.PApplet;
import processing.core.PConstants;

/**
 * A study mode where users directly interact with information from the map
 * @author diya
 *
 */
public class StudyMode extends Screen {

	String current;
	private DrawingSurface draw;
	boolean pressed, facts;
	Map map;
	
	/**
	 * sets default settings
	 */
	public StudyMode(DrawingSurface draw)
	{
		super(1000, 751);
		this.draw = draw;
		map = new Map(200, 80, 600, 591);
		pressed = false;
		facts = false;
	}
	
	/**
	 * draws map, and displays information
	 * @param draw
	 */
	public void draw()
	{
		draw.background(255);
		
		draw.rectMode(PConstants.CENTER);
		
		draw.fill(169, 169, 169);
		draw.rect(50, 50, 50, 50); //Back button
		
		draw.image(draw.loadImage("fileData/map.png"), draw.width/2 - 300, draw.height/2 - (591f/2));
		
		if (draw.mousePressed && draw.mouseX <= 75 && draw.mouseX >= 25 && draw.mouseY >= 25 && draw.mouseY <= 75) 
		{
			draw.switchScreen(ScreenSwitcher.MENU_SCREEN);
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
}
