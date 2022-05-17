import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;

import processing.core.PApplet;
import processing.core.PConstants;

/**
 * The introduction screen for the program, which contains the Play button
 * @author diya
 *
 */
public class Introduction extends Screen {

	private float textSize, bWidth, bHeight, num;
	private boolean pressed;
	private DrawingSurface surface;
	private Rectangle button;
	
	/**
	 * Sets default settings
	 */
	public Introduction(DrawingSurface surface)
	{
		super(1000, 751);
		this.surface = surface;
		
		button = new Rectangle(1000/2-100,751/2-50,200,100);
		
		textSize = 45;
		bWidth = 150;
		bHeight = 75;
		num = 0.25f;
		pressed = false;
	}
	
	/**
	 * Draws the blue background and play button
	 * @param draw given PApplet
	 */
	public void draw() 
	{
		surface.background(255,255,255);
		
		surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "Click me!";
		
		surface.textAlign(PConstants.CENTER);
		surface.textSize(textSize);
		surface.text("Play!", surface.width/2, surface.height/2);
		
//		draw.textSize((draw.height/110f) * (draw.width/150f) * 2);
		surface.text("ATLAS", surface.width/2, surface.height/10);
		
	}
	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p))
			surface.switchScreen(ScreenSwitcher.QUIZ_SCREEN);
	}
	
}

///**
// * Draws the blue background and play button
// * @param draw given PApplet
// */
//public void draw() 
//{
//	surface.background(255,255,255);
//	
//	surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
//	surface.fill(0);
//	String str = "Click me!";
//	
//	
//	if(num <= 0 && draw.mousePressed && draw.mouseX <= draw.width/2 + bWidth/2 && draw.mouseX >= draw.width/2 - bWidth/2 && draw.mouseY <= draw.height*0.4f + bHeight/2 && draw.mouseY >= draw.height*0.4f - bHeight/2) 
//	{
//		pressed = true;
//		DrawingSurface.switchToMenu();
//	}
//	
//	if(pressed) 
//	{
//		bWidth = draw.width/8;
//		bHeight = draw.height/11;
//		textSize = (draw.height/120f) * (draw.width/160f);
//	}
//	
//	else 
//	{
//		bWidth = draw.width/6.5f;
//		bHeight = draw.height/10;
//		textSize = (draw.height/110f) * (draw.width/150f);
//	}
//	
//	draw.rectMode(PConstants.CENTER);
//	
//	if (pressed) draw.fill(150);
//	
//	else 
//	{
//		if (num > 0) 
//		{
//			float tempOpq = 5/num;
//			if (tempOpq > 50) tempOpq = 50;
//			draw.fill(250, 185, 35, tempOpq);
//			draw.noStroke();
//			float tempWidth = (1+1/num/250);
//			if (tempWidth > 1.2) tempWidth = 1.2f;
//			draw.rect(draw.width/2, draw.height*0.4f + draw.height*num, bWidth*tempWidth, bHeight*1.3f, 10);
//			draw.fill(220, 220, 250, 10/num);
//			draw.rect(draw.width/2, draw.height*0.4f + draw.height*num, bWidth, bHeight, 10);
//		}
//		else
//		{
//			draw.fill(250, 185, 35, 50);
//			draw.noStroke();
//			draw.rect(draw.width/2, draw.height*0.4f + draw.height*num, bWidth*1.2f, bHeight*1.3f, 10);
//			draw.fill(220, 220, 250);
//			draw.rect(draw.width/2, draw.height*0.4f + draw.height*num, bWidth, bHeight, 10);
//		}
//	}
//	
//	
//	draw.fill(0);
//	draw.textAlign(PConstants.CENTER);
//	draw.textSize(textSize);
//	if (num > 0) draw.text("Play!", draw.width/2, draw.height*0.4f + draw.height*num + textSize/3);
//	else draw.text("Play!", draw.width/2, draw.height*0.4f + textSize/3);
//	draw.textSize((draw.height/110f) * (draw.width/150f) * 2);
//	draw.text("ATLAS", draw.width/2, draw.height/10);
//	
//	pressed = false;
//	if (num > 0) num-=0.0075;
//}
