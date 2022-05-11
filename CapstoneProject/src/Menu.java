import processing.core.PApplet;

public class Menu {

	StudyMode study;
	QuizMode quiz;
	DrawingMode drawing;
	int highScore;
	Instructions inst;
	
	public Menu()
	{
		
	}
	
	public void draw(PApplet draw) 
	{
		draw.image(draw.loadImage(image), 0, 0, 1000, 751);
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
