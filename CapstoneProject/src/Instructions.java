import java.awt.FlowLayout;
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
 * @author diya
 *
 */
public class Instructions extends Screen{

	String image;
	private DrawingSurface draw;
	
	/**
	 * Sets default settings
	 */
	public Instructions(DrawingSurface draw)
	{
		super(1600, 750);
		this.draw = draw;
	}
	
	/**
	 * draws text and button on the new window
	 * @param draw of PApplet
	 */
	public void draw ()
	{
		draw.noLoop();
		JFrame jFrame = new JFrame();

        JDialog jd = new JDialog(jFrame);

        jd.setLayout(new FlowLayout());

        jd.setBounds(500, 300, 600, 600);

        JLabel jLabel = new JLabel("Once on the title page, the user will be transported to the menu, which will display their high score (if they have one, zero otherwise), and options to start Study Mode, Quiz Mode, or Drawing Mode.");
        jLabel.setBounds(50, 50, 400, 50);
        JLabel jLabel1 = new JLabel("Drawing Mode allows the user to draw their own maps and save them.");
        jLabel1.setBounds(50, 150, 400, 50);
        JLabel jLabel2 = new JLabel("Study Mode allows the user to interact with a map of Africa, and select countries to learn more about them. ");
        jLabel2.setBounds(50, 250, 400, 50);
        JLabel jLabel3 = new JLabel("Once clicked on, a pop-up window will appear and display images and information on the clicked country in a slideshow-esque manner.");
        jLabel3.setBounds(50, 350, 400, 50);
        JLabel jLabel4 = new JLabel("In Quiz Mode, the user must answer questions (multiple choice, short answer, select correct country, … etc.) about the countries of Africa.");
        jLabel4.setBounds(50, 450, 400, 50);
        JLabel jLabel5 = new JLabel("Based on how many questions the user is able to answer correctly the user receives their score, which if high enough will become their new high score.");
        jLabel5.setBounds(50, 550, 400, 50);
        JLabel jLabel6 = new JLabel("All three Modes will be able to navigate back to Menu through a button in one corner of the screen.");
        jLabel6.setBounds(50, 650, 400, 50);
        
        JButton jButton = new JButton("Close");
        
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	jFrame.dispatchEvent(new WindowEvent(jFrame, WindowEvent.WINDOW_CLOSING));
                draw.loop();
                draw.switchScreen(ScreenSwitcher.MENU_SCREEN);
            }
        });
        jd.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            	draw.loop();
                draw.switchScreen(ScreenSwitcher.MENU_SCREEN);
            }
        });

        jd.add(jLabel);
        jd.add(jLabel1);
        jd.add(jLabel2);
        jd.add(jLabel3);
        jd.add(jLabel4);
        jd.add(jLabel5);
        jd.add(jLabel6);
        jd.add(jButton);
        jd.setVisible(true);
		
//        draw.background(draw.loadImage(image));
	}
}