
package Models;

public class Hobby {
	private int id;
	private String name;

	public Hobby(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getID() {
		return id;
	}
}
