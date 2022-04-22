package model;

import java.util.List;

public class Account {
    private String username;
    private String password;
    private String email;
    private List<AccountAttributes> attributes;
    protected String userRole;

    public Account(String username, String password, String email, List<AccountAttributes> attributes)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.attributes = attributes;
        this.userRole = "user";
    }


    public List<AccountAttributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AccountAttributes> attributes) {
        this.attributes = attributes;
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
                ", Attributes='" + attributes + '\'' +
                '}';
    }
}
