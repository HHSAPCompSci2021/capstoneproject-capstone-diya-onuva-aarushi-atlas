import java.awt.Color;
import java.awt.*;

/**
 * Serves to act as the draw feature for the class which is an interactive tool allowing the user to draw on a white board with four color options
 * Has an image and a Graphics2D
 * 
 * @author Aarushi Gupta
 */
public class DrawingMode extends Screen {

	private static boolean yes;
	private static boolean isDragged;
	private static boolean setBackground;
	Color color;
	private DrawingSurface surface;
	private Menu menu;
	
	public DrawingMode(DrawingSurface draw) {

		super(1200, 750);
		this.surface = draw;
		isDragged = false;
		setBackground = true;
	}

	
	public void setup() {
//		surface.background(255);
	}
	
	/**
	 * draws the drawing mode
	 */
	public void draw() {
		
		if(setBackground)
			surface.background(255);
		setBackground = false;
		
		if(isDragged) {
			surface.stroke(10, 30, 40);
			surface.line(surface.pmouseX, surface.pmouseY, surface.mouseX, surface.mouseY);
		}
		
		surface.rect(30, 30, 30, 30);
		
		if(surface.mousePressed && surface.mouseX <= 60 && surface.mouseX >= 30 && surface.mouseY <= 60 && surface.mouseY >= 30) {
			setBackground = true;
			surface.switchScreen(ScreenSwitcher.MENU_SCREEN);
		}
	}
	
	/**
	 * when mouse is clicked, program is directed to draw a rectangle
	 */
//	public void mouseReleased() {
//		
//		surface.fill(10, 15, 14);
//		
//		surface.rect(surface.mouseX, surface.mouseY, 5, 5);
//		
//	}
	
	public void mouseClicked() {
		
		if (surface.mouseX <= 60 && surface.mouseX >= 30 && surface.mouseY <= 60 && surface.mouseY >= 30) {
//			surface.background(255);
			setBackground = true;
		}
		else {
			surface.fill(10, 15, 14);
			surface.rect(surface.pmouseX, surface.pmouseY, 20, 20);
		}

	}
	
	public void mouseDragged() {
		
		isDragged = true;
	}
	
	public void mouseReleased() {
		if (isDragged) {
			isDragged = false;
		}
	}
	
	/**
	 * sets the paint color to red
	 */
	public void red() {
		surface.fill(DRAWING_HEIGHT);
	}
	
	/**
	 * sets the paint color to black
	 */
	public void black() {
		surface.fill(DRAWING_HEIGHT);
	}
	
	/**
	 * sets the paint color to green
	 */
	public void green() {
		surface.fill(DRAWING_HEIGHT);
	}
	
	/**
	 * sets the paint color to blue
	 */
	public void blue() {
		surface.fill(DRAWING_HEIGHT);
	}

}