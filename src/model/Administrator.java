package model;

public class Administrator extends Account{
    private String username;
    private String password;
    private String userRole;
    
    public Administrator(String username, String password)
    {
        super(username, password);
        this.userRole = "administrator";
    }
}
