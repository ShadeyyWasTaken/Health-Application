package daos;

import model.Account;
import model.Administrator;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class SQLDAO extends DAO{
    static private final String username = "root";
    static private final String password = "";
    static private final String url = "jdbc:mysql://localhost:3307/healthapp";
    static private Connection connection = null;

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
        String text = "\"" + username + "\"";
        String queryString = "CALL GETACCOUNT(" + "\"" + username + "\"" + ")";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryString);
            Account account = null;

            if (resultSet.next()) {
                String password = resultSet.getString("PASSWORD");
                String email = resultSet.getString("EMAIL");
                String userRole = resultSet.getString("USERROLE");

                if(userRole.equals("user")) {
                    account = new Account(username, password, email);
                }
                else if(userRole.equals("administrator"))
                {
                    account = new Administrator(username, password, email);
                }
                else{
                    System.out.println("Error");
                }

                //List<Activity> activities = getReviews(restaurantId);
                //restaurant.setReviewsCollection(reviewsCollection);
                return account;
            }
        } catch (SQLException ex) {System.out.println(ex.getMessage());}
        return null;
    }

    @Override
    public List<Account> getAllAccounts()
    {
        List<Account> accounts = new ArrayList<>();
        Account account = null;
        try {
            String queryString = "CALL GETACCOUNTS()";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryString);

            while (resultSet.next()) {
                String username = resultSet.getString("USERNAME");
                String password = resultSet.getString("PASSWORD");
                String email = resultSet.getString("EMAIL");
                String userRole = resultSet.getString("USERROLE");

                if(userRole.equals("user")) {
                    account = new Account(username, password, email);
                }
                else if(userRole.equals("administrator"))
                {
                    account = new Administrator(username, password, email);
                }
                else{
                    System.out.println("Error not existing role");
                }

                //When we create the activities
                //List<Account> reviewsCollection = getReviews(restaurantId);
                //restaurant.setReviewsCollection(reviewsCollection);

                if (account != null)
                {
                    accounts.add(account);
                }
                else
                {
                    System.out.println("Error");
                }
            }
        } catch (SQLException ex) {System.out.println(ex.getMessage());}

        return accounts;
    }

    public boolean makeAdministrator(String username)
    {
        return false;
    }

    public Account login(String username, String password)
    {
        Account newAccount = getAccount(username);
        if (newAccount == null)
        {
            System.out.println("No account found with that username!");
            return null;
        }
        else
        {
            if (password.equals(newAccount.getPassword()))
            {
                System.out.println("Login successfull!");
                return newAccount;
            }
            else
            {
                System.out.println("Wrong password!");
                return null;
            }
        }

    }

    public boolean register(String username, String password, String email)
    {
        if(getAccount(username) != null){
            System.out.println("An account with that username exists!");
            return false;
        }
        else {
            String queryString = "CALL AddAccount('";
            queryString += username + "', '";
            queryString += password + "', '";
            queryString += email + "')";

            try
            {
                Statement statement = connection.createStatement();
                statement.executeUpdate(queryString);
            }
            catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        return true;
    }
}
