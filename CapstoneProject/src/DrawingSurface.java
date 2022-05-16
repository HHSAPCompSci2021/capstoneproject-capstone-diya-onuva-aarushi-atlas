import java.awt.Point;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

/** <code>Drawing Surface</code> is responsible for displaying the
 * <code>Introduction</code> and <code>Menu</code> screens
 * 
 * @author Diya Bengani & Onuva Ekram
*/

public class DrawingSurface extends PApplet{
	
	private static Introduction intro;
	private static Menu menu;
//	private static DrawingMode drawing;
	private static QuizMode quiz;
	private static DrawingMode draw;
	private static StudyMode study;
	private static Instructions instruct;
	
	private static boolean showIntro;
	private PImage bg;
	private int activeScreen;
	private ArrayList<Integer> screens;
	
	/**
	 * Creates and initializes <code>Introduction</code> and <code>Menu</code> screens
	 */
	public DrawingSurface() {
		showIntro = true;
		
		intro = new Introduction();
		menu = new Menu();
		quiz = new QuizMode();
		draw = new DrawingMode();
		study = new StudyMode();
		instruct = new Instructions();
		
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
	}
	
	/**
	 * Draws <code>Introduction</code> screen
	 * or <code>Menu</code> screen
	 */
	public void draw() {
		
		if (showIntro) 
		{
			background(bg);
			intro.draw(this);
		}
		else 
		{
//			background(255, 255, 255);
			menu.draw(this);
		}
		
		
		
	}
	
	public void mousePressed() {
//		if (mouseButton == LEFT) {
//			Point click = new Point(mouseX,mouseY);
//			float dimension = height;
//			Point cellCoord = board.clickToIndex(click,0,0,dimension,dimension);
//			if (cellCoord != null) {
//				board.toggleCell(cellCoord.x, cellCoord.y);
//				prevToggle = cellCoord;
//			}
//		} 
	}
	
	/**
	 * Switches displayed <code>Introduction</code> screen
	 * to <code>Menu</code> screen
	 */
	public static void switchToMenu() {
		showIntro = false;
	}
	
	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}

}