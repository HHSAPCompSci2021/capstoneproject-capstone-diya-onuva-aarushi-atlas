import processing.core.PApplet;

public class Menu {

	StudyMode study;
	QuizMode quiz;
	DrawingMode drawing;
	int highScore;
	Instructions inst;
	String back;
	
	public Menu(String b)
	{
		back = b;
	}
	
	public void draw(PApplet draw) {
		
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
