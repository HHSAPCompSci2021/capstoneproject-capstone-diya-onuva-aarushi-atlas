import processing.core.PApplet;
import processing.core.PConstants;

/**
 * Serves to act as the draw feature for the class which is an interactive tool allowing the user to draw on a white board with six color options
 * Has an DrawingSurface, Menu and other variables allowing for control switches
 * Does the drawing, interprets mouse interactions, and changes drawing controls
 * 
 * @author Aarushi Gupta
 */
public class DrawingMode extends Screen {

	private static boolean isDragged, setBackground, chooseColor, rectDrag;
	private DrawingSurface surface;
	private int r, g, b;
	private float x, y, rectX, rectY;
	private boolean erase;

	/**
	 * @param draw of type DrawingSurface
	 * Constructor and initializes fields 
	 */
	public DrawingMode(DrawingSurface draw) {
		super(1200, 750);
		this.surface = draw;
		
		isDragged = false;
		setBackground = true;
		chooseColor = false;
		rectDrag = false;
		
		x = -1;
		y = -1;
		
		rectX = -1;
		rectY = -1;
	}
	
	/**
	 * Serves to draw onto the screen
	 * @post setBackground is changed
	 * @post draw can switch screens if a certain button is pressed
	 * @post user can draw lines onto the draw, changing the state of the draw
	 */
	public void draw() {
	
		//if(draw.mousePressed && draw.mouseX <= 60 && draw.mouseX >= 30 && draw.mouseY <= 60 && draw.mouseY >= 30) {
		//setBackground = true;
		//curColor = 0;
		//draw.switchScreen(ScreenSwitcher.MENU_SCREEN);
		//}
		surface.strokeWeight(2);
		
		if (erase) 
			surface.strokeWeight(40);
		
		if (surface.mousePressed && x < 0 && y < 0) {
			x = surface.mouseX;
			y = surface.mouseY;
		}
		
		else if (!surface.mousePressed) {
			x = -1;
			y = -1;
			surface.cursor(PConstants.ARROW);
		}
		
		if(surface.mouseX <= surface.width * 0.05f + surface.height * 0.05f 
		  && surface.mouseX >= surface.width * 0.05f - surface.height * 0.05f 
		  && surface.mouseY <= surface.height * 0.13f && surface.mouseY >= surface.height * 0.03f)
			surface.cursor(PConstants.HAND);
		
		//sets the background
		if(setBackground)
			surface.background(255);
		setBackground = false;
		
		controlsSetUp();
		
		//allows for user to free draw
		if(isDragged) {
			surface.stroke(r, g, b);
			surface.line(surface.pmouseX, surface.pmouseY, surface.mouseX, surface.mouseY);
		}
		
		if (rectDrag) {
			surface.fill(r, g, b);
			surface.rectMode(PConstants.CORNER);
			surface.rect(rectX, rectY, Math.abs(surface.mouseX - rectX), Math.abs(surface.mouseY - rectY));
			surface.rectMode(PConstants.CENTER);
		}
		
		if (chooseColor) 
			surface.image(surface.loadImage("fileData/ColorWheel.png"), DRAWING_WIDTH - 285, 350); //285, 350
		
		else {
			surface.rectMode(PConstants.CORNER);
			surface.noStroke();
			surface.fill(255);
			surface.rect(DRAWING_WIDTH - 285, 350, 220, 220);
			surface.rectMode(PConstants.CORNER);
		}
	}
	
	/**
	 * Serves to detect and interpret when a user drags their mouse
	 * @post sets isDragged to true; allows draw to be changed
	 */
	public void mouseDragged() {
		if (!chooseColor && surface.mouseButton == PConstants.LEFT) 
			isDragged = true;
		
		else if (!chooseColor && surface.mouseButton == PConstants.RIGHT && !rectDrag) {
		rectDrag = true;
		rectX = surface.mouseX;
		rectY = surface.mouseY;
		}
	}
	
	/** 
	 * Serves to detect and interpret when a user released their mouse
	 * @post sets isDragged to true
	 */
	public void mouseReleased() {
	
		if (chooseColor) {
			erase = false;
			int r2 = PApplet.round(surface.red(surface.color(surface.get(DrawingSurface.round(x), DrawingSurface.round(y)))));
			int g2 = PApplet.round(surface.green(surface.color(surface.get(DrawingSurface.round(x), DrawingSurface.round(y)))));
			int b2 = PApplet.round(surface.blue(surface.color(surface.get(DrawingSurface.round(x), DrawingSurface.round(y)))));
		
			if (surface.mouseX >= DRAWING_WIDTH - 285 && surface.mouseX <= DRAWING_WIDTH - 65
			  && surface.mouseY >= 350 && surface.mouseY <= 570
			  && (!(r2 == g2 && g2 == b2 && r2 == b2 && b2 == 255))) {
				r = r2;
				g = g2;
				b = b2;
			}
			chooseColor = false;
			}
		
		else {
			if (isDragged) 
				isDragged = false;
			if (rectDrag) {
				rectDrag = false;
				rectX = -1;
				rectY = -1;
			}
			if (surface.mouseX <= surface.width * 0.05f + surface.height * 0.05f 
			  && surface.mouseX >= surface.width * 0.05f - surface.height * 0.05f 
			  && surface.mouseY <= surface.height * 0.13f && surface.mouseY >= surface.height * 0.03f
			  && x <= surface.width * 0.05f + surface.height * 0.05f 
			  && x >= surface.width * 0.05f - surface.height * 0.05f 
			  && y <= surface.height * 0.13f && y >= surface.height * 0.03f) {
				setBackground = true;
				erase = false;
				r = 0;
				g = 0;
				b = 0;
				surface.switchScreen(ScreenSwitcher.MENU_SCREEN);
			}
			
			//switches to red stroke
			if((surface.mouseX <= (DRAWING_WIDTH - 35) && surface.mouseX >= (DRAWING_WIDTH - 65) && surface.mouseY <= 65 && surface.mouseY >= 35)
			  && (x <= (DRAWING_WIDTH - 35) && x >= (DRAWING_WIDTH - 65) && y <= 65 && y >= 35)) {
				erase = false;
				r = 205;
				g = 30;
				b = 40;
			}
			
			if((surface.mouseX <= (DRAWING_WIDTH - 35) && surface.mouseX >= (DRAWING_WIDTH - 65) && surface.mouseY <= 115 && surface.mouseY >= 85)
			  && (x <= (DRAWING_WIDTH - 35) && x >= (DRAWING_WIDTH - 65) && y <= 115 && y >= 85)) {
				erase = false;
				r = 205;
				g = 100;
				b = 40;
			}
			
			if((surface.mouseX <= (DRAWING_WIDTH - 35) && surface.mouseX >= (DRAWING_WIDTH - 65) && surface.mouseY <= 165 && surface.mouseY >= 135)
			  && (x <= (DRAWING_WIDTH - 35) && x >= (DRAWING_WIDTH - 65) && y <= 165 && y >= 135)) {
				r = 203;
				g = 160;
				b = 40;
				erase = false;
			}
			
			if((surface.mouseX <= (DRAWING_WIDTH - 35) && surface.mouseX >= (DRAWING_WIDTH - 65) && surface.mouseY <= 215 && surface.mouseY >=185)
			  && (x <= (DRAWING_WIDTH - 35) && x >= (DRAWING_WIDTH - 65) && y <= 215 && y >=185)) {
				erase = false;
				r = 20;
				g = 215;
				b = 5;
			}
			
			if((surface.mouseX <= (DRAWING_WIDTH - 35) && surface.mouseX >= (DRAWING_WIDTH - 65) && surface.mouseY <= 265 && surface.mouseY >= 235)
			  && (x <= (DRAWING_WIDTH - 35) && x >= (DRAWING_WIDTH - 65) && y <= 265 && y >= 235)) {
				erase = false;
				r = 10;
				g = 75;
				b = 140;
			}
			
			if((surface.mouseX <= (DRAWING_WIDTH - 35) && surface.mouseX >= (DRAWING_WIDTH - 65) && surface.mouseY <= 315 && surface.mouseY >= 285)
			  && (x <= (DRAWING_WIDTH - 35) && x >= (DRAWING_WIDTH - 65) && y <= 315 && y >= 285)) {
				erase = false;
				r = 80;
				g = 40;
				b = 120;
			}
			
			if((surface.mouseX <= (DRAWING_WIDTH - 35) && surface.mouseX >= (DRAWING_WIDTH - 65) && surface.mouseY <= 365 && surface.mouseY >= 335)
			  && (x <= (DRAWING_WIDTH - 35) && x >= (DRAWING_WIDTH - 65) && y <= 365 && y >= 335)) {
				erase = false;
				r = 0;
				g = 0;
				b = 0;
			}
			
			//eraser 
			if((surface.mouseX <= (1170) && surface.mouseX >= (1130) && surface.mouseY <= 550 && surface.mouseY >= 500)
			  && (x <= (1170) && x >= (1130) && y <= 550 && y >= 500)) {
				
				surface.strokeWeight(10);
				erase = true;
				r = 255;
				g = 255;
				b = 255;
				surface.strokeWeight(2);
			}
			
			if((surface.mouseX <= (DRAWING_WIDTH - 35) && surface.mouseX >= (DRAWING_WIDTH - 65) && surface.mouseY <= 415 && surface.mouseY >= 385)
			  && (x <= (DRAWING_WIDTH - 35) && x >= (DRAWING_WIDTH - 65) && y <= 415 && y >= 385)) {
				erase = false;
				reset();
			}
			
			if((surface.mouseX <= (DRAWING_WIDTH - 10) && surface.mouseX >= (DRAWING_WIDTH - 65) && surface.mouseY <= 492 && surface.mouseY >= 425)
			  && (x <= (DRAWING_WIDTH - 10) && x >= (DRAWING_WIDTH - 65) && y <= 492 && y >= 425)) {
				erase = false;
				chooseColor = true;
			}
		}
	}
	
	/** 
	 * Serves to draw out the controls for the user to use (color changing) and button animations
	 */
	public void controlsSetUp() {
		surface.noStroke();
		
		surface.rectMode(PConstants.CORNER);
		surface.fill(255);
//		surface.rect(1130, 0, surface.width - 1140, surface.height);
//		surface.stroke(0);
		surface.rect(1130, 0, surface.width - 1140, surface.height);
		surface.stroke(255);
		surface.line(1130, 0, 1130, surface.height);
		surface.line(911, surface.height - 225, 1130, surface.height - 225);
		surface.line(911, surface.height, 1130, surface.height);
		surface.line(911, surface.height - 225, 911, surface.height);
		
//		surface.line(911, 349, 1130, 349);
//		surface.line(911, 571, 1130, 571);
//		surface.line(911, 349, 911, 571);
		surface.stroke(0);
		surface.rectMode(PConstants.CENTER);
		surface.noStroke();
		
		if (surface.mousePressed && x <= surface.width * 0.05f + surface.height * 0.05f && x >= surface.width * 0.05f - surface.height * 0.05f && y <= surface.height * 0.13f && y >= surface.height * 0.03f) 
		{
			surface.fill(255);
			surface.rect(surface.width * 0.05f, surface.height * 0.08f, surface.height * 0.1f, surface.height * 0.1f);
			surface.fill(30, 120, 0);
			surface.ellipse(surface.width * 0.05f, surface.height * 0.08f, surface.height * 0.1f * (2f/3f), surface.height * 0.1f * (2f/3f)); //Back button
			surface.image(surface.loadImage("fileData/smallHouse.png"), surface.width * 0.035f, surface.height * 0.0575f);
		}
		else {
			surface.fill(50, 140, 5);
			surface.ellipse(surface.width * 0.05f, surface.height * 0.08f, surface.height * 0.1f, surface.height * 0.1f); //Back button
			surface.image(surface.loadImage("fileData/house.png"), surface.width * 0.03f, surface.height * 0.05f);
		}
		
		surface.fill(203, 32, 40); //red
		surface.rect(1150, 50, 30, 30);
		
		surface.fill(205, 99, 41); //orange
		surface.rect(1150, 100, 30, 30);
		
		surface.fill(204, 162, 42); //yellow
		surface.rect(1150, 150, 30, 30);
		
		surface.fill(19, 2139, 6); //green
		surface.rect(1150, 200, 30, 30);
		
		surface.fill(9, 77, 140); //blue
		surface.rect(1150, 250, 30, 30);
		
		surface.fill(81, 42, 123); //purple
		surface.rect(1150, 300, 30, 30);
		
		surface.fill(0); //black
		surface.rect(1150, 350, 30, 30);
		
		surface.fill(255); //color wheel
		surface.rect(1150, 450, 60, 60);
		surface.image(surface.loadImage("fileData/wheel.png"), 1120, 420);
		
		surface.fill(220, 236, 245); //reset
		surface.rect(1150, 400, 30, 30);
		surface.fill(0);
		surface.textSize(10);
		surface.text("Reset", 1150, 405);
		
		surface.fill(220, 236, 245); //eraser
		surface.rect(1150, 520, 30, 30);
		surface.fill(0);
		surface.image(surface.loadImage("fileData/trashcan.png"), 1130, 500);
		surface.textSize(10);
//		surface.text("Eraser", 1150, 525);
	}
	
	/**
	 * Serves to allow the user to reset any modifications on the screen (clear the draw)
	 * @post clears the surface and sets setBackground back to true
	 */
	public void reset() {
		setBackground = true;
	}
	
}