import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;

public class Menu {

	StudyMode study;
	QuizMode quiz;
	DrawingMode drawing;
	int highScore;
	Instructions inst;
	PFont myFont;
//	Rect rect1;
	
	public Menu()
	{
		
	}
	
	public void draw(PApplet draw) 
	{
		draw.fill(130, 185, 35);
		
		draw.rect(draw.width/2, draw.height/2 - 100, 350, 50); //Study
		draw.rect(draw.width/2, draw.height/2, 350, 50); //Quiz
		draw.rect(draw.width/2, draw.height/2 + 100, 350, 50); //Draw
		
		draw.fill(0);
		myFont = draw.createFont("Times New Roman", 18);
		draw.textFont(myFont);
		draw.textSize(18);
		
		draw.text("Study Mode", draw.width/2, draw.height/2 - 90);
		draw.text("Quiz Mode", draw.width/2, draw.height/2 + 10);
		draw.text("Draw Mode", draw.width/2, draw.height/2 + 110);
		
	}
	
	public int getHighScore()
	{
		return highScore;
	}
	
	public String getMode()
	{
		return null;
	}
	
	public void mouseClicked()
	{
		
	}
}
