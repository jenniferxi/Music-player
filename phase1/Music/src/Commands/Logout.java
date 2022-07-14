package Commands;

import Main.Program;
import Main.AccountManager;

import java.util.List;

public class Logout extends Command {

    public Logout(){
        super(0,1);
    }

    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        p.logoutMsg();
        p.loginDisplay();
    }
}
