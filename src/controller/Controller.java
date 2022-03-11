package controller;

import repositories.Repository;

import java.util.Scanner;

public class Controller {
    Repository repository;

    public Controller()
    {
        repository = new Repository();
    }

    public void run() {

        boolean finished = false;

        do {
            String username;
            String password;
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nA. Get Account");
            System.out.print("\tB. Get All Accounts");
            System.out.print("\tC. Register Account");
            System.out.print("\tD. Log In Account");
            System.out.print("\tQ. Quit\n");
            String choice = scanner.next();
            switch (choice) {
                case "A":
                    System.out.print("\nInput username:");
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
                    System.out.print("\nInput username:");
                    username = scanner.next();
                    System.out.print("\nInput password:");
                    password = scanner.next();
                    repository.register(username, password);
                    break;
                case "D":
                    System.out.print("\nInput username:");
                    username = scanner.next();
                    System.out.print("\nInput password:");
                    password = scanner.next();
                    repository.login(username, password);
                    break;
                case "Q":
                    finished = true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        } while (!finished);
    }
}
