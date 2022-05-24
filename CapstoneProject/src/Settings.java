import java.awt.*;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;

/**
 * 
 * Serves to act as a menu where the user can navigate to different Screens within the game
 * Screens include Instructions, Quiz Mode, Study Mode, and Drawing Mode
 * @author Aarushi Gupta
 * Has a PImage (for background), a drawing surface, animation controls, and custom font
 * 
 */

public class Settings extends Screen {

	private DrawingSurface draw;
	private boolean hoverScroll;
	private float x, y;
	private PImage bg;
	
	/**
	 * Sets to default settings; initializes fields
	 * @param draw given PApplet
	 */
	public Settings(DrawingSurface draw)
	{
		super(1200, 750);
		this.draw = draw;
		x = -1;
		y = -1;
		hoverScroll =false;
		
	}
	
	/**
	 * Completes PApplet setup
	 */
	public void setup() {
		bg = draw.loadImage("fileData/music.jpg");
	}
	
	/**
	 * Draws the Menu screen and its corresponding animation controls
	 * @post modifies draw (the drawing surface) by adding buttons, colors, etc.
	 */
	public void draw() 
	{
		draw.background(bg);
		
		if (draw.mousePressed && x < 0 && y < 0) {
			x = draw.mouseX;
			y = draw.mouseY;
		}
		
		else if (!draw.mousePressed) {
			x = -1;
			y = -1;
			draw.cursor(PConstants.ARROW);
		}
		
		if (draw.mouseX >= draw.width * 0.4 && draw.mouseX <= draw.width * 0.8
				&& draw.mouseY >= draw.height*0.48 && draw.mouseY <= draw.height*0.52) hoverScroll = true;
		else hoverScroll = false;
		
		if ((draw.mouseX <= draw.width * 0.05f + draw.height * 0.05f 
				&& draw.mouseX >= draw.width * 0.05f - draw.height * 0.05f 
				&& draw.mouseY <= draw.height * 0.13f && draw.mouseY >= draw.height * 0.03f)
				|| hoverScroll)
			draw.cursor(PConstants.HAND);
		
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
		draw.fill(195, 35, 0);
		draw.textSize(80);
		draw.text("SETTINGS", draw.width/2, draw.height/2 - 240);
		draw.fill(130, 130, 245);
		draw.textSize(45);
		draw.text("Music Volume: ", draw.width * 0.28f, draw.height/2f + 15f);
		updateProgress();
		
	}
	
	/**
	 * It updates the progress bar depending on where the user moves it or how the user interacts with it. 
	 * @post the strokCap is set to ROUND, meaning all strokes drawn on this screenw ill be round. 
	 */
	public void updateProgress() {
		if(!hoverScroll)draw.stroke(255);
		else draw.stroke(170);
		draw.strokeCap(PConstants.ROUND);
		draw.strokeWeight(7);
		draw.line(draw.width * 0.4f, draw.height/2f, draw.width*0.8f, draw.height/2f);
		draw.stroke(0,255,0);
		if(hoverScroll && draw.mousePressed) {
			draw.ellipse(draw.mouseX, draw.height/2f, 10, 10);
			draw.line(draw.width * 0.4f, draw.height/2f, draw.mouseX, draw.height/2f);
			draw.setVol((draw.mouseX - draw.width * 0.4f)/(draw.width * 0.4f));
		}
		else {
			draw.line(draw.width * 0.4f, draw.height/2f, draw.width*0.4f + draw.width * 0.4f * draw.getVolP(), draw.height/2f);
			if (hoverScroll) draw.ellipse(draw.width*0.4f + draw.width * 0.4f * draw.getVolP(), draw.height/2f, 10, 10);
		}
		draw.noStroke();
	}
	
	
	/**
	 * Detects when mouse is released
	 * @post if mouse hits one of the indicated buttons, screen switches to corresponding screen
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