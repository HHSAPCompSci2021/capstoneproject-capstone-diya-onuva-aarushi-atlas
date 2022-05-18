import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;

/**
 * Creates multiple choice questions for the user to interact with
 * @author Diya Bengani
 *
 */
public class QuizMode extends Screen{

	private static int score;
	private ArrayList<String> unlocked;
	private ArrayList<String> countries;
	private DrawingSurface draw;
	private static Map map;
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
		draw.textSize(30);
		draw.fill(0, 0, 0);
		draw.text("QUIZ MODE", draw.width/2, draw.height/2 - 300);
		
		draw.textSize(20);
		
		draw.fill(169, 169, 169);
		draw.rect(900, 700, 50, 50); //Next button
		
		if (qRandomizer == 1)
		{
			draw.fill(0, 0, 0);
			draw.text("What is the capital of " + countries.get(correct) + "?", draw.width/2, draw.height/2 - 200);
		}
		else if (qRandomizer == 2)
		{
			draw.fill(0, 0, 0);
			draw.text("What region of Africa is " + countries.get(correct) + " located?", draw.width/2, draw.height/2 - 200);
		}
		else if (qRandomizer == 3)
		{
			draw.fill(0, 0, 0);
			draw.text("Where is " + countries.get(correct) + " located on the map featured below?", draw.width/2, draw.height/2 - 200);
		}
		
		if (qRandomizer == 3)
		{
			draw.image(draw.loadImage("fileData/map.png"), draw.width/2 - 200, draw.height/2 - (591f/2) + 150, 450, 500);
		}
		else
		{
			draw.fill(135, 206, 250);
			draw.rect(draw.width/2, draw.height/2 - 100, 350, 50);//A
			draw.rect(draw.width/2, draw.height/2, 350, 50); //B
			draw.rect(draw.width/2, draw.height/2 + 100, 350, 50); //C
			draw.rect(draw.width/2, draw.height/2 + 200, 350, 50);//D
			
			if (qRandomizer == 1)
			{
				randomizeCapital(draw);
			}
			else if (qRandomizer == 2)
			{
				randomizeLocation(draw);
			}
			
			//click on A
			if(draw.mousePressed && draw.mouseX <= (draw.width/2 + 175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 - 75) && (draw.height/2 - 125) <= draw.mouseY)
			{
				draw.fill(0, 191, 255);
				draw.rect(draw.width/2, draw.height/2 - 100, 350, 50);
				
				if (qRandomizer == 1)
				{
					if (ansRandomizer == 1)
					{
						draw.fill(51, 255, 51);
						draw.textSize(50);
						draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
						score++;
					}
				}
				else if (qRandomizer == 2)
				{
					if (ansRandomizer == 1)
					{
						draw.fill(51, 255, 51);
						draw.textSize(50);
						draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
						score++;
					}
				}
			}
					
			//click on B
			else if(draw.mousePressed && draw.mouseX <= (draw.width/2 + 175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 + 25) && (draw.height/2 - 25) <= draw.mouseY)
			{
				draw.fill(0, 191, 255);
				draw.rect(draw.width/2, draw.height/2, 350, 50); //Quiz
				
				if (qRandomizer == 1)
				{
					if (ansRandomizer == 2)
					{
						draw.fill(51, 255, 51);
						draw.textSize(50);
						draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
						score++;
					}
				}
				else if (qRandomizer == 2)
				{
					if (ansRandomizer == 2)
					{
						draw.fill(51, 255, 51);
						draw.textSize(50);
						draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
						score++;
					}
				}
			}
					
			//click on C
			else if(draw.mousePressed && draw.mouseX <= (draw.width/2 +175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 + 125) && (draw.height/2 + 75) <= draw.mouseY)
			{
				draw.fill(0, 191, 255);
				draw.rect(draw.width/2, draw.height/2 + 100, 350, 50); //Draw
				
				if (qRandomizer == 1)
				{
					if (ansRandomizer == 3)
					{
						draw.fill(51, 255, 51);
						draw.textSize(50);
						draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
						score++;
					}
				}
				else if (qRandomizer == 2)
				{
					if (ansRandomizer == 3)
					{
						draw.fill(51, 255, 51);
						draw.textSize(50);
						draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
						score++;
					}
				}
			}
			
			//click on D
			else if(draw.mousePressed && draw.mouseX <= (draw.width/2 +175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 + 225) && (draw.height/2 + 175) <= draw.mouseY)
			{
				draw.fill(0, 191, 255);
				draw.rect(draw.width/2, draw.height/2 + 200, 350, 50); //Draw
				
				if (qRandomizer == 1)
				{
					if (ansRandomizer == 4)
					{
						draw.fill(51, 255, 51);
						draw.textSize(50);
						draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
						score++;
					}
				}
				else if (qRandomizer == 2)
				{
					if (ansRandomizer == 4)
					{
						draw.fill(51, 255, 51);
						draw.textSize(50);
						draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
						score++;
					}
				}
			}
		}
		
		
		if (qRandomizer == 1)
		{
			randomizeCapital(draw);
		}
		else if (qRandomizer == 2)
		{
			randomizeLocation(draw);
		}
//		else if (qRandomizer == 3)
//		{
//			draw.image(draw.loadImage("fileData/map.png"), draw.width/2 - 200, draw.height/2 - (591f/2) + 150, 450, 500);
//		}
		
		if (qRandomizer == 3)
		{
			if (draw.mousePressed && countries.get(correct) == map.getCountry(draw, draw.mouseX, draw.mouseY))
			{
				draw.fill(51, 255, 51);
				draw.textSize(50);
				draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
				score++;
			}
		}
		
		//click on Next
		if (draw.mousePressed && draw.mouseX <= (925) && (875) <= draw.mouseX && draw.mouseY <= (725) && (675) <= draw.mouseY)
		{
			resetRandomize();
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
		
		draw.text("High Score: " + score, draw.width * 0.90f, draw.height * 0.1f);
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
	
	public void mouseClicked() {
//		if(draw.mouseX <= (draw.width/2 + 175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 - 75) && (draw.height/2 - 125) <= draw.mouseY)
//		{
//			draw.fill(0, 191, 255);
//			draw.rect(draw.width/2, draw.height/2 - 100, 350, 50);
//			
//			if (qRandomizer == 1)
//			{
//				if (ansRandomizer == 1)
//				{
//					draw.fill(51, 255, 51);
//					draw.textSize(50);
//					draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
//					score++;
//				}
//			}
//			else if (qRandomizer == 2)
//			{
//				if (ansRandomizer == 1)
//				{
//					draw.fill(51, 255, 51);
//					draw.textSize(50);
//					draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
//					score++;
//				}
//			}
//		}
//				
//		//click on B
//		else if(draw.mouseX <= (draw.width/2 + 175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 + 25) && (draw.height/2 - 25) <= draw.mouseY)
//		{
//			draw.fill(0, 191, 255);
//			draw.rect(draw.width/2, draw.height/2, 350, 50); //Quiz
//			
//			if (qRandomizer == 1)
//			{
//				if (ansRandomizer == 2)
//				{
//					draw.fill(51, 255, 51);
//					draw.textSize(50);
//					draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
//					score++;
//				}
//			}
//			else if (qRandomizer == 2)
//			{
//				if (ansRandomizer == 2)
//				{
//					draw.fill(51, 255, 51);
//					draw.textSize(50);
//					draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
//					score++;
//				}
//			}
//		}
//				
//		//click on C
//		else if(draw.mouseX <= (draw.width/2 +175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 + 125) && (draw.height/2 + 75) <= draw.mouseY)
//		{
//			draw.fill(0, 191, 255);
//			draw.rect(draw.width/2, draw.height/2 + 100, 350, 50); //Draw
//			
//			if (qRandomizer == 1)
//			{
//				if (ansRandomizer == 3)
//				{
//					draw.fill(51, 255, 51);
//					draw.textSize(50);
//					draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
//					score++;
//				}
//			}
//			else if (qRandomizer == 2)
//			{
//				if (ansRandomizer == 3)
//				{
//					draw.fill(51, 255, 51);
//					draw.textSize(50);
//					draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
//					score++;
//				}
//			}
//		}
//		
//		//click on D
//		else if(draw.mouseX <= (draw.width/2 +175) && (draw.width/2 - 175) <= draw.mouseX && draw.mouseY <= (draw.height/2 + 225) && (draw.height/2 + 175) <= draw.mouseY)
//		{
//			draw.fill(0, 191, 255);
//			draw.rect(draw.width/2, draw.height/2 + 200, 350, 50); //Draw
//			
//			if (qRandomizer == 1)
//			{
//				if (ansRandomizer == 4)
//				{
//					draw.fill(51, 255, 51);
//					draw.textSize(50);
//					draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
//					score++;
//				}
//			}
//			else if (qRandomizer == 2)
//			{
//				if (ansRandomizer == 4)
//				{
//					draw.fill(51, 255, 51);
//					draw.textSize(50);
//					draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
//					score++;
//				}
//			}
//		}
//		if (qRandomizer == 3)
//		{
//			if (countries.get(correct) == map.getCountry(draw, draw.mouseX, draw.mouseY))
//			{
//				draw.fill(51, 255, 51);
//				draw.textSize(50);
//				draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
//				score++;
//			}
//		}
//		
//		//click on Next
//		if (draw.mouseX <= (925) && (875) <= draw.mouseX && draw.mouseY <= (725) && (675) <= draw.mouseY)
//		{
//			resetRandomize();
//		}
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
	
	public void randomizeCapital(PApplet draw)
	{
		if (ansRandomizer == 1)
		{
			draw.fill(0, 0, 0);
			draw.textSize(20);
			draw.text("A: " + map.getCapital(countries.get(correct)), draw.width/2, draw.height/2 - 100);
			draw.text("B: " + map.getCapital(countries.get(rand1)), draw.width/2, draw.height/2); 
			draw.text("C: " + map.getCapital(countries.get(rand2)), draw.width/2, draw.height/2 + 100); 
			draw.text("D: " + map.getCapital(countries.get(rand3)), draw.width/2, draw.height/2 + 200);
		}
		else if(ansRandomizer == 2)
		{
			draw.fill(0, 0, 0);
			draw.textSize(20);
			draw.text("A: " + map.getCapital(countries.get(rand1)), draw.width/2, draw.height/2 - 100);
			draw.text("B: " + map.getCapital(countries.get(correct)), draw.width/2, draw.height/2); 
			draw.text("C: " + map.getCapital(countries.get(rand2)), draw.width/2, draw.height/2 + 100); 
			draw.text("D: " + map.getCapital(countries.get(rand3)), draw.width/2, draw.height/2 + 200);
		}
		else if(ansRandomizer == 3)
		{
			draw.fill(0, 0, 0);
			draw.textSize(20);
			draw.text("A: " + map.getCapital(countries.get(rand1)), draw.width/2, draw.height/2 - 100);
			draw.text("B: " + map.getCapital(countries.get(rand2)), draw.width/2, draw.height/2); 
			draw.text("C: " + map.getCapital(countries.get(correct)), draw.width/2, draw.height/2 + 100); 
			draw.text("D: " + map.getCapital(countries.get(rand3)), draw.width/2, draw.height/2 + 200);
		}
		else if(ansRandomizer == 4)
		{
			draw.fill(0, 0, 0);
			draw.textSize(20);
			draw.text("A: " + map.getCapital(countries.get(rand1)), draw.width/2, draw.height/2 - 100);
			draw.text("B: " + map.getCapital(countries.get(rand2)), draw.width/2, draw.height/2); 
			draw.text("C: " + map.getCapital(countries.get(rand3)), draw.width/2, draw.height/2 + 100); 
			draw.text("D: " + map.getCapital(countries.get(correct)), draw.width/2, draw.height/2 + 200);
		}
	}
	
	public void randomizeLocation(PApplet draw)
	{
		if (ansRandomizer == 1)
		{
			draw.fill(0, 0, 0);
			draw.textSize(20);
			draw.text("A: " + map.getRegion(countries.get(correct)), draw.width/2, draw.height/2 - 100);
			draw.text("B: " + map.getRegion(countries.get(rand1)), draw.width/2, draw.height/2); 
			draw.text("C: " + map.getRegion(countries.get(rand2)), draw.width/2, draw.height/2 + 100); 
			draw.text("D: " + map.getRegion(countries.get(rand3)), draw.width/2, draw.height/2 + 200);
		}
		else if(ansRandomizer == 2)
		{
			draw.fill(0, 0, 0);
			draw.textSize(20);
			draw.text("A: " + map.getRegion(countries.get(rand1)), draw.width/2, draw.height/2 - 100);
			draw.text("B: " + map.getRegion(countries.get(correct)), draw.width/2, draw.height/2); 
			draw.text("C: " + map.getRegion(countries.get(rand2)), draw.width/2, draw.height/2 + 100); 
			draw.text("D: " + map.getRegion(countries.get(rand3)), draw.width/2, draw.height/2 + 200);
		}
		else if(ansRandomizer == 3)
		{
			draw.fill(0, 0, 0);
			draw.textSize(20);
			draw.text("A: " + map.getRegion(countries.get(rand1)), draw.width/2, draw.height/2 - 100);
			draw.text("B: " + map.getRegion(countries.get(rand2)), draw.width/2, draw.height/2); 
			draw.text("C: " + map.getRegion(countries.get(correct)), draw.width/2, draw.height/2 + 100); 
			draw.text("D: " + map.getRegion(countries.get(rand3)), draw.width/2, draw.height/2 + 200);
		}
		else if(ansRandomizer == 4)
		{
			draw.fill(0, 0, 0);
			draw.textSize(20);
			draw.text("A: " + map.getRegion(countries.get(rand1)), draw.width/2, draw.height/2 - 100);
			draw.text("B: " + map.getRegion(countries.get(rand2)), draw.width/2, draw.height/2); 
			draw.text("C: " + map.getRegion(countries.get(rand3)), draw.width/2, draw.height/2 + 100); 
			draw.text("D: " + map.getRegion(countries.get(correct)), draw.width/2, draw.height/2 + 200);
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
