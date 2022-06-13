public class AdminAccount extends Account{
    public AdminAccount(String u, String p){
        super(u, p);
    }

    @Override
    public boolean isAdmin() {
        return true;
    }
}
