import java.awt.Point;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

/** <code>Drawing Surface</code> is responsible for displaying the
 * <code>Introduction</code> and <code>Menu</code> screens
 * 
 * @author Aarushi Gupta
*/

public class DrawingSurface extends PApplet implements ScreenSwitcher {
	
	public float ratioX, ratioY;
	
	private static Introduction intro;
	private static Menu menu;
//	private static DrawingMode drawing;
//	private static QuizMode quiz;
//	private static DrawingMode draw;
//	private static StudyMode study;
//	private static Instructions instruct;
	
	private static boolean showIntro;
	private PImage bg;
	private Screen activeScreen;
	private ArrayList<Screen> screens;

	
	/**
	 * Creates and initializes <code>Introduction</code> and <code>Menu</code> screens
	 */
	public DrawingSurface() {
		showIntro = true;
		
//		intro = new Introduction();
//		menu = new Menu();
//		quiz = new QuizMode();
//		draw = new DrawingMode();
//		study = new StudyMode();
//		instruct = new Instructions();
		
		screens = new ArrayList<Screen>();
		
		Introduction screen1 = new Introduction(this); 
		screens.add(screen1);
		
		Menu screen2 = new Menu(this);
		screens.add(screen2);
		
		StudyMode screen3 = new StudyMode(this);
		screens.add(screen3);
		
		QuizMode screen4 = new QuizMode(this);
		screens.add(screen4);
		
		DrawingMode screen5 = new DrawingMode(this);
		screens.add(screen5);
		
		activeScreen = screens.get(0);
		
	}
	
	/**
	 * Sets PApplet settings
	 */
	public void settings() {
		size(1000, 751);
	}
	
	/**
	 * Completes PApplet setup
	 */
	public void setup() {
		bg = loadImage("fileData/IntroTree.png");
		
		
			for (Screen s : screens)
				s.setup();
	}
	
	/**
	 * Draws <code>Introduction</code> screen
	 * or <code>Menu</code> screen
	 */
	public void draw() {
		
//		if (showIntro) 
//		{
//			background(bg);
//			intro.draw(this);
//		}
//		else 
//		{
////			background(255, 255, 255);
//			menu.draw(this);
//		}
		
		ratioX = (float)width/activeScreen.DRAWING_WIDTH;
		ratioY = (float)height/activeScreen.DRAWING_HEIGHT;

		push();
		
		scale(ratioX, ratioY);
		
		activeScreen.draw();
		
		pop();
	}
	
	/**
	 * Switches displayed <code>Introduction</code> screen
	 * to <code>Menu</code> screen
	 */
	public static void switchToMenu() {
		showIntro = false;
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
	
	public Point assumedCoordinatesToActual(Point assumed) {
		return new Point((int)(assumed.getX()*ratioX), (int)(assumed.getY()*ratioY));
	}

	public Point actualCoordinatesToAssumed(Point actual) {
		return new Point((int)(actual.getX()/ratioX) , (int)(actual.getY()/ratioY));
	}

	@Override
	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}

}