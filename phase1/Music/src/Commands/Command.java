package Commands;

import Main.Program;
import Main.AccountManager;

import java.util.List;

public abstract class Command {
    private final int expectedArguments;
    private final int expectedLocation;

    public Command(int expectedArguments, int expectedLocation){
        this.expectedArguments = expectedArguments;
        this.expectedLocation = expectedLocation;
    }
    abstract public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException;

    public void checkLocation(Program p) throws CommandException{
        if(p.getLocation() != expectedLocation && expectedLocation != -1){
            throw new CommandException("can't use that command here");
        }
    }

    public void checkLocationSpecialLmao(Program p) throws CommandException{
        if(p.getLocation() < 1){
            throw new CommandException("can't use that command here");
        }
    }

    public void checkArguments(List<String> arguments) throws CommandException{
        if(arguments.size() != expectedArguments){
            throw new CommandException("wrong number of arguments provided");
        }
    }

    public void checkPerms(AccountManager AM) throws CommandException{
        if(!AM.isPermitted()){
            throw new CommandException("you don't have permission to use this command");
        }
    }
}
