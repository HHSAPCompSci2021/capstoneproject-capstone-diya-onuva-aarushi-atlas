import java.awt.Rectangle;

import processing.core.PApplet;
import processing.core.PFont;

/**
 * 
 * Has a StudyMode, QuizMode, highscore, Instructions, PFont, if pressed, int for mode
 * Serves to act as a menu where the user can navigate to different features within the game (study, quiz, and draw mode as well as the instructions)
 *
 * @author Aarushi Gupta
 * 
 */

public class Menu {

	private StudyMode study;
	private QuizMode quiz;
	private DrawingMode drawing;
	private int highScore;
	private Instructions inst;
	private PFont myFont;
	boolean pressed;
	private int mode;
	private final static int menu = 0;
	private final static int studyMode = 1;
	private final static int quizMode = 2;
	private final static int drawMode = 3;
	private final static int instructions = 4;
	private static int activeMode;
	private static boolean yes;
	
	public Menu()
	{
		inst = new Instructions();
		study = new StudyMode();
		quiz = new QuizMode();
		drawing = new DrawingMode();
		yes = true;
//		studyBtn = new Rectangle(1000/2, 751/2 - 50, 350, 50);
//		quizBtn = new Rectangle (1000/2, 751/2, 350, 50);
//		drawingBtn = new Rectangle (1000/2, 751/2 + 50, 350, 50);
		
	}
	
	/**
	 * Draws the chosen Mode
	 * @param draw
	 */
	public void draw(PApplet draw) 
	{
		
		if (activeMode == 0) menuDraw(draw);
		else if (activeMode == 1) study.draw(draw);
		else if (activeMode == 2) quiz.draw(draw);
		else if (activeMode == 3) drawing.draw(draw);
		else inst.draw(draw);
		
	}
	
	/**
	 * Monitors the screen switch by using the user's mouse pressed position
	 * @param draw
	 * @post pressed changes value to its opposite once clicked on, and active screen switches determining where the click was
	 */
	public void menuDraw(PApplet draw) 
	{
		if(yes)
		draw.background(100, 40, 35);
		if(draw.mousePressed && draw.mouseX <= (draw.width/2 + 175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 - 75) && (draw.height/2 - 125) <= draw.mouseY)
		{
			yes = false;
			switchActiveScreen(1);
			pressed = true;
			//draw.fill(0, 185, 35);
		}
				
		//click on Quiz
		if(draw.mousePressed && draw.mouseX <= (draw.width/2 + 175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 + 25) && (draw.height/2 - 25) <= draw.mouseY)
		{
			switchActiveScreen(2);
			pressed = true;
			//draw.fill(0, 185, 35);
		}
				
		//click on Draw
		if(draw.mousePressed && draw.mouseX <= (draw.width/2 +175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 + 125) && (draw.height/2 + 75) <= draw.mouseY)
		{
			yes = false;
			switchActiveScreen(3);
			pressed = true;
			//draw.fill(0, 185, 35);
		}
		
		//click on Instructions
		if(draw.mousePressed && draw.mouseX <= 75 && 25 <= draw.mouseX && draw.mouseY <= 75 && 25 <= draw.mouseY)
		{
//			switchActiveScreen(3);
			inst.draw(draw);
			pressed = true;
			
		}
		
		draw.background(255,255,255);
		
		draw.fill(130, 185, 35);
		
		if (pressed) {
			if (activeMode == 1) {
				draw.fill(0, 185, 35);
				draw.rect(draw.width/2, draw.height/2 - 100, 350, 50);
				draw.fill(130, 185, 35);
				draw.rect(draw.width/2, draw.height/2, 350, 50); //Quiz
				draw.rect(draw.width/2, draw.height/2 + 100, 350, 50); //Draw
				draw.rect(50, 50, 50, 50);
			}
			else if (activeMode == 2) {
				draw.fill(0, 185, 35);
				draw.rect(draw.width/2, draw.height/2, 350, 50); //Quiz
				draw.fill(130, 185, 35);
				draw.rect(draw.width/2, draw.height/2 - 100, 350, 50);
				draw.rect(draw.width/2, draw.height/2 + 100, 350, 50); //Draw
				draw.rect(50, 50, 50, 50);
			}
			else if (activeMode == 3) {
				draw.fill(0, 185, 35);
				draw.rect(draw.width/2, draw.height/2 + 100, 350, 50); //Draw
				draw.fill(130, 185, 35);
				draw.rect(draw.width/2, draw.height/2 - 100, 350, 50);
				draw.rect(draw.width/2, draw.height/2, 350, 50); //Quiz
				draw.rect(50, 50, 50, 50);
			}
			else {
				draw.fill(0, 185, 35);
				draw.rect(50, 50, 50, 50);
				draw.fill(130, 185, 35);
				draw.rect(draw.width/2, draw.height/2 - 100, 350, 50);
				draw.rect(draw.width/2, draw.height/2, 350, 50); //Quiz
				draw.rect(draw.width/2, draw.height/2 + 100, 350, 50); //Draw
			}
		}
		else {
			draw.rect(50, 50, 50, 50);
			draw.rect(draw.width/2, draw.height/2 - 100, 350, 50); //Study
			draw.rect(draw.width/2, draw.height/2, 350, 50); //Quiz
			draw.rect(draw.width/2, draw.height/2 + 100, 350, 50); //Draw
		}
		
		draw.fill(0);
		draw.textSize(40);
		draw.text("?", 50, 60);
		
		draw.fill(0);
		myFont = draw.createFont("Times New Roman", 18);
		draw.textFont(myFont);
		draw.textSize(30);
		draw.text("MAIN MENU", draw.width/2, draw.height/2 - 170);
		
		draw.textSize(18);
		
		draw.text("Study Mode", draw.width/2, draw.height/2 - 90);
		draw.text("Quiz Mode", draw.width/2, draw.height/2 + 10);
		draw.text("Draw Mode", draw.width/2, draw.height/2 + 110);
		
		pressed = false;
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
	 * changes the Active Screen
	 * @param x
	 * @post sets activeMode to the x value passed
	 */
	public static void switchActiveScreen(int x) {
		activeMode = x;
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
