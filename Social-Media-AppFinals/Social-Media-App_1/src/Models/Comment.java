package Models;

import java.sql.Date;

public class Comment {
	private int ID;
	private String text;
	private Object poster;
	private Date posted;

	public Comment(int id, String text, Object poster, Date posted) {
		this.ID = id;
		this.text = text;
		this.poster = poster;
		this.posted = posted;
	}

	public String getText() {
		return text;
	}

	public Object getPoster() {
		return poster;
	}
}
