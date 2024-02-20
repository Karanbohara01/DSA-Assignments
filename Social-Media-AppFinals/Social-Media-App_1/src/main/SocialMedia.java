package main;

import Models.Page;
import Models.Hobby;
import Models.Activity;
import java.util.ArrayList;

import javax.swing.*;

import Database.DatabaseServices;
import Models.*;
import Models.Object;
import UI.Screens.*;
import Util.State;

public class SocialMedia {
	public static State states = new State();
	public static DatabaseServices db = new DatabaseServices();

	public static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<Page> pages = new ArrayList<>();
	public static ArrayList<Post> posts = new ArrayList<>();
	public static ArrayList<Hobby> hobbies = new ArrayList<>();
	public static ArrayList<Activity> activities = new ArrayList<>();

	private static User currentUser;

	private SocialMedia() {
		db.initConnection();
		db.loadUsers();
		db.loadPages();
		db.loadLikedPages();
		db.loadPosts();
		db.loadLikes();
		db.loadComments();
		db.loadHobbies();
		db.loadActivities();

		SwingUtilities.invokeLater(() -> {
			states.changeState(new LoginPage());
		});
	}

	public static User searchUserByID(String id) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getID().equals(id))
				return users.get(i);
		}
		return null;
	}

	public static Page searchPageByID(String id) {
		for (int i = 0; i < pages.size(); i++) {
			if (pages.get(i).getID().equals(id))
				return pages.get(i);
		}
		return null;
	}

	public static Object searchObjectByID(String id) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getID().equals(id))
				return users.get(i);
		}
		for (int i = 0; i < pages.size(); i++) {
			if (pages.get(i).getID().equals(id))
				return pages.get(i);
		}
		return null;
	}

	public static Post searchPostByID(int id) {
		for (int i = 0; i < posts.size(); i++) {
			if (posts.get(i).getID() == id)
				return posts.get(i);
		}
		return null;
	}

	public static Hobby searchHobbyByID(int id) {
		for (int i = 0; i < hobbies.size(); i++) {
			if (hobbies.get(i).getID() == id)
				return hobbies.get(i);
		}
		return null;
	}

	public static Activity searchActivityByID(int id) {
		for (int i = 0; i < activities.size(); i++) {
			if (activities.get(i).getID() == id)
				return activities.get(i);
		}
		return null;
	}

	public static void setCurrentUser(User user) {
		currentUser = user;
	}

	public static User getCurrentUser() {
		return currentUser;
	}

	public static void main(String[] args) {
		new SocialMedia();
	}
}