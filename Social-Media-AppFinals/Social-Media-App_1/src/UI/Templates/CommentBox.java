package UI.Templates;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Models.Comment;

public class CommentBox extends JPanel {
	Comment comment;

	public CommentBox(Comment comment) {
		this.comment = comment;
		initComponents();

		// for (int i = 0; i < this.comments.size(); i ++) {
		// 	System.out.println(comments.get(i).getText());
		// 	add(new JLabel(comments.get(i).getPoster().getName()));
		// 	add(new JLabel(comments.get(i).getText()));
		// }
	}

    private void initComponents() {
        setLayout(new BorderLayout());

        // User label at the top
        JLabel userLabel = new JLabel(comment.getPoster().getName());

        // Comment text in the center
        JTextArea commentArea = new JTextArea(comment.getText());
        commentArea.setLineWrap(true);
        commentArea.setWrapStyleWord(true);
        commentArea.setEditable(false);

        // Add components to the panel
        add(userLabel, BorderLayout.NORTH);
        add(new JScrollPane(commentArea), BorderLayout.CENTER);

        // Add some padding around the panel
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		setPreferredSize(new Dimension(550, 100));
    }
}