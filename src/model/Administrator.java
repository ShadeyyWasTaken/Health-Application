package model;

import java.util.List;

public class Administrator extends Account{
    private String username;
    private String password;
    private String email;
    private List<AccountAttributes> attributes;
    private String userRole;

    public Administrator(String username, String password, String email, List<AccountAttributes> attributes)
    {
        super(username, password, email, attributes);
        super.userRole = "administrator";
    }

    public Administrator(Account account)
    {
        super(account.getUsername(), account.getPassword(), account.getEmail(), account.getAttributes());
        super.userRole = "administrator";
    }

    private void setUserRole(String userRole)
    {
        this.userRole = userRole;
    }
}
