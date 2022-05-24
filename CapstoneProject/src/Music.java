import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Music {

		static Clip clip;
		static float vol = -25;
		boolean started = false;
		private static int frame;

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

		public void setVol(float v) {
			vol = (v * 86.0206f) - 80;
			if (clip != null) {
				FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue(vol);
			}
		}
		
		public float getVolP() {
			float f = vol + 80;
			return f/86.0206f;
		}
		public void restart() {
			frame = 0;
			play();
		}

		public void play() {
			clip.setFramePosition(frame);
			clip.start();
			started = true;
		}
		
//		public float progress() {
//			if(clip.getFramePosition() <= 0 && clip.getFrameLength() !=0)  return (float)frame/clip.getFrameLength();
//			else if(clip.getFrameLength() !=0) return (float)clip.getFramePosition()/clip.getFrameLength();
//			else return 1;
//		}
		public void loop() {
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}

		public void stop() {
			frame = clip.getFramePosition();
			clip.stop();
			clip.close();
		}
}
