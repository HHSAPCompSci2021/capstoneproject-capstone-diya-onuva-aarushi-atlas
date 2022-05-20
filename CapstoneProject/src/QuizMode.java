import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;

/**
 * Creates multiple choice questions for the user to interact with
 * @author Diya Bengani
 *
 */
public class QuizMode extends Screen{

	private static int score;
	private boolean clicked = false;
	private ArrayList<String> countries;
	private DrawingSurface draw;
	private static Map map;
	private PFont myFont;
	private int correct;
	private int rand1;
	private int rand2;
	private int rand3;
	private int qRandomizer;
	private int ansRandomizer;
	private static String highScore;
	
	/**
	 * populates countries arraylist, and sets default settings
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
	}
	
	/**
	 * Draws the question and title
	 * @param draw
	 */
	public void draw() 
	{
		draw.background(255, 255, 255);
		map.changeSettings(draw.width/2 - 200, draw.height/2 - (591f/2) + 150, 450, 500);
		
		draw.textAlign(PConstants.CENTER);
		draw.rectMode(PConstants.CENTER);
		
		myFont = draw.createFont("Times New Roman", 18);
		draw.textFont(myFont);
		draw.noStroke();		
		draw.textSize(30);
		
		draw.fill(169, 169, 169);
		draw.rect(900, 700, 50, 50); //Next button
		
		draw.fill(169, 169, 169);
		draw.rect(50, 50, 50, 50); //Back button
		
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
			draw.fill(50, 235, 190);
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
					draw.fill(51, 255, 51);
					draw.rect(draw.width/2, draw.height/2 - 100, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					score++;
				}
				else
				{
					draw.fill(255, 51, 51);
					draw.rect(draw.width/2, draw.height/2 - 100, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
				}
			}
			else if (qRandomizer == 2)
			{
				if ("North Africa".equals(map.getRegion(countries.get(correct))))
				{
					draw.fill(51, 255, 51);
					draw.rect(draw.width/2, draw.height/2 - 100, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					score++;
				}
				else
				{
					draw.fill(255, 51, 51);
					draw.rect(draw.width/2, draw.height/2 - 100, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
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
					draw.fill(51, 255, 51);
					draw.rect(draw.width/2, draw.height/2, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					score++;
				}
				else
				{
					draw.fill(255, 51, 51);
					draw.rect(draw.width/2, draw.height/2, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
				}
			}
			else if (qRandomizer == 2)
			{
				if ("South Africa".equals(map.getRegion(countries.get(correct))))
				{
					draw.fill(51, 255, 51);
					draw.rect(draw.width/2, draw.height/2, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					score++;
				}
				else
				{
					draw.fill(255, 51, 51);
					draw.rect(draw.width/2, draw.height/2, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
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
					draw.fill(51, 255, 51);
					draw.rect(draw.width/2, draw.height/2 + 100, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					score++;
				}
				else
				{
					draw.fill(255, 51, 51);
					draw.rect(draw.width/2, draw.height/2 + 100, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
				}
			}
			else if (qRandomizer == 2)
			{
				if ("East Africa".equals(map.getRegion(countries.get(correct))))
				{
					draw.fill(51, 255, 51);
					draw.rect(draw.width/2, draw.height/2 + 100, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					score++;
				}
				else
				{
					draw.fill(255, 51, 51);
					draw.rect(draw.width/2, draw.height/2 + 100, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
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
					draw.fill(51, 255, 51);
					draw.rect(draw.width/2, draw.height/2 + 200, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					score++;
				}
				else
				{
					draw.fill(255, 51, 51);
					draw.rect(draw.width/2, draw.height/2 + 200, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
				}
			}
			else if (qRandomizer == 2)
			{
				if ("West Africa".equals(map.getRegion(countries.get(correct))))
				{
					draw.fill(51, 255, 51);
					draw.rect(draw.width/2, draw.height/2 + 200, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
					score++;
				}
				else
				{
					draw.fill(255, 51, 51);
					draw.rect(draw.width/2, draw.height/2 + 200, 350, 50, 5);
					draw.fill(0);
					draw.textSize(15);
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
						draw.fill(51, 255, 51);
						draw.rect(draw.width/2, draw.height/2 - 200, 350, 50, 5);
						draw.fill(0);
						draw.textSize(15);
						score++;
					}
					else
					{
						draw.fill(255, 51, 51);
						draw.rect(draw.width/2, draw.height/2 - 200, 350, 50, 5);
						draw.fill(0);
						draw.textSize(15);
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
				score++;
			}
			else
			{
				draw.fill(255, 51, 51);
				draw.stroke(0);
				draw.circle(draw.mouseX, draw.mouseY, 20);
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
		
		draw.fill(0, 0, 0);
		draw.textFont(myFont);
		draw.textSize(25);
		draw.noStroke();
		draw.text("Score: " + score, 1100, draw.height/2 - 300);
	}
	
	/**
	 * gets the high score of the game
	 * 
	 * @return high score
	 */
	public int getHighScore()
	{
		return score;
	}
	
	public void mouseClicked() 
	{
		//click on Next
		if (draw.mouseX <= (925) && (875) <= draw.mouseX && draw.mouseY <= (725) && (675) <= draw.mouseY)
		{
			resetRandomize();
		}
	}
	
	public void resetRandomize()
	{
		
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
	 * adds countries to the countries arraylist
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
		countries.add("The Comoros");
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
