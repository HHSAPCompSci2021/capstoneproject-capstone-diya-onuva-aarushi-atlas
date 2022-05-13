import java.awt.Rectangle;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;


public class Menu {
	private StudyMode study;
	private QuizMode quiz;
	private DrawingMode drawing;
	private int highScore;
	private Instructions inst;
	private PFont myFont;
	boolean pressed;
	private int mode;
	private boolean clicked;
	private DrawingSurface surface;
	private Rectangle studyBtn, quizBtn, drawingBtn;
	final static int menu = 0;
	final static int studyMode = 1;
	final static int quizMode = 2;
	final static int drawMode = 3;
	final static int instructions = 4;
	static int activeMode;
	
	public Menu()
	{
		inst = new Instructions();
		study = new StudyMode();
		quiz = new QuizMode();
		drawing = new DrawingMode();
		studyBtn = new Rectangle(1000/2, 751/2 - 50, 350, 50);
		quizBtn = new Rectangle (1000/2, 751/2, 350, 50);
		drawingBtn = new Rectangle (1000/2, 751/2 + 50, 350, 50);
		
	}
	
	public void draw(PApplet draw) 
	{
		
		draw.background(255,255,255);
		
		draw.fill(130, 185, 35);
		
		draw.rect(draw.width/2, draw.height/2 - 100, 350, 50); //Study
		draw.rect(draw.width/2, draw.height/2, 350, 50); //Quiz
		draw.rect(draw.width/2, draw.height/2 + 100, 350, 50); //Draw
		
		draw.fill(0, 185, 35);
		draw.rect(50, 50, 50, 50); //Instructions
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
		
		mode = 0;
		
		//click on Study
		if(draw.mousePressed && draw.mouseX <= (draw.width/2 + 175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 - 75) && (draw.height/2 - 125) <= draw.mouseY)
		{
			Menu.switchActiveScreen(1);
			activeMode = 1;
			mode = 1;
			pressed = true;
			draw.fill(0, 185, 35);
			draw.rect(draw.width/2, draw.height/2 - 100, 350, 50);
//			draw.background(255);
//			study.draw(draw);
//			switch screen implementation
			Menu.switchActiveScreen(1);
			study.draw(draw);
//			surface.switchScreen(ScreenSwitcher.STUDY_SCREEN);
		}
				
		//click on Quiz
		if(draw.mousePressed && draw.mouseX <= (draw.width/2 + 175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 + 25) && (draw.height/2 - 25) <= draw.mouseY)
		{
			mode = 2;
			pressed = true;
			draw.fill(0, 185, 35);
			draw.rect(draw.width/2, draw.height/2, 350, 50);

			Menu.switchActiveScreen(2);
			quiz.draw(draw);
//			draw.background(255);
//			quiz.draw(draw);
//			switch screen implementation
//			surface.switchScreen(ScreenSwitcher.QUIZ_SCREEN);
			}
				
		//click on Draw
		if(draw.mousePressed && draw.mouseX <= (draw.width/2 +175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 + 125) && (draw.height/2 + 75) <= draw.mouseY)
		{
			mode = 3;
			pressed = true;
			draw.fill(0, 185, 35);
			draw.rect(draw.width/2, draw.height/2 + 100, 350, 50);

			Menu.switchActiveScreen(3);
			drawing.draw();
//			surface.switchScreen(ScreenSwitcher.DRAW_SCREEN);
//			draw.background(255);
//			drawing.draw();
//			switch screen implementation
		}
		
		
		
		
		//click on Instructions
		if(draw.mousePressed && draw.mouseX <= 75 && 25 <= draw.mouseX && draw.mouseY <= 75 && 25 <= draw.mouseY)
		{
			mode = 4;
			pressed = true;
			inst.draw(draw);
		}
		
//		if(activeMode == 1) {
//			study.draw(draw);
//		}
//		if(activeMode == 2) {
//			quiz.draw(draw);
//		}
//		if(activeMode == 3) {
//			drawing.draw();
//		}
//		if(activeMode == 4) {
//			inst.draw(draw);
//		}
		
	}
	
	public int getHighScore()
	{
		return highScore;
	}
	
	public static void switchActiveScreen(int x) {
		activeMode = x;
	}
	
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
	
	public void mousePressed(PApplet draw)
	{
		
		//click on Study
		if(draw.mousePressed && draw.mouseX <= (draw.width/2 + 175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 - 75) && (draw.height/2 - 125) <= draw.mouseY)
		{
			mode = 1;
			pressed = true;
			draw.fill(0, 185, 35);
			draw.rect(draw.width/2, draw.height/2 - 100, 350, 50);
//			switch screen implementation
		}
				
		//click on Quiz
		if(draw.mousePressed && draw.mouseX <= (draw.width/2 + 175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 + 25) && (draw.height/2 - 25) <= draw.mouseY)
		{
			mode = 2;
			pressed = true;
			draw.fill(0, 185, 35);
			draw.rect(draw.width/2, draw.height/2, 350, 50);
//			switch screen implementation
			}
				
		//click on Draw
		if(draw.mousePressed && draw.mouseX <= (draw.width/2 +175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 + 125) && (draw.height/2 + 75) <= draw.mouseY)
		{
			mode = 3;
			pressed = true;
			draw.fill(0, 185, 35);
			draw.rect(draw.width/2, draw.height/2 + 100, 350, 50);
//			switch screen implementation
		}
	}
}
