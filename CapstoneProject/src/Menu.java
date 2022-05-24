import java.awt.*;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;

/**
 * 
 * Serves to act as a menu where the user can navigate to different <code>Screen</code> within the game
 * <code>Screens</code> include <code>Instructions</code>, <code>QuizMode</code>, <code>StudyMode</code>, and <code>DrawingMode</code>
 * @author Aarushi Gupta, Onuva Ekram
 * 
 */

public class Menu extends Screen {

	private PImage bg;
	private DrawingSurface draw;
	private float bW, bH, normT, factor, x, y;
	private PFont myFont;
	
	/**
	 * Sets to default settings; initializes fields
	 * @param draw given PApplet
	 */
	public Menu(DrawingSurface draw)
	{
		super(1200, 750);
		this.draw = draw;
		
		factor = 0.9f;
		bW = DRAWING_WIDTH * 0.23f;
		bH = DRAWING_HEIGHT * 0.09f;
		normT = 35;
		
		x = -1;
		y = -1;
		
	}
	
	/**
	 * Completes PApplet setup
	 */
	public void setup() {
		bg = draw.loadImage("fileData/MenuMap.jpg");
	}
	
	/**
	 * Draws the <code>Menu</code> and its corresponding animation controls
	 * @post modifies current PApplet (the <code>DrawingSurface</code>) by adding buttons, colors, etc.
	 */
	public void draw() 
	{
		draw.background(bg);
		
		draw.textAlign(PConstants.CENTER);
		draw.rectMode(PConstants.CENTER);
		
		myFont = draw.createFont("Times New Roman", 65);
		draw.textFont(myFont);
		
		if (draw.mousePressed && x < 0 && y < 0) {
			x = draw.mouseX;
			y = draw.mouseY;
		}
		
		else if (!draw.mousePressed) {
			x = -1;
			y = -1;
			draw.cursor(PConstants.ARROW);
		}
		if ((draw.mouseX <= draw.width/2 + bW/2 && draw.mouseX >= draw.width/2 - bW/2
				&& draw.mouseY <= draw.height*0.43f + bH/2 && draw.mouseY >= draw.height*0.43f - bH/2)
				|| (draw.mouseX <= draw.width/2 + bW/2 && draw.mouseX >= draw.width/2 - bW/2
				&& draw.mouseY <= draw.height*0.6f + bH/2 && draw.mouseY >= draw.height*0.6f - bH/2)
				|| (draw.mouseX <= draw.width/2 + bW/2 && draw.mouseX >= draw.width/2 - bW/2
				&& draw.mouseY <= draw.height*0.77f + bH/2 && draw.mouseY >= draw.height*0.77f - bH/2)
				|| (draw.mouseX <= draw.width * 0.93f + draw.height * 0.05f && draw.mouseX >= draw.width * 0.93f - draw.height * 0.05f 
				&& draw.mouseY <= draw.height * 0.13f && draw.mouseY >= draw.height * 0.03f)
				|| (draw.mouseX <= draw.width * 0.93f + draw.height * 0.05f - draw.height * 0.1f * factor - 30
				&& draw.mouseX >= draw.width * 0.93f - draw.height * 0.05f  - draw.height * 0.1f * factor - 30
				&& draw.mouseY <= draw.height * 0.13f && draw.mouseY >= draw.height * 0.03f)) 
			draw.cursor(PConstants.HAND);
		
		
		if (draw.mousePressed && x <= draw.width/2 + bW/2 && x >= draw.width/2 - bW/2
				&& y <= draw.height*0.43f + bH/2 && y >= draw.height*0.43f - bH/2) {
			draw.fill(204, 204, 255);
			draw.rect(draw.width/2, draw.height * 0.43f, bW * factor, bH * factor, 5);
			draw.fill(0);
			draw.textSize(normT * factor);
			draw.text("Study Mode", draw.width/2, draw.height * 0.43f + normT/3 * factor);
		}
		else {
			draw.fill(178, 172, 136);
			draw.rect(draw.width/2, draw.height * 0.43f, bW, bH, 5);
			draw.fill(0);
			draw.textSize(normT);
			draw.text("Study Mode", draw.width/2, draw.height * 0.43f + normT/3);
		}
		
		if (draw.mousePressed && x <= draw.width/2 + bW/2 && x >= draw.width/2 - bW/2
				&& y <= draw.height*0.6f + bH/2 && y >= draw.height*0.6f - bH/2) {
			draw.fill(204, 204, 255);
			draw.rect(draw.width/2, draw.height * 0.6f, bW * factor, bH * factor, 5);
			draw.fill(0);
			draw.textSize(normT * factor);
			draw.text("Quiz Mode", draw.width/2, draw.height * 0.6f + normT/3 * factor);
		}
		else {
			draw.fill(178, 172, 136);
			draw.rect(draw.width/2, draw.height * 0.6f, bW, bH, 5);
			draw.fill(0);
			draw.textSize(normT);
			draw.text("Quiz Mode", draw.width/2, draw.height * 0.6f + normT/3);
		}
		
		if (draw.mousePressed && x <= draw.width/2 + bW/2 && x >= draw.width/2 - bW/2
				&& y <= draw.height*0.77f + bH/2 && y >= draw.height*0.77f - bH/2) {
			draw.fill(204, 204, 255);
			draw.rect(draw.width/2, draw.height * 0.77f, bW * factor, bH * factor, 5);
			draw.fill(0);
			draw.textSize(normT * factor);
			draw.text("Draw Mode", draw.width/2, draw.height * 0.77f + normT/3 * factor);
		}
		else {
			draw.fill(178, 172, 136);
			draw.rect(draw.width/2, draw.height * 0.77f, bW, bH, 5);
			draw.fill(0);
			draw.textSize(normT);
			draw.text("Draw Mode", draw.width/2, draw.height * 0.77f + normT/3);
		}
		
		if (draw.mousePressed && x <= draw.width * 0.93f + draw.height * 0.05f && x >= draw.width * 0.93f - draw.height * 0.05f 
				&& y <= draw.height * 0.13f && y >= draw.height * 0.03f) {
			draw.fill(120, 130, 140);
			draw.ellipse(draw.width * 0.93f, draw.height * 0.08f, draw.height * 0.1f * (2f/3f), draw.height * 0.1f * (2f/3f));
			draw.fill(255);
			draw.textSize(normT*1.4f * factor);
			draw.text("?", draw.width * 0.93f, draw.height * 0.08f + normT/3 * 1.4f * factor);
		}
		else {
			draw.fill(145, 155, 165);
			draw.ellipse(draw.width * 0.93f, draw.height * 0.08f, draw.height * 0.1f * factor, draw.height * 0.1f * factor);
			draw.fill(255);
			draw.textSize(normT*1.4f);
			draw.text("?", draw.width * 0.93f, draw.height * 0.08f + normT/3 * 1.4f);
		}
		
		if (draw.mousePressed && x <= draw.width * 0.93f + draw.height * 0.05f - draw.height * 0.1f * factor - 30 && x >= draw.width * 0.93f - draw.height * 0.05f - draw.height * 0.1f * factor - 30 
				&& y <= draw.height * 0.13f && y >= draw.height * 0.03f) {
			draw.fill(120, 130, 140);
			draw.ellipse(draw.width * 0.93f - draw.height * 0.1f * factor - 30, draw.height * 0.08f, draw.height * 0.1f * (2f/3f), draw.height * 0.1f * (2f/3f));
			draw.fill(0);
			draw.textSize(normT*1.4f * factor);
			draw.image(draw.loadImage("fileData/smallSet.png"), draw.width * 0.93f - draw.height * 0.1f * factor - 30 - 16, draw.height * 0.08f - 17);
		}
		else {
			draw.fill(145, 155, 165);
			draw.ellipse(draw.width * 0.93f - draw.height * 0.1f * factor - 30, draw.height * 0.08f, draw.height * 0.1f * factor, draw.height * 0.1f * factor);
			draw.fill(0);
			draw.textSize(normT*1.4f);
			draw.image(draw.loadImage("fileData/set.png"), draw.width * 0.93f - draw.height * 0.1f * factor - 30 - 23, draw.height * 0.08f - 24);
		}
		
		
		draw.fill(0);
		draw.textSize(80);
		draw.text("MAIN MENU", draw.width/2, draw.height/2 - 240);
		
	}
	
	/**
	 * Detects when mouse is released
	 * @post if mouse hits one of the indicated buttons, screen switches to corresponding <code>Screen</code>
	 */
	public void mouseReleased() {
		if (draw.mouseX <= draw.width/2 + bW/2 && draw.mouseX >= draw.width/2 - bW/2
				&& draw.mouseY <= draw.height*0.43f + bH/2 && draw.mouseY >= draw.height*0.43f - bH/2
				&& x <= draw.width/2 + bW/2 && x >= draw.width/2 - bW/2
				&& y <= draw.height*0.43f + bH/2 && y >= draw.height*0.43f - bH/2) {
			draw();
			draw.switchScreen(ScreenSwitcher.STUDY_SCREEN);
		}
		else if (draw.mouseX <= draw.width/2 + bW/2 && draw.mouseX >= draw.width/2 - bW/2
				&& draw.mouseY <= draw.height*0.6f + bH/2 && draw.mouseY >= draw.height*0.6f - bH/2
				&& x <= draw.width/2 + bW/2 && x >= draw.width/2 - bW/2
				&& y <= draw.height*0.6f + bH/2 && y >= draw.height*0.6f - bH/2) {
			draw();
			draw.switchScreen(ScreenSwitcher.QUIZ_SCREEN);
		}
		else if (draw.mouseX <= draw.width/2 + bW/2 && draw.mouseX >= draw.width/2 - bW/2
				&& draw.mouseY <= draw.height*0.77f + bH/2 && draw.mouseY >= draw.height*0.77f - bH/2
				&& x <= draw.width/2 + bW/2 && x >= draw.width/2 - bW/2
				&& y <= draw.height*0.77f + bH/2 && y >= draw.height*0.77f - bH/2) {
			draw();
			draw.switchScreen(ScreenSwitcher.DRAW_SCREEN);
		}
		else if (draw.mouseX <= draw.width * 0.93f + draw.height * 0.05f && draw.mouseX >= draw.width * 0.93f - draw.height * 0.05f 
				&& draw.mouseY <= draw.height * 0.13f && draw.mouseY >= draw.height * 0.03f
				&& x <= draw.width * 0.93f + draw.height * 0.05f && x >= draw.width * 0.93f - draw.height * 0.05f 
				&& y <= draw.height * 0.13f && y >= draw.height * 0.03f) {
			draw();
			draw.switchScreen(ScreenSwitcher.INSTRUCTIONS_SCREEN);
		}
		else if(draw.mouseX <= draw.width * 0.93f + draw.height * 0.05f - draw.height * 0.1f * factor - 30
				&& draw.mouseX >= draw.width * 0.93f - draw.height * 0.05f  - draw.height * 0.1f * factor - 30
				&& draw.mouseY <= draw.height * 0.13f && draw.mouseY >= draw.height * 0.03f
				&& x <= draw.width * 0.93f + draw.height * 0.05f - draw.height * 0.1f * factor - 30 
				&& x >= draw.width * 0.93f - draw.height * 0.05f  - draw.height * 0.1f * factor - 30
				&& y <= draw.height * 0.13f && y >= draw.height * 0.03f){
			draw();
			draw.switchScreen(ScreenSwitcher.SETTINGS_SCREEN);
		}
	}
}