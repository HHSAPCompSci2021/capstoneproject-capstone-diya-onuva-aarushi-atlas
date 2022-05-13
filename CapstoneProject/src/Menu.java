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
	boolean pressed;
	private int mode;
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
	
	public int getHighScore()
	{
		return highScore;
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
//		//click on Study
//		if(draw.mousePressed && draw.mouseX <= (draw.width/2 + 175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 - 75) && (draw.height/2 - 125) <= draw.mouseY)
//		{
//			mode = 1;
//			pressed = true;
//			draw.fill(0, 185, 35);
//			draw.rect(draw.width/2, draw.height/2 - 100, 350, 50);
////			switch screen implementation
//		}
//				
//		//click on Quiz
//		if(draw.mousePressed && draw.mouseX <= (draw.width/2 + 175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 + 25) && (draw.height/2 - 25) <= draw.mouseY)
//		{
//			mode = 2;
//			pressed = true;
//			draw.fill(0, 185, 35);
//			draw.rect(draw.width/2, draw.height/2, 350, 50);
////			switch screen implementation
//			}
//				
//		//click on Draw
//		if(draw.mousePressed && draw.mouseX <= (draw.width/2 +175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 + 125) && (draw.height/2 + 75) <= draw.mouseY)
//		{
//			mode = 3;
//			pressed = true;
//			draw.fill(0, 185, 35);
//			draw.rect(draw.width/2, draw.height/2 + 100, 350, 50);
////			switch screen implementation
//		}
	}
}
