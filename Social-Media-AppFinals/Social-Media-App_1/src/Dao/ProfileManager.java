package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfileManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/social_media_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Kathmandu@123";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean createProfile(String username, String name, String photoURL, String address, String bio) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO profiles (username, name, photo_url, address, bio) VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, username);
            pstmt.setString(2, name);
            pstmt.setString(3, photoURL);
            pstmt.setString(4, address);
            pstmt.setString(5, bio);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
