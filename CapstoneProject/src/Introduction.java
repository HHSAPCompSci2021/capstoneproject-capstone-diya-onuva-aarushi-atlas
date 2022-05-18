import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

/**
 * The introduction screen for the program, which contains the Play button
 * @author Diya Bengani, Onuva Ekram
 *
 */
public class Introduction extends Screen {

	private float normText, pressText, bWidth, bHeight, n;
	private boolean pressed;
	private PImage bg;
	private DrawingSurface draw;
	
	/**
	 * Sets default settings
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
	}
	
	/**
	 * Completes PApplet setup
	 */
	public void setup() {
		//bg = draw.loadImage("fileData/Intro.jpg");
	}
	
	/**
	 * Draws the <code>Introduction</code> <code>Screen</code>
	 * @post Changes PApplet's textAlign and rectMode to PConstants.CENTER
	 */
	public void draw() 
	{
		//draw.background(bg);
		draw.background(bHeight);
		draw.textAlign(PConstants.CENTER);
		draw.rectMode(PConstants.CENTER);
		
		if (draw.mousePressed && draw.mouseX <= draw.width/2 + bWidth/2 
				&& draw.mouseX >= draw.width/2 - bWidth/2
				&& draw.mouseY >= draw.height*0.4f - bHeight/2
				&& draw.mouseY <= draw.height*0.4f + bHeight/2)
			pressed = true;
		
		if (pressed && n >= 1) {
			draw.fill(150);
			draw.rect(draw.width/2, draw.height * 0.4f, bWidth * 0.95f, bHeight * 0.95f, 10);
		}
		else {
			draw.fill(255);
			draw.rect(draw.width/2, draw.height * 0.4f, bWidth * n, bHeight * n, 10);
		}
		
		draw.fill(0);
		if (pressed && n >= 1) {
			draw.textSize(pressText);
			draw.text("Play!", draw.width/2, draw.height * 0.4f + pressText/3);
		}
		else {
			draw.textSize(normText * n);
			draw.text("Play!", draw.width/2, draw.height * 0.4f + normText/3 * n);
		}
		
		pressed = false;
		if (n < 1) n+=0.0075;
		
	}
	
	/**
	 * Detects when mouse is clicked
	 */
	public void mouseClicked() {
		if (draw.mouseX <= draw.width/2 + bWidth/2 
				&& draw.mouseX >= draw.width/2 - bWidth/2
				&& draw.mouseY >= draw.height*0.4f - bHeight/2
				&& draw.mouseY <= draw.height*0.4f + bHeight/2
				&& n >= 1)
			draw.switchScreen(ScreenSwitcher.MENU_SCREEN);
	}
	
}
