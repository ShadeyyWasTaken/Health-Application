package daos;

import model.Account;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class SQLDAO extends DAO{
    static private final String username = "root";
    static private final String password = "";
    static private final String url = "jdbc:mysql://localhost:3306/healthapp";
    static private Connection connection = null;
    static private Statement stmt = null;
    static private ResultSet rs  = null;

    public SQLDAO()
    {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database");
        } catch (SQLException ex) {System.out.println(ex.getMessage());}
    }

    @Override
    public Account getAccount(String username)
    {
        return null;
    }

    @Override
    public List<Account> getAllAccounts()
    {
        return null;
    }

    public String login(String username, String password) {

        try{
            



        }





        return "Not implemented";
    }

    public boolean register(String username, String password)
    {
        return false;
    }
}
