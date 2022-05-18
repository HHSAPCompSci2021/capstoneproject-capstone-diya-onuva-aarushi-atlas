import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
public class DrawingMode extends Screen {

	private Graphics2D g2;
	private static boolean yes;
	private static boolean isDragged;
	private static boolean setBackground;
	Color color;
	private DrawingSurface surface;
	
	public DrawingMode(DrawingSurface draw) {

		super(1000, 751);
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
//		surface.stroke(10, 30, 40);
//		surface.line(surface.pmouseX, surface.pmouseY, surface.mouseX, surface.mouseY);
		
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
		
//		if(clicked) {
//			surface.fill(10, 15, 14);
//			
//			surface.rect(surface.pmouseX, surface.pmouseY, 20, 20);
//		}
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
		surface.fill(10, 15, 14);
		
		surface.rect(surface.pmouseX, surface.pmouseY, 20, 20);
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