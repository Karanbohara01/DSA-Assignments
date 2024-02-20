
package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SocialMediaAppGUI {
    private JFrame mainFrame;
    private String currentUser;

    public SocialMediaAppGUI(String currentUser) {
        this.currentUser = currentUser;

        // Create the main frame
        mainFrame = new JFrame("Social Media App - " + currentUser);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);

        // Add a welcome label
        JLabel welcomeLabel = new JLabel("Welcome, " + currentUser + "!");
        mainFrame.getContentPane().add(welcomeLabel, BorderLayout.CENTER);

        // Create buttons for posting photo and following users
        JButton postPhotoButton = new JButton("Post Photo");
        postPhotoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement photo posting functionality
                JOptionPane.showMessageDialog(mainFrame, "Photo posted successfully!");
            }
        });

        JButton followUserButton = new JButton("Follow User");
        followUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement follow user functionality
                String usernameToFollow = JOptionPane.showInputDialog(mainFrame, "Enter username to follow:");
                if (usernameToFollow != null && !usernameToFollow.isEmpty()) {
                    // Store the user in the database as being followed
                    followUser(currentUser, usernameToFollow);
                    JOptionPane.showMessageDialog(mainFrame, "You are now following " + usernameToFollow);
                }
            }
        });

        // Create panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(postPhotoButton);
        buttonPanel.add(followUserButton);

        // Add buttons to the frame
        mainFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Display the main frame
        mainFrame.setVisible(true);
    }

    // Method to store the follow relationship in the database
    private void followUser(String follower, String followee) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:social_media.db");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO follows (follower, followee) VALUES (?, ?)");
            pstmt.setString(1, follower);
            pstmt.setString(2, followee);
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create profiles table in the database if not exists
        createProfilesTable();
        // Create follows table in the database if not exists
        createFollowsTable();

        // Create an instance of the profile creation GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProfileCreationGUI();
            }
        });
    }

    // Method to create profiles table in the database
    private static void createProfilesTable() {
        String url = "jdbc:sqlite:social_media.db";
        String sql = "CREATE TABLE IF NOT EXISTS profiles (\n"
                + "    username TEXT PRIMARY KEY,\n"
                + "    name TEXT,\n"
                + "    photo TEXT,\n"
                + "    address TEXT,\n"
                + "    bio TEXT\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             java.sql.Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to create follows table in the database
    private static void createFollowsTable() {
        String url = "jdbc:sqlite:social_media.db";
        String sql = "CREATE TABLE IF NOT EXISTS follows (\n"
                + "    follower TEXT,\n"
                + "    followee TEXT,\n"
                + "    FOREIGN KEY (follower) REFERENCES profiles(username),\n"
                + "    FOREIGN KEY (followee) REFERENCES profiles(username),\n"
                + "    PRIMARY KEY (follower, followee)\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             java.sql.Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class ProfileCreationGUI {
    private JFrame frame;
    private JTextField usernameField;
    private JTextField nameField;
    private JTextField photoField;
    private JTextField addressField;
    private JTextArea bioArea;

    public ProfileCreationGUI() {
        // Create the profile creation window
        frame = new JFrame("Create Profile");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Username input
        JPanel usernamePanel = new JPanel();
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);

        // Name input
        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        // Photo input
        JPanel photoPanel = new JPanel();
        JLabel photoLabel = new JLabel("Photo URL:");
        photoField = new JTextField(20);
        photoPanel.add(photoLabel);
        photoPanel.add(photoField);

        // Address input
        JPanel addressPanel = new JPanel();
        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField(20);
        addressPanel.add(addressLabel);
        addressPanel.add(addressField);

        // Bio input
        JPanel bioPanel = new JPanel();
        JLabel bioLabel = new JLabel("Bio:");
        bioArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(bioArea);
        bioPanel.add(bioLabel);
        bioPanel.add(scrollPane);

        // Create button
        JButton createButton = new JButton("Create Profile");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve user input
                String username = usernameField.getText().trim();
                String name = nameField.getText().trim();
                String photoURL = photoField.getText().trim();
                String address = addressField.getText().trim();
                String bio = bioArea.getText().trim();

                // Validate input fields
                if (username.isEmpty() || name.isEmpty()) {
                    showError("Username and Name cannot be empty.");
                    return;
                }

                // Store profile data in the database
                try {
                    Connection conn = DriverManager.getConnection("jdbc:sqlite:social_media.db");
                    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO profiles (username, name, photo, address, bio) VALUES (?, ?, ?, ?, ?)");
                    pstmt.setString(1, username);
                    pstmt.setString(2, name);
                    pstmt.setString(3, photoURL);
                    pstmt.setString(4, address);
                    pstmt.setString(5, bio);
                    pstmt.executeUpdate();
                    conn.close();
                    showSuccess("Profile created successfully!");
                } catch (SQLException ex) {
                    showError("Error creating profile: " + ex.getMessage());
                }

                // Close the profile creation window
                frame.dispose();
                // Open the main application window
                new SocialMediaAppGUI(username);
            }
        });

        // Add components to the frame
        JPanel inputPanel = new JPanel(new GridLayout(6, 1));
        inputPanel.add(usernamePanel);
        inputPanel.add(namePanel);
        inputPanel.add(photoPanel);
        inputPanel.add(addressPanel);
        inputPanel.add(bioPanel);
        inputPanel.add(createButton);

        frame.add(inputPanel, BorderLayout.CENTER);

        // Display the frame
        frame.setVisible(true);
    }

    // Method to show error message
    private void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Method to show success message
    private void showSuccess(String message) {
        JOptionPane.showMessageDialog(frame, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}

