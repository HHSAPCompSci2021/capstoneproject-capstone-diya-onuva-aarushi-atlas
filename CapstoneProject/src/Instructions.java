import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import processing.core.PApplet;

public class Instructions {

	String image;
	
	public Instructions()
	{
		
	}
	
	public void draw (PApplet draw)
	{
		JFrame jFrame = new JFrame();

        JDialog jd = new JDialog(jFrame);

        jd.setLayout(new FlowLayout());

        jd.setBounds(500, 300, 600, 600);

        JLabel jLabel = new JLabel("Once on the title page, the user will be transported to the menu, which will display their high score (if they have one, zero otherwise), and options to start Study Mode, Quiz Mode, or Drawing Mode."
        		+ "\n Drawing Mode allows the user to draw their own maps and save them."
        		+ "\n Study Mode allows the user to interact with a map of Africa, and select countries to learn more about them. Once clicked on, a pop-up window will appear and display images and information on the clicked country in a slideshow-esque manner."
        		+ "\n In Quiz Mode, the user must answer questions (multiple choice, short answer, select correct country, … etc.) about the countries of Africa."
        		+ "\n Based on how many questions the user is able to answer correctly the user receives their score, which if high enough will become their new high score."
        		+ "\n All three Modes will be able to navigate back to Menu through a button in one corner of the screen.");
        
        JButton jButton = new JButton("Close");
        
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jd.setVisible(false);
            }
        });

        jd.add(jLabel);
        jd.add(jButton);
        jd.setVisible(true);
		
		draw.background(draw.loadImage(image));
	}
}
