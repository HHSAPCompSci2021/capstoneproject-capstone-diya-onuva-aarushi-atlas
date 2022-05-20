/**
 * 
 * @author aarushigupta
 * Purpose: To set a convenient precedent for switching between modes/features of the game (screens)
 * Includes a list of fields that works with the outlined, switchScreen method
 *
 */

public interface ScreenSwitcher {
	
	public static final int MENU_SCREEN = 1;
	public static final int STUDY_SCREEN = 2;
	public static final int QUIZ_SCREEN = 3;
	public static final int DRAW_SCREEN = 4;
	public static final int INSTRUCTIONS_SCREEN = 5;
	
	/**
	 * Purpose is to switch between screens
	 * @param i screen number
	 */
	public void switchScreen(int i);
}
