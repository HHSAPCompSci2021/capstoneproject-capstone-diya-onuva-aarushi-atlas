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
//	private ArrayList<String> countries;
	
	/**
	 * @param draw of type DrawingSurface
	 * Constructor and initializes fields 
	 */
	public DrawingMode(DrawingSurface draw) {
		super(1200, 750);
		this.surface = draw;
		
		isDragged = false;
		setBackground = true;
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
			red();
			surface.line(surface.pmouseX, surface.pmouseY, surface.mouseX, surface.mouseY);
		}
		
		if(surface.mousePressed && surface.mouseX <= 60 && surface.mouseX >= 30 && surface.mouseY <= 60 && surface.mouseY >= 30) {
			setBackground = true;
			surface.switchScreen(ScreenSwitcher.MENU_SCREEN);
		}
		
		surface.stroke(100, 100, 100);
	}
	
	/**
	 * Serves to detect and interpret when and where a user clicks on the screen
	 * @post if a certain button is clicked, background changes
	 * @post if a certain button is clicked, surface changes
	 */
	public void mouseClicked() {
		
		if (surface.mouseX <= 60 && surface.mouseX >= 30 && surface.mouseY <= 60 && surface.mouseY >= 30) {
//			surface.background(255);
			setBackground = true;
		}
		
		if((surface.mouseX <= (DRAWING_WIDTH - 35) && surface.mouseX >= (DRAWING_WIDTH - 65) && surface.mouseY <= 65 && surface.mouseY >= 35)) {
			surface.rect(150,  150,  100,  100);
			red();
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
		if (isDragged) {
			isDragged = false;
		}
	}
	
	/** 
	 * Serves to draw out the controls for the user to use (color changing)
	 */
	public void controlsSetUp() {
		surface.stroke(0);
		surface.rect(30, 30, 30, 30);
		
		surface.fill(203, 32, 40); //red
		surface.rect(DRAWING_WIDTH - 50, 50, 30, 30);
		
		surface.fill(205, 99, 41); //orange
		surface.rect(DRAWING_WIDTH - 50, 100, 30, 30);
		
		surface.fill(204, 162, 42); //yellow
		surface.rect(DRAWING_WIDTH - 50, 150, 30, 30);
		
		surface.fill(19, 2139, 6); //green
		surface.rect(DRAWING_WIDTH - 50, 200, 30, 30);
		
		surface.fill(9, 77, 140); //blue
		surface.rect(DRAWING_WIDTH - 50, 250, 30, 30);
		
		surface.fill(81, 42, 123); //purple
		surface.rect(DRAWING_WIDTH - 50, 300, 30, 30);
		surface.fill(0);
	}
	
	/**
	 * sets the paint color to red
	 */
	public void red() {
		surface.stroke(255, 0, 0);
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
	
	/**
	 * Serves to allow the user to reset any modifications on the screen (clear the surface)
	 * @post clears the surface and sets setBackground back to true
	 */
	public void reset() {
		setBackground = true;
	}
	
}