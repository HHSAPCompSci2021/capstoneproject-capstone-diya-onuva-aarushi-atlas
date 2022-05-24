/**
 * 
 * Sets a convenient precedent for switching between modes/features of the game (<code>Screens</code>)
 * Includes a list of fields that works with the outlined, switchScreen method
 * @author Aarushi Gupta
 */

public interface ScreenSwitcher {
	
	public static final int MENU_SCREEN = 1;
	public static final int STUDY_SCREEN = 2;
	public static final int QUIZ_SCREEN = 3;
	public static final int DRAW_SCREEN = 4;
	public static final int INSTRUCTIONS_SCREEN = 5;
	public static final int SETTINGS_SCREEN = 6;
	
	/**
	 * Purpose is to switch between screens
	 * @param i screen number
	 */
	public void switchScreen(int i);
}
