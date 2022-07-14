package Commands;

import Main.AccountManager;
import Main.Program;

import java.util.List;
import java.util.Scanner;

public class Delete extends Command{

    public Delete(){
        super(1, 1);
    }

    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocation(p);
        checkPerms(AM);

        if(AM.deleteAccount(args.get(0))){
            p.deleteSuccess();
            p.mainMenu();
        }
        else{
            p.deleteFail();
            p.mainMenu();
        }
    }
}
