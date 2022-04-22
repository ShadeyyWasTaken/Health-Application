package repositories;

import daos.DAO;
import daos.SQLDAO;

import java.util.List;

import helpers.SecurityHelper;
import model.Account;
import model.AccountAttributes;

public class Repository{
    private final DAO dao;

    public Repository()
    {
        dao = new SQLDAO();
    }

    public Account getAccount(String username)
    {
        return dao.getAccount(username);
    }

    public List<Account> getAllAccounts()
    {
        return dao.getAllAccounts();
    }

    public List<AccountAttributes> getAccountAttributes(String username)
    {
        return dao.getAccountAttributes(username);
    }

    public AccountAttributes getAccountAttributesByDate(String username, String date) { return dao.getAccountAttributesByDate(username, date); }

    public Account login(String username, String password)
    {
        return dao.login(username, password);
    }

    public boolean register(String username, String password, String email)
    {
        String salt = SecurityHelper.generateSaltValue(30);
        String hashedPassword = SecurityHelper.hashPassword(password, salt);
        return dao.register(username, hashedPassword, salt, email);
    }

    public boolean addActivity(String username, String date)
    {
        return dao.addActivity(username, date);
    }

    public boolean changeAttribute(String username, String attribute, String value, String date){
        return dao.changeAttribute(username, attribute, value, date);
    }

    public boolean makeAdministrator(String username)
    {
        return dao.makeAdministrator(username);
    }
}
