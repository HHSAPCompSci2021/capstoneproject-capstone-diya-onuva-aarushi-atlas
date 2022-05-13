import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

public class DrawingMode extends Screen{

	public DrawingMode() {
		
		
	}

	private Image image;
	private Graphics2D g2;
	
	private int curX, curY, oldX, oldY;
	Color color;
	
	public void red() {
		g2.setPaint(Color.red);
	}
	
	public void black() {
		g2.setPaint(Color.black);
	}
	
	public void green() {
		g2.setPaint(Color.green);
	}
	
	public void blue() {
		g2.setPaint(Color.blue);
	}
}