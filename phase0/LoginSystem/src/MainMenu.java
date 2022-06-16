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
            else{
                System.out.println("Invalid input, try again...");
                run();
            }
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }
}
