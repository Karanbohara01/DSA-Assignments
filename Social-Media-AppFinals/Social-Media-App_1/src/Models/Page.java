package Models;

import java.util.ArrayList;

public class Page extends Object {
	private User owner;
	private String name;
	ArrayList<Post> posts;

	public Page(int id, String name, User owner) {
		this.id = "p" + Integer.toString(id);
		this.name = name;
		this.owner = owner;
		this.posts = new ArrayList<>();
	}

	@Override
	public void addPost(Post post) {
		posts.add(post);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getID() {
		return id;
	}

	public ArrayList<Post> getPosts() {
		return posts;
	}
}
