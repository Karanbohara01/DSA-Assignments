package UI.Screens;

import java.awt.*;
import java.util.ArrayList;

//import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import Models.Page;
import Models.Post;
import UI.Templates.PostTemplate;
import main.SocialMedia;

public class ViewPagePage extends BasePage {
	private Page page;

    public ViewPagePage(Page page) {
		this.page = page;
        initComponents();
		loadPageData();

        if (SocialMedia.getCurrentUser().getLikedPages().contains(page))
            likeButton.setVisible(false);

		//Bring the view to the start of page
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                scrollPane.getViewport().setViewPosition(new java.awt.Point(0, 0));
            }
        });
    }

	private void loadPageData() {
		pageName.setText(page.getName());
		ArrayList<Post> posts = page.getPosts();

		container.setPreferredSize(new Dimension(container.getWidth(), (posts.size() + 1) * 200 + 100));
		for (int i = 0; i < posts.size(); i++) {
			container.add(new PostTemplate(posts.get(i), i));
		}
	}

	private void initComponents() {
        scrollPane = new javax.swing.JScrollPane();
        container = new javax.swing.JPanel();
        pageName = new javax.swing.JLabel();
        likeButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pageName.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        pageName.setText("page name can be long");

        likeButton.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        likeButton.setText("Like");
        likeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                likeButtonActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(likeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pageName)))
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1145, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(backButton)
                .addGap(45, 45, 45)
                .addComponent(pageName)
                .addGap(18, 18, 18)
                .addComponent(likeButton)
                .addContainerGap(565, Short.MAX_VALUE))
        );

        scrollPane.setViewportView(container);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void likeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SocialMedia.db.likePage(SocialMedia.getCurrentUser(), page);
	}

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SocialMedia.states.changeState(new HomePage());
    }

    // Variables declaration - do not modify
    private javax.swing.JButton backButton;
    private javax.swing.JPanel container;
    private javax.swing.JButton likeButton;
    private javax.swing.JLabel pageName;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration
}
