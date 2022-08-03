package main.java.Driver;

import java.time.LocalDateTime;

/**
 * Login log for each account
 */

public class LoginLog {
    /**
     * Time of login
     */
    private final LocalDateTime time;
    /**
     * Checks whether login attempt was successful
     */
    private final boolean successLogin;

    /**
     * Initializes login log
     *
     * @param successLogin whether login attempt was successful
     */
    public LoginLog(boolean successLogin) {
        this.time = LocalDateTime.now();
        this.successLogin = successLogin;
    }

    /**
     * Gets date and time
     *
     * @return time
     */
    public LocalDateTime getTime() {
        return time;
    }

    /**
     * Checks whether login attempt was successful or not
     *
     * @return true if login attempt was successful
     */
    public boolean isSuccessLogin() {
        return successLogin;
    }

    @Override
    public String toString() {
        if (successLogin) {
            return "User had a success login in " + time.toString();
        } else {
            return "User failed to login in " + time.toString();
        }
    }
}
