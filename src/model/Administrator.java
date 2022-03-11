package model;

public class Administrator extends Account{
    private String username;
    private String password;
    private String email;
    private String userRole;

    public Administrator(String username, String password, String email)
    {
        super(username, password, email);
        super.userRole = "administrator";
    }

    public Administrator(Account account)
    {
        super(account.getUsername(), account.getPassword(), account.getEmail());
        super.userRole = "administrator";
    }

    private void setUserRole(String userRole)
    {
        this.userRole = userRole;
    }
}
