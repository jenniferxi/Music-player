package Commands;

import Main.Program;
import Main.AccountManager;

public class Exit extends Command {

    public void executeCommand(AccountManager AM, Program p){
        p.stopRunning();
        System.out.println("exiting program...");
    }
}
