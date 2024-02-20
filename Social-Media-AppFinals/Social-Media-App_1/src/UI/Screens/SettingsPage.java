package UI.Screens;

import java.awt.Image;

import javax.swing.ImageIcon;

import main.SocialMedia;

public class SettingsPage extends BasePage {
    public SettingsPage() {
        initComponents();
    }

    private void initComponents() {

        pageHeading = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        changeThemeButton = new javax.swing.JButton();
        editProfileButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        createPageButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pageHeading.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        pageHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pageHeading.setText("Settings");
        pageHeading.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        changeThemeButton.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        changeThemeButton.setText("Change Theme");
        changeThemeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeThemeButtonActionPerformed(evt);
            }
        });

        editProfileButton.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        editProfileButton.setText("Edit Profile");
        editProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProfileButtonActionPerformed(evt);
            }
        });

        logOutButton.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        logOutButton.setText("Log Out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        createPageButton.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        createPageButton.setText("Create Page");
        createPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(479, 479, 479)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(editProfileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(changeThemeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logOutButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pageHeading, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createPageButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(548, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pageHeading))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(backButton)))
                .addGap(63, 63, 63)
                .addComponent(changeThemeButton)
                .addGap(36, 36, 36)
                .addComponent(editProfileButton)
                .addGap(42, 42, 42)
                .addComponent(createPageButton)
                .addGap(35, 35, 35)
                .addComponent(logOutButton)
                .addContainerGap(355, Short.MAX_VALUE))
        );

        pack();
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("Back Button Pressed");
		SocialMedia.states.changeState(new HomePage());
	}

    private void changeThemeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
		System.out.println("Change Theme Button Pressed");
	}

    private void editProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SocialMedia.states.changeState(new EditProfilePage());
    }

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SocialMedia.states.changeState(new LoginPage());
    }

    private void createPageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SocialMedia.states.changeState(new CreatePagePage());
    }

    // Variables declaration - do not modify
    private javax.swing.JButton backButton;
    private javax.swing.JButton changeThemeButton;
    private javax.swing.JButton editProfileButton;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton createPageButton;
    private javax.swing.JLabel pageHeading;
    // End of variables declaration
}
