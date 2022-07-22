package Main;

/**
 * A user account
 */

public class Account {
    /**
     * the username of current account
     */
    private String username;
    /**
     * the user ID of current account
     */
    private int userID;
    /**
     * the password of current account
     */
    private String password;
    /**
     * whether current account is Admin or non-Admin, false by default
     */
    private boolean adminStatus;
    /**
     * whether current account is banned or not, false by default
     */
    private boolean banned=false;

    /**
     * Construct Account object with initialized username and password
     *
     * @param u is the username of the user
     * @param p is the password of the user
     */
    public Account(String u, String p){
        username = u;
        password = p;
    }

    /**
     * Returns username of account
     *
     * @return username
     */
    public String getUsername(){
        return username;
    }

    /**
     * Returns password of account
     *
     * @return password
     */
    public String getPassword(){
        return password;
    }

    /**
     * Checks whether account is an Admin account, returns true or false
     *
     * @return if adminStatus is true
     */
    public boolean isAdmin(){
        return adminStatus;
    }

    /**
     * Sets Admin account
     *
     * @param admin the admin account
     */
    public void setAdminStatus(Boolean admin) {
        this.adminStatus = admin;
    }

    /**
     * Checks whether account is banned, returns true or false
     *
     * @return if banned is true
     */
    public boolean isBanned() {
        return banned;
    }

    /**
     * Sets banned account
     *
     * @param banned the account to be banned
     */
    public void setBanned(Boolean banned) {
        this.banned = banned;
    }


    @Override
    public String toString(){
        return username;
    }
}