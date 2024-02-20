package UI.Screens;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Models.Hobby;
import Models.User;
import main.SocialMedia;

public class EditProfilePage extends BasePage {
    public EditProfilePage() {
        initComponents();
		setUserData();
		setHobbies();

		errorLabel.setVisible(false);
    }

	private void setUserData() {
		User user = SocialMedia.getCurrentUser();
		fnameTextField.setText(user.getFirstName());
		lnameTextField.setText(user.getLastName());
		phoneTextField.setText(user.getPhone());
		usernameTextField.setText(user.getUsername());
		cityTextField.setText(user.getCity());
		bioTextArea.setText(user.getBio());
	}

//	private void setHobbies() {
//		hobbyButton1.setText(SocialMedia.hobbies.get(0).getName());
//		hobbyButton2.setText(SocialMedia.hobbies.get(1).getName());
//		hobbyButton3.setText(SocialMedia.hobbies.get(2).getName());
//		hobbyButton4.setText(SocialMedia.hobbies.get(3).getName());
//		hobbyButton5.setText(SocialMedia.hobbies.get(4).getName());
//		hobbyButton6.setText(SocialMedia.hobbies.get(5).getName());
//
//		ArrayList<Hobby> userHobbies = SocialMedia.getCurrentUser().getHobbies();
//		if (userHobbies.contains(SocialMedia.hobbies.get(0)))
//			hobbyButton1.setSelected(true);
//		if (userHobbies.contains(SocialMedia.hobbies.get(1)))
//			hobbyButton2.setSelected(true);
//		if (userHobbies.contains(SocialMedia.hobbies.get(2)))
//			hobbyButton3.setSelected(true);
//		if (userHobbies.contains(SocialMedia.hobbies.get(3)))
//			hobbyButton4.setSelected(true);
//		if (userHobbies.contains(SocialMedia.hobbies.get(4)))
//			hobbyButton5.setSelected(true);
//		if (userHobbies.contains(SocialMedia.hobbies.get(5)))
//			hobbyButton6.setSelected(true);
//	}
        
        
        private void setHobbies() {
    ArrayList<Hobby> hobbies = SocialMedia.hobbies;
    if (hobbies.size() >= 6) {
        hobbyButton1.setText(hobbies.get(0).getName());
        hobbyButton2.setText(hobbies.get(1).getName());
        hobbyButton3.setText(hobbies.get(2).getName());
        hobbyButton4.setText(hobbies.get(3).getName());
        hobbyButton5.setText(hobbies.get(4).getName());
        hobbyButton6.setText(hobbies.get(5).getName());
    } else {
        System.err.println("Not enough hobbies available.");
    }

    ArrayList<Hobby> userHobbies = SocialMedia.getCurrentUser().getHobbies();
    // Check if user has each hobby and set the corresponding button as selected
    for (int i = 0; i < Math.min(userHobbies.size(), 6); i++) {
        if (userHobbies.contains(hobbies.get(i))) {
            switch (i) {
                case 0:
                    hobbyButton1.setSelected(true);
                    break;
                case 1:
                    hobbyButton2.setSelected(true);
                    break;
                case 2:
                    hobbyButton3.setSelected(true);
                    break;
                case 3:
                    hobbyButton4.setSelected(true);
                    break;
                case 4:
                    hobbyButton5.setSelected(true);
                    break;
                case 5:
                    hobbyButton6.setSelected(true);
                    break;
            }
        }
    }
}


	private void initComponents() {
        pageHeading = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        fnameTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lnameTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        hobbiesContainer = new javax.swing.JPanel();
        selectHobbiesHeading = new javax.swing.JLabel();
        hobbyButton1 = new javax.swing.JRadioButton();
        hobbyButton2 = new javax.swing.JRadioButton();
        hobbyButton3 = new javax.swing.JRadioButton();
        hobbyButton4 = new javax.swing.JRadioButton();
        hobbyButton5 = new javax.swing.JRadioButton();
        hobbyButton6 = new javax.swing.JRadioButton();
        cityTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bioTextArea = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pageHeading.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        pageHeading.setText("Edit Profile");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel5.setText("UserName:");

        submitButton.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        submitButton.setText("Submit Changes");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        errorLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(204, 0, 51));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setText("Error");

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel11.setText("Phone Number:");

        usernameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });

        fnameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameTextFieldActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel12.setText("First Name:");

        lnameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameTextFieldActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel13.setText("Last Name:");

        phoneTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phoneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTextFieldActionPerformed(evt);
            }
        });

        selectHobbiesHeading.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        selectHobbiesHeading.setText("Select Hobbies");

        hobbyButton1.setText("Hobby 1");
        hobbyButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hobbyButton1ActionPerformed(evt);
            }
        });

        hobbyButton2.setText("Hobby 1");
        hobbyButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hobbyButton2ActionPerformed(evt);
            }
        });

        hobbyButton3.setText("Hobby 1");
        hobbyButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hobbyButton3ActionPerformed(evt);
            }
        });

        hobbyButton4.setText("Hobby 1");
        hobbyButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hobbyButton4ActionPerformed(evt);
            }
        });

        hobbyButton5.setText("Hobby 1");
        hobbyButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hobbyButton5ActionPerformed(evt);
            }
        });

        hobbyButton6.setText("Hobby 1");
        hobbyButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hobbyButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hobbiesContainerLayout = new javax.swing.GroupLayout(hobbiesContainer);
        hobbiesContainer.setLayout(hobbiesContainerLayout);
        hobbiesContainerLayout.setHorizontalGroup(
            hobbiesContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hobbiesContainerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectHobbiesHeading)
                .addGap(73, 73, 73))
            .addGroup(hobbiesContainerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(hobbiesContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hobbyButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hobbyButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(hobbiesContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(hobbyButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hobbyButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hobbyButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(hobbyButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hobbiesContainerLayout.setVerticalGroup(
            hobbiesContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hobbiesContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectHobbiesHeading)
                .addGap(29, 29, 29)
                .addComponent(hobbyButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hobbyButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hobbyButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hobbyButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hobbyButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hobbyButton6)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        cityTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityTextFieldActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel6.setText("City:");

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



        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        bioTextArea.setColumns(20);
        bioTextArea.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        bioTextArea.setLineWrap(true);
        bioTextArea.setRows(5);
        bioTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(bioTextArea);

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel7.setText("Bio:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pageHeading)
                .addGap(536, 536, 536))
            .addGroup(layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hobbiesContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(308, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(474, 474, 474))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(416, 416, 416))))
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
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(fnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(lnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hobbiesContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(27, 27, 27)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(errorLabel)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
    }

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String fname = fnameTextField.getText();
		String lname = lnameTextField.getText();
		String phone = phoneTextField.getText();
		String username = usernameTextField.getText();
		String city = cityTextField.getText();
		String bio = bioTextArea.getText();

		if (fname.isEmpty() || lname.isEmpty()) {
			errorLabel.setText("Name Should Not Be Empty");
			errorLabel.setVisible(true);
			return;
		}

		ArrayList<Hobby> hobbies = new ArrayList<>();
		if (hobbyButton1.isSelected()) hobbies.add(SocialMedia.hobbies.get(0));
		if (hobbyButton2.isSelected()) hobbies.add(SocialMedia.hobbies.get(1));
		if (hobbyButton3.isSelected()) hobbies.add(SocialMedia.hobbies.get(2));
		if (hobbyButton4.isSelected()) hobbies.add(SocialMedia.hobbies.get(3));
		if (hobbyButton5.isSelected()) hobbies.add(SocialMedia.hobbies.get(4));
		if (hobbyButton6.isSelected()) hobbies.add(SocialMedia.hobbies.get(5));

		SocialMedia.db.updateUserData(
			SocialMedia.getCurrentUser(), fname, lname, phone, username, city, bio, hobbies
		);
    }

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
	}

    private void fnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void lnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
	}

    private void phoneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void hobbyButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
	}

    private void hobbyButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void hobbyButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void hobbyButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void hobbyButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void hobbyButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SocialMedia.states.changeState(new SettingsPage());
    }

    // Variables declaration - do not modify
    private javax.swing.JButton backButton;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JTextField fnameTextField;
    private javax.swing.JPanel hobbiesContainer;
    private javax.swing.JRadioButton hobbyButton1;
    private javax.swing.JRadioButton hobbyButton2;
    private javax.swing.JRadioButton hobbyButton3;
    private javax.swing.JRadioButton hobbyButton4;
    private javax.swing.JRadioButton hobbyButton5;
    private javax.swing.JRadioButton hobbyButton6;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea bioTextArea;
    private javax.swing.JTextField lnameTextField;
    private javax.swing.JLabel pageHeading;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JLabel selectHobbiesHeading;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration
}
