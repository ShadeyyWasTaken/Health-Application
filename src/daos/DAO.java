package daos;

import java.util.List;

import model.Account;
import model.AccountAttributes;
import model.Administrator;


public abstract class DAO {

    public abstract Account getAccount(String username);

    public abstract List<Account> getAllAccounts();

    public abstract List<AccountAttributes> getAccountAttributes(String username);

    public abstract AccountAttributes getAccountAttributesByDate(String username, String date);

    public abstract Account login(String username, String password);

    public abstract boolean register(String username, String password, String salt , String email);

    public abstract boolean makeAdministrator(String username);

    public abstract boolean addActivity(String username, String date);

    public abstract boolean changeAttribute(String username, String attribute, String value, String date);

    public abstract boolean changeUserInfo(String username, String attribute, String value);
}
