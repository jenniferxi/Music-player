package Commands;

import Main.AccountManager;
import Main.Program;

import java.util.List;

public class History extends Command{

    public History(){
        super(0,1);
    }

    public void executeCommand(AccountManager AM, Program p, List<String> args)  throws CommandException{
        checkArguments(args);
        checkLocation(p);
        p.getLoginHistory();
        p.mainMenu();
    }
}