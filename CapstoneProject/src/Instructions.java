import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import processing.core.PApplet;

/**
 * Creates a pop out window with instructions on the game.
 * @author Diya Bengani
 * Has an String for the image 
 *
 */
public class Instructions extends Screen{

	private DrawingSurface draw;
	
	/**
	 * Sets default settings, initializes fields
	 * @param draw of type DrawingSurface
	 */
	public Instructions(DrawingSurface draw)
	{
		super(1600, 750);
		this.draw = draw;
	}
	
	/**
	 * Draws the text and button on the new window
	 * @post draw (screen) is modified and buttons are added
	 * @post buttons are drawn with center alignment
	 */
	public void draw ()
	{
		draw.noLoop();
		JFrame jFrame = new JFrame();
		jFrame.setResizable(false);

        JDialog jd = new JDialog(jFrame);
        GridLayout gl = new GridLayout(0,1);
        gl.setVgap(-100);
        jd.setLayout(gl);

        jd.setBounds(500, 300, 1050, 400);
        
        JLabel title1 = new JLabel("INSTRUCTIONS");
        title1.setHorizontalAlignment(JLabel.CENTER);
        title1.setFont(new Font("Times New Roman", Font.BOLD, 55));
        
        JLabel title2 = new JLabel("Welcome to Atlas!");
        title2.setHorizontalAlignment(JLabel.CENTER);
        title2.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        
        JLabel intro = new JLabel("From here, you can navigate to the Study, Quiz, or Drawing Mode:");
        intro.setHorizontalAlignment(JLabel.CENTER);
        intro.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        
        JLabel study = new JLabel("Study Mode allows you to click on various countries in Africa to learn its name, capital,and a fun fact about that country!");
        study.setHorizontalAlignment(JLabel.CENTER);
        study.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        
        JLabel quiz = new JLabel("Quiz Mode gives you an opportunity to test your geography knowledge about Africa!");
        quiz.setHorizontalAlignment(JLabel.CENTER);
        quiz.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        
        JLabel inst = new JLabel("Answer questions about the capital and region of a country, and select the correct country from a map.");
        inst.setHorizontalAlignment(JLabel.CENTER);
        inst.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        
        JLabel drawing = new JLabel("Draw Mode is a blank screen that the user can use to draw a country, a map, or their own notes and save them for future use.");
        drawing.setHorizontalAlignment(JLabel.CENTER);
        drawing.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        
        JLabel enjoy = new JLabel("Have fun navigating Africa with Atlas!");
        enjoy.setHorizontalAlignment(JLabel.CENTER);
        enjoy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        
        jd.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            	draw.loop();
                draw.switchScreen(ScreenSwitcher.MENU_SCREEN);
            }
        });

        jd.add(title1);
        jd.add(title2);
        jd.add(intro);
        jd.add(study);
        jd.add(quiz);
        jd.add(inst);
        jd.add(drawing);
        jd.add(enjoy);
        jd.setVisible(true);
		
//        draw.background(draw.loadImage(image));
	}
}