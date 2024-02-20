package UI.Screens;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import Models.Comment;
import Models.Post;
import UI.Templates.AddCommentBox;
import UI.Templates.CommentBox;
import UI.Templates.PostTemplate;
import main.SocialMedia;

public class ViewPostPage extends BasePage {
	private Post post;

    public ViewPostPage(Post post) {
		this.post = post;
		ArrayList<Comment> comments = post.getComments();
        initComponents();

		container.setPreferredSize(new Dimension(container.getWidth(), 200 + comments.size() * 100));
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.setBorder(new EmptyBorder(20, 20, 0, 0));

		PostTemplate postTemplate = new PostTemplate(post, 0);
		postTemplate.setPreferredSize(new Dimension(postTemplate.getBounds().width, postTemplate.getBounds().height));
		postTemplate.setMaximumSize(new Dimension(postTemplate.getBounds().width, postTemplate.getBounds().height));
		container.add(postTemplate);
		container.add(new JLabel(" "));
		container.add(new JLabel(" "));

		AddCommentBox newComment = new AddCommentBox(post);
		newComment.setMaximumSize(newComment.getPreferredSize());
		container.add(newComment);

		for (int i = 0; i < comments.size(); i++) {
			CommentBox commentBox = new CommentBox(comments.get(i));
			commentBox.setMaximumSize(commentBox.getPreferredSize());
			container.add(commentBox);
		}
    }

    private void initComponents() {

        pageHeading = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        container = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pageHeading.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        pageHeading.setText("Post");

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1058, Short.MAX_VALUE)
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(container);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pageHeading)
                .addGap(599, 599, 599))
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
                .addGap(101, 101, 101)
                .addComponent(scrollPane))
        );

        pack();
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SocialMedia.states.changeState(new HomePage());
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel pageHeading;
	private javax.swing.JScrollPane scrollPane;
	private javax.swing.JPanel container;
	private javax.swing.JButton backButton;
    // End of variables declaration
}
