package Database;




import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import Models.Post;
import Models.User;
import Models.Activity;
import Models.Comment;
import Models.Hobby;
import Models.Object;
import Models.Page;
import main.SocialMedia;

public class DatabaseServices {
    private String connectionString = "jdbc:mysql://localhost:3306/socialmedia?user=root&password=Kathmandu@123";
    private Connection connection;

    public DatabaseServices() {}

    public void initConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionString);
            System.out.println("Connection successful");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadUsers() {
        String query = "SELECT * FROM `USER`";

        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("userID");
                String fname = resultSet.getString("first_name");
                String lname = resultSet.getString("last_name");
                String username = resultSet.getString("username");
                String bio = resultSet.getString("bio");
                String contact = resultSet.getString("contact");
                String city = resultSet.getString("city");
                Date dob = resultSet.getDate("dob");

                SocialMedia.users.add(new User(id,username, fname, lname, bio, contact, dob, city));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        loadFriendships();
    }

    private void loadFriendships() {
        String query = "SELECT * FROM friendship";
        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id1 = resultSet.getInt("userID1");
                int id2 = resultSet.getInt("userID2");

                SocialMedia.searchUserByID(
                    "u" + Integer.toString(id1)
                ).addFriend(
                    SocialMedia.searchUserByID("u" + Integer.toString(id2))
                );
                SocialMedia.searchUserByID(
                    "u" + Integer.toString(id2)
                ).addFriend(
                    SocialMedia.searchUserByID("u" + Integer.toString(id1))
                );
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadLikedPages() {
        String query = "SELECT * FROM follower";
        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int uid = resultSet.getInt("userID");
                int pid = resultSet.getInt("pageID");

                User user = SocialMedia.searchUserByID("u" + Integer.toString(uid));
                Page page = SocialMedia.searchPageByID("p" + Integer.toString(pid));
                user.likePage(page);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadPages() {
        String query = "SELECT * FROM Page";

        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("pageID");
                int userid = resultSet.getInt("userID");
                String name = resultSet.getString("pageName");

                User u = SocialMedia.searchUserByID("u" + Integer.toString(userid));
                SocialMedia.pages.add(new Page(id, name, u));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadPosts() {
        String query = "SELECT * FROM Post";
        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("postID");
                Date posted = resultSet.getDate("postDate");
                String text = resultSet.getString("postText");
                int objId = resultSet.getInt("pageID");

                String objectID;
                if (resultSet.wasNull()) {
                    // if pageid is null then post must be made by a user
                    objId = resultSet.getInt("userID");
                    objectID = "u" + Integer.toString(objId);
                }
                else {
                    objectID = "p" + Integer.toString(objId);
                }

                Object poster = SocialMedia.searchObjectByID(objectID);
                Post post = new Post(id, text, poster, posted);
                SocialMedia.posts.add(post);
                poster.addPost(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadLikes() {
        String query = "SELECT * FROM Likes";


        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int postID = resultSet.getInt("postID");
                int userID = resultSet.getInt("userID");

                String uid = "u" + Integer.toString(userID);
                SocialMedia.searchPostByID(postID).addLike(SocialMedia.searchUserByID(uid));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadComments() {
        String query = "SELECT * FROM Comment";
        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("commentID");
                int postID = resultSet.getInt("postID");
                int userID = resultSet.getInt("userID");
                String text = resultSet.getString("CommentContent");
                Date date = resultSet.getDate("commentDate");

                String uid = "u" + Integer.toString(userID);

                User user = SocialMedia.searchUserByID(uid);
                Comment comment = new Comment(id, text, user, date);
                Post post = SocialMedia.searchPostByID(postID);
                post.addComment(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadHobbies() {
        String query = "SELECT * FROM Hobby";
        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("hobbyID");
                String name = resultSet.getString("hobbyName");

                Hobby hobby = new Hobby(id, name);
                SocialMedia.hobbies.add(hobby);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        query = "SELECT * FROM User_Hobbies";
        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("hobby_id");
                int userid = resultSet.getInt("user_id");

                SocialMedia.searchUserByID("u" + Integer.toString(userid)).addHobby(
                    SocialMedia.searchHobbyByID(id)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadActivities() {
        String query = "SELECT * FROM Activity";
        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("activityID");
                String text = resultSet.getString("text");

                Activity activity = new Activity(id, text);
                SocialMedia.activities.add(activity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        query = "SELECT * FROM User_Activity";
        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int pid = resultSet.getInt("postID");
                int activityID = resultSet.getInt("activityID");

                SocialMedia.searchPostByID(pid).addActivity(SocialMedia.searchActivityByID(activityID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public boolean addUser(String fname, String lname, String email, String password, String contact, Date dob) {
//        String query = "INSERT INTO \"User\" "
//        + "(first_name, last_name, email, password, contact, dob) "
//        + "VALUES (?, ?, ?, ?, ?, ?)";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, fname);
//            statement.setString(2, lname);
//            statement.setString(3, email);
//            statement.setString(4, password);
//            statement.setString(5, contact);
//            statement.setDate(6, dob);
//
//            int rowsAffected = statement.executeUpdate();
//
//            if (rowsAffected > 0) {
//                System.out.println("User inserted successfully");
//                return true;
//            } else {
//                System.out.println("Failed to insert user");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
    
    public boolean addUser(String fname, String lname, String email, String password, String contact, Date dob) {
    String query = "INSERT INTO User " +
                   "(first_name, last_name, email, password, contact, dob) " +
                   "VALUES (?, ?, ?, ?, ?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, fname);
        statement.setString(2, lname);
        statement.setString(3, email);
        statement.setString(4, password);
        statement.setString(5, contact);
        statement.setDate(6, dob);

        int rowsAffected = statement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("User inserted successfully");
            return true;
        } else {
            System.out.println("Failed to insert user");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}


    public boolean addPost(String objId, String text) {
        Object poster = SocialMedia.searchObjectByID(objId);

        LocalDate currentDate = LocalDate.now();
        Date date = Date.valueOf(currentDate);

        String query = "";
        if (objId.charAt(0) == 'u') {
            //user posted
            query = "INSERT INTO Post (postDate, userID, postText) "
                    + "VALUES (?, ?, ?);";
        }
        else if (objId.charAt(0) == 'p') {
            //page posted
            query = "INSERT INTO Post (postDate, pageID, postText) "
                    + "VALUES (?, ?, ?);";
        }

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            int id = Integer.parseInt(objId.substring(1));

            statement.setDate(1, date);
            statement.setInt(2, id);
            statement.setString(3, text);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Posted successfully");
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    Post post = new Post(generatedId, text, poster, date);
                    SocialMedia.posts.add(post);
                }
                return true;
            } else {
                System.out.println("Failed to insert user");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addPostAsActivity(String objId, String text, Activity activity) {
        Object poster = SocialMedia.searchObjectByID(objId);

        LocalDate currentDate = LocalDate.now();
        Date date = Date.valueOf(currentDate);

        String query = "";
        if (objId.charAt(0) == 'u') {
            //user posted
            query = "INSERT INTO Post (postDate, userID, postText) "
                    + "VALUES (?, ?, ?);";
        }
        else if (objId.charAt(0) == 'p') {
            //page posted
            query = "INSERT INTO Post (postDate, pageID, postText) "
                    + "VALUES (?, ?, ?);";
        }

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            int id = Integer.parseInt(objId.substring(1));

            statement.setDate(1, date);
            statement.setInt(2, id);
            statement.setString(3, text);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Posted successfully");
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    Post post = new Post(generatedId, text, poster, date);
                    if (addActivity(post, activity))
                        SocialMedia.posts.add(post);
                }
                return true;
            } else {
                System.out.println("Failed to insert user");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean addActivity(Post post, Activity activity) {
        String query = "INSERT INTO User_Activity (postID, activityID) VALUES (?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, post.getID());
            statement.setInt(2, activity.getID());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                post.addActivity(activity);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addComment(User user, String text, Post post) {
        String query = "INSERT INTO Comment (postID, userID, CommentContent, commentDate) "
                    + "VALUES (?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            int userid = Integer.parseInt(user.getID().substring(1));
            LocalDate currentDate = LocalDate.now();
            Date date = Date.valueOf(currentDate);

            statement.setInt(1, post.getID());
            statement.setInt(2, userid);
            statement.setString(3, text);
            statement.setDate(4, date);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    Comment comment = new Comment(generatedId, text, user, date);
                    post.addComment(comment);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addPage(User user, String pageName) {
        String query = "INSERT INTO Page (userID, pageName) "
                    + "VALUES (?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            int userid = Integer.parseInt(user.getID().substring(1));

            statement.setInt(1, userid);
            statement.setString(2, pageName);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    Page page = new Page(generatedId, pageName, user);
                    SocialMedia.pages.add(page);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addFriend(User u1, User u2) {
        String query = "INSERT INTO Friendship (userID1, userID2) VALUES (?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            int userid1 = Integer.parseInt(u1.getID().substring(1));
            int userid2 = Integer.parseInt(u2.getID().substring(1));

            statement.setInt(1, userid1);
            statement.setInt(2, userid2);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                u1.addFriend(u2);
                u2.addFriend(u1);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User authenticate(String email, String password) {
        String query = "SELECT * FROM User WHERE email = (?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String pass = resultSet.getString("password");
                    int id = resultSet.getInt("userID");
                    if (pass.equals(password)) {
                        return SocialMedia.searchUserByID("u" + Integer.toString(id));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void likePost(User user, Post post) {
        String query = "INSERT INTO Likes (postID, userID) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            int uid = Integer.parseInt(user.getID().substring(1));

            statement.setInt(1, post.getID());
            statement.setInt(2, uid);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Post liked");
                post.addLike(user);
            }
            else {
                System.out.println("Could not like post");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean likePage(User user, Page page) {
        String query = "INSERT INTO follower (userID, pageID) VALUES (?, ?);";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            int uid = Integer.parseInt(user.getID().substring(1));
            int pid = Integer.parseInt(page.getID().substring(1));

            statement.setInt(1, uid);
            statement.setInt(2, pid);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("page liked");
                user.likePage(page);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void updateUserData(User user, String fname, String lname, String phone,
        String username, String city, String bio, ArrayList<Hobby> hobbies) {

        String query = "UPDATE User SET first_name = ?, last_name = ?, contact = ?, "
                    + "city = ?, username = ?, bio = ? WHERE userID = ?";

        int userid = Integer.parseInt(user.getID().substring(1));
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, fname);
            statement.setString(2, lname);
            statement.setString(3, phone);
            statement.setString(4, city);
            statement.setString(5, username);
            statement.setString(6, bio);
            statement.setInt(7, userid);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                user.updateData(fname, lname, phone, username, city, bio, hobbies);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < hobbies.size(); i++) {
            try {
                if (!userHobbyExists(userid, hobbies.get(i).getID())) {
                    insertUserHobby(userid, hobbies.get(i).getID());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<User> searchUser(String name) {
        String[] names = name.split(" ");
        String query = "";

        if (names.length == 1)
            query = "SELECT * FROM User WHERE first_name like ?";
        else if (names.length == 2)
            query = "SELECT * FROM User WHERE first_name like ? and last_name like ?";

        if (query.isEmpty())
            return null;

        ArrayList<User> users = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + names[0] + "%");
            if (names.length == 2) statement.setString(2, "%" + names[1] + "%");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("userID");
                User user = SocialMedia.searchUserByID("u" + Integer.toString(id));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public ArrayList<Page> searchPage(String name) {
        String query = "SELECT * FROM Page WHERE pageName like ?";

        ArrayList<Page> pages = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + name + "%");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("pageID");
                Page page = SocialMedia.searchPageByID("p" + Integer.toString(id));
                pages.add(page);
            }
        } catch (SQLException e) {
        }
        return pages;
    }

    private boolean userHobbyExists(int userId, int hobbyId) throws SQLException {
        String query = "SELECT COUNT(*) FROM user_hobbies WHERE user_id = ? AND hobby_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, hobbyId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }

    private void insertUserHobby(int userId, int hobbyId) throws SQLException {
        String insertQuery = "INSERT INTO user_hobbies (user_id, hobby_id) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, hobbyId);
            preparedStatement.executeUpdate();
        }
    }
}
