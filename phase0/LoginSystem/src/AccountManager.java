import java.util.ArrayList;
public class AccountManager {
    private static ArrayList<Account> accounts;
    private static Account activeUser;

    public AccountManager(){ accounts = new ArrayList<Account>(); }

    public boolean authenticate(String username, String password){
        for(Account acc : accounts){
            if(acc.getUsername().equals(username) && acc.getPassword().equals(password)){
                activeUser = acc;
                return true;
            }
        }
        return false;
    }

    private static Account newAccount(String username, String password, Boolean isAdmin){
        Account acc = new Account(username, password);
        acc.setAdminStatus(isAdmin);
        return acc;
    }

    public void createAccount(String username, String password){
        accounts.add(newAccount(username, password, false));
    }

    public void createAdminAccount(String username, String password){
        accounts.add(newAccount(username, password, true));
    }

    public boolean deleteAccount(String username) {
        if (isPermitted() && !getAccountByUsername(username).isAdmin()) {
            accounts.remove(getAccountByUsername(username));
            return true;
        }
        return false;
    }

    public void banAccount(String username){
        if (isPermitted() && !getAccountByUsername(username).isAdmin()) {
            getAccountByUsername(username).setBanned(true);
        }
    }

    private boolean isPermitted() { return getActiveUser().isAdmin(); }

    public Account getActiveUser() { return activeUser; }

    public Account getAccountByUsername(String username) {
        for(Account acc: accounts){
            if (acc.getUsername().equals(username)) {
                return acc;
            }
        }
        return null;
    }

    public void setActiveUser(String username) { activeUser = getAccountByUsername(username); }

}
