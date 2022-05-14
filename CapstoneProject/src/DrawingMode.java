import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

/**
 * 
 * @author aarushigupta
 * 
 * Serves to act as the draw feature for the class which is an interactive tool allowing the user to draw on a white board with four color options
 * Has an image and a Graphics2D
 */
public class DrawingMode extends Screen{

	public DrawingMode() {
		
		
	}

	private Image image;
	private Graphics2D g2;
	
	private int curX, curY, oldX, oldY;
	Color color;
	
	/**
	 * sets the paint color to red
	 */
	public void red() {
		g2.setPaint(Color.red);
	}
	
	/**
	 * sets the paint color to black
	 */
	public void black() {
		g2.setPaint(Color.black);
	}
	
	/**
	 * sets the paint color to green
	 */
	public void green() {
		g2.setPaint(Color.green);
	}
	
	/**
	 * sets the paint color to blue
	 */
	public void blue() {
		g2.setPaint(Color.blue);
	}
}