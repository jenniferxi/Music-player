package Commands;

import java.util.*;

public class Constants {
    public static final Hashtable<String, Command> COMMAND_MAP = new Hashtable<String, Command>();

    static{
        COMMAND_MAP.put("login", new Login());
        COMMAND_MAP.put("exit", new Exit());
        COMMAND_MAP.put("create", new Create());
        COMMAND_MAP.put("logout", new Logout());
        COMMAND_MAP.put("history", new History());
        COMMAND_MAP.put("newadmin", new CreateAdmin());
        COMMAND_MAP.put("delete", new Delete());
        COMMAND_MAP.put("allsongs", new AllSongs());
        COMMAND_MAP.put("mainmenu", new MainMenu());
        COMMAND_MAP.put("play", new Play());
        COMMAND_MAP.put("pause", new Pause());
    }
}
