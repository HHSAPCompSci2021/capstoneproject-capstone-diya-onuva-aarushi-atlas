import java.awt.Point;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

/** <code>Drawing Surface</code> is responsible for displaying the
 * <code>Introduction</code> and <code>Menu</code> screens
 * 
 * @author Aarushi Gupta
*/

public class DrawingSurface extends PApplet implements ScreenSwitcher {
	
	private float ratioX, ratioY;
	
	private static Introduction intro;
	private static Menu menu;
	private static StudyMode study;
	private static QuizMode quiz;
	private static DrawingMode drawing;
	private static Instructions instruct;
	
	private Screen activeScreen;
	private ArrayList<Screen> screens;

	
	/**
	 * Creates and initializes all screens
	 */
	public DrawingSurface() {
		
		screens = new ArrayList<Screen>();
		
		intro = new Introduction(this); 
		screens.add(intro);
		
		menu = new Menu(this);
		screens.add(menu);
		
		study = new StudyMode(this);
		screens.add(study);
		
		quiz = new QuizMode(this);
		screens.add(quiz);
		
		drawing = new DrawingMode(this);
		screens.add(drawing);
		
		instruct = new Instructions(this);
		screens.add(instruct);
		
		activeScreen = screens.get(0);
		
	}
	
	/**
	 * Sets PApplet settings
	 */
	public void settings() {
		size(1200, 750);
	}
	
	/**
	 * Completes PApplet setup
	 */
	public void setup() {
		for (Screen s : screens)
			s.setup();
	}
	
	/**
	 * Draws current active <code>Screen</code>
	 */
	public void draw() {
		PFont myFont = createFont("Times New Roman", 18);
		textFont(myFont);
		ratioX = (float)width/activeScreen.DRAWING_WIDTH;
		ratioY = (float)height/activeScreen.DRAWING_HEIGHT;
		noStroke();

		push();
		
		scale(ratioX, ratioY);
		
		activeScreen.draw();
		
		pop();
	}
	
	/**
	 * Detects when mouse is pressed
	 */
	public void mousePressed() {
		activeScreen.mousePressed();
	}
	
	/**
	 * Detects when mouse is clicked
	 */
	public void mouseClicked() {
		activeScreen.mouseClicked();
	}
	
	/**
	 * Detects when mouse is moved
	 */
	public void mouseMoved() {
		activeScreen.mouseMoved();
	}
	
	/**
	 * Detects when mouse is dragged
	 */
	public void mouseDragged() {
		activeScreen.mouseDragged();
	}
	
	/**
	 * Detects when mouse is released for active screen
	 */
	public void mouseReleased() {
		activeScreen.mouseReleased();
	}
	
	/**
	 * Gets the mouse location of the user
	 * @param assumed point
	 * @return new point
	 */
	public Point assumedCoordinatesToActual(Point assumed) {
		return new Point((int)(assumed.getX()*ratioX), (int)(assumed.getY()*ratioY));
	}

	/**
	 * translates the user's mouse information to correspond with the active screen dimensions
	 * @param actual point 
	 * @return new point 
	 */
	public Point actualCoordinatesToAssumed(Point actual) {
		return new Point((int)(actual.getX()/ratioX) , (int)(actual.getY()/ratioY));
	}

	/**
	 * Switches display to given <code>Screen</code>
	 * @param i <code>Screen</code> to display
	 * @post Switches displayed screen to given <code>Screen</code>
	 */
	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}

}