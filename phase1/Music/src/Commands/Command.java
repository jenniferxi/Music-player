package Commands;

import Main.Program;
import Main.AccountManager;

public abstract class Command {
    abstract public void executeCommand(AccountManager AM, Program p);
}
