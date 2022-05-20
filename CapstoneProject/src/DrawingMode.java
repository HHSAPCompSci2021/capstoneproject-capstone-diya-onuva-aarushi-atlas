/**
 * Serves to act as the draw feature for the class which is an interactive tool allowing the user to draw on a white board with six color options
 * Has an DrawingSurface, Menu and other variables allowing for control switches
 * Does the drawing, interprets mouse interactions, and changes drawing controls
 * 
 * @author Aarushi Gupta
 */
public class DrawingMode extends Screen {

	private static boolean isDragged, setBackground;
	private DrawingSurface surface;
	private Menu menu;
	private int[] colorSwitch;
	private int curColor;
	
	/**
	 * @param draw of type DrawingSurface
	 * Constructor and initializes fields 
	 */
	public DrawingMode(DrawingSurface draw) {
		super(1200, 750);
		this.surface = draw;
		
		isDragged = false;
		setBackground = true;
		colorSwitch = new int[6];
		curColor = 0;
	}
	

	/**
	 * Serves to draw onto the screen
	 * @post setBackground is changed
	 * @post surface can switch screens if a certain button is pressed
	 * @post user can draw lines onto the surface, changing the state of the surface
	 */
	public void draw() {
		
		//sets the background
		if(setBackground)
			surface.background(255);
		setBackground = false;
		
		controlsSetUp();
		
		//allows for user to free draw
		if(isDragged) {
			if(curColor == 0)
				surface.stroke(0);
			else if (curColor == 1)
				surface.stroke(203, 32, 40); //red
			else if (curColor == 2) 
				surface.stroke(205, 99, 41); //orange
			else if (curColor == 3)
				surface.stroke(204, 162, 42); //yellow
			else if (curColor == 4)
				surface.stroke(19, 2139, 6); //green
			else if (curColor == 5)
				surface.stroke(9, 77, 140); //blue
			else if (curColor == 6)
				surface.stroke(81, 42, 123); //purple
			
			surface.line(surface.pmouseX, surface.pmouseY, surface.mouseX, surface.mouseY);
			
		}
		
		if(surface.mousePressed && surface.mouseX <= 60 && surface.mouseX >= 30 && surface.mouseY <= 60 && surface.mouseY >= 30) {
			setBackground = true;
			curColor = 0;
			surface.switchScreen(ScreenSwitcher.MENU_SCREEN);
		}
		
		surface.stroke(100, 100, 100);
	}
	
	/**
	 * Serves to detect and interpret when and where a user clicks on the screen
	 * @post if a certain button is clicked, background changes
	 * @post if a certain button is clicked, surface changes
	 * @post if a certain button is clicked, curColor changes
	 */
	public void mouseClicked() {
		
		if (surface.mouseX <= 60 && surface.mouseX >= 30 && surface.mouseY <= 60 && surface.mouseY >= 30) {
//			surface.background(255);
			setBackground = true;
		}
		
		//switches to red stroke
		if((surface.mouseX <= (DRAWING_WIDTH - 35) && surface.mouseX >= (DRAWING_WIDTH - 65) && surface.mouseY <= 65 && surface.mouseY >= 35)) {
			curColor = 1;
		}
		
		if((surface.mouseX <= (DRAWING_WIDTH - 35) && surface.mouseX >= (DRAWING_WIDTH - 65) && surface.mouseY <= 115 && surface.mouseY >= 85)) {
			curColor = 2;
		}
		
		if((surface.mouseX <= (DRAWING_WIDTH - 35) && surface.mouseX >= (DRAWING_WIDTH - 65) && surface.mouseY <= 165 && surface.mouseY >= 135)) {
			curColor = 3;
		}
		
		if((surface.mouseX <= (DRAWING_WIDTH - 35) && surface.mouseX >= (DRAWING_WIDTH - 65) && surface.mouseY <= 215 && surface.mouseY >=185)) {
			curColor = 4;
		}
		
		if((surface.mouseX <= (DRAWING_WIDTH - 35) && surface.mouseX >= (DRAWING_WIDTH - 65) && surface.mouseY <= 265 && surface.mouseY >= 235)) {
			curColor = 5;
		}
		
		if((surface.mouseX <= (DRAWING_WIDTH - 35) && surface.mouseX >= (DRAWING_WIDTH - 65) && surface.mouseY <= 315 && surface.mouseY >= 285)) {
			curColor = 6;
		}
		
		if((surface.mouseX <= (DRAWING_WIDTH - 35) && surface.mouseX >= (DRAWING_WIDTH - 65) && surface.mouseY <= 375 && surface.mouseY >= 325)) {
			curColor = 0;
		}
		
		if((surface.mouseX <= (DRAWING_WIDTH - 35) && surface.mouseX >= (DRAWING_WIDTH - 65) && surface.mouseY <= 415 && surface.mouseY >= 385)) {
			reset();
		}
	}

	/**
	 * Serves to detect and interpret when a user drags their mouse
	 * @post sets isDragged to true; allows surface to be changed
	 */
	public void mouseDragged() {
		isDragged = true;
	}
	
	/** 
	 * Serves to detect and interpret when a user released their mouse
	 * @post sets isDragged to true
	 */
	public void mouseReleased() {
		
		if (isDragged) 
			isDragged = false;
	}
	
	/** 
	 * Serves to draw out the controls for the user to use (color changing)
	 */
	public void controlsSetUp() {
		surface.stroke(10, 10, 10);
		surface.rect(30, 30, 35, 35, 5);
		surface.fill(255);
		surface.text("Menu", 31, 31);
		
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
		
		surface.fill(220, 236, 199); //sage green reset
		surface.rect(1150, 400, 30, 30);
		surface.fill(0);
		surface.text("Reset", 1150, 405);
	}
	
	/**
	 * Serves to allow the user to reset any modifications on the screen (clear the surface)
	 * @post clears the surface and sets setBackground back to true
	 */
	public void reset() {
		setBackground = true;
	}
	
}