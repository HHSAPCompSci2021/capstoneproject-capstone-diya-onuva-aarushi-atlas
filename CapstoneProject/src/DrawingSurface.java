import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	
	Introduction intro;
	Menu menu;
	static boolean showIntro;
	
	public DrawingSurface() {
		showIntro = true;
		intro = new Introduction("src/fileData/IntroTree.png");
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
	
	public static void switchToMenu() {
		showIntro = false;
	}
}