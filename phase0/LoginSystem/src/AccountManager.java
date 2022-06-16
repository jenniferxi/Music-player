import java.util.ArrayList;

public class AccountManager {
    private static ArrayList<Account> accounts;
    private static Account activeUser;
    private LoginHistory history = new LoginHistory();

    public AccountManager() {
        accounts = new ArrayList<Account>();
    }

    public boolean authenticate(String username, String password) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)) {
                activeUser = acc;
                history.addEvent(username, true);
                return true;

            }
        }
        history.addEvent(username, false);
        return false;
    }

    private static Account newAccount(String username, String password, Boolean isAdmin) {
        Account acc = new Account(username, password);
        acc.setAdminStatus(isAdmin);
        return acc;
    }

    public boolean createAccount(String username, String password) {
        if (accounts.contains(username)) {
            return false;
        } else {
            accounts.add(newAccount(username, password, false));
            history.createUser(username);
            return true;
        }
    }

    public void createAdminAccount(String username, String password) {
        accounts.add(newAccount(username, password, true));
    }

    public boolean deleteAccount(String username) {
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

    private boolean isPermitted() {
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
        }
        return userHistory.toString();
    }
}
