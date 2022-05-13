import processing.core.PApplet;

public class StudyMode extends Map {

	String current;
	private DrawingSurface surface;
	
	public StudyMode()
	{
		super(200, 80, 600, 591);
	}
	
	public void draw(PApplet draw)
	{
		draw.background(255);
		
		draw.image(draw.loadImage("src/fileData/map.png"), draw.width/2 - 300, draw.height/2 - (591f/2));
		
		if (draw.mousePressed) {
			System.out.println(getCountry(draw, draw.mouseX, draw.mouseY));
		}
		
	}
}
