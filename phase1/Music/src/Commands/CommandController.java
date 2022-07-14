package Commands;

import Main.Program;
import Main.AccountManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandController {

    public void executeCommand(AccountManager AM, Program p, String input){
        List<String> args = getArgs(input);
        String[] split = input.split(" ");
        try{
            Command command = Constants.COMMAND_MAP.get(split[0]);
            command.executeCommand(AM, p, args);
        }
        catch(NullPointerException e){
            System.out.println("command not found...");
        }
        catch(CommandException e){
            System.out.println(e.getMessage());
        }
    }

    private List<String> getArgs(String command){
        String[] split = command.split(" ");
        List<String> args = new ArrayList<>();
        if(split.length > 1){
            args.addAll(Arrays.asList(split).subList(1, split.length));
        }
        return args;
    }
}
