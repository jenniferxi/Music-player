package Commands;

import Main.AccountManager;
import Main.Program;

import java.util.List;
import java.util.Scanner;

public class Create extends Command{

    public Create(){
        super(2, 0);
    }

    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        if(AM.createAccount(args.get(0), args.get(1))){
            p.createSuccess();
            p.loginDisplay();
        }
        else{
            p.createFail();
            p.loginDisplay();
        }
    }
}
