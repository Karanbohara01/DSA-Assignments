package Models;

public abstract class Object {
	protected String id;
	public abstract String getID();
	public abstract String getName();
	public abstract void addPost(Post post);
}
