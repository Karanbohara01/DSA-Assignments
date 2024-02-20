
package Models;

public class Activity {
	int id;
	String text;

	public Activity(int id, String text) {
		this.id = id;
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public int getID() {
		return id;
	}
}
