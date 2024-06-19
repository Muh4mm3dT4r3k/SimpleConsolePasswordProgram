package org.example;

public class User {
    private String username;
    private String email;
    private String password;
    private int wrongPassword;

    public User() {
        this.wrongPassword = 0;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.wrongPassword = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWrongPassword() {
        return wrongPassword;
    }

    public void setWrongPassword(int wrongPassword) {
        this.wrongPassword = wrongPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", wrongPassword=" + wrongPassword +
                '}' + '\n';
    }
}
