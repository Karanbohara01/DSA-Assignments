package UI.Screens;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Models.Hobby;
import Models.User;
import UI.Templates.UserButton;
import main.SocialMedia;

public class ProfilePage extends BasePage {
	private User user;

    public ProfilePage(User user) {
		this.user = user;
        initComponents();
		loadUserData();

        if (user == SocialMedia.getCurrentUser() || SocialMedia.getCurrentUser().isFriend(user)) {
            addFriendButton.setVisible(false);
        }
    }

	private void loadUserData() {
		username.setText(user.getName());
		bioTextArea.setLineWrap(true);
		bioTextArea.setWrapStyleWord(true);
		// bioTextArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc aliquam nisi mattis erat ultricies, sed aliquet nibh luctus. Pellentesque elementum aliquam mauris ut faucibus. Mauris in massa malesuada, placerat tortor sit amet, congue nibh. Integer fermentum elit eu risus blandit ultricies. Cras venenatis lacus vel tellus varius placerat. Mauris vitae egestas nunc. Praesent pellentesque erat nec condimentum vestibulum. Morbi quis quam massa. Vivamus pellentesque ut enim sit amet condimentum. Nullam porttitor sem sit amet ligula lacinia, eu egestas elit facilisis.");
        bioTextArea.setText(user.getBio());

        city.setText(user.getCity());
		loadFriends();
		loadHobbies();
	}

	private void loadFriends() {
		friendsContainer.setLayout(new BoxLayout(friendsContainer, BoxLayout.Y_AXIS));
		friendsContainer.setBorder(new EmptyBorder(10, 20, 0, 0));

		JPanel leftAligned = new JPanel();
		leftAligned.setLayout(new BoxLayout(leftAligned, BoxLayout.Y_AXIS));

		for (int i = 0; i < user.getFriends().size(); i++) {
			leftAligned.add(new JLabel(" "));
			leftAligned.add(new UserButton(user.getFriends().get(i)));
		}

		friendsContainer.add(leftAligned);
	}

	private void loadHobbies() {
		ArrayList<Hobby> hobbies = user.getHobbies();
		if (hobbies != null) {
			MiscContainer.setLayout(new BoxLayout(MiscContainer, BoxLayout.Y_AXIS));
			MiscContainer.setBorder(new EmptyBorder(10, 20, 0, 0));
			JLabel hobbiesHeading = new JLabel("Hobbies");
			hobbiesHeading.setFont(new java.awt.Font("Comic Sans MS", 0, 18));
			MiscContainer.add(hobbiesHeading);

			for (int i = 0; i < hobbies.size(); i++) {
				MiscContainer.add(new JLabel(" "));
				MiscContainer.add(new JLabel(hobbies.get(i).getName()));
			}
		}
	}

    private void initComponents() {
        profilePic = new javax.swing.JPanel();
        username = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        MiscContainer = new javax.swing.JPanel();
        friendsScrPane = new javax.swing.JScrollPane();
        friendsContainer = new javax.swing.JPanel();
        friendsHeading = new javax.swing.JLabel();
        city = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bioTextArea = new javax.swing.JTextArea();
        homeButton = new javax.swing.JButton();
        addFriendButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        profilePic.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        profilePic.setPreferredSize(new java.awt.Dimension(128, 128));

        javax.swing.GroupLayout profilePicLayout = new javax.swing.GroupLayout(profilePic);
        profilePic.setLayout(profilePicLayout);
        profilePicLayout.setHorizontalGroup(
            profilePicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );
        profilePicLayout.setVerticalGroup(
            profilePicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );

        username.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        username.setText("username");

        javax.swing.GroupLayout MiscContainerLayout = new javax.swing.GroupLayout(MiscContainer);
        MiscContainer.setLayout(MiscContainerLayout);
        MiscContainerLayout.setHorizontalGroup(
            MiscContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );
        MiscContainerLayout.setVerticalGroup(
            MiscContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(MiscContainer);

        friendsHeading.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        friendsHeading.setText("Friends");

        javax.swing.GroupLayout friendsContainerLayout = new javax.swing.GroupLayout(friendsContainer);
        friendsContainer.setLayout(friendsContainerLayout);
        friendsContainerLayout.setHorizontalGroup(
            friendsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friendsContainerLayout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(friendsHeading)
                .addContainerGap(258, Short.MAX_VALUE))
        );
        friendsContainerLayout.setVerticalGroup(
            friendsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friendsContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friendsHeading)
                .addContainerGap(414, Short.MAX_VALUE))
        );

        friendsScrPane.setViewportView(friendsContainer);

        city.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        city.setText("city");

        bioTextArea.setEditable(false);
        bioTextArea.setColumns(20);
        bioTextArea.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        bioTextArea.setRows(5);
        jScrollPane1.setViewportView(bioTextArea);

//        ImageIcon homeIcon = new ImageIcon(getClass().getResource("/images/home icon.png"));
//        homeButton.setIcon(
//            new ImageIcon(homeIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH))
//        );
homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        addFriendButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        addFriendButton.setText("Add Friend");
        addFriendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFriendButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username)
                            .addComponent(city))
                        .addGap(295, 295, 295)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(friendsScrPane, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addFriendButton)
                .addGap(18, 18, 18)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(username)
                        .addGap(18, 18, 18)
                        .addComponent(city))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(homeButton)
                            .addComponent(addFriendButton))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addGap(2, 2, 2)))))
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane)
                    .addComponent(friendsScrPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        pack();
    }

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SocialMedia.states.changeState(new HomePage());
    }

    private void addFriendButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        SocialMedia.db.addFriend(SocialMedia.getCurrentUser(), user);
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel MiscContainer;
    private javax.swing.JTextArea bioTextArea;
    private javax.swing.JLabel city;
    private javax.swing.JPanel friendsContainer;
    private javax.swing.JLabel friendsHeading;
    private javax.swing.JScrollPane friendsScrPane;
    private javax.swing.JPanel profilePic;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JLabel username;
	private javax.swing.JButton homeButton;
    private javax.swing.JButton addFriendButton;
    // End of variables declaration
}
