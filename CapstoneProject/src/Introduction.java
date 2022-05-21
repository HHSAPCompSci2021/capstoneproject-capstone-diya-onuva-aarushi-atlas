import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;

/**
 * Serves to display the title/introduction display
 * @author Diya Bengani, Onuva Ekram
 *
 */
public class Introduction extends Screen {

	private PImage bg;
	private double x, y;
	private PFont myFont;
	private boolean pressed;
	private DrawingSurface draw;
	private float normText, pressText, bWidth, bHeight, n;
	
	/**
	 * Sets default settings, initializes the fields
	 * @param draw of type DrawingSurface
	 */
	public Introduction(DrawingSurface draw)
	{
		super(1200, 750);
		this.draw = draw;
		
		normText = 75;
		pressText = 65;
		bWidth = 225;
		bHeight = 100;
		n = 0.007f;
		pressed = false;
		x = -1;
		y = -1;
		
		
	}
	
	/**
	 * Completes PApplet setup
	 */
	public void setup() 
	{
		bg = draw.loadImage("fileData/Intro.png");
	}
	
	/**
	 * Draws the Introduction Screen
	 * @post Changes PApplet's textAlign and rectMode to PConstants.CENTER
	 * @post modifies draw, the drawing surface 
	 */
	public void draw() 
	{
		draw.background(bg);
		draw.textAlign(PConstants.CENTER);
		myFont = draw.createFont("Times New Roman", 65);
		draw.textFont(myFont);
		draw.rectMode(PConstants.CENTER);
		
		if (draw.mousePressed && x < 0 && y < 0) {
			x = draw.mouseX;
			y = draw.mouseY;
		}
		else if (!draw.mousePressed) {
			x = -1;
			y = -1;
			draw.cursor(PConstants.ARROW);
		}
		if (draw.mouseX <= draw.width/2 + bWidth/2 
				&& draw.mouseX >= draw.width/2 - bWidth/2
				&& draw.mouseY >= draw.height*0.4f - bHeight/2
				&& draw.mouseY <= draw.height*0.4f + bHeight/2
				&& n >= 1)
			draw.cursor(PConstants.HAND);
		
		if (draw.mousePressed && x <= draw.width/2 + bWidth/2 
				&& x >= draw.width/2 - bWidth/2
				&& y >= draw.height*0.4f - bHeight/2
				&& y <= draw.height*0.4f + bHeight/2)
			pressed = true;
		
		if (pressed && n >= 1) {
			draw.fill(204, 204, 255);
			draw.rect(draw.width/2, draw.height * 0.4f, bWidth * 0.95f, bHeight * 0.95f, 10);
		}
		else {
			draw.fill(178, 172, 136);
			draw.rect(draw.width/2, draw.height * 0.4f, bWidth * n, bHeight * n, 10);
		}
		
		draw.fill(255);
		if (pressed && n >= 1) {
			draw.textSize(pressText);
			draw.text("Play!", draw.width/2, draw.height * 0.4f + pressText/3);
		}
		else {
			draw.textSize(normText * n);
			draw.text("Play!", draw.width/2, draw.height * 0.4f + normText/3 * n);
		}
		
		pressed = false;
		if (n < 1) n+=0.02;
		
	}
	
	/**
	 * Detects when mouse is clicked
	 * @post when certain button is clicked, screen switches to the menu screen
	 */
	public void mouseReleased() {
		if (draw.mouseX <= draw.width/2 + bWidth/2 
				&& draw.mouseX >= draw.width/2 - bWidth/2
				&& draw.mouseY >= draw.height*0.4f - bHeight/2
				&& draw.mouseY <= draw.height*0.4f + bHeight/2
				&& x <= draw.width/2 + bWidth/2 
				&& x >= draw.width/2 - bWidth/2
				&& y >= draw.height*0.4f - bHeight/2
				&& y <= draw.height*0.4f + bHeight/2
				&& n >= 1) {
			draw();
			draw.switchScreen(ScreenSwitcher.MENU_SCREEN);
		}
	}
	
}
