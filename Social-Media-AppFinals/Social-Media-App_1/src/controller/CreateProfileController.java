
package controller;

import Dao.ProfileManager;

public class CreateProfileController {
    private ProfileManager profileManager;

    public CreateProfileController(ProfileManager profileManager) {
        this.profileManager = profileManager;
    }

    public boolean createProfile(String username, String name, String photoURL, String address, String bio) {
        return profileManager.createProfile(username, name, photoURL, address, bio);
    }
    
}
