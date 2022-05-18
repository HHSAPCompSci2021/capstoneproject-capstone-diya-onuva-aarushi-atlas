import java.awt.*;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;

/**
 * 
 * Has a StudyMode, QuizMode, highscore, Instructions, PFont, if pressed, int for mode
 * Serves to act as a menu where the user can navigate to different features within the game (study, quiz, and draw mode as well as the instructions)
 *
 * @author Aarushi Gupta
 * 
 */

public class Menu extends Screen {

	private Instructions inst;
	private QuizMode quiz;
	private DrawingMode drawing;
	private StudyMode study;
	private DrawingSurface draw;
	private PFont myFont;
	private int mode;
	private Rectangle studyBtn;
	private Rectangle quizBtn;
	private Rectangle drawingBtn;
	private Rectangle instructBtn;
	
	private boolean pressed;
	private float bW, bH, normT, factor;
	
	private PImage bg;
	
	public Menu(DrawingSurface draw)
	{
		super(1200, 750);
		this.draw = draw;
		
		inst = new Instructions(draw);
		quiz = new QuizMode(draw);
		study = new StudyMode(draw);
		drawing = new DrawingMode(draw);
		
		studyBtn = new Rectangle(1200/2, 750/2 - 150, 350, 50);
		quizBtn = new Rectangle (1200/2, 750/2, 350, 50);
		drawingBtn = new Rectangle (1200/2 , 750/2 + 150, 350, 50);
		instructBtn = new Rectangle (1200/2 , 750/2 + 300, 350, 50);
		
		pressed = false;
		factor = 0.9f;
		bW = DRAWING_WIDTH * 0.23f;
		bH = DRAWING_HEIGHT * 0.09f;
		normT = 35;
		
	}
	
	public void setup() {
		bg = draw.loadImage("fileData/MenuMap.jpg");
	}
	
	/**
	 * Draws the chosen Mode
	 * @param draw
	 */
	public void draw() 
	{
		draw.background(bg);
		
		draw.textAlign(PConstants.CENTER);
		draw.rectMode(PConstants.CENTER);
		myFont = draw.createFont("Times New Roman", 18);
		draw.textFont(myFont);
		draw.noStroke();
		
		if (draw.mousePressed && draw.mouseX <= draw.width/2 + bW/2 && draw.mouseX >= draw.width/2 - bW/2
				&& draw.mouseY <= draw.height*0.43f + bH/2 && draw.mouseY >= draw.height*0.43f - bH/2) {
			draw.fill(25, 210, 165);
			draw.rect(draw.width/2, draw.height * 0.43f, bW * factor, bH * factor, 5);
			draw.fill(0);
			draw.textSize(normT * factor);
			draw.text("Study Mode", draw.width/2, draw.height * 0.43f + normT/3 * factor);
		}
		else {
			draw.fill(50, 235, 190);
			draw.rect(draw.width/2, draw.height * 0.43f, bW, bH, 5);
			draw.fill(0);
			draw.textSize(normT);
			draw.text("Study Mode", draw.width/2, draw.height * 0.43f + normT/3);
		}
		
		if (draw.mousePressed && draw.mouseX <= draw.width/2 + bW/2 && draw.mouseX >= draw.width/2 - bW/2
				&& draw.mouseY <= draw.height*0.6f + bH/2 && draw.mouseY >= draw.height*0.6f - bH/2) {
			draw.fill(25, 210, 165);
			draw.rect(draw.width/2, draw.height * 0.6f, bW * factor, bH * factor, 5);
			draw.fill(0);
			draw.textSize(normT * factor);
			draw.text("Quiz Mode", draw.width/2, draw.height * 0.6f + normT/3 * factor);
		}
		else {
			draw.fill(50, 235, 190);
			draw.rect(draw.width/2, draw.height * 0.6f, bW, bH, 5);
			draw.fill(0);
			draw.textSize(normT);
			draw.text("Quiz Mode", draw.width/2, draw.height * 0.6f + normT/3);
		}
		
		if (draw.mousePressed && draw.mouseX <= draw.width/2 + bW/2 && draw.mouseX >= draw.width/2 - bW/2
				&& draw.mouseY <= draw.height*0.77f + bH/2 && draw.mouseY >= draw.height*0.77f - bH/2) {
			draw.fill(25, 210, 165);
			draw.rect(draw.width/2, draw.height * 0.77f, bW * factor, bH * factor, 5);
			draw.fill(0);
			draw.textSize(normT * factor);
			draw.text("Draw Mode", draw.width/2, draw.height * 0.77f + normT/3 * factor);
		}
		else {
			draw.fill(50, 235, 190);
			draw.rect(draw.width/2, draw.height * 0.77f, bW, bH, 5);
			draw.fill(0);
			draw.textSize(normT);
			draw.text("Draw Mode", draw.width/2, draw.height * 0.77f + normT/3);
		}
		
		if (draw.mousePressed && draw.mouseX <= draw.width * 0.08f + bH*0.85f/2 && draw.mouseX >= draw.width * 0.08f - bH*0.85f/2
				&& draw.mouseY <= draw.height * 0.09f + bH*0.85f/2 && draw.mouseY >= draw.height * 0.09f - bH*0.85f/2) {
			draw.fill(120, 130, 140);
			draw.ellipse(draw.width * 0.08f, draw.height * 0.09f, bH*0.85f * factor, bH*0.85f * factor);
			draw.fill(0);
			draw.textSize(normT*1.4f * factor);
			draw.text("?", draw.width * 0.08f, draw.height * 0.09f + normT/3 * 1.4f * factor);
		}
		else {
			draw.fill(145, 155, 165);
			draw.ellipse(draw.width * 0.08f, draw.height * 0.09f, bH*0.85f, bH*0.85f);
			draw.fill(0);
			draw.textSize(normT*1.4f);
			draw.text("?", draw.width * 0.08f, draw.height * 0.09f + normT/3 * 1.4f);
		}
		
		
		draw.fill(0);
		draw.textSize(80);
		draw.text("MAIN MENU", draw.width/2, draw.height/2 - 240);
		
	}
	
	
	public void mouseClicked() {
		
		draw.textAlign(PConstants.CENTER);
		draw.rectMode(PConstants.CENTER);
		
		if (draw.mouseX <= draw.width/2 + bW/2 && draw.mouseX >= draw.width/2 - bW/2
				&& draw.mouseY <= draw.height*0.43f + bH/2 && draw.mouseY >= draw.height*0.43f - bH/2) 
			draw.switchScreen(ScreenSwitcher.STUDY_SCREEN);
		else if (draw.mouseX <= draw.width/2 + bW/2 && draw.mouseX >= draw.width/2 - bW/2
				&& draw.mouseY <= draw.height*0.6f + bH/2 && draw.mouseY >= draw.height*0.6f - bH/2)
			draw.switchScreen(ScreenSwitcher.QUIZ_SCREEN);
		else if (draw.mouseX <= draw.width/2 + bW/2 && draw.mouseX >= draw.width/2 - bW/2
				&& draw.mouseY <= draw.height*0.77f + bH/2 && draw.mouseY >= draw.height*0.77f - bH/2) 
			draw.switchScreen(ScreenSwitcher.DRAW_SCREEN);
		else if (draw.mouseX <= draw.width * 0.08f + bH*0.85f/2 && draw.mouseX >= draw.width * 0.08f - bH*0.85f/2
				&& draw.mouseY <= draw.height * 0.09f + bH*0.85f/2 && draw.mouseY >= draw.height * 0.09f - bH*0.85f/2) 
			draw.switchScreen(ScreenSwitcher.INSTRUCTIONS_SCREEN);
	}
	
	/**
	 * To say which mode the user is currently in
	 * @return a string with what mode is currently selected
	 */
	public String getMode()
	{
		if (mode == 1)
			return "Study Mode";
		if (mode == 2)
			return "Quiz Mode";
		if (mode == 3)
			return "Draw Mode";
		else
			return "No mode selected";
	}
}