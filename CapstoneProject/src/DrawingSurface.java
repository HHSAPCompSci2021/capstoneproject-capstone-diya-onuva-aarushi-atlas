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
	private static boolean showIntro;
	private PImage bg;
	
	/**
	 * Creates and initializes <code>Introduction</code> and <code>Menu</code> screens
	 */
	public DrawingSurface() {
		showIntro = true;
		
<<<<<<< Updated upstream
=======
		screens = new ArrayList<Screen>();
		
		DrawingMode drawM = new DrawingMode();
//		Instructions instructM = new Instructions();
		QuizMode quizM = new QuizMode();
		StudyMode studyM = new StudyMode();
		
		screens.add(drawM);
//		screens.add(instructM);
//		screens.add(quizM);
//		screens.add(studyM);
		
>>>>>>> Stashed changes
		intro = new Introduction();
		menu = new Menu();
		
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
		bg = loadImage("src/fileData/IntroTree.png");
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
			background(255, 255, 255);
			menu.draw(this);
		}
	}
	
	/**
	 * Switches displayed <code>Introduction</code> screen
	 * to <code>Menu</code> screen
	 */
	public static void switchToMenu() {
		showIntro = false;
	}

}