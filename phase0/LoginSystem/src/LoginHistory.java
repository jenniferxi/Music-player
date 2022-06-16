import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginHistory {
    private static Map<String, ArrayList<LoginLog>> loginHistory;

    public LoginHistory() {
        loginHistory = new HashMap<>();
    }

    /*Initiate a login history for a new user

     */
    public void createUser(String username) {
        ArrayList<LoginLog> history = new ArrayList<>();
        loginHistory.put(username, history);

    }

    public List<LoginLog> getHistory(String username) {
        return loginHistory.get(username);
    }

    public void addEvent(String username,boolean successLogin) {
        ArrayList<LoginLog> history = loginHistory.get(username);
        LoginLog newLogin = new LoginLog(successLogin);
        history.add(newLogin);
        loginHistory.replace(username, history);
    }
}
