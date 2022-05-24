import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;

/**
 * Creates multiple choice questions for the user to interact with in order to learn fun and fast facts about each country.
 * Also contains a point system and incorrect/correct system, and is a screen
 * @author Diya Bengani
 *
 */
public class QuizMode extends Screen{

	private static int score;
	private double n;
	private boolean clicked;
	private ArrayList<String> countries;
	private DrawingSurface draw;
	private static Map map;
	private PFont myFont;
	private int correct;
	private boolean foo, foo2;
	private int r;
	private int rand1;
	private int rand2;
	private int rand3;
	private int qRandomizer;
	private int ansRandomizer;
	private static String highScore;
	private float x, y;
	
	/**
	 * Populates countries (Arraylist), initializes fields, and sets default settings
	 * @param draw of type DrawingSurface
	 */
	public QuizMode (DrawingSurface draw)
	{
		super(1200, 750);
		map = new Map();
		
		this.draw = draw;
		
		countries = new ArrayList<String>();
		addCountries();
		
		correct = (int) (Math.random() * countries.size());
		rand1 = (int) (Math.random() * countries.size());
		rand2 = (int) (Math.random() * countries.size());
		rand3 = (int) (Math.random() * countries.size());
		
		ansRandomizer = (int) (Math.random() * 4 + 1);
		qRandomizer = (int) (Math.random() * 3 + 1);
		
		score = 0;
		highScore = "fileData/HighScore";
		
		clicked = false;
		x = -1;
		y = -1;
		n = 0;
		
		r = 1;
		foo = false;
		foo2 = false;
	}
	
	/**
	 * Draws the randomized questions and title
	 * @param draw
	 * @post Modifies the draw (drawing surface)
	 * @post changes rectangles and text to be draw from the center
	 */
	public void draw() 
	{
		draw.background(255, 255, 255);
		map.changeSettings(draw.width/2 - 200, draw.height/2 - (591f/2) + 150, 450, 500);
		
		if (draw.mousePressed && x < 0 && y < 0) 
		{
			x = draw.mouseX;
			y = draw.mouseY;
		}
		
		else if (!draw.mousePressed) {
			x = -1;
			y = -1;
		}
		
		draw.textAlign(PConstants.CENTER);
		draw.rectMode(PConstants.CENTER);
		
		myFont = draw.createFont("Times New Roman", 18);
		draw.textFont(myFont);
		draw.noStroke();		
		draw.textSize(30);
		
		//Back button
		if (draw.mousePressed && x <= draw.width * 0.05f + draw.height * 0.05f && x >= draw.width * 0.05f - draw.height * 0.05f && y <= draw.height * 0.13f && y >= draw.height * 0.03f) 
		{
			draw.fill(30, 120, 0);
			draw.ellipse(draw.width * 0.05f, draw.height * 0.08f, draw.height * 0.1f * (2f/3f), draw.height * 0.1f * (2f/3f)); //Back button
			draw.image(draw.loadImage("fileData/smallHouse.png"), draw.width * 0.035f, draw.height * 0.0575f);
		}
		else {
			draw.fill(50, 140, 5);
			draw.ellipse(draw.width * 0.05f, draw.height * 0.08f, draw.height * 0.1f, draw.height * 0.1f); //Back button
			draw.image(draw.loadImage("fileData/house.png"), draw.width * 0.03f, draw.height * 0.05f);
		}
		
		
		if (qRandomizer == 1)
		{
			draw.fill(0, 0, 0);
			draw.text("What is the capital of " + countries.get(correct) + "?", draw.width/2, draw.height/2 - 300);
		}
		else if (qRandomizer == 2)
		{
			draw.fill(0, 0, 0);
			draw.text("What region of Africa is " + countries.get(correct) + " located?", draw.width/2, draw.height/2 - 300);
		}
		else if (qRandomizer == 3)
		{
			draw.fill(0, 0, 0);
			draw.text("Where is " + countries.get(correct) + " located on the map featured below?", draw.width/2, draw.height/2 - 300);
		}
		
		if (qRandomizer == 3)
		{
			draw.image(draw.loadImage("fileData/map.png"), draw.width/2 - 200, draw.height/2 - (591f/2) + 50, 470, 520);
		}
		else
		{
			draw.fill(178, 172, 136);
			draw.rect(draw.width/2, draw.height/2 - 100, 350, 50, 5);// A
			draw.rect(draw.width/2, draw.height/2, 350, 50, 5); // B
			draw.rect(draw.width/2, draw.height/2 + 100, 350, 50, 5); // C
			draw.rect(draw.width/2, draw.height/2 + 200, 350, 50, 5);// D
			
			if (qRandomizer == 1)
			{
				randomizeCapital(draw);
			}
			else if (qRandomizer == 2)
			{
				draw.rect(draw.width/2, draw.height/2 - 200, 350, 50, 5); // E
				selectLocation(draw);
			}
		}
		
		if(draw.mousePressed && draw.mouseX <= (draw.width/2 + 175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 - 75) && (draw.height/2 - 125) <= draw.mouseY)
		{
			
			if (qRandomizer == 1)
			{
				if (ansRandomizer == 1)
				{
					draw.fill(46, 139, 87);
					draw.rect(draw.width/2, draw.height/2 - 100, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					foo = true;
					foo2 = true;
					
					
				}
				else
				{
					draw.fill(220, 20, 60);
					draw.rect(draw.width/2, draw.height/2 - 100, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					foo = true;
				}
			}
			else if (qRandomizer == 2)
			{
				if ("North Africa".equals(map.getRegion(countries.get(correct))))
				{
					draw.fill(46, 139, 87);
					draw.rect(draw.width/2, draw.height/2 - 100, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					foo = true;

					foo2 = true;
					
				}
				else
				{
					draw.fill(220, 20, 60);
					draw.rect(draw.width/2, draw.height/2 - 100, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					foo = true;
				}
			}
		}
				
		//click on B
		else if(draw.mousePressed && draw.mouseX <= (draw.width/2 + 175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 + 25) && (draw.height/2 - 25) <= draw.mouseY)
		{
			
			if (qRandomizer == 1)
			{
				if (ansRandomizer == 2)
				{
					draw.fill(46, 139, 87);
					draw.rect(draw.width/2, draw.height/2, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					foo = true;
					foo2 = true;
					
					
				}
				else
				{
					draw.fill(220, 20, 60);
					draw.rect(draw.width/2, draw.height/2, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					foo = true;
				}
			}
			else if (qRandomizer == 2)
			{
				if ("South Africa".equals(map.getRegion(countries.get(correct))))
				{
					draw.fill(46, 139, 87);
					draw.rect(draw.width/2, draw.height/2, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					foo = true;
					foo2 = true;
					
					
				}
				else
				{
					draw.fill(220, 20, 60);
					draw.rect(draw.width/2, draw.height/2, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					foo = true;
				}
			}
		}
				
		//click on C
		else if(draw.mousePressed && draw.mouseX <= (draw.width/2 +175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 + 125) && (draw.height/2 + 75) <= draw.mouseY)
		{
			
			if (qRandomizer == 1)
			{
				if (ansRandomizer == 3)
				{
					draw.fill(46, 139, 87);
					draw.rect(draw.width/2, draw.height/2 + 100, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					foo = true;
					foo2 = true;
					
					
				}
				else
				{
					draw.fill(220, 20, 60);
					draw.rect(draw.width/2, draw.height/2 + 100, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					foo = true;
				}
			}
			else if (qRandomizer == 2)
			{
				if ("East Africa".equals(map.getRegion(countries.get(correct))))
				{
					draw.fill(46, 139, 87);
					draw.rect(draw.width/2, draw.height/2 + 100, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					foo = true;
					foo2 = true;
					
					
				}
				else
				{
					draw.fill(220, 20, 60);
					draw.rect(draw.width/2, draw.height/2 + 100, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					foo = true;
				}
			}
		}
		
		//click on D
		else if(draw.mousePressed && draw.mouseX <= (draw.width/2 +175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 + 225) && (draw.height/2 + 175) <= draw.mouseY)
		{
			
			if (qRandomizer == 1)
			{
				if (ansRandomizer == 4)
				{
					draw.fill(46, 139, 87);
					draw.rect(draw.width/2, draw.height/2 + 200, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					foo = true;
					foo2 = true;
					
					
				}
				else
				{
					draw.fill(220, 20, 60);
					draw.rect(draw.width/2, draw.height/2 + 200, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					foo = true;
				}
			}
			else if (qRandomizer == 2)
			{
				if ("West Africa".equals(map.getRegion(countries.get(correct))))
				{
					draw.fill(46, 139, 87);
					draw.rect(draw.width/2, draw.height/2 + 200, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					foo = true;
					foo2 = true;
					
					
				}
				else
				{
					draw.fill(220, 20, 60);
					draw.rect(draw.width/2, draw.height/2 + 200, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					foo = true;
				}
			}
		}
		
		if (qRandomizer == 2)
		{
			//E
			if(draw.mousePressed && draw.mouseX <= (draw.width/2 + 175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 - 175) && (draw.height/2 - 225) <= draw.mouseY)
			{
				if ("Central Africa".equals(map.getRegion(countries.get(correct))))
					{
						draw.fill(46, 139, 87);
						draw.rect(draw.width/2, draw.height/2 - 200, 350, 50, 5);
						draw.fill(0);
						draw.textSize(15);
						foo = true;
						foo2 = true;
						
						
					}
					else
					{
						draw.fill(220, 20, 60);
						draw.rect(draw.width/2, draw.height/2 - 200, 350, 50, 5);
						draw.fill(0);
						draw.textSize(15);
						foo = true;
					}
				}
			}
		
		String country = map.getCountry(draw, draw.mouseX, draw.mouseY);
		
		if (qRandomizer == 1)
		{
			randomizeCapital(draw);
		}
		else if (qRandomizer == 2)
		{
			selectLocation(draw);
		}
		
		if (draw.mousePressed && draw.mouseX <= 75 && draw.mouseX >= 25 && draw.mouseY >= 25 && draw.mouseY <= 75) 
		{
			draw.switchScreen(ScreenSwitcher.MENU_SCREEN);
		}
		
		if (qRandomizer == 3)
		{
			draw.image(draw.loadImage("fileData/download.png"), draw.width/2 - 200, draw.height/2 - (591f/2) + 50, 470, 520);
		}
		
		
		if (draw.mousePressed && qRandomizer == 3)
		{
			if (countries.get(correct).equals(country))
			{
				draw.fill(51, 255, 51);
				draw.stroke(0);
				draw.circle(draw.mouseX, draw.mouseY, 20);
				foo = true;
				foo2 = true;
				
				
			}
			else
			{
				draw.fill(255, 51, 51);
				draw.stroke(0);
				draw.circle(draw.mouseX, draw.mouseY, 20);
				foo = true;
			}
		}
		
		
		
		try {
			if (Integer.parseInt(map.readFile(highScore)) < score) {
				FileWriter writer = new FileWriter(new File(highScore));
				writer.write(Integer.toString(score));
				writer.close();
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
		draw.fill(50, 140, 5);
		draw.rect(1100, draw.height/2 - 307, 100, 45, 10);
		
		draw.fill(50, 140, 5);
		draw.rect(1100, draw.height/2 - 258, 155, 45, 10);
		
		draw.fill(255);
		draw.textFont(myFont);
		draw.textSize(25);
		draw.noStroke();
		draw.text("Score: " + score, 1100, draw.height/2 - 300);
		
		draw.fill(255);
		draw.textFont(myFont);
		draw.textSize(25);
		draw.noStroke();
		try {
			draw.text("High Score: " + getHighScore(), 1100, draw.height/2 - 250);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (foo) 
		{
			n += 0.04;
			r++;
		}
		
		if (n >= 1) 
		{
			if(foo2)score++;
			resetRandomize();
		}
		
	}
	
	/**
	 * Gets the high score of the game
	 * @return the high score
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int getHighScore() throws NumberFormatException, IOException
	{
		return Integer.parseInt(map.readFile(highScore));
	}
	
	/**
	 * Interprets and carries out actions when mouse is clicked
	 * @post if certain, indicated button is called, current displayed question is randomized and changed 
	 */
	public void mouseClicked() 
	{
		clicked = true;
		

		if (draw.mouseX <= draw.width * 0.05f + draw.height * 0.05f 
				&& draw.mouseX >= draw.width * 0.05f - draw.height * 0.05f 
				&& draw.mouseY <= draw.height * 0.13f && draw.mouseY >= draw.height * 0.03f
				&& x <= draw.width * 0.05f + draw.height * 0.05f 
				&& x >= draw.width * 0.05f - draw.height * 0.05f 
				&& y <= draw.height * 0.13f && y >= draw.height * 0.03f)
			draw.switchScreen(ScreenSwitcher.MENU_SCREEN);
	}
	
	/**
	 *  Purpose is to randomize questions order for the user to answer
	 *  @post score changes 
	 */
	public void resetRandomize()
	{
		foo = false;
		foo2 = false;
		n = 0;
		
		int newRandomizer = (int) (Math.random() * 4 + 1);
		
		if (ansRandomizer != newRandomizer)
		{
			ansRandomizer = newRandomizer;
		}
		else
		{
			resetRandomize();
		}
		
		qRandomizer = (int) (Math.random() * 3 + 1);
		correct = (int) (Math.random() * countries.size());
		rand1 = (int) (Math.random() * countries.size());
		rand2 = (int) (Math.random() * countries.size());
		rand3 = (int) (Math.random() * countries.size());
	}
	
	/**
	 * Purpose is to indicate answer options for questions regarding location
	 * @param draw of type PApplet
	 * 
	 */
	public void selectLocation(PApplet draw)
	{
		draw.fill(0, 0, 0);
		draw.textSize(20);
		
		draw.text("Central Africa", draw.width/2, (float) (draw.height/2 - 200 + 20.0/3));
		draw.text("North Africa", draw.width/2, (float) (draw.height/2 - 100 + 20.0/3));
		draw.text("South Africa", draw.width/2, (float) (draw.height/2 + 20.0/3)); 
		draw.text("East Africa", draw.width/2, (float) (draw.height/2 + 100 + 20.0/3)); 
		draw.text("West Africa", draw.width/2, (float) (draw.height/2 + 200 + 20.0/3));
	}
	
	/**
	 * @param draw of type PApplet
	 * @post randomizes answer order for each question
	 * 
	 */
	public void randomizeCapital(PApplet draw)
	{
		if (ansRandomizer == 1)
		{
			draw.fill(0, 0, 0);
			draw.textSize(20);
			draw.text(map.getCapital(countries.get(correct)), draw.width/2, (float) (draw.height/2 - 100 + 20.0/3));
			draw.text(map.getCapital(countries.get(rand1)), draw.width/2, (float) (draw.height/2 + 20.0/3)); 
			draw.text(map.getCapital(countries.get(rand2)), draw.width/2, (float) (draw.height/2 + 100 + 20.0/3)); 
			draw.text(map.getCapital(countries.get(rand3)), draw.width/2, (float) (draw.height/2 + 200 + 20.0/3));
		}
		else if(ansRandomizer == 2)
		{
			draw.fill(0, 0, 0);
			draw.textSize(20);
			draw.text(map.getCapital(countries.get(rand1)), draw.width/2, (float) (draw.height/2 - 100 + 20.0/3));
			draw.text(map.getCapital(countries.get(correct)), draw.width/2, (float) (draw.height/2 + 20.0/3)); 
			draw.text(map.getCapital(countries.get(rand2)), draw.width/2, (float) (draw.height/2 + 100 + 20.0/3)); 
			draw.text(map.getCapital(countries.get(rand3)), draw.width/2, (float) (draw.height/2 + 200 + 20.0/3));
		}
		else if(ansRandomizer == 3)
		{
			draw.fill(0, 0, 0);
			draw.textSize(20);
			draw.text(map.getCapital(countries.get(rand1)), draw.width/2, (float) (draw.height/2 - 100 + 20.0/3));
			draw.text(map.getCapital(countries.get(rand2)), draw.width/2, (float) (draw.height/2 + 20.0/3)); 
			draw.text(map.getCapital(countries.get(correct)), draw.width/2, (float) (draw.height/2 + 100 + 20.0/3)); 
			draw.text(map.getCapital(countries.get(rand3)), draw.width/2, (float) (draw.height/2 + 200 + 20.0/3));
		}
		else if(ansRandomizer == 4)
		{
			draw.fill(0, 0, 0);
			draw.textSize(20);
			draw.text(map.getCapital(countries.get(rand1)), draw.width/2, (float) (draw.height/2 - 100 + 20.0/3));
			draw.text(map.getCapital(countries.get(rand2)), draw.width/2, (float) (draw.height/2 + 20.0/3)); 
			draw.text(map.getCapital(countries.get(rand3)), draw.width/2, (float) (draw.height/2 + 100 + 20.0/3)); 
			draw.text(map.getCapital(countries.get(correct)), draw.width/2, (float) (draw.height/2 + 200 + 20.0/3));
		}
	}
	
	/**
	 * Adds countries to the countries Arraylist
	 */
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
