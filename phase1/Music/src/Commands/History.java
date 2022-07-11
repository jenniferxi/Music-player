package Commands;

import Main.AccountManager;
import Main.Program;

public class History extends Command{

    public void executeCommand(AccountManager AM, Program p) {
        if(p.getLocation() == 1){
            System.out.println(AM.getUserLoginHistory(AM.getActiveUser()));
        }
        else{
            System.out.println("can't use that command here");
        }
    }
}
