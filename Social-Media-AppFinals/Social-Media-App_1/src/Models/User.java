package Models;

import java.util.ArrayList;
import java.util.Date;
import main.SocialMedia;



public class User extends Object {
	private String username;
	private String firstName;
	private String lastName;
	private String bio;
	private String phoneNumber;
	private Date dob;
	private String city;
	private ArrayList<Hobby> hobbies;
	private ArrayList<User> friends;
	private ArrayList<Post> posts;
	private ArrayList<Page> likedPages;

	public User(int id, String username, String fName, String lName, String bio, String phone, Date dob, String city) {
		this.id = "u" + Integer.toString(id);
		this.username = username;
		this.firstName = fName;
		this.lastName = lName;
		this.bio = bio;
		this.phoneNumber = phone;
		this.dob = dob;
		this.city = city;
		this.hobbies = new ArrayList<>();
		this.friends = new ArrayList<>();
		this.posts = new ArrayList<>();
		this.likedPages = new ArrayList<>();
	}

	public void addFriend(User friend) {
		friends.add(friend);
	}

	@Override
	public void addPost(Post post) {
		posts.add(post);
	}

	public void addHobby(Hobby hobby) {
		hobbies.add(hobby);
	}

	public void likePost(Post post) {
		SocialMedia.db.likePost(this, post);
	}

	public void likePage(Page page) {
		likedPages.add(page);
	}

	public void postComment(Post post, String text) {
		SocialMedia.db.addComment(this, text, post);
	}

	public void createPage(String pageName) {
		SocialMedia.db.addPage(this, pageName);
	}

	public boolean isFriend(User user) {
		return friends.contains(user);
	}

	public void updateData(String fname, String lname, String phone,
		String username, String city, String bio, ArrayList<Hobby> hobbies) {

		this.firstName = fname;
		this.lastName = lname;
		this.phoneNumber = phone;
		this.username = username;
		this.city = city;
		this.bio = bio;
		this.hobbies = hobbies;
	}

	public ArrayList<Post> getPosts() {
		return posts;
	}

	public ArrayList<User> getFriends() {
		return friends;
	}

	public ArrayList<Page> getLikedPages() {
		return likedPages;
	}

	public String getBio() {
		return bio;
	}

	public String getCity() {
		return city;
	}

	public void printPosts() {
		for (int i = 0; i < posts.size(); i++) {
			System.out.println(posts.get(i).getText());
		}
	}

	public void printFriendList() {
		for (int i = 0; i < friends.size(); i++) {
			System.out.println(friends.get(i).getName());
		}
	}

	@Override
	public String getName() {
		return firstName + ' ' + lastName;
	}

	@Override
	public String getID() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public ArrayList<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<Hobby> hobbies) {
		this.hobbies = hobbies;
	}
}