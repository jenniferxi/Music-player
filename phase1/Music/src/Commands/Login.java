package Commands;

import java.util.Scanner;
import Main.Program;
import Main.AccountManager;

public class Login extends Command {

    public void executeCommand(AccountManager AM, Program p){
        if(p.getLocation() == 0){
            Scanner in = new Scanner(System.in);
            System.out.println("Enter username");
            String username = in.nextLine();
            System.out.println("Enter password");
            String password = in.nextLine();
            if(AM.authenticate(username, password)){
                System.out.println("login successful");
                System.out.println(AM.getActiveUser());
                p.mainMenu();
            }
            else {
                System.out.println("login failed");
                p.loginDisplay();
            }
        }
        else{
            System.out.println("can't use that command here");
        }
    }
}
