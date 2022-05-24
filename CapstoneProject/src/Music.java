import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 * Plays music based on given <code>Clip</code> and alters its volume
 * 
 * @author Onuva Ekram
 *
 */
public class Music {

		static Clip clip;
		static float vol = -25;
		private static int frame;

		/**
		 * Identifies and sets the sound file to play
		 * @param soundFileName sound file to play
		 */
		public void setFile(String soundFileName) {
			try {
				File file = new File(soundFileName);
				AudioInputStream sound = AudioSystem.getAudioInputStream(file);
				clip = AudioSystem.getClip();
				clip.open(sound);
			} catch (Exception e) {
				System.out.println(e);
			}

			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(vol);
		}

		/**
		 * Sets current volume using given percentage
		 * @param v given percentage of max volume
		 */
		public void setVol(float v) {
			vol = (v * 86.0206f) - 80;
			if (clip != null) {
				FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue(vol);
			}
		}
		
		/**
		 * Returns current volume in percentage of max volume
		 * @return current volume as a percentage of max volume
		 */
		public float getVolP() {
			float f = vol + 80;
			return f/86.0206f;
		}
		
		/**
		 * Plays current clips from the beginning
		 */
		public void restart() {
			frame = 0;
			play();
		}

		/**
		 * Plays clip from starting frame
		 */
		public void play() {
			clip.setFramePosition(frame);
			clip.start();
		}
		
		/**
		 * Loops the current clip
		 */
		public void loop() {
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}

		/** 
		 * Stops playing and closes the current clip
		 */
		public void stop() {
			frame = clip.getFramePosition();
			clip.stop();
			clip.close();
		}
}
