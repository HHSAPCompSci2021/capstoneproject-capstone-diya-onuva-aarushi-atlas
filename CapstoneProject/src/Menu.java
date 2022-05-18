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

	private int highScore;
	private Instructions inst;
	private QuizMode quiz;
	private DrawingMode drawing;
	private StudyMode study;
	private DrawingSurface draw;
	private PFont myFont;
	boolean pressed;
	private int mode;
	private Rectangle studyBtn;
	private Rectangle quizBtn;
	private Rectangle drawingBtn;
	private Rectangle instructBtn;
	
	private PImage bg;
	
	public Menu(DrawingSurface draw)
	{
		super(1600, 1050);
		this.draw = draw;
		
		inst = new Instructions(draw);
		quiz = new QuizMode(draw);
		study = new StudyMode(draw);
		drawing = new DrawingMode(draw);
		
		studyBtn = new Rectangle(1000/2, 751/2 - 150, 350, 50);
		quizBtn = new Rectangle (1000/2, 751/2, 350, 50);
		drawingBtn = new Rectangle (1000/2 , 751/2 + 150, 350, 50);
		instructBtn = new Rectangle (1000/2 , 751/2 + 300, 350, 50);
		
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
		
		draw.fill(19, 200, 134);
		draw.rect(studyBtn.x, studyBtn.y, studyBtn.width, studyBtn.height, 10, 10, 10, 10);
		draw.rect(quizBtn.x, quizBtn.y, quizBtn.width, quizBtn.height, 10, 10, 10, 10);
		draw.rect(drawingBtn.x, drawingBtn.y, drawingBtn.width, drawingBtn.height, 10, 10, 10, 10);
		draw.rect(instructBtn.x, instructBtn.y, instructBtn.width, instructBtn.height, 10, 10, 10, 10);
		
		draw.fill(0);
		myFont = draw.createFont("Times New Roman", 18);
		draw.textFont(myFont);
		draw.textSize(30);
		draw.text("MAIN MENU", draw.width/2, draw.height/2 - 240);
		
		draw.textSize(18);
		draw.stroke(0);
		
		draw.text("Study Mode", studyBtn.x, studyBtn.y);
		draw.text("Quiz Mode", quizBtn.x, quizBtn.y);
		draw.text("Draw Mode", drawingBtn.x, drawingBtn.y);
		draw.text("?", instructBtn.x, instructBtn.y);
		
	}
	
	
	public void mouseClicked() {
		
		draw.textAlign(PConstants.CENTER);
		draw.rectMode(PConstants.CENTER);
		
		if (draw.mouseX <= 650 && draw.mouseX >= 350 && draw.mouseY >= 200 && draw.mouseY <=250)
			draw.switchScreen(ScreenSwitcher.STUDY_SCREEN);
		
		if (draw.mouseX <= 650 && draw.mouseX >= 350 && draw.mouseY >= 350 && draw.mouseY <= 401)
			draw.switchScreen(ScreenSwitcher.QUIZ_SCREEN);
		
		if (draw.mouseX <= 650 && draw.mouseX >= 350 && draw.mouseY >= 500 && draw.mouseY <= 551)
			draw.switchScreen(ScreenSwitcher.DRAW_SCREEN);
		
		if (draw.mouseX <= 650 && draw.mouseX >= 350 && draw.mouseY >= 650 && draw.mouseY <= 701)
			draw.switchScreen(ScreenSwitcher.INSTRUCTIONS_SCREEN);
	}
	/**
	 * gets the high score of the game
	 * 
	 * @return high score
	 */
	public int getHighScore()
	{
		return highScore;
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