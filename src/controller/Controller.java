package controller;

import helpers.SecurityHelper;
import repositories.Repository;
import model.Account;
import model.Administrator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Scanner;

public class Controller {
    Repository repository;
    Account account;

    public Controller()
    {
        repository = new Repository();
    }

    public void run() {

        boolean finished = false;

        do {
            String username;
            String password;
            String email;
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nA. Get Account");
            System.out.print("\tB. Get All Accounts");
            System.out.print("\tC. Register Account");
            System.out.print("\tD. Log In Account");
            System.out.print("\tE. Make an Administrator");
            System.out.print("\tQ. Quit\n");
            String choice = scanner.next();
            switch (choice) {
                case "A":
                    System.out.print("\nInput username: ");
                    username = scanner.next();
                    try{
                        System.out.println(repository.getAccount(username).toString());
                    }
                    catch (NullPointerException ex)
                    {
                        ex.printStackTrace();
                    }
                    break;
                case "B":
                    try{
                        System.out.println(repository.getAllAccounts());
                    }
                    catch (NullPointerException ex)
                    {
                        ex.printStackTrace();
                    }
                    break;
                case "C":
                    System.out.print("\nInput username: ");
                    username = scanner.next();
                    System.out.print("\nInput password: ");
                    password = scanner.next();
                    while(!passwordChecker(password))
                    {
                        System.out.print("\nIncorrect password format! Input password: ");
                        password = scanner.next();
                    }
                    System.out.print("\nInput email:");
                    email = scanner.next();
                    String salt = SecurityHelper.generateSaltValue(30);
                    password = SecurityHelper.hashPassword(password, salt);
                    repository.register(username, password, salt, email);
                    break;
                case "D":
                    System.out.print("\nInput username: ");
                    username = scanner.next();
                    System.out.print("\nInput password: ");
                    password = scanner.next();
                    account = repository.login(username, password);
                    System.out.println(account);
                    break;
                case "E":
                    System.out.print("\nInput username: ");
                    username = scanner.next();
                    repository.makeAdministrator(username);
                    break;
                case "Q":
                    finished = true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        } while (!finished);
    }

    public boolean passwordChecker(String password)
    {
        // 1 Capital Letter
        // 1 Small Letter
        // 1 Special symbol
        // 1 Digit
        // At least 6 characters
        // Maximum 16 characters

        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{6,16}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}
