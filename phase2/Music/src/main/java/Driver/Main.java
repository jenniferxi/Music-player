package main.java.Driver;
import main.java.Commands.CommandController;
import main.java.MusicUtil.PlaylistManager;
import main.java.MusicUtil.SongManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        AccountManager AM = new AccountManager("src/accounts.txt");
        SongManager SM = new SongManager();
        SM.initializeSongs();
        PlaylistManager PM = new PlaylistManager(SM);
        Program p = new Program(AM, SM, PM);
        Scanner in = new Scanner(System.in);
        CommandController CC = new CommandController();
        p.loginDisplay();
        while (p.isRunning()) {
            String input = in.nextLine();
            CC.executeCommand(AM, p, input);
        }
        AM.updateLog("src/accounts.txt");
    }
}
