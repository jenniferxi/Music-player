package main.java.Commands;

import main.java.Driver.Program;
import main.java.Driver.AccountManager;

import java.util.List;

/**
 * User can pause music
 */

public class Pause extends Command{

    public Pause(){
        super(0,2);
    }

    /**
     * Pause music
     *
     * @param AM account manager
     * @param p program
     * @param args provided arguments and command
     * @throws CommandException if invalid argument or location
     */
    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocation(p);
        // p.pause();
    }
}
