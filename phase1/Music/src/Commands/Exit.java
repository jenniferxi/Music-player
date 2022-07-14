package Commands;

import Main.Program;
import Main.AccountManager;

import java.util.List;

public class Exit extends Command {

    public Exit(){
        super(0, -1);
    }

    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocation(p);
        p.stopRunning();
        p.exitMsg();
    }
}
