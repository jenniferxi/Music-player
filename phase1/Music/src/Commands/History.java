package Commands;

import Main.AccountManager;
import Main.Program;

import java.util.List;

/**
 * See the login history of account
 */

public class History extends Command{

    public History(){
        super(0,1);
    }

    /**
     * Display login history of given account
     *
     * @param AM account manager
     * @param p program
     * @param args provided arguments and command
     * @throws CommandException if invalid argument or command location
     */
    public void executeCommand(AccountManager AM, Program p, List<String> args)  throws CommandException{
        checkArguments(args);
        checkLocation(p);
        p.getLoginHistory();
        p.mainMenu();
    }
}
