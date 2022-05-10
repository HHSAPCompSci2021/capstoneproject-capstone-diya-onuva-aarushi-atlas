import java.awt.Image;

import processing.core.PApplet;
import processing.core.PConstants;

public class Introduction {

	String image;
	int textSize;
	float bWidth, bHeight;
	boolean pressed;
	
	public Introduction(String i)
	{
		image = i;
		textSize = 45;
		bWidth = 150;
		bHeight = 75;
		pressed = false;
	}
	
	public void draw(PApplet draw) {
		if(draw.mousePressed && draw.mouseX <= draw.width/2 + bWidth/2 && draw.mouseX >= draw.width/2 - bWidth/2 && draw.mouseY <= draw.height/2 + bHeight/2 && draw.mouseY >= draw.height/2 - bHeight/2) {
			pressed = true;
			DrawingSurface.switchToMenu();
		}
		if(pressed) {
			bWidth = 130;
			bHeight = 70;
			textSize = 40;
		}
		else {
			bWidth = 150;
			bHeight = 75;
			textSize = 45;
		}
		
		draw.image(draw.loadImage(image), 0, 0);
		if (pressed) draw.fill(150);
		else draw.fill(220);
		draw.rectMode(PConstants.CENTER);
		draw.rect(draw.width/2, draw.height/2, bWidth, bHeight, 10);
		draw.fill(0);
		draw.textAlign(PConstants.CENTER);
		draw.textSize(textSize);
		draw.text("Play!", draw.width/2, draw.height/2 + textSize/3);
		
		pressed = false;
	}
	
	public boolean getPressed() {
		return pressed;
	}
	
}
