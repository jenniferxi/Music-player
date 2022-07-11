package Main;

import java.io.IOException;
import java.util.Scanner;

import Commands.CommandController;

public class Main {
    public static void main(String[] args) throws IOException {
        AccountManager AM = new AccountManager("src/accounts.txt");
        Program p = new Program(AM);
        Scanner in = new Scanner(System.in);
        CommandController CC = new CommandController();
        p.loginDisplay();
        while(p.isRunning()){
            String input = in.nextLine();
            CC.executeCommand(AM, p, input);
        }
        AM.updateLog("src/accounts.txt");
    }
}
