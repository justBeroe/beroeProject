package bg.softuni.beroe.model.dto;

public class UserProfileDto {
    private String username;
    private String firstName;

    public String getUsername() {
        return username;
    }

    public UserProfileDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserProfileDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
}
