package Commands;

import Main.AccountManager;
import Main.Program;

import java.util.List;
import java.util.Scanner;

public class CreateAdmin extends Command{

    public CreateAdmin(){
        super(2, 1);
    }

    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        checkPerms(AM);

        if(AM.createAdminAccount(args.get(0), args.get(1))){
            p.createSuccess();
            p.mainMenu();
        }
        else{
            p.createFail();
            p.mainMenu();
        }
    }
}
