package Commands;

import Main.Program;
import Main.AccountManager;

public class CommandController {

    public void executeCommand(AccountManager AM, Program p, String input){
        try{
            Command command = Constants.COMMAND_MAP.get(input);
            command.executeCommand(AM, p);
        }
        catch(NullPointerException e){
            System.out.println("command not found...");
        }
    }
}
