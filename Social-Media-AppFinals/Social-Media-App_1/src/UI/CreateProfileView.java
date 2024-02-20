package UI;

import controller.CreateProfileController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateProfileView {
    private JFrame frame;
    private JTextField usernameField;
    private JTextField nameField;
    private JTextField photoField;
    private JTextField phoneField;
    private JTextArea bioArea;
    private CreateProfileController controller;

    public CreateProfileView(CreateProfileController controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {
        frame = new JFrame("Create Profile");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        JPanel usernamePanel = new JPanel();
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);

        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        JPanel photoPanel = new JPanel();
        JLabel photoLabel = new JLabel("Photo URL:");
        photoField = new JTextField(20);
        photoPanel.add(photoLabel);
        photoPanel.add(photoField);

        JPanel phonePanel = new JPanel();
        JLabel phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField(20);
        phonePanel.add(phoneLabel);
        phonePanel.add(phoneField);

        JPanel bioPanel = new JPanel();
        JLabel bioLabel = new JLabel("Bio:");
        bioArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(bioArea);
        bioPanel.add(bioLabel);
        bioPanel.add(scrollPane);

        JButton createButton = new JButton("Create Profile");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String name = nameField.getText().trim();
                String photoURL = photoField.getText().trim();
                String phone = phoneField.getText().trim();
                String bio = bioArea.getText().trim();
                boolean success = controller.createProfile(username, name, photoURL, phone, bio);
                if (success) {
                    JOptionPane.showMessageDialog(frame, "Profile created successfully!");
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Failed to create profile.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel inputPanel = new JPanel(new GridLayout(6, 1));
        inputPanel.add(usernamePanel);
        inputPanel.add(namePanel);
        inputPanel.add(photoPanel);
        inputPanel.add(phonePanel);
        inputPanel.add(bioPanel);
        inputPanel.add(createButton);

        frame.add(inputPanel, BorderLayout.CENTER);
    }

    public void display() {
        frame.setVisible(true);
    }
}
