package Main;

import java.time.LocalDateTime;

public class LoginLog {
    private final LocalDateTime time;
    private final boolean successLogin;

    public LoginLog(boolean successLogin) {
        this.time = LocalDateTime.now();
        this.successLogin = successLogin;
    }

    public LocalDateTime getTime() {
        return time;
    }

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
