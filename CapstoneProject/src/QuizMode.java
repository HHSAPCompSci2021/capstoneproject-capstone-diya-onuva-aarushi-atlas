import java.util.ArrayList;

import processing.core.PApplet;

public class QuizMode extends Screen{

	int score;
	ArrayList<String> unlocked;
	ArrayList<String> countries;
	private DrawingSurface surface;
	
	public QuizMode ()
	{
		countries = new ArrayList<String>();
		
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
	
	public void keyPressed ()
	{
		
	}

	public void draw(PApplet draw) 
	{
		draw.background(255, 255, 224);
		
		draw.textSize(30);
		draw.text("QUIZ MODE", draw.width/2, draw.height/2 - 300);
		
		draw.textSize(12);
		int rand = (int) (Math.random() * countries.size() + 1);
		
		draw.text("What is the capitol of " + countries.get(rand), draw.width/2, draw.height/2);
	}
}
