import java.awt.*;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;

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
	private DrawingSurface surface;
	private PFont myFont;
	boolean pressed;
	private int mode;
	private Rectangle studyBtn;
	private Rectangle quizBtn;
	private Rectangle drawingBtn;
	private Rectangle instructBtn;
	
	public Menu(DrawingSurface surface)
	{
		super(1000, 751);
		this.surface = surface;
		
		inst = new Instructions(surface);
		quiz = new QuizMode(surface);
		study = new StudyMode(surface);
		drawing = new DrawingMode(surface);
		
		studyBtn = new Rectangle(1000/2, 751/2 - 150, 350, 50);
		quizBtn = new Rectangle (1000/2, 751/2, 350, 50);
		drawingBtn = new Rectangle (1000/2 , 751/2 + 150, 350, 50);
		instructBtn = new Rectangle (1000/2 , 751/2 + 300, 350, 50);
		
	}
	
	/**
	 * Draws the chosen Mode
	 * @param draw
	 */
	public void draw() 
	{
		surface.background(255, 119, 255);
		
		surface.textAlign(PConstants.CENTER);
		surface.rectMode(PConstants.CENTER);
		
		surface.fill(19, 200, 134);
		surface.rect(studyBtn.x, studyBtn.y, studyBtn.width, studyBtn.height, 10, 10, 10, 10);
		surface.rect(quizBtn.x, quizBtn.y, quizBtn.width, quizBtn.height, 10, 10, 10, 10);
		surface.rect(drawingBtn.x, drawingBtn.y, drawingBtn.width, drawingBtn.height, 10, 10, 10, 10);
		surface.rect(instructBtn.x, instructBtn.y, instructBtn.width, instructBtn.height, 10, 10, 10, 10);
		
		surface.fill(0);
		myFont = surface.createFont("Times New Roman", 18);
		surface.textFont(myFont);
		surface.textSize(30);
		surface.text("MAIN MENU", surface.width/2, surface.height/2 - 240);
		
		surface.textSize(18);
		surface.stroke(0);
		
		surface.text("Study Mode", studyBtn.x, studyBtn.y);
		surface.text("Quiz Mode", quizBtn.x, quizBtn.y);
		surface.text("Draw Mode", drawingBtn.x, drawingBtn.y);
		surface.text("?", instructBtn.x, instructBtn.y);
		
	}
	
	
	public void mouseClicked() {
		
		surface.textAlign(PConstants.CENTER);
		surface.rectMode(PConstants.CENTER);
		
		if (surface.mouseX <= 650 && surface.mouseX >= 350 && surface.mouseY >= 200 && surface.mouseY <=250)
			surface.switchScreen(ScreenSwitcher.STUDY_SCREEN);
		
		if (surface.mouseX <= 650 && surface.mouseX >= 350 && surface.mouseY >= 350 && surface.mouseY <= 401)
			surface.switchScreen(ScreenSwitcher.QUIZ_SCREEN);
		
		if (surface.mouseX <= 650 && surface.mouseX >= 350 && surface.mouseY >= 500 && surface.mouseY <= 551)
			surface.switchScreen(ScreenSwitcher.DRAW_SCREEN);
		
		if (surface.mouseX <= 650 && surface.mouseX >= 350 && surface.mouseY >= 650 && surface.mouseY <= 701)
			surface.switchScreen(ScreenSwitcher.INSTRUCTIONS_SCREEN);
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