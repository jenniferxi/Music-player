import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginSystem {
    private AccountManager AM;

    public LoginSystem(AccountManager accountManager) {
        AM = accountManager;
    }

    public void display() {
        System.out.println("Welcome to the login system. \n" +
                "1. Login to an existing account \n" +
                "2. Create a new account \n" +
                "3. Exit program");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String input = br.readLine();
            if (input.equals("1")) {
                login();
            } else if (input.equals("2")) {
                createAccount();
            } else if (input.equals("3")) {
                System.out.println("Exiting program...");
            } else {
                System.out.println("Invalid input, try again...");
                display();
            }
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }

    public void createAccount() {
        System.out.println("Please enter a username");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String username = br.readLine();
            System.out.println("Please enter a password");
            String password = br.readLine();
            if (AM.createAccount(username, password)) {
                System.out.println("Account created successfully!");
            }
            display();
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }

    public void login() {
        System.out.println("Please enter your username");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String username = br.readLine();
            System.out.println("Please enter your password");
            String password = br.readLine();
            if (AM.authenticate(username, password)) {
                System.out.println("User " + username + " has logged in successfully!");
                AM.setActiveUser(username);
                MainMenu m = new MainMenu(AM);
                m.run();
            } else {
                System.out.println("There's an error with the username or password.");
            }
            display();
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }

}
