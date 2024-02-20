package UI.Templates;

import javax.swing.*;

import Models.Post;
import main.SocialMedia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCommentBox extends JPanel {
    private JTextArea commentTextArea;
	private Post post;

    public AddCommentBox(Post post) {
		this.post = post;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        commentTextArea = new JTextArea();
        commentTextArea.setLineWrap(true);
        commentTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(commentTextArea);

        JButton postButton = new JButton("Post Comment");
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String commentText = commentTextArea.getText();
                if (!commentText.isEmpty()) {
					SocialMedia.getCurrentUser().postComment(post, commentText);

                    System.out.println("Comment posted: " + commentText);

                    commentTextArea.setText("");
                }
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(postButton, BorderLayout.SOUTH);

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		setPreferredSize(new Dimension(550, 100));
    }
}
