
package model;

public class CreateProfileModel {
    private String username;
    private String name;
    private String photoURL;
    private String address;
    private String bio;

    public CreateProfileModel(String username, String name, String photoURL, String address, String bio) {
        this.username = username;
        this.name = name;
        this.photoURL = photoURL;
        this.address = address;
        this.bio = bio;
    }

    // Getters and setters
}

