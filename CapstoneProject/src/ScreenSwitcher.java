
public interface ScreenSwitcher {
	public static final int MENU_SCREEN = 0;
	public static final int STUDY_SCREEN = 1;
	public static final int QUIZ_SCREEN = 2;
	public static final int DRAW_SCREEN = 3;
	
	public void switchScreen(int i);
}
