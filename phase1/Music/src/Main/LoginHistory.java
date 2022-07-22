package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The login history of an account
 */

public class LoginHistory {
    /**
     * Map between usernames and their associated login history
     */
    private static Map<String, ArrayList<LoginLog>> loginHistory;

    /**
     * Construct login history
     */
    public LoginHistory() {
        loginHistory = new HashMap<>();
    }

    /**
     * Initiates a login history for a new user
     */
    public void createUser(String username) {
        ArrayList<LoginLog> history = new ArrayList<>();
        loginHistory.put(username, history);
    }

    /**
     * Gets login history of account
     *
     * @param username username of account
     * @return the login history of account
     */
    public List<LoginLog> getHistory(String username) {
        return loginHistory.get(username);
    }

    /**
     * Add login event to login history
     *
     * @param username username of account
     * @param successLogin whether account has been authenticated
     */
    public void addEvent(String username,boolean successLogin) {
        ArrayList<LoginLog> history = loginHistory.get(username);
        LoginLog newLogin = new LoginLog(successLogin);
        history.add(newLogin);
        loginHistory.replace(username, history);
    }
}

