package Commands;

import Main.Program;
import Main.AccountManager;
public class Logout extends Command {

    public void executeCommand(AccountManager AM, Program p) {
        if(p.getLocation() == 1){
            p.loginDisplay();
        }
        else{
            System.out.println("can't use that command here");
        }
    }
}
