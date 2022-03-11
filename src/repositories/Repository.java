package repositories;

import daos.DAO;
import daos.SQLDAO;

import java.util.List;

import daos.TestDAO;
import model.Account;
import model.Administrator;

public class Repository{
    private final DAO dao;

    public Repository()
    {
        dao = new TestDAO();
    }

    public Account getAccount(String username)
    {
        return dao.getAccount(username);
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
