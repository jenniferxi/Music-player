package Commands;

import java.util.List;
import java.util.Scanner;
import Main.Program;
import Main.AccountManager;

/**
 * User can login to account with correct username and password
 */

public class Login extends Command {

    public Login(){
        super(2, 0);
    }

    /**
     * User logins after successful authentication
     *
     * @param AM account manager
     * @param p program
     * @param args provided arguments and command
     * @throws CommandException if invalid argument or location of command
     */
    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        if(AM.authenticate(args.get(0), args.get(1))){
            p.loginMsg();
            p.mainMenu();
        }
        else{
            p.loginFail();
            p.loginDisplay();
        }
    }
}
