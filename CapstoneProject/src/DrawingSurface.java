import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurface extends PApplet {
	
	Introduction intro;
	Menu menu;
	static boolean showIntro;
	PImage bg;
	
	public DrawingSurface() {
		showIntro = true;
		intro = new Introduction();
		menu = new Menu();
	}
	
	public void settings() {
		size(1000, 751);
	}
	
	public void setup() {
		bg = loadImage("src/fileData/IntroTree.png");
	}
	
	public void draw() {
		background(bg);
		if (showIntro) 
		{
			intro.draw(this);
		}
		else 
		{
			bg = loadImage("src/fileData/map.png");
			menu.draw(this);
		}
	}
	
	public static void switchToMenu() {
		showIntro = false;
	}
}