package UI.Templates;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import Models.Object;
import UI.Screens.ProfilePage;
import UI.Screens.ViewPagePage;
import main.SocialMedia;

public class UserButton extends JLabel {
	private Object object;

	public UserButton(Object obj) {
		this.object = obj;

		setText(object.getName());
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
				if (object.getID().charAt(0) == 'u')
					SocialMedia.states.changeState(new ProfilePage(SocialMedia.searchUserByID(object.getID())));
				else
					SocialMedia.states.changeState(new ViewPagePage(SocialMedia.searchPageByID(object.getID())));
            }
        });
	}
}
