package UI.Screens;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class BasePage extends JFrame{
    public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 1220;

    public void enter() {
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void exit() {
        setVisible(false);
    }
}