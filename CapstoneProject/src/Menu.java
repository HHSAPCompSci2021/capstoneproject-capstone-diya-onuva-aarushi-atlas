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
<<<<<<< Updated upstream
		
		
=======
		draw.image(draw.loadImage(image), 0, 0, 1000, 751);
>>>>>>> Stashed changes
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
