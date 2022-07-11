package Commands;

import Main.AccountManager;
import Main.Program;

import java.util.Scanner;

public class CreateAdmin extends Command{

    public void executeCommand(AccountManager AM, Program p) {
        if(!AM.isPermitted()){
            System.out.println("you do not have access to this command");
        }
        else{
            if(p.getLocation() == 1){
                Scanner in = new Scanner(System.in);
                System.out.println("Enter username");
                String username = in.nextLine();
                System.out.println("Enter password");
                String password = in.nextLine();
                if (AM.createAdminAccount(username, password)) {
                    System.out.println("Account created successfully!");
                }
                else{
                    System.out.println("An account with this username already exists.");
                }
            }
            else{
                System.out.println("can't use that command here");
            }
        }
    }
}
