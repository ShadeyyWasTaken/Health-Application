package daos;

import helpers.SecurityHelper;
import helpers.ValidationHelper;
import model.Account;
import model.AccountAttributes;
import model.Administrator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
                List<AccountAttributes> attributes = getAccountAttributes(username);

                if(userRole.equals("user")) {
                    account = new Account(username, password, email, attributes);
                }
                else if(userRole.equals("administrator"))
                {
                    account = new Administrator(username, password, email, attributes);
                }
                else{
                    System.out.println("Error");
                }

                return account;
            }
        } catch (SQLException ex) {System.out.println(ex.getMessage());}
        return null;
    }

    @Override
    public AccountAttributes getAccountAttributesByDate(String username, String date)
    {
        String text = "\"" + username + "\"";
        String queryString = "CALL GETACCOUNTATTRIBUTESBYDATE(" + "\"" + username + "\"" + ", \"" + date + "\"" + ")";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryString);

            if (resultSet.next()) {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                double weight = resultSet.getDouble("WEIGHT");
                double weightGoal = resultSet.getDouble("WEIGHT_GOAL");
                int age = resultSet.getInt("AGE");
                String gender = resultSet.getString("GENDER");
                int height = resultSet.getInt("HEIGHT");
                int heartRate = resultSet.getInt("HEART_RATE");
                int restingHeartRate = resultSet.getInt("RESTING_HEART_RATE");
                int bloodPressure = resultSet.getInt("BLOOD_PRESSURE");
                int bloodOxygen = resultSet.getInt("BLOOD_OXYGEN");
                int respiratoryRate = resultSet.getInt("RESPIRATORY_RATE");
                int lungCapacity = resultSet.getInt("LUNG_CAPACITY");
                int steps = resultSet.getInt("STEPS");
                double walkingDistance = resultSet.getDouble("WALKING_DISTANCE");
                int walkingTime = resultSet.getInt("WALKING_TIME");
                int sleepTime = resultSet.getInt("SLEEP_TIME");
                int sleepGoal = resultSet.getInt("SLEEP_GOAL");
                int waterIntake = resultSet.getInt("WATER_INTAKE");
                int waterGoal = resultSet.getInt("WATER_GOAL");
                LocalDate todayDate = LocalDate.parse(resultSet.getString("TODAY_DATE"), formatter);
                boolean appointment = resultSet.getBoolean("APPOINTMENT");
                String mood = resultSet.getString("MOOD");
                String stressLevel = resultSet.getString("STRESS_LEVEL");


                return new AccountAttributes(weight, weightGoal, age, gender, height, heartRate
                        , restingHeartRate, bloodPressure, bloodOxygen, respiratoryRate, lungCapacity, steps, walkingDistance
                        ,walkingTime, sleepTime, sleepGoal ,waterIntake ,waterGoal ,todayDate, appointment, mood, stressLevel);

            }
        } catch (SQLException ex) {System.out.println(ex.getMessage());}
        return null;
    }

    @Override
    public List<AccountAttributes> getAccountAttributes(String username)
    {
        List<AccountAttributes> accountAttributesList = new ArrayList<>();
        String text = "\"" + username + "\"";
        String queryString = "CALL GETACCOUNTATTRIBUTES(" + "\"" + username + "\"" + ")";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryString);

            while (resultSet.next()) {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                double weight = resultSet.getDouble("WEIGHT");
                double weightGoal = resultSet.getDouble("WEIGHT_GOAL");
                int age = resultSet.getInt("AGE");
                String gender = resultSet.getString("GENDER");
                int height = resultSet.getInt("HEIGHT");
                int heartRate = resultSet.getInt("HEART_RATE");
                int restingHeartRate = resultSet.getInt("RESTING_HEART_RATE");
                int bloodPressure = resultSet.getInt("BLOOD_PRESSURE");
                int bloodOxygen = resultSet.getInt("BLOOD_OXYGEN");
                int respiratoryRate = resultSet.getInt("RESPIRATORY_RATE");
                int lungCapacity = resultSet.getInt("LUNG_CAPACITY");
                int steps = resultSet.getInt("STEPS");
                double walkingDistance = resultSet.getDouble("WALKING_DISTANCE");
                int walkingTime = resultSet.getInt("WALKING_TIME");
                int sleepTime = resultSet.getInt("SLEEP_TIME");
                int sleepGoal = resultSet.getInt("SLEEP_GOAL");
                int waterIntake = resultSet.getInt("WATER_INTAKE");
                int waterGoal = resultSet.getInt("WATER_GOAL");
                LocalDate todayDate = LocalDate.parse(resultSet.getString("TODAY_DATE"), formatter);
                boolean appointment = resultSet.getBoolean("APPOINTMENT");
                String mood = resultSet.getString("MOOD");
                String stressLevel = resultSet.getString("STRESS_LEVEL");


                AccountAttributes attributes = new AccountAttributes(weight, weightGoal, age, gender, height, heartRate
                , restingHeartRate, bloodPressure, bloodOxygen, respiratoryRate, lungCapacity, steps, walkingDistance
                ,walkingTime, sleepTime, sleepGoal ,waterIntake ,waterGoal ,todayDate, appointment, mood, stressLevel);

                accountAttributesList.add(attributes);

            }
            return accountAttributesList;
        } catch (SQLException ex) {System.out.println(ex.getMessage());}
        return accountAttributesList;
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

            while (resultSet.next())
            {
                String username = resultSet.getString("USERNAME");
                String password = resultSet.getString("PASSWORD");
                String email = resultSet.getString("EMAIL");
                String userRole = resultSet.getString("USERROLE");
                List<AccountAttributes> attributes = getAccountAttributes(username);

                if(userRole.equals("user")) {
                    account = new Account(username, password, email, attributes);
                }
                else if(userRole.equals("administrator"))
                {
                    account = new Administrator(username, password, email, attributes);
                }
                else{
                    System.out.println("Error not existing role");
                }


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
        if (getAccount(username) == null)
        {
            System.out.println("No account found with that username!");
            return false;
        }
        else
        {
            String queryString = "CALL MakeAdministrator('";
            queryString += username + "')";

            try
            {
                Statement statement = connection.createStatement();
                statement.executeUpdate(queryString);
            }
            catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
                return false;
            }

            System.out.print("The account has been successfully made an administrator!");
            return true;
        }
    }

    public Account login(String username, String password)
    {
        Account account = null;
        String saltDB = null;

        try {
            String text = "\"" + username + "\"";
            String queryString = "CALL GETACCOUNT(" + "\"" + username + "\"" + ")";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryString);

            if (resultSet.next())
            {
                String passwordDB = resultSet.getString("PASSWORD");
                saltDB = resultSet.getString("SALT");
                String emailDB = resultSet.getString("EMAIL");
                String userRoleDB = resultSet.getString("USERROLE");
                List<AccountAttributes> attributes = getAccountAttributes(username);

                if(userRoleDB.equals("user")) {
                    account = new Account(username, passwordDB, emailDB, attributes);
                }
                else if(userRoleDB.equals("administrator"))
                {
                    account = new Administrator(username, passwordDB, emailDB, attributes);
                }
                else{
                    System.out.println("Error");
                    return null;
                }
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }



        if (account != null)
        {
            if (account.getPassword().equalsIgnoreCase(SecurityHelper.hashPassword(password, saltDB)))
            {
                return account;
            }

            else
            {
                System.out.println("Incorrect username or password!");
                return null;
            }
        }
        else
        {
            System.out.println("Account does not exist");
            return null;
        }
    }

    public boolean register(String username, String password, String salt, String email)
    {
        if(getAccount(username) != null){
            System.out.println("An account with that username exists!");
            return false;
        }
        else {
            String queryString = "CALL AddAccount('";
            queryString += username + "', '";
            queryString += password + "', '";
            queryString += salt + "', '";
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

    public boolean addActivity(String username, String date)
    {
        date = ValidationHelper.dateChecker(date);
        if(date != null)
        {
            if(getAccount(username) == null)
            {
                System.out.println("An account with that username does not exist!");
                return false;
            }

            else {
                if(getAccountAttributesByDate(username, date) != null){
                    System.out.println("An activity for this date already exists!");
                    return false;
                }
                else {
                    String queryString = "CALL AddActivity('";
                    queryString += username + "', '";
                    queryString += date + "')";

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
        else {
            System.out.println("Invalid Date!");
            return false;
        }

    }

    public boolean changeAttribute(String username, String attribute, String value, String date)
    {
        if(getAccount(username) == null)
        {
            System.out.println("An account with that username does not exist!");
            return false;
        }

        else {
            if(getAccountAttributesByDate(username, date) == null){
                addActivity(username, date);

            }

            String queryString = "CALL ChangeAttribute('";
            queryString += username + "', '";
            queryString += attribute + "', '";
            queryString += value + "', '";
            queryString += date + "')";
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

    public boolean changeUserInfo(String username, String attribute, String value)
    {
        if(getAccount(username) == null)
        {
            System.out.println("An account with that username does not exist!");
            return false;
        }

        else {

            if (attribute.equalsIgnoreCase("password"))
            {
                String saltDB = null;

                try {
                    String text = "\"" + username + "\"";
                    String queryString = "CALL GETACCOUNT(" + "\"" + username + "\"" + ")";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(queryString);

                    if (resultSet.next())
                    {
                        saltDB = resultSet.getString("SALT");
                    }
                }
                catch (SQLException ex)
                {
                    System.out.println(ex.getMessage());
                }

                attribute = SecurityHelper.hashPassword(password, saltDB);
            }

            String queryString = "CALL ChangeUserInfo('";
            queryString += username + "', '";
            queryString += attribute + "', '";
            queryString += value + "')";
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
