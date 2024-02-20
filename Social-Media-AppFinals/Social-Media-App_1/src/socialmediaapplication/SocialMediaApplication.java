
package socialmediaapplication;

import Dao.ProfileManager;
import controller.CreateProfileController;
import UI.CreateProfileView;

public class SocialMediaApplication {

    public static void main(String[] args) {
        // TODO code application logic here
                // Initialize Model
        ProfileManager profileManager = new ProfileManager();

        // Initialize Controller
        CreateProfileController profileCreationController = new CreateProfileController(profileManager);

        // Initialize View
        CreateProfileView createProfileView = new CreateProfileView(profileCreationController);

        // Display the GUI
        createProfileView.display();
    }
    
}
