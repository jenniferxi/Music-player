package Commands;

import Main.AccountManager;
import Main.Program;

import java.util.List;

public class Play extends Command{
    public Play(){
        super(0,2);
    }
    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocation(p);
        p.play();
    }
}
