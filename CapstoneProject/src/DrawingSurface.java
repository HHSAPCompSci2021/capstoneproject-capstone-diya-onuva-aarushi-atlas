import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurface extends PApplet implements ScreenSwitcher {
	
	Introduction intro;
	Menu menu;
	static boolean showIntro;
	PImage bg;
	private Screen activeScreen;
	private ArrayList<Screen> screens;
	
	public DrawingSurface() {
		showIntro = true;
		
		screens = new ArrayList<Screen>();
		
		DrawingMode drawM = new DrawingMode();
//		Instructions instructM = new Instructions();
		QuizMode quizM = new QuizMode();
		StudyMode studyM = new StudyMode();
		
		screens.add(drawM);
//		screens.add(instructM);
		screens.add(quizM);
		screens.add(studyM);
		
		intro = new Introduction();
		menu = new Menu();
		
		activeScreen = screens.get(0);
	}
	
	public void settings() {
		size(1000, 751);
	}
	
	public void setup() {
		for (Screen s : screens)
			s.setup();
		
		bg = loadImage("src/fileData/IntroTree.png");
	}
	
	public void draw() {
		
		activeScreen.draw();
		
		if (showIntro) 
		{
			background(bg);
			intro.draw(this);
		}
		else 
		{
			background(255, 255, 255);
			menu.draw(this);
		}
	}
	
	public void mousePressed() {
		activeScreen.mousePressed();
	}
	
	public void mouseMoved() {
		activeScreen.mouseMoved();
	}
	
	public void mouseDragged() {
		activeScreen.mouseDragged();
	}
	
	public void mouseReleased() {
		activeScreen.mouseReleased();
	}
	
	public static void switchToMenu() {
		showIntro = false;
	}

	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}
}