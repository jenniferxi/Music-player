package Commands;

import Main.AccountManager;
import Main.Program;

import java.util.List;

public class SkipForward extends Command{
    public SkipForward(){
        super(0,2);
    }
    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocation(p);
        p.skipForward();
    }
}
