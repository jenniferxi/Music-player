package Commands;

import Main.AccountManager;
import Main.Program;

import java.util.Scanner;

public class Create extends Command{

    public void executeCommand(AccountManager AM, Program p){
        if(p.getLocation() == 0){
            Scanner in = new Scanner(System.in);
            System.out.println("Enter username");
            String username = in.nextLine();
            System.out.println("Enter password");
            String password = in.nextLine();
            if (AM.createAccount(username, password)) {
                System.out.println("Account created successfully!");
            }
            else{
                System.out.println("An account with this username already exists.");
            }
            p.loginDisplay();
        }
        else{
            System.out.println("can't use that command here");
        }
    }
}
