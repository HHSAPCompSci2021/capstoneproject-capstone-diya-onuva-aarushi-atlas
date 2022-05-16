import processing.core.PApplet;

/**
 * A study mode where users directly interact with information from the map
 * @author diya
 *
 */
public class StudyMode extends Map {

	String current;
	private DrawingSurface surface;
	
	/**
	 * sets default settings
	 */
	public StudyMode()
	{
		super(200, 80, 600, 591);
	}
	
	/**
	 * draws map, and displays information
	 * @param draw
	 */
	public void draw(PApplet draw)
	{
		draw.background(255);
		
		draw.image(draw.loadImage("fileData/map.png"), draw.width/2 - 300, draw.height/2 - (591f/2));
		
		if (draw.mousePressed) {
			System.out.println(getCountry(draw, draw.mouseX, draw.mouseY));
			System.out.println(getCapital(getCountry(draw, draw.mouseX, draw.mouseY)));
		}
		
	}
}
