package daos;

import java.util.List;

import model.Account;
import model.Administrator;


public abstract class DAO {

    public abstract Account getAccount(String username);

    public abstract List<Account> getAllAccounts();

    public abstract Account login(String username, String password);

    public abstract boolean register(String username, String password, String email);
}
