package Commands;

import Main.AccountManager;
import Main.Program;

import java.util.List;
import java.util.Scanner;

/**
 * Admin account can delete account
 */

public class Delete extends Command{

    public Delete(){
        super(1, 1);
    }

    /**
     * Admin account deletes the account with given username, displays main menu
     *
     * @param AM account manager
     * @param p program
     * @param args provided arguments and command
     * @throws CommandException if non-Admin account or invalid arguments and command location
     */
    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocation(p);
        checkPerms(AM);

        if(AM.deleteAccount(args.get(0))){
            p.deleteSuccess();
            p.mainMenu();
        }
        else{
            p.deleteFail();
            p.mainMenu();
        }
    }
}
