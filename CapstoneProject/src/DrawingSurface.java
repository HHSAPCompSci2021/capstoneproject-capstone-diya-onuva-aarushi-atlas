import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	
	Introduction intro;
	Menu menu;
	boolean showIntro;
	
	public DrawingSurface() {
		showIntro = false;
		intro = new Introduction("src/fileData/IntroTree.jpeg");
		menu = new Menu("src/fileData/MenuMap.jpeg");
	}
	
	public void draw() {
		if (showIntro) 
		{
			intro.draw(this);
		}
		else 
		{
			menu.draw(this);
		}
	}
	
	public void switchToMenu() {
		showIntro = false;
	}
}