package Main;

import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

public class AccountManager {
    private static ArrayList<Account> accounts = new ArrayList<Account>();
    private static Account activeUser;
    private LoginHistory history = new LoginHistory();

    public AccountManager(String path) throws FileNotFoundException{
        Scanner scanner = new Scanner(new FileInputStream(path));
        String[] line;
        Account acc;

        while(scanner.hasNextLine()){
            line = scanner.nextLine().split(",");
//            acc = new other.Account(info[0], info[1]);
//            if(info[2].equals("true")){
//                acc.setBanned(true);
//            }
            if(line[3].equals("true")){
                createAdminAccount(line[0], line[1]);
            }
            else{
                createAccount(line[0], line[1]);
            }
        }
        scanner.close();
    }

    public boolean authenticate(String username, String password) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)) {
                activeUser = acc;
                history.addEvent(username, true);
                return true;

            }
        }
        if(accounts.contains(getAccountByUsername(username))){
            history.addEvent(username, false);
        }
        return false;
    }

    private static Account newAccount(String username, String password, Boolean isAdmin) {
        Account acc = new Account(username, password);
        acc.setAdminStatus(isAdmin);
        return acc;
    }

    public boolean createAccount(String username, String password) {
        if (accounts.contains(getAccountByUsername(username))) {
            return false;
        } else {
            accounts.add(newAccount(username, password, false));
            history.createUser(username);
            return true;
        }
    }

    public boolean createAdminAccount(String username, String password) {
        if (accounts.contains(getAccountByUsername(username))) {
            return false;
        } else {
            accounts.add(newAccount(username, password, true));
            history.createUser(username);
            return true;
        }
    }

    public boolean deleteAccount(String username) {
        if(!accounts.contains(getAccountByUsername(username))){
            return false;
        }
        if (isPermitted() && !getAccountByUsername(username).isAdmin()) {
            accounts.remove(getAccountByUsername(username));
            return true;
        }
        return false;
    }

    public void banAccount(String username) {
        if (isPermitted() && !getAccountByUsername(username).isAdmin()) {
            getAccountByUsername(username).setBanned(true);
        }
    }

    public boolean isPermitted() {
        return activeUser.isAdmin();
    }

    public String getActiveUser() {
        return activeUser.getUsername();
    }

    public Account getAccountByUsername(String username) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username)) {
                return acc;
            }
        }
        return null;
    }

    public void setActiveUser(String username) {
        activeUser = getAccountByUsername(username);
    }

    public String getUserLoginHistory(String username) {
        StringBuilder userHistory = new StringBuilder();
        ArrayList<LoginLog> events = (ArrayList<LoginLog>) history.getHistory(username);
        for (LoginLog e : events) {
            userHistory.append(e.toString());
            userHistory.append("\n");
        }
        userHistory.deleteCharAt(userHistory.length()-1);
        return userHistory.toString();
    }

    public void updateLog(String filePath) throws IOException {
        PrintWriter oos = new PrintWriter(filePath);
        for(Account acc : accounts){
            oos.print(acc.getUsername()+","+acc.getPassword()+","+acc.isBanned()+","+acc.isAdmin()+"\n");
        }
        oos.close();
    }
}
