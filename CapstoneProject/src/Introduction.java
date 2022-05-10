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
	}
	
	public void mouseClicked()
	{
		
	}
}
