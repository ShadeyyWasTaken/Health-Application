package model;

public class Administrator extends Account{
    private String username;
    private String password;
    private String userRole;

    public Administrator(String username, String password)
    {
        super(username, password);
        super.userRole = "administrator";
    }

    public Administrator(Account account)
    {
        super(account.getUsername(), account.getPassword());
        super.userRole = "administrator";
    }

    private void setUserRole(String userRole)
    {
        this.userRole = userRole;
    }
}
