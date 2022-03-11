package daos;

import model.Account;
import model.Administrator;

import java.util.ArrayList;
import java.util.List;

public class TestDAO extends DAO{
    List<Account> accountsList;

    public TestDAO()
    {
        accountsList = new ArrayList<>();
        Account account1 = new Account("test1", "pass1");
        Account account2 = new Account("test2", "pass2");
        Account account3 = new Account("test3", "pass3");
        Account account4 = new Account("test4", "pass4");
        Account admin1 = new Administrator("admin1", "pass1");
        Account admin2 = new Administrator("admin2", "pass2");
        Account admin3 = new Administrator("admin3", "pass3");
        Account userToAdm = new Account("testAdmin", "passAdmin");
        Administrator newAdmin = new Administrator(userToAdm);
        accountsList.add(account1);
        accountsList.add(account2);
        accountsList.add(account3);
        accountsList.add(account4);
        accountsList.add(admin1);
        accountsList.add(admin2);
        accountsList.add(admin3);
        accountsList.add(newAdmin);
    }

    @Override
    public Account getAccount(String username)
    {
        List <Account> accounts = getAllAccounts();

        if(accounts.size() > 0)
        {
            for (Account account : accounts)
            {
                if (account.getUsername().equals(username))
                {
                    return account;
                }
            }
        }
        return null;
    }

    @Override
    public List<Account> getAllAccounts()
    {
        return accountsList;
    }

    @Override
    public String login(String username, String password)
    {
        return "Not implemented";
    }

    @Override
    public boolean register(String username, String password)
    {
        return false;
    }

}
