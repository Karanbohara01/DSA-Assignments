package UI.Templates;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import Models.Post;
import Models.Object;
import UI.Screens.ViewPostPage;
import main.SocialMedia;

public class PostTemplate extends JPanel {
	private Post post;
	private boolean isLiked;

	private JLabel username;
	private JTextArea postText;

	private int width = 550;
	private int height = 200;
	private int y = 150;

	public PostTemplate(Post post, int n) {
		this.post = post;

		isLiked = checkLiked();

		username = new UserButton(this.post.getSharedBy());
		postText = new JTextArea();

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		postText.setLineWrap(true);
		postText.setWrapStyleWord(true);
		postText.setEditable(false);

		String postTest;
		if (post.isActivity()) {
			postTest = "ACTIVITY: " + post.getActivity().getText() + " " + this.post.getText();
		}
		else {
			postTest = this.post.getText();
		}
		postText.setText(postTest);

		JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        usernamePanel.add(username);

		JButton likeButton = new JButton();
		likeButton.setText(isLiked ? "Liked" : "Like");
		likeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				likeButtonActionPerformed(evt);
            }
        });

		JButton commentButton = new JButton();
		commentButton.setText("Comment");
		commentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentButtonActionPerformed(evt);
            }
        });

		JPanel bar = new JPanel();
		bar.add(likeButton);
		bar.add(commentButton);

		add(usernamePanel);
		add(postText);
		add(bar);

		setBounds(1280 / 2 - width / 2, y + (height + 10) * n, width, height);
		setBorder(new LineBorder(Color.BLACK, 2));
	}

	private boolean checkLiked() {
		for (Object user : post.getLikes()) {
			if (user.getID().equals(SocialMedia.getCurrentUser().getID()))
				return true;
		}
		return false;
	}

	private void likeButtonActionPerformed(ActionEvent evt) {
		System.out.println("like button pressed");
		if (!isLiked)
			SocialMedia.getCurrentUser().likePost(post);
	}

	private void commentButtonActionPerformed(ActionEvent evt) {
		System.out.println("comment button pressed");
		SocialMedia.states.changeState(new ViewPostPage(post));
	}
}
