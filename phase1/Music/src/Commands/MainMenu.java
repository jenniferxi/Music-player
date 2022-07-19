package Commands;

import Main.AccountManager;
import Main.Program;

import java.util.List;

public class MainMenu extends Command{

    public MainMenu(){
        super(0,0);
    }
    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocationSpecialLmao(p);
        p.mainMenu();
    }
}
