package daos;

import java.util.List;

import model.Account;
import model.Administrator;


public abstract class DAO {

    public abstract Account getAccount();

    public abstract List<Account> getAllAccounts();

    public String login(String username, String password) {
        return "Not implemented";
    }

    public boolean register(String username, String password) {
        return false;
    }
}
