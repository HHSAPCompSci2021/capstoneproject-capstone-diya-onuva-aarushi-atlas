import java.awt.Image;

import processing.core.PApplet;

public class Introduction {

	String image;
	
	public Introduction(String i)
	{
		image = i;
	}
	
	public void draw(PApplet draw) {
		
		draw.image(draw.loadImage(image), 0, 0);
		draw.fill(220,220,220);
		draw.rectMode(draw.CENTER);
		draw.rect(draw.width/2, draw.height/2, 150, 75, 10);
		
		draw.textMode(draw.CENTER);
		draw.text("Play", draw.width/2, draw.height/2);
	}
	
	public void mouseClicked()
	{
		
	}
}
