/**
 * I think we can just get rid of this class, since we can set the admin status in the Account class instead
 * (bc we'd only need a new class if AdminAccount has its own unique attributes) - Jennifer
 */
public class AdminAccount extends Account{
    public AdminAccount(String u, String p){
        super(u, p);
    }

    @Override
    public boolean isAdmin() {
        return true;
    }
}
