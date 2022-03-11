package model;

public class Account {
    private String username;
    private String password;
    private String email;
    protected String userRole;

    public Account(String username, String password, String email)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRole = "user";
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getUserRole() {
        return userRole;
    }


    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
