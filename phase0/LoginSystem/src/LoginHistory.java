import java.time.LocalDateTime;
import java.util.*;

public class LoginHistory {
    private static Map<String, ArrayList<LocalDateTime>> loginHistory;

    public LoginHistory() {
        loginHistory = new HashMap<>();
    }

    /*Initiate a login history for a new user

     */
    public void firstLogin(String username) {
        ArrayList<LocalDateTime> history = new ArrayList<>();
        history.add(LocalDateTime.now());
        loginHistory.put(username, history);

    }

    public List<LocalDateTime> getHistory(String username) {
        return loginHistory.get(username);
    }

    public void addHistory(String username) {

        ArrayList<LocalDateTime> history = loginHistory.get(username);
        history.add(LocalDateTime.now());
        loginHistory.replace(username, history);
    }
}
