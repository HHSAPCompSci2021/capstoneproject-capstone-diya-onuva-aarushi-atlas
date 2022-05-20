import java.util.ArrayList;
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
	private ArrayList<String> countries;
	
	public DrawingMode(DrawingSurface draw) {

		super(1200, 750);
		this.surface = draw;
		isDragged = false;
		setBackground = true;
		
		countries = new ArrayList<String>();
		addCountries();
		
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
	
	public void reset() {
		setBackground = true;
	}
	
	public void addCountries()
	{
		countries.add("The Gambia");
		countries.add("Liberia");
		countries.add("Benin");
		countries.add("Egypt");
		countries.add("Zimbabwe");
		countries.add("Ghana");
		countries.add("Gabon");
		countries.add("South Africa");
		countries.add("Eritrea");
		countries.add("Sengal");
		countries.add("Burkina Faso");
		countries.add("Somalia");
		countries.add("Mozambique");
		countries.add("The Comoros");
		countries.add("Madagascar");
		countries.add("Angola");
		countries.add("Uganda");
		countries.add("Morocco");
		countries.add("Western Sahara");
		countries.add("Algeria");
		countries.add("Libya");
		countries.add("Sudan");
		countries.add("Tunisia");
		countries.add("Ethiopia");
		countries.add("Kenya");
		countries.add("Tanzania");
		countries.add("Malawi");
		countries.add("Zambia");
		countries.add("Eswatini");
		countries.add("Djibouti");
		countries.add("Lesotho");
		countries.add("Botswana");
		countries.add("Namibia");
		countries.add("Central African Republic");
		countries.add("Republic of the Congo");
		countries.add("Equatorial Guinea");
		countries.add("Democratic Republic of the Congo");
		countries.add("Cameroon");
		countries.add("Rwanda");
		countries.add("Burundi");
		countries.add("Chad");
		countries.add("Niger");
		countries.add("Mali");
		countries.add("Mauritania");
		countries.add("Guinea");
		countries.add("Nigeria");
		countries.add("Togo");
		countries.add("South Sudan");
		countries.add("Guinea-Bissau");
		countries.add("Sierra Leone");
		countries.add("Côte D'Ivore");
	}

}