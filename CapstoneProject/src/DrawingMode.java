import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.sound.sampled.Line;
import javax.swing.JComponent;

import processing.core.PApplet;

/**
 * Serves to act as the draw feature for the class which is an interactive tool allowing the user to draw on a white board with four color options
 * Has an image and a Graphics2D
 * 
 * @author Aarushi Gupta
 */
public class DrawingMode extends Frame implements MouseListener{

	public DrawingMode() {
	 yes = true;
	}

	private Image image;
	private Graphics2D g2;
	private boolean clicked;
	private Rectangle rect;
	private static boolean yes;
	private DrawingSurface surface;
	
	private int curX, curY, oldX, oldY;
	Color color;
	
	/**
	 * draws the drawing mode
	 * @param draw
	 * @post clicked is changed if mouse is pressed
	 */
	
//	public void setup(PApplet draw) {
//		draw.background(255);
//	}
//	
	public void draw(PApplet draw) {
		
		
		if (yes)
			draw.background(255);
			
//		mouseClicked(draw);
//		draw.rect(100, 100, 50, 50);
//		
//		
//		draw.mouseClicked();
		yes = false;
		draw.stroke(10, 30, 40);
		draw.line(draw.pmouseX, draw.pmouseY, draw.mouseX, draw.mouseY);
		
//		if (draw.mousePressed) {
//			clicked = true;
//			draw.fill(10, 15, 14);
//			
//			draw.rect(draw.mouseX, draw.mouseY, 5, 5);
//			
//		}
		
//		if(draw.mouseReleased() == true)
		
		
//		if(clicked) {
//			draw.fill(10, 15, 14);
//		
//			draw.line(draw.mouseX, draw.mouseY, draw.mouseX+5, draw.mouseY +10);
//		}
	}
	
	/**
	 * when mouse is clicked, program is directed to draw a rectangle
	 */
	public static void mouseClicked(PApplet draw) {
//		draw.fill(10, 15, 14);
//		
//		draw.rect(draw.mouseX, draw.mouseY, 5, 5);
		
	}
	
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
//		e.rect(e.getX(), e.getY(), 5, 5);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}