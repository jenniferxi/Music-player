package Commands;

import Main.AccountManager;
import Main.Program;

import java.util.List;

/**
 * User can skip to the next song in the current playlist
 */

public class SkipForward extends Command{

    public SkipForward(){
        super(0,2);
    }

    /**
     * Skips to next song in current playlist
     *
     * @param AM account manager
     * @param p program
     * @param args provided arguments and command
     * @throws CommandException if invalid argument or location
     */
    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocation(p);
        p.skipForward();
    }
}
