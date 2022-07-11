package Main;

public class Account {
    private String username;
    private int userID;
    private String password;
    private boolean adminStatus;
    private boolean banned=false;

    public Account(String u, String p){
        username = u;
        password = p;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
    public boolean isAdmin(){
        return adminStatus;
    }

    public void setAdminStatus(Boolean admin) { this.adminStatus = admin; }

    public boolean isBanned() { return banned; }

    public void setBanned(Boolean banned) { this.banned = banned; }

    @Override
    public String toString(){
        return username;
    }
}