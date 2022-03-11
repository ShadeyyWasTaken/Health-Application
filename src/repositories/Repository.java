package repositories;

import daos.DAO;
import daos.SQLDAO;

import java.util.List;
import model.Account;
import model.Administrator;

public class Repository{
    private final DAO dao;

    public Repository()
    {
        dao = new SQLDAO();
    }

    public Account getAccount()
    {
        return dao.getAccount();
    }

    public List<Account> getAllAccounts()
    {
        return dao.getAllAccounts();
    }

    public String login(String username, String password)
    {
        return dao.login(username, password);
    }

    public boolean register(String username, String password)
    {
        return dao.register(username, password);
    }
}
