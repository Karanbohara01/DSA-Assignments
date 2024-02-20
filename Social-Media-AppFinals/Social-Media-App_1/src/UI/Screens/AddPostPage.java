package UI.Screens;

import java.awt.Image;

import javax.swing.ImageIcon;

import Models.Activity;
import main.SocialMedia;

public class AddPostPage extends BasePage {
    private boolean postFromPage = false;

    public AddPostPage() {
        initComponents();
		errorLabel.setVisible(false);

        loadActivities();
    }

    private void loadActivities() {
        activityDropDown.setVisible(isActivityCheckBox.isSelected());
        String[] activities = new String[4];
        for (int i = 0; i < SocialMedia.activities.size(); i++) {
            activities[i] = SocialMedia.activities.get(i).getText();
        }
        activityDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(activities));
    }

    private void initComponents() {
        pageHeading = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        postTextArea = new javax.swing.JTextArea();
        postButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        isActivityCheckBox = new javax.swing.JCheckBox();
        activityDropDown = new javax.swing.JComboBox<>();
        postAsPageCheckBox = new javax.swing.JCheckBox();

        pageHeading.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        pageHeading.setText("Add Post");

//        ImageIcon backIcon = new ImageIcon(getClass().getResource("/images/back icon.png"));
//        backButton.setIcon(
//            new ImageIcon(backIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH))
//        );
backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        postTextArea.setColumns(20);
        postTextArea.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        postTextArea.setLineWrap(true);
        postTextArea.setRows(5);
        postTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(postTextArea);

        postButton.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        postButton.setText("Post");
        postButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postButtonActionPerformed(evt);
            }
        });

        errorLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(204, 0, 51));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setText("Error");

        isActivityCheckBox.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        isActivityCheckBox.setText("Activity");
        isActivityCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isActivityCheckBoxActionPerformed(evt);
            }
        });

        activityDropDown.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        activityDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        activityDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activityDropDownActionPerformed(evt);
            }
        });

        postAsPageCheckBox.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        postAsPageCheckBox.setText("Post From Page");
        postAsPageCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postAsPageCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(395, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(344, 344, 344))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(postButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(530, 530, 530))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(434, 434, 434))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(482, 482, 482)
                        .addComponent(pageHeading))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(474, 474, 474)
                        .addComponent(postAsPageCheckBox)
                        .addGap(23, 23, 23)
                        .addComponent(isActivityCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(activityDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pageHeading))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(backButton)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isActivityCheckBox)
                    .addComponent(activityDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postAsPageCheckBox))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(postButton)
                .addGap(72, 72, 72)
                .addComponent(errorLabel)
                .addContainerGap(189, Short.MAX_VALUE))
        );

        pack();
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
		SocialMedia.states.changeState(new HomePage());
	}

    private void postButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String postText = postTextArea.getText();
        if (postText.isEmpty()) {
			errorLabel.setText("Post content cannot be empty");
			errorLabel.setVisible(true);
		}
		else {
            if (isActivityCheckBox.isSelected()) {
                Activity activity = SocialMedia.activities.get(activityDropDown.getSelectedIndex());
                if (SocialMedia.db.addPostAsActivity(SocialMedia.getCurrentUser().getID(), postText, activity)) {
                    errorLabel.setText("Posted Successfully");
                    errorLabel.setVisible(true);
                }
                else {
                    errorLabel.setText("Could not post due to an error");
                    errorLabel.setVisible(true);
                }
            }
            else {
                if (SocialMedia.db.addPost(SocialMedia.getCurrentUser().getID(), postText)) {
                    errorLabel.setText("Posted Successfully");
                    errorLabel.setVisible(true);
                }
                else {
                    errorLabel.setText("Could not post due to an error");
                    errorLabel.setVisible(true);
                }
            }
		}
	}

    private void isActivityCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {
        activityDropDown.setVisible(isActivityCheckBox.isSelected());
    }

    private void activityDropDownActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void postAsPageCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {
        postFromPage = postAsPageCheckBox.isSelected();
    }

	// Variables declaration - do not modify
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pageHeading;
    private javax.swing.JButton postButton;
    private javax.swing.JTextArea postTextArea;
	private javax.swing.JLabel errorLabel;
    private javax.swing.JCheckBox isActivityCheckBox;
    private javax.swing.JCheckBox postAsPageCheckBox;
    private javax.swing.JComboBox<String> activityDropDown;
    // End of variables declaration
}
