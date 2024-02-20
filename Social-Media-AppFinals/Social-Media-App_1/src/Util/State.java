
package Util;
import UI.Screens.*;

public class State {
	private BasePage current;

	public void changeState(BasePage nextState) {
		if (current != null) {
			current.exit();
		}
		current = nextState;
		current.enter();
	}

	public BasePage getCurrentState() {
		return current;
	}
}
