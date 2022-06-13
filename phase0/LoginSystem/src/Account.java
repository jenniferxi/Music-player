public class Account {
    private String username;
    private int userID;
    private String password;
    private boolean adminStatus;

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
        return false;
    }

    @Override
    public String toString(){
        return username;
    }
}
