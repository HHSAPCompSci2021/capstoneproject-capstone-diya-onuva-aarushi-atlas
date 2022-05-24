/**
 * 
 * Sets a convenient precedent for switching between modes/features of the game (<code>Screens</code>)
 * Includes a list of fields that works with the outlined, switchScreen method
 * 
 * @author Aarushi Gupta
 */

public interface ScreenSwitcher {
	
	/**
	 * Value for <code>Menu</code> <code>Screen</code>
	 */
	public static final int MENU_SCREEN = 1;
	
	/**
	 * Value for <code>StudyMode</code> <code>Screen</code>
	 */
	public static final int STUDY_SCREEN = 2;
	
	/**
	 * Value for <code>QuizMode</code> <code>Screen</code>
	 */
	public static final int QUIZ_SCREEN = 3;
	
	/**
	 * Value for <code>DrawMode</code> <code>Screen</code>
	 */
	public static final int DRAW_SCREEN = 4;
	
	/**
	 * Value for <code>Instructions</code> <code>Screen</code>
	 */
	public static final int INSTRUCTIONS_SCREEN = 5;
	
	/**
	 * Value for <code>Settings</code> <code>Screen</code>
	 */
	public static final int SETTINGS_SCREEN = 6;
	
	/**
	 * Purpose is to switch between screens
	 * @param i screen number
	 */
	public void switchScreen(int i);
}
