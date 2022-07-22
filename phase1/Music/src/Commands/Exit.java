package Commands;

import Main.Program;
import Main.AccountManager;

import java.util.List;

/**
 * User can exit the program
 */

public class Exit extends Command {

    public Exit(){
        super(0, -1);
    }

    /**
     * Program stops running
     *
     * @param AM account manager
     * @param p program
     * @param args provided arguments and command
     * @throws CommandException if invalid argument or command location
     */
    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocation(p);
        p.stopRunning();
        p.exitMsg();
    }
}
