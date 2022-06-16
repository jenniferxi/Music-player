import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class MainMenu {
    private AccountManager AM;

    public MainMenu(AccountManager accountManager){
        AM = accountManager;
    }

    public void run(){
        System.out.println("Welcome to the main menu. \n" +
                "1. Log out \n" +
                "2. View login history \n" +
                "3. Print active account");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        try {
            String input = br.readLine();
            if(input.equals("1")){
                System.out.println("Logging out of account...");
            }
            else if (input.equals("2")) {
                System.out.println(AM.getUserLoginHistory(AM.getActiveUser()));
                run();
            }
            else if (input.equals("3")) {
                System.out.println("Currently, user " + AM.getActiveUser() + " is logged in.");
                run();
            }
            else if (input.equals("DeleteAccount") && AM.isPermitted()){
                deleteAccount();
            }
            else if (input.equals("NewAdminAccount") && AM.isPermitted()){
                createAdminAccount();
            }
            else{
                System.out.println("Invalid input, try again...");
                run();
            }
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }

    public void deleteAccount(){
        System.out.println("Enter the username of the account you would like to delete");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            String input = br.readLine();
            if(AM.deleteAccount(input)){
                System.out.println("Account deleted successfully.");
            }
            else{
                System.out.println("Account couldn't be found.");
            }
            run();
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }
    public void createAdminAccount() {
        System.out.println("Please enter a username");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String username = br.readLine();
            System.out.println("Please enter a password");
            String password = br.readLine();
            if (AM.createAdminAccount(username, password)) {
                System.out.println("Account created successfully!");
            }
            else{
                System.out.println("An account with this username already exists.");
            }
            run();
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }
}
