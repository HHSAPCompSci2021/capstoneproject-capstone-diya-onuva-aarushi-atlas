/**
 * 
 * An abstract class which serves as a base for each screen coded
 * Has a width and a height which are initialized in the constructor
 * 
 * @author Aarushi Gupta
 */
public abstract class Screen {

	/**
	 * Fixed width and height of the screen
	 */
	public final int DRAWING_WIDTH, DRAWING_HEIGHT;
	
	/**
	 * Sets Screen width and height
	 * @param width given width
	 * @param height given height
	 */
	public Screen(int width, int height) {
		this.DRAWING_WIDTH = width;
		this.DRAWING_HEIGHT = height;
	}
	
	/**
	 * Completes PApplet setup
	 */
	public void setup() {}
	
	/**
	 * Draws current screen
	 */
	public void draw() {}
	
	/**
	 * Detects when mouse is pressed
	 */
	public void mousePressed() {}
	
	/**
	 * Detects when mouse is cliked
	 */
	public void mouseClicked() {}
	
	/**
	 * Detects when mouse is moved
	 */
	public void mouseMoved() {}
	
	/**
	 * Detects when mouse is dragged
	 */
	public void mouseDragged() {}
	
	/**
	 * Detects when mouse is released
	 */
	public void mouseReleased() {}
}