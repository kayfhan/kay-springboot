package me.kay.entities;

public class Login {
    private String username;
    private String password;
    private boolean isRemember;

    public Login(String username, String password, boolean isRemember) {
        this.username = username;
        this.password = password;
        this.isRemember = isRemember;
    }

    public Login() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return isRemember;
    }

    public void setRemember(boolean remember) {
        isRemember = remember;
    }

    @Override
    public String toString() {
        return "Login{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isRemember=" + isRemember +
                '}';
    }
}
