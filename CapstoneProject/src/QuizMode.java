import java.util.ArrayList;

import processing.core.PApplet;

/**
 * Creates multiple choice questions for the user to interact with
 * @author diya
 *
 */
public class QuizMode extends Map {

	private int score;
	private ArrayList<String> unlocked;
	private ArrayList<String> countries;
	private DrawingSurface surface;
	private Map map;
	private int correct;
	private int rand1;
	private int rand2;
	private int rand3;
	private int qRandomizer;
	private int ansRandomizer;
	
	/**
	 * populates countries arraylist, and sets default settings
	 */
	public QuizMode ()
	{
		map = new Map();
		
		countries = new ArrayList<String>();
		addCountries();
		
		correct = (int) (Math.random() * countries.size());
		rand1 = (int) (Math.random() * countries.size());
		rand2 = (int) (Math.random() * countries.size());
		rand3 = (int) (Math.random() * countries.size());
		
		ansRandomizer = (int) (Math.random() * 4 + 1);
		qRandomizer = (int) (Math.random() * 3 + 1);
	}
	
	/**
	 * Draws the question and title
	 * @param draw
	 */
	public void draw(PApplet draw) 
	{
		draw.background(255, 255, 224);
		
		draw.textSize(30);
		draw.fill(0, 0, 0);
		draw.text("QUIZ MODE", draw.width/2, draw.height/2 - 300);
		
		draw.textSize(20);
		
		if (qRandomizer == 1)
		{
			draw.text("What is the capital of " + countries.get(correct) + "?", draw.width/2, draw.height/2 - 200);
		}
		else if (qRandomizer == 2)
		{
			draw.text("What region of Africa is " + countries.get(correct) + " located?", draw.width/2, draw.height/2 - 200);
		}
		else if (qRandomizer == 3)
		{
			draw.text("Which picture represents " + countries.get(correct) + "?", draw.width/2, draw.height/2 - 200);
		}
		
		draw.fill(135, 206, 250);
		draw.rect(draw.width/2, draw.height/2 - 100, 350, 50);//A
		draw.rect(draw.width/2, draw.height/2, 350, 50); //B
		draw.rect(draw.width/2, draw.height/2 + 100, 350, 50); //C
		draw.rect(draw.width/2, draw.height/2 + 200, 350, 50);//D
		
		draw.fill(169, 169, 169);
		draw.rect(900, 700, 50, 50); //Next button
		
		draw.fill(169, 169, 169);
		draw.rect(900, 700, 50, 50);
		
		if (qRandomizer == 1)
		{
			randomizeCapital(draw);
		}
		else if (qRandomizer == 2)
		{
			randomizeLocation(draw);
		}
		else if (qRandomizer == 3)
		{
			randomizeImages(draw);
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
				}
			}
			else if (qRandomizer == 2)
			{
				if (ansRandomizer == 1)
				{
					draw.fill(51, 255, 51);
					draw.textSize(50);
					draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
				}
			}
			else if (qRandomizer == 3)
			{
				if (ansRandomizer == 1)
				{
					draw.fill(51, 255, 51);
					draw.textSize(50);
					draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
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
				}
			}
			else if (qRandomizer == 2)
			{
				if (ansRandomizer == 2)
				{
					draw.fill(51, 255, 51);
					draw.textSize(50);
					draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
				}
			}
			else if (qRandomizer == 3)
			{
				if (ansRandomizer == 2)
				{
					draw.fill(51, 255, 51);
					draw.textSize(50);
					draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
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
				}
			}
			else if (qRandomizer == 2)
			{
				if (ansRandomizer == 3)
				{
					draw.fill(51, 255, 51);
					draw.textSize(50);
					draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
				}
			}
			else if (qRandomizer == 3)
			{
				if (ansRandomizer == 3)
				{
					draw.fill(51, 255, 51);
					draw.textSize(50);
					draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
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
				}
			}
			else if (qRandomizer == 2)
			{
				if (ansRandomizer == 4)
				{
					draw.fill(51, 255, 51);
					draw.textSize(50);
					draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
				}
			}
			else if (qRandomizer == 3)
			{
				if (ansRandomizer == 4)
				{
					draw.fill(51, 255, 51);
					draw.textSize(50);
					draw.text("Correct!", draw.width/2 - 400, draw.height/2 - 300);
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
		else if (qRandomizer == 3)
		{
			randomizeImages(draw);
		}
		
		//click on Next
		if (draw.mousePressed && draw.mouseX <= (925) && (875) <= draw.mouseX && draw.mouseY <= (725) && (675) <= draw.mouseY)
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
			draw.text("A: " + map.getLocation(countries.get(correct)), draw.width/2, draw.height/2 - 100);
			draw.text("B: " + map.getLocation(countries.get(rand1)), draw.width/2, draw.height/2); 
			draw.text("C: " + map.getLocation(countries.get(rand2)), draw.width/2, draw.height/2 + 100); 
			draw.text("D: " + map.getLocation(countries.get(rand3)), draw.width/2, draw.height/2 + 200);
		}
		else if(ansRandomizer == 2)
		{
			draw.fill(0, 0, 0);
			draw.textSize(20);
			draw.text("A: " + map.getLocation(countries.get(rand1)), draw.width/2, draw.height/2 - 100);
			draw.text("B: " + map.getLocation(countries.get(correct)), draw.width/2, draw.height/2); 
			draw.text("C: " + map.getLocation(countries.get(rand2)), draw.width/2, draw.height/2 + 100); 
			draw.text("D: " + map.getLocation(countries.get(rand3)), draw.width/2, draw.height/2 + 200);
		}
		else if(ansRandomizer == 3)
		{
			draw.fill(0, 0, 0);
			draw.textSize(20);
			draw.text("A: " + map.getLocation(countries.get(rand1)), draw.width/2, draw.height/2 - 100);
			draw.text("B: " + map.getLocation(countries.get(rand2)), draw.width/2, draw.height/2); 
			draw.text("C: " + map.getLocation(countries.get(correct)), draw.width/2, draw.height/2 + 100); 
			draw.text("D: " + map.getLocation(countries.get(rand3)), draw.width/2, draw.height/2 + 200);
		}
		else if(ansRandomizer == 4)
		{
			draw.fill(0, 0, 0);
			draw.textSize(20);
			draw.text("A: " + map.getLocation(countries.get(rand1)), draw.width/2, draw.height/2 - 100);
			draw.text("B: " + map.getLocation(countries.get(rand2)), draw.width/2, draw.height/2); 
			draw.text("C: " + map.getLocation(countries.get(rand3)), draw.width/2, draw.height/2 + 100); 
			draw.text("D: " + map.getLocation(countries.get(correct)), draw.width/2, draw.height/2 + 200);
		}
	}
	
	public void randomizeImages(PApplet draw)
	{
		if (ansRandomizer == 1)
		{
			draw.fill(0, 0, 0);
			draw.textSize(20);
			draw.text("A: " + map.getPics(countries.get(correct)), draw.width/2, draw.height/2 - 100);
			draw.text("B: " + map.getPics(countries.get(rand1)), draw.width/2, draw.height/2); 
			draw.text("C: " + map.getPics(countries.get(rand2)), draw.width/2, draw.height/2 + 100); 
			draw.text("D: " + map.getPics(countries.get(rand3)), draw.width/2, draw.height/2 + 200);
		}
		else if(ansRandomizer == 2)
		{
			draw.fill(0, 0, 0);
			draw.textSize(20);
			draw.text("A: " + map.getPics(countries.get(rand1)), draw.width/2, draw.height/2 - 100);
			draw.text("B: " + map.getPics(countries.get(correct)), draw.width/2, draw.height/2); 
			draw.text("C: " + map.getPics(countries.get(rand2)), draw.width/2, draw.height/2 + 100); 
			draw.text("D: " + map.getPics(countries.get(rand3)), draw.width/2, draw.height/2 + 200);
		}
		else if(ansRandomizer == 3)
		{
			draw.fill(0, 0, 0);
			draw.textSize(20);
			draw.text("A: " + map.getPics(countries.get(rand1)), draw.width/2, draw.height/2 - 100);
			draw.text("B: " + map.getPics(countries.get(rand2)), draw.width/2, draw.height/2); 
			draw.text("C: " + map.getPics(countries.get(correct)), draw.width/2, draw.height/2 + 100); 
			draw.text("D: " + map.getPics(countries.get(rand3)), draw.width/2, draw.height/2 + 200);
		}
		else if(ansRandomizer == 4)
		{
			draw.fill(0, 0, 0);
			draw.textSize(20);
			draw.text("A: " + map.getPics(countries.get(rand1)), draw.width/2, draw.height/2 - 100);
			draw.text("B: " + map.getPics(countries.get(rand2)), draw.width/2, draw.height/2); 
			draw.text("C: " + map.getPics(countries.get(rand3)), draw.width/2, draw.height/2 + 100); 
			draw.text("D: " + map.getPics(countries.get(correct)), draw.width/2, draw.height/2 + 200);
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
