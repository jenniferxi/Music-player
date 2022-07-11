package Commands;

import Main.AccountManager;
import Main.Program;

import java.util.Scanner;

public class Delete extends Command{

    public void executeCommand(AccountManager AM, Program p) {
        if(!AM.isPermitted()){
            System.out.println("you do not have access to this command");
        }
        else{
            if(p.getLocation() == 1){
                Scanner in = new Scanner(System.in);
                System.out.println("Enter the username of the account you would like to delete");
                String input = in.nextLine();
                if(AM.deleteAccount(input)){
                    System.out.println("Account deleted successfully.");
                }
                else{
                    System.out.println("Account couldn't be found.");
                }
            }
            else{
                System.out.println("can't use that command here");
            }
        }
    }
}
