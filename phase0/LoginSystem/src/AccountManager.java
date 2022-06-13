import java.util.ArrayList;
public class AccountManager {
    private ArrayList<Account> accounts;
    private Account activeUser;

    public AccountManager(){
        accounts = new ArrayList<Account>();
    }

    public boolean authenticate(String username, String password){
        for(Account acc : accounts){
            if(acc.getUsername().equals(username) && acc.getPassword().equals(password)){
                activeUser = acc;
                return true;
            }
        }
        return false;
    }

    public boolean createAccount(String username, String password){
        Account acc = new Account(username, password);
        accounts.add(acc);
        return true;
    }

    public Account getActiveUser(){
        return activeUser;
    }
}
